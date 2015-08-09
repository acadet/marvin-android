package com.adriencadet.marvin.models.bll.interfaces;

import com.adriencadet.marvin.models.beans.Task;
import com.adriencadet.marvin.models.beans.TodoList;
import com.coshx.chocolatine.utils.actions.Action;

import java.util.List;

/**
 * @class ITaskBLL
 * @brief
 */
public interface ITaskBLL {
    void create(String label, TodoList list);

    void update(Task task);

    void delete(Task task);

    void toggleCompleted(Task task);

    void sortByLabel(TodoList list, Action<List<Task>> success);

    void sortByLabelDesc(TodoList list, Action<List<Task>> success);

    void sortByUpdateDate(TodoList list, Action<List<Task>> success);

    void sortByUpdateDateDesc(TodoList list, Action<List<Task>> success);
}
