package com.adriencadet.marvin.ui.fragments;

import android.app.Fragment;

import com.adriencadet.marvin.models.bll.BLLFactory;
import com.adriencadet.marvin.models.bll.interfaces.IReminderBLL;
import com.adriencadet.marvin.models.bll.interfaces.ITaskBLL;
import com.adriencadet.marvin.models.bll.interfaces.ITodoListBLL;

/**
 * @class BaseFragment
 * @brief
 */
public abstract class BaseFragment extends Fragment {
    private ITaskBLL     _taskBLL;
    private ITodoListBLL _todoListBLL;
    private IReminderBLL _reminderBLL;

    public ITaskBLL getTaskBLL() {
        if (_taskBLL == null) {
            _taskBLL = BLLFactory.task(getActivity());
        }
        return _taskBLL;
    }

    public ITodoListBLL getTodoListBLL() {
        if (_todoListBLL == null) {
            _todoListBLL = BLLFactory.todoList(getActivity());
        }
        return _todoListBLL;
    }

    public IReminderBLL getReminderBLL() {
        if (_reminderBLL == null) {
            _reminderBLL = BLLFactory.reminder(getActivity());
        }
        return _reminderBLL;
    }

    @Override
    public void onPause() {
        super.onPause();

        getTaskBLL().cancelAllTasks();
        getTodoListBLL().cancelAllTasks();
        getTodoListBLL().cancelAllTasks();
    }
}
