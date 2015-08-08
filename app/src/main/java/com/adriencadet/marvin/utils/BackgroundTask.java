package com.adriencadet.marvin.utils;

import android.os.AsyncTask;

import com.coshx.chocolatine.utils.actions.Action;

import java.util.UUID;

/**
 * @class BackgroundTask
 * @brief
 */
public abstract class BackgroundTask extends AsyncTask<Void, Void, Void> {
    private String                 _id;
    private Action<BackgroundTask> _callback;

    public BackgroundTask() {
        _id = UUID.randomUUID().toString();
    }

    public String getId() {
        return _id;
    }

    public void whenDone(Action<BackgroundTask> callback) {
        _callback = callback;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        _callback.run(this);
    }
}
