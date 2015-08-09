package com.adriencadet.marvin.models.dao;

import com.adriencadet.marvin.models.beans.Reminder;
import com.adriencadet.marvin.models.dao.interfaces.IReminderDAO;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * @class ReminderDAO
 * @brief
 */
class ReminderDAO extends BaseDAO implements IReminderDAO {
    private final static String LABEL       = "label";
    private final static String DATE        = "date";
    private final static String UPDATE_DATE = "updateDate";

    ReminderDAO(Realm dal) {
        super(dal);
    }

    private RealmQuery<Reminder> _onlyDone() {
        return getDAL().where(Reminder.class).equalTo("wasDone", true);
    }

    List<Reminder> sort(String field) {
        return sort(field, true);
    }

    List<Reminder> sort(String field, boolean ascending) {
        return super.sort(Reminder.class, field, ascending);
    }

    @Override
    public void create(Reminder reminder) {
        getDAL().executeTransaction(
            (dal) -> {
                super.create(reminder);
                dal.copyToRealm(reminder);
            }
        );
    }

    @Override
    public void update(Reminder reminder) {
        getDAL().executeTransaction(
            (dal) -> {
                Reminder r = find(reminder.getId());

                r.setLabel(reminder.getLabel());
                r.setDate(reminder.getDate());

                super.update(r);
            }
        );
    }

    @Override
    public void delete(Reminder reminder) {
        reminder.removeFromRealm();
    }

    @Override
    public void flagAsDone(Reminder reminder) {
        getDAL().executeTransaction((dal) -> reminder.setWasDone(true));
    }

    @Override
    public void flagAsUndone(Reminder reminder) {
        getDAL().executeTransaction((dal) -> reminder.setWasDone(false));
    }

    @Override
    public Reminder find(String id) {
        return getDAL().where(Reminder.class).equalTo("id", id).findFirst();
    }

    @Override
    public List<Reminder> sortByLabel() {
        return sort(LABEL);
    }

    @Override
    public List<Reminder> sortByLabelDesc() {
        return sort(LABEL, false);
    }

    @Override
    public List<Reminder> sortByDate() {
        return sort(DATE);
    }

    @Override
    public List<Reminder> sortByDateDesc() {
        return sort(DATE, false);
    }

    @Override
    public List<Reminder> sortByUpdateDate() {
        return sort(UPDATE_DATE);
    }

    @Override
    public List<Reminder> sortByUpdateDateDesc() {
        return sort(UPDATE_DATE, false);
    }

    @Override
    public List<Reminder> sortDoneByLabel() {
        return _onlyDone().findAllSorted(LABEL);
    }

    @Override
    public List<Reminder> sortDoneByLabelDesc() {
        return _onlyDone().findAllSorted(LABEL, false);
    }

    @Override
    public List<Reminder> sortDoneByDate() {
        return _onlyDone().findAllSorted(DATE);
    }

    @Override
    public List<Reminder> sortDoneByDateDesc() {
        return _onlyDone().findAllSorted(DATE, false);
    }

    @Override
    public List<Reminder> sortDoneByUpdateDate() {
        return _onlyDone().findAllSorted(UPDATE_DATE);
    }

    @Override
    public List<Reminder> sortDoneByUpdateDateDesc() {
        return _onlyDone().findAllSorted(
            UPDATE_DATE,
            false
        );
    }
}
