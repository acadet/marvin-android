package com.adriencadet.marvin.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.adriencadet.marvin.R;
import com.adriencadet.marvin.models.beans.Reminder;
import com.coshx.chocolatine.widgets.SmartAdapter;

import java.util.List;

/**
 * @class ReminderAdapter
 * @brief
 */
public class ReminderAdapter extends SmartAdapter<Reminder> {

    public ReminderAdapter(List<Reminder> items, Context context) {
        super(items, context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View adapter;

        adapter = recycle(convertView, R.layout.adapter_reminder, parent);

        return adapter;
    }
}
