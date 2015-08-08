package com.adriencadet.marvin.models.dao;

import com.adriencadet.marvin.models.beans.BaseBean;

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

    void create(BaseBean bean) {
        getDAL().executeTransaction(
            (dal) -> {
                bean.setId(UUID.randomUUID().toString());
                bean.setCreateDate(DateTime.now().toDate());
                bean.setUpdateDate(DateTime.now().toDate());
                dal.copyToRealm(bean);
            }
        );
    }

    void update(BaseBean bean) {
        bean.setUpdateDate(DateTime.now().toDate());
    }

    <E extends RealmObject> List<E> sort(Class<E> entity, String field) {
        return sort(entity, field, true);
    }

    <E extends RealmObject> List<E> sort(Class<E> entity, String field, boolean ascending) {
        return getDAL().where(entity).findAllSorted(field, ascending);
    }
}
