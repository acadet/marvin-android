package com.adriencadet.marvin.models.bll;

import android.content.Context;

import com.adriencadet.marvin.models.bll.interfaces.IReminderBLL;
import com.adriencadet.marvin.models.bll.interfaces.ITaskBLL;
import com.adriencadet.marvin.models.bll.interfaces.ITodoListBLL;
import com.adriencadet.marvin.models.dao.DAOFactory;
import com.adriencadet.marvin.utils.Lazy;

/**
 * @class BLLFactory
 * @brief
 */
public class BLLFactory {
    private final static Lazy<ITaskBLL>     _task     = new Lazy<>();
    private final static Lazy<ITodoListBLL> _todoList = new Lazy<>();
    private final static Lazy<IReminderBLL> _reminder = new Lazy<>();

    public static ITaskBLL task(Context context) {
        return _task.get(
            () -> {
                return new TaskBLL(DAOFactory.task(context));
            }
        );
    }

    public static ITodoListBLL todoList(Context context) {
        return _todoList.get(
            () -> {
                return new TodoListBLL(DAOFactory.todoList(context), DAOFactory.task(context));
            }
        );
    }

    public static IReminderBLL reminder(Context context) {
        return _reminder.get(
            () -> {
                return new ReminderBLL(DAOFactory.reminder(context));
            }
        );
    }
}
