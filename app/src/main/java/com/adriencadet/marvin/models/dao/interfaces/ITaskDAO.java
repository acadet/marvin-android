package com.adriencadet.marvin.models.dao.interfaces;

import com.adriencadet.marvin.models.beans.Task;

import java.util.List;

/**
 * @class ITaskDAO
 * @brief
 */
public interface ITaskDAO {
    void create(Task task);

    void update(Task task);

    void delete(Task task);

    Task find(String id);

    void flagAsCompleted(Task task);

    void flagAsUncompleted(Task task);

    List<Task> sortByLabel(String todoListId);

    List<Task> sortByLabelDesc(String todoListId);

    List<Task> sortByUpdateDate(String todoListId);

    List<Task> sortByUpdateDateDesc(String todoListId);

    void deleteByList(String todoListId);
}
