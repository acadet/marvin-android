package com.adriencadet.marvin.models.bll;

import com.adriencadet.marvin.models.beans.TodoList;
import com.adriencadet.marvin.models.beans.utils.TodoListColor;
import com.adriencadet.marvin.models.bll.interfaces.ITodoListBLL;
import com.adriencadet.marvin.models.dao.interfaces.ITaskDAO;
import com.adriencadet.marvin.models.dao.interfaces.ITodoListDAO;
import com.adriencadet.marvin.utils.BackgroundTask;
import com.coshx.chocolatine.utils.actions.Action;
import com.coshx.chocolatine.utils.actions.Action0;

import java.util.List;

/**
 * @class TodoListBLL
 * @brief
 */
class TodoListBLL extends BaseBLL implements ITodoListBLL {
    private ITodoListDAO _dao;
    private ITaskDAO     _taskDAO;

    TodoListBLL(ITodoListDAO dao, ITaskDAO taskDAO) {
        super();

        _dao = dao;
        _taskDAO = taskDAO;
    }

    @Override
    public void create(String label, TodoListColor color) {
        TodoList l = new TodoList();

        l.setLabel(label.trim());
        l.setColor(color.toInt());
        l.setWasCompleted(false);

        _dao.create(l);
    }

    @Override
    public void update(TodoList list) {
        list.setLabel(list.getLabel().trim());
        _dao.update(list);
    }

    @Override
    public void delete(TodoList list, Action0 success) {
        run(
            new BackgroundTask() {
                @Override
                protected Object doInBackground(Object[] params) {
                    _taskDAO.deleteByList(list.getId());
                    _dao.delete(list);

                    return null;
                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);
                    success.run();
                }
            }
        );
    }

    @Override
    public void toggleCompleted(TodoList list) {
        if (list.getWasCompleted()) {
            _dao.flagAsUncompleted(list);
        } else {
            _dao.flagAsCompleted(list);
        }
    }

    @Override
    public void sortByLabel(Action<List<TodoList>> success) {
        BackgroundTask<List<TodoList>> t = new BackgroundTask<List<TodoList>>() {
            @Override
            protected List<TodoList> doInBackground(Void... params) {
                return _dao.sortByLabel();
            }

            @Override
            protected void onPostExecute(List<TodoList> todoLists) {
                super.onPostExecute(todoLists);

                success.run(todoLists);
            }
        };

        run(t);
    }

    @Override
    public void sortByLabelDesc(Action<List<TodoList>> success) {
        BackgroundTask<List<TodoList>> t = new BackgroundTask<List<TodoList>>() {
            @Override
            protected List<TodoList> doInBackground(Void... params) {
                return _dao.sortByLabelDesc();
            }

            @Override
            protected void onPostExecute(List<TodoList> todoLists) {
                super.onPostExecute(todoLists);

                success.run(todoLists);
            }
        };

        run(t);
    }

    @Override
    public void sortByUpdateDate(Action<List<TodoList>> success) {
        BackgroundTask<List<TodoList>> t = new BackgroundTask<List<TodoList>>() {
            @Override
            protected List<TodoList> doInBackground(Void... params) {
                return _dao.sortByUpdateDate();
            }

            @Override
            protected void onPostExecute(List<TodoList> todoLists) {
                super.onPostExecute(todoLists);

                success.run(todoLists);
            }
        };

        run(t);
    }

    @Override
    public void sortByUpdateDateDesc(Action<List<TodoList>> success) {
        BackgroundTask<List<TodoList>> t = new BackgroundTask<List<TodoList>>() {
            @Override
            protected List<TodoList> doInBackground(Void... params) {
                return _dao.sortByUpdateDateDesc();
            }

            @Override
            protected void onPostExecute(List<TodoList> todoLists) {
                super.onPostExecute(todoLists);

                success.run(todoLists);
            }
        };

        run(t);
    }

    @Override
    public void sortCompletedByLabel(Action<List<TodoList>> success) {
        BackgroundTask<List<TodoList>> t = new BackgroundTask<List<TodoList>>() {
            @Override
            protected List<TodoList> doInBackground(Void... params) {
                return _dao.sortCompletedByLabel();
            }

            @Override
            protected void onPostExecute(List<TodoList> todoLists) {
                super.onPostExecute(todoLists);

                success.run(todoLists);
            }
        };

        run(t);
    }

    @Override
    public void sortCompletedByLabelDesc(Action<List<TodoList>> success) {
        BackgroundTask<List<TodoList>> t = new BackgroundTask<List<TodoList>>() {
            @Override
            protected List<TodoList> doInBackground(Void... params) {
                return _dao.sortCompletedByLabelDesc();
            }

            @Override
            protected void onPostExecute(List<TodoList> todoLists) {
                super.onPostExecute(todoLists);

                success.run(todoLists);
            }
        };

        run(t);
    }

    @Override
    public void sortCompletedByUpdateDate(Action<List<TodoList>> success) {
        BackgroundTask<List<TodoList>> t = new BackgroundTask<List<TodoList>>() {
            @Override
            protected List<TodoList> doInBackground(Void... params) {
                return _dao.sortCompletedByUpdateDate();
            }

            @Override
            protected void onPostExecute(List<TodoList> todoLists) {
                super.onPostExecute(todoLists);

                success.run(todoLists);
            }
        };

        run(t);
    }

    @Override
    public void sortCompletedByUpdateDateDesc(Action<List<TodoList>> success) {
        BackgroundTask<List<TodoList>> t = new BackgroundTask<List<TodoList>>() {
            @Override
            protected List<TodoList> doInBackground(Void... params) {
                return _dao.sortCompletedByUpdateDateDesc();
            }

            @Override
            protected void onPostExecute(List<TodoList> todoLists) {
                super.onPostExecute(todoLists);

                success.run(todoLists);
            }
        };

        run(t);
    }
}
