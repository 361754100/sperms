package com.smart.sperms.dao.model;

import java.io.Serializable;

public class EquipmentErrCode implements Serializable {
    private String errCode;

    private String errName;

    private String errDesc;

    private static final long serialVersionUID = 1L;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }

    public String getErrDesc() {
        return errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }
}