package com.adriencadet.marvin.models.beans;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @class TodoList
 * @brief
 */
public class TodoList extends RealmObject implements IBean {
    @PrimaryKey
    private String  id;
    private Date    createDate;
    private Date    updateDate;
    private String  label;
    private int     color;
    private boolean wasCompleted;

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

    public int getColor() {
        return color;
    }

    public void setColor(int value) {
        color = value;
    }

    public boolean getWasCompleted() {
        return wasCompleted;
    }

    public void setWasCompleted(boolean value) {
        wasCompleted = value;
    }
}
