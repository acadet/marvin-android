package com.adriencadet.marvin.models.beans;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @class Task
 * @brief
 */
public class Task extends RealmObject implements IBean {
    @PrimaryKey
    private String  id;
    private Date    createDate;
    private Date    updateDate;
    private String  label;
    private boolean wasCompleted;
    private String  listId;

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

    public boolean getWasCompleted() {
        return wasCompleted;
    }

    public void setWasCompleted(boolean value) {
        wasCompleted = value;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String value) {
        listId = value;
    }
}
