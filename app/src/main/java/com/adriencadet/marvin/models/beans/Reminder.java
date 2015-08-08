package com.adriencadet.marvin.models.beans;

import java.util.Date;

/**
 * @class Reminder
 * @brief
 */
public class Reminder extends BaseBean {
    private String  label;
    private Date    date;
    private boolean wasDone;

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
