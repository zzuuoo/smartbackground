package com.zuo.smartbackground.model;

import java.util.Date;

public class MakeSchedule {
    private Integer sectionId;//门诊id
    private Date date;//出诊日期
    private Integer when;//0 全天、1上午、2下午
    private Integer remainder;//可挂号的数量
    private Integer doctorId;//医生id

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getWhen() {
        return when;
    }

    public void setWhen(Integer when) {
        this.when = when;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
}
