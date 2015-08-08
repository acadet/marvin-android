package com.adriencadet.marvin.models.beans;

/**
 * @class TodoList
 * @brief
 */
public class TodoList extends BaseBean {
    private String  label;
    private int     color;
    private boolean wasCompleted;

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
