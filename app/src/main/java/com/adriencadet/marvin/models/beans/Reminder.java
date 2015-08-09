package com.adriencadet.marvin.models.beans;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @class Reminder
 * @brief
 */
public class Reminder extends RealmObject implements IBean {
    @PrimaryKey
    private String  id;
    private Date    createDate;
    private Date    updateDate;
    private String  label;
    private Date    date;
    private boolean wasDone;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        id = value;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date value) {
        createDate = value;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date value) {
        updateDate = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String value) {
        label = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        date = value;
    }

    public boolean getWasDone() {
        return wasDone;
    }

    public void setWasDone(boolean value) {
        wasDone = value;
    }
}
