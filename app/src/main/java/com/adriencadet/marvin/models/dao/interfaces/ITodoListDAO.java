package com.adriencadet.marvin.models.dao.interfaces;

import com.adriencadet.marvin.models.beans.TodoList;

import java.util.List;

/**
 * @class ITodoListDAO
 * @brief
 */
public interface ITodoListDAO {
    void create(TodoList list);

    void update(TodoList list);

    void delete(TodoList list);

    void flagAsCompleted(TodoList list);

    void flagAsUncompleted(TodoList list);

    TodoList find(String id);

    List<TodoList> sortByLabel();

    List<TodoList> sortByLabelDesc();

    List<TodoList> sortByUpdateDate();

    List<TodoList> sortByUpdateDateDesc();

    List<TodoList> sortCompletedByLabel();

    List<TodoList> sortCompletedByLabelDesc();

    List<TodoList> sortCompletedByUpdateDate();

    List<TodoList> sortCompletedByUpdateDateDesc();
}
