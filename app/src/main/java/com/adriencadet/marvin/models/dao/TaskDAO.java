package com.adriencadet.marvin.models.dao;

import com.adriencadet.marvin.models.beans.Task;
import com.adriencadet.marvin.models.dao.interfaces.ITaskDAO;

import java.util.List;

import io.realm.Realm;

/**
 * @class TaskDAO
 * @brief
 */
class TaskDAO extends BaseDAO implements ITaskDAO {
    private final static String LABEL       = "label";
    private final static String UPDATE_DATE = "updateDate";

    TaskDAO(Realm dal) {
        super(dal);
    }

    List<Task> sort(String todoListId, String field) {
        return sort(todoListId, field, true);
    }

    List<Task> sort(String todoListId, String field, boolean ascending) {
        return
            getDAL()
                .where(Task.class)
                .equalTo("listId", todoListId)
                .findAllSorted(field, ascending);
    }

    @Override
    public void create(Task task) {
        super.create(task);
    }

    @Override
    public void update(Task task) {
        getDAL().executeTransaction(
            (dal) -> {
                Task t = find(task.getId());

                t.setLabel(task.getLabel());

                super.update(t);
            }
        );
    }

    @Override
    public void delete(Task task) {
        task.removeFromRealm();
    }

    @Override
    public Task find(String id) {
        return getDAL().where(Task.class).equalTo("id", id).findFirst();
    }

    @Override
    public void flagAsCompleted(Task task) {
        getDAL().executeTransaction((dal) -> task.setWasCompleted(true));
    }

    @Override
    public void flagAsUncompleted(Task task) {
        getDAL().executeTransaction((dal) -> task.setWasCompleted(false));
    }

    @Override
    public List<Task> sortByLabel(String todoListId) {
        return sort(todoListId, LABEL);
    }

    @Override
    public List<Task> sortByLabelDesc(String todoListId) {
        return sort(todoListId, LABEL, false);
    }

    @Override
    public List<Task> sortByUpdateDate(String todoListId) {
        return sort(todoListId, UPDATE_DATE);
    }

    @Override
    public List<Task> sortByUpdateDateDesc(String todoListId) {
        return sort(todoListId, UPDATE_DATE, false);
    }
}
