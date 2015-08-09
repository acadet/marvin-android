package com.adriencadet.marvin.models.bll;

import com.adriencadet.marvin.models.beans.Task;
import com.adriencadet.marvin.models.beans.TodoList;
import com.adriencadet.marvin.models.bll.interfaces.ITaskBLL;
import com.adriencadet.marvin.models.dao.interfaces.ITaskDAO;
import com.adriencadet.marvin.utils.BackgroundTask;
import com.coshx.chocolatine.utils.actions.Action;

import java.util.List;

/**
 * @class TaskBLL
 * @brief
 */
class TaskBLL extends BaseBLL implements ITaskBLL {
    private ITaskDAO _dao;

    TaskBLL(ITaskDAO dao) {
        super();
        _dao = dao;
    }

    @Override
    public void create(String label, TodoList list) {
        Task t = new Task();

        t.setLabel(label.trim());
        t.setListId(list.getId());
        t.setWasCompleted(false);

        _dao.create(t);
    }

    @Override
    public void update(Task task) {
        task.setLabel(task.getLabel().trim());
        _dao.update(task);
    }

    @Override
    public void delete(Task task) {
        _dao.delete(task);
    }

    @Override
    public void toggleCompleted(Task task) {
        if (task.getWasCompleted()) {
            _dao.flagAsUncompleted(task);
        } else {
            _dao.flagAsCompleted(task);
        }
    }

    @Override
    public void sortByLabel(TodoList list, Action<List<Task>> success) {
        BackgroundTask t = new BackgroundTask<List<Task>>() {
            @Override
            protected List<Task> doInBackground(Void... params) {
                return _dao.sortByLabel(list.getId());
            }

            @Override
            protected void onPostExecute(List<Task> tasks) {
                super.onPostExecute(tasks);
                success.run(tasks);
            }
        };

        run(t);
    }

    @Override
    public void sortByLabelDesc(TodoList list, Action<List<Task>> success) {
        BackgroundTask t = new BackgroundTask<List<Task>>() {
            @Override
            protected List<Task> doInBackground(Void... params) {
                return _dao.sortByLabelDesc(list.getId());
            }

            @Override
            protected void onPostExecute(List<Task> tasks) {
                super.onPostExecute(tasks);
                success.run(tasks);
            }
        };

        run(t);
    }

    @Override
    public void sortByUpdateDate(TodoList list, Action<List<Task>> success) {
        BackgroundTask t = new BackgroundTask<List<Task>>() {
            @Override
            protected List<Task> doInBackground(Void... params) {
                return _dao.sortByUpdateDate(list.getId());
            }

            @Override
            protected void onPostExecute(List<Task> tasks) {
                super.onPostExecute(tasks);
                success.run(tasks);
            }
        };

        run(t);
    }

    @Override
    public void sortByUpdateDateDesc(TodoList list, Action<List<Task>> success) {
        BackgroundTask t = new BackgroundTask<List<Task>>() {
            @Override
            protected List<Task> doInBackground(Void... params) {
                return _dao.sortByUpdateDateDesc(list.getId());
            }

            @Override
            protected void onPostExecute(List<Task> tasks) {
                super.onPostExecute(tasks);
                success.run(tasks);
            }
        };

        run(t);
    }
}
