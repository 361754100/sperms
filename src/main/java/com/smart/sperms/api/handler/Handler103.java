package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.DataBody103;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.config.PropertiesConfig;
import com.smart.sperms.dao.ProductDao;
import com.smart.sperms.dao.ProductionStatDao;
import com.smart.sperms.dao.model.Product;
import com.smart.sperms.dao.model.ProductionStat;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 处理103协议
 */
@Component
public class Handler103 extends Handler {

    @Autowired
    private PropertiesConfig propsConfig;

    @Autowired
    private ProductionStatDao statDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public void execute(String eId, MsgPayload req) {
        List<DataBody103> dataList = (ArrayList<DataBody103>)req.getData();
        logger.info("recv android msg...body = {}", dataList);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_104.getCode());
        super.sendMsg(eId, resp);

        saveProductStat(eId, dataList);
        // 保存图片
//        String imgBase64 = reqBody.getImage();
//        if(!StringUtils.isEmpty(imgBase64)) {
//            saveImage(eId, reqBody.getType(), imgBase64);
//        }
    }

    /**
     * 保存生成统计信息
     * @param eId
     * @param dataList
     */
    private void saveProductStat(String eId, List<DataBody103> dataList) {
        if(CollectionUtils.isEmpty(dataList)) {
            logger.error("dataList is Empty...eId={}", eId);
            return;
        }
        List<ProductionStat> stats = new ArrayList<>();
        Map<String, Product> prods = productDao.queryProMap();
        Product tmpProd = null;
        String proId = null;
        for(DataBody103 dataBody103: dataList) {
            proId = String.valueOf(dataBody103.getType());

            int psQuantity = dataBody103.getCount();
            double actualWeight = 0;
            tmpProd = prods.get(proId);
            if(tmpProd != null) {
                actualWeight = tmpProd.getProWeightActual();
            }
            int psMount = (int)(psQuantity * actualWeight);

            ProductionStat stat = new ProductionStat();
            stat.setPsMount(psMount);
            stat.setPsDate(DateUtils.parseStrToDate(dataBody103.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
            stat.setPsEndDate(DateUtils.parseStrToDate(dataBody103.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
            stat.seteId(eId);
            stat.setProId(proId);
            stat.setPsQuantity(psQuantity);
            stats.add(stat);
        }

        int cnt  = statDao.saveList(stats);
        logger.debug("insert product stat record...cnt = {}", cnt);
    }

    /**
     * 保存设备上传的图片
     * @param eId
     * @param type
     * @param imgBase64
     */
    private void saveImage(String eId, int type, String imgBase64) {
        Date curDate = new Date();
        long timeMs = curDate.getTime();
        String timeDir = DateUtils.parseDateToStr(curDate, "yyyyMMdd");

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        String imgName = "IMG103_"+ eId +"_"+ type +"_"+ timeMs +"_"+ uuid +".jpg";

        String IMG_STORE_PATH = propsConfig.getImage_file_path();
        if(StringUtils.isEmpty(IMG_STORE_PATH)) {
            IMG_STORE_PATH = "/opt/file_store/images";
        }
        IMG_STORE_PATH += File.separator + eId + File.separator + timeDir + File.separator +imgName;

        OutputStream out = null;
        try {
            File imgFile = new File(IMG_STORE_PATH);
            if(imgFile.exists()) {
                logger.info("image is exists... FILE_PATH = {}", IMG_STORE_PATH);
                return;
            }

            byte[] imgByte = Base64.getDecoder().decode(imgBase64);

            File fileParent = imgFile.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }

            out = new FileOutputStream(imgFile);
            out.write(imgByte);
            out.flush();

        } catch (Exception e) {
            logger.error("保存图片数据异常", e);
        } finally {
            try {
                if(out != null) {
                    out.close();
                    out = null;
                }
            } catch (Exception e2) {
                logger.error("关闭图片文件输出流异常", e2);
            }
        }
    }

}
