package com.smart.sperms.service;

import com.smart.sperms.dao.ProductDao;
import com.smart.sperms.dao.model.Product;
import com.smart.sperms.enums.ResultCodeEnum;
import com.smart.sperms.request.ProductEditReq;
import com.smart.sperms.response.CommonWrapper;
import com.smart.sperms.response.ListQueryWrapper;
import com.smart.sperms.response.PageSearchWrapper;
import com.smart.sperms.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(ProductEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String proId = req.getProId();
        boolean isExist = this.isExists(proId);
        if(isExist) {
            wrapper.setResultMsg("该产品类型已存在");
            return wrapper;
        }
        Product info = new Product();
        info.setProId(req.getProId());
        info.setProLength(req.getProLength());
        info.setProMaterial(req.getProMaterial());
        info.setProName(req.getProName());
        info.setProSize(req.getProSize());
        info.setProType(req.getProType());
        info.setProWeightActual(req.getProWeightActual());
        info.setProWeightStd(req.getProWeightStd());

        int cnt = productDao.saveData(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 修改记录
     * @param req
     * @return
     */
    public CommonWrapper updateInfo(ProductEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        Product info = new Product();
        info.setProLength(req.getProLength());
        info.setProMaterial(req.getProMaterial());
        info.setProName(req.getProName());
        info.setProSize(req.getProSize());
        info.setProType(req.getProType());
        info.setProWeightActual(req.getProWeightActual());
        info.setProWeightStd(req.getProWeightStd());

        int cnt = productDao.updateData(req.getProId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param proIds
     * @return
     */
    public CommonWrapper deleteInfo(List<String> proIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = productDao.delData(proIds);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param proName   名称关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String proName) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = productDao.queryPageTotal(proName);
        List<Product> result = productDao.queryPage(pageNo, pageSize, proName);

        wrapper.setTotalCount(total);
        wrapper.setPageNo(pageNo);
        wrapper.setRecords(result);
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 查询单个结果
     * @param recordId
     * @return
     */
    public SingleQueryWrapper findRecordById(String recordId) {
        SingleQueryWrapper wrapper = new SingleQueryWrapper();

        Product condition = new Product();
        condition.setProId(recordId);

        List<Product> result = productDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 查询单个结果
     * @return
     */
    public ListQueryWrapper listAll() {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        List<Product> result = productDao.listAll();
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecords(result);
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 判断记录是否存在
     * @param proId
     * @return
     */
    private boolean isExists(String proId) {
        boolean isExist= false;
        Product condition = new Product();
        condition.setProId(proId);

        List<Product> dataList = productDao.queryList(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
