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

    List<Task> sort(String field) {
        return sort(field, true);
    }

    List<Task> sort(String field, boolean ascending) {
        return super.sort(Task.class, field, ascending);
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
    public List<Task> sortByLabel() {
        return sort(LABEL);
    }

    @Override
    public List<Task> sortByLabelDesc() {
        return sort(LABEL, false);
    }

    @Override
    public List<Task> sortByUpdateDate() {
        return sort(UPDATE_DATE);
    }

    @Override
    public List<Task> sortByUpdateDateDesc() {
        return sort(UPDATE_DATE, false);
    }
}
