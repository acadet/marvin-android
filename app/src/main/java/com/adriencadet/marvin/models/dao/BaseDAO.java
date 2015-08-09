package com.adriencadet.marvin.models.dao;

import com.adriencadet.marvin.models.beans.IBean;

import org.joda.time.DateTime;

import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * @class BaseDAO
 * @brief
 */
abstract class BaseDAO {
    private Realm _dal;

    BaseDAO(Realm dal) {
        _dal = dal;
    }

    Realm getDAL() {
        return _dal;
    }

    void create(IBean bean) {
        bean.setId(UUID.randomUUID().toString());
        bean.setCreateDate(DateTime.now().toDate());
        bean.setUpdateDate(DateTime.now().toDate());
    }

    void update(IBean bean) {
        bean.setUpdateDate(DateTime.now().toDate());
    }

    <E extends RealmObject> List<E> sort(Class<E> entity, String field) {
        return sort(entity, field, true);
    }

    <E extends RealmObject> List<E> sort(Class<E> entity, String field, boolean ascending) {
        return getDAL().where(entity).findAllSorted(field, ascending);
    }
}
