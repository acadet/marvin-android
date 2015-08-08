package com.adriencadet.marvin.models.beans;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @class BaseBean
 * @brief
 */
public abstract class BaseBean extends RealmObject {
    @PrimaryKey
    private String id;
    private Date   createDate;
    private Date   updateDate;

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
}
