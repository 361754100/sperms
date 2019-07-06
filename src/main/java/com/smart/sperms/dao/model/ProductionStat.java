package com.smart.sperms.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ProductionStat implements Serializable {
    private String eId;

    private Date psDate;

    private Date psEndDate;

    private Integer psMount;

    private static final long serialVersionUID = 1L;

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public Date getPsDate() {
        return psDate;
    }

    public void setPsDate(Date psDate) {
        this.psDate = psDate;
    }

    public Date getPsEndDate() {
        return psEndDate;
    }

    public void setPsEndDate(Date psEndDate) {
        this.psEndDate = psEndDate;
    }

    public Integer getPsMount() {
        return psMount;
    }

    public void setPsMount(Integer psMount) {
        this.psMount = psMount;
    }
}