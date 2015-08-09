package com.adriencadet.marvin.models.dao;

import com.adriencadet.marvin.models.beans.TodoList;
import com.adriencadet.marvin.models.dao.interfaces.ITodoListDAO;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * @class TodoListDAO
 * @brief
 */
class TodoListDAO extends BaseDAO implements ITodoListDAO {
    private final static String LABEL       = "label";
    private final static String UPDATE_DATE = "updateDate";

    TodoListDAO(Realm dal) {
        super(dal);
    }

    private RealmQuery<TodoList> _onlyCompleted() {
        return getDAL().where(TodoList.class).equalTo("wasCompleted", true);
    }

    public List<TodoList> sort(String field) {
        return sort(field, true);
    }

    public List<TodoList> sort(String field, boolean ascending) {
        return super.sort(TodoList.class, field, ascending);
    }

    @Override
    public void create(TodoList list) {
        getDAL().executeTransaction(
            (dal) -> {
                super.create(list);
                dal.copyToRealm(list);
            }
        );
    }

    @Override
    public void update(TodoList list) {
        getDAL().executeTransaction(
            (dal) -> {
                TodoList l = find(list.getId());

                l.setLabel(l.getLabel());
                l.setColor(l.getColor());

                super.update(l);
            }
        );
    }

    @Override
    public void delete(TodoList list) {
        list.removeFromRealm();
    }

    @Override
    public void flagAsCompleted(TodoList list) {
        getDAL().executeTransaction((dal) -> list.setWasCompleted(true));
    }

    @Override
    public void flagAsUncompleted(TodoList list) {
        getDAL().executeTransaction((dal) -> list.setWasCompleted(false));
    }

    @Override
    public TodoList find(String id) {
        return getDAL().where(TodoList.class).equalTo("id", id).findFirst();
    }

    @Override
    public List<TodoList> sortByLabel() {
        return sort(LABEL);
    }

    @Override
    public List<TodoList> sortByLabelDesc() {
        return sort(LABEL, false);
    }

    @Override
    public List<TodoList> sortByUpdateDate() {
        return sort(UPDATE_DATE);
    }

    @Override
    public List<TodoList> sortByUpdateDateDesc() {
        return sort(UPDATE_DATE, false);
    }

    @Override
    public List<TodoList> sortCompletedByLabel() {
        return _onlyCompleted().findAllSorted(LABEL);
    }

    @Override
    public List<TodoList> sortCompletedByLabelDesc() {
        return _onlyCompleted().findAllSorted(LABEL, false);
    }

    @Override
    public List<TodoList> sortCompletedByUpdateDate() {
        return _onlyCompleted().findAllSorted(UPDATE_DATE);
    }

    @Override
    public List<TodoList> sortCompletedByUpdateDateDesc() {
        return _onlyCompleted().findAllSorted(UPDATE_DATE, false);
    }
}
