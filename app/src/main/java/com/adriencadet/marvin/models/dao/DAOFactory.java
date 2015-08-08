package com.adriencadet.marvin.models.dao;

import android.content.Context;

import com.adriencadet.marvin.models.dao.interfaces.IReminderDAO;
import com.adriencadet.marvin.models.dao.interfaces.ITaskDAO;
import com.adriencadet.marvin.models.dao.interfaces.ITodoListDAO;
import com.adriencadet.marvin.utils.Lazy;

import io.realm.Realm;

/**
 * @class DAOFactory
 * @brief
 */
public class DAOFactory {
    private static Lazy<IReminderDAO> _reminder = new Lazy<>();
    private static Lazy<ITaskDAO>     _task     = new Lazy<>();
    private static Lazy<ITodoListDAO> _todoList = new Lazy<>();

    public static IReminderDAO reminder(Context context) {
        return _reminder.get(() -> new ReminderDAO(Realm.getInstance(context)));
    }

    public static ITaskDAO task(Context context) {
        return _task.get(() -> new TaskDAO(Realm.getInstance(context)));
    }

    public static ITodoListDAO todoList(Context context) {
        return _todoList.get(() -> new TodoListDAO(Realm.getInstance(context)));
    }
}
