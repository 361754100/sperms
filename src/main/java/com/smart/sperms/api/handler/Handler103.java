package com.smart.sperms.api.handler;

import com.smart.sperms.api.protocol.DataBody103;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.config.PropertiesConfig;
import com.smart.sperms.enums.ProtocolEnum;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * 处理103协议
 */
@Component
public class Handler103 extends Handler {

    @Autowired
    private PropertiesConfig propsConfig;

    @Override
    public void execute(String eId, MsgPayload req) {
        DataBody103 reqBody = (DataBody103)req.getData();
        logger.info("recv android msg...body = {}", reqBody);

        MsgPayload resp = new MsgPayload();
        resp.setProtocol(ProtocolEnum.CODE_104.getCode());
        super.sendMsg(eId, resp);

        // 保存图片
        String imgBase64 = reqBody.getImage();
        if(!StringUtils.isEmpty(imgBase64)) {
            saveImage(eId, reqBody.getType(), imgBase64);
        }
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
