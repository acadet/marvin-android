package com.adriencadet.marvin.models.beans;

/**
 * @class Task
 * @brief
 */
public class Task extends BaseBean {
    private String  label;
    private boolean wasCompleted;
    private String  listId;

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
