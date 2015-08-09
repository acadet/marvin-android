package com.adriencadet.marvin.models.bll;

import com.adriencadet.marvin.utils.BackgroundTask;

import java.util.HashMap;
import java.util.Map;

/**
 * @class BaseBLL
 * @brief
 */
abstract class BaseBLL {
    private Map<String, BackgroundTask> _backgroundTasks;

    BaseBLL() {
        _backgroundTasks = new HashMap<>();
    }

    public void run(BackgroundTask task) {
        _backgroundTasks.put(task.getId(), task);
        task.whenDone((t) -> _backgroundTasks.remove(t.getId()));
        task.execute();
    }

    public void cancelAllTasks() {
        for (Map.Entry<String, BackgroundTask> pair : _backgroundTasks.entrySet()) {
            pair.getValue().cancel(false);
        }
    }
}
