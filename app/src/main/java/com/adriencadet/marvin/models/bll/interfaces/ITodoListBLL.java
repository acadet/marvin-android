package com.adriencadet.marvin.models.bll.interfaces;

import com.adriencadet.marvin.models.beans.TodoList;
import com.adriencadet.marvin.models.beans.utils.TodoListColor;
import com.coshx.chocolatine.utils.actions.Action;
import com.coshx.chocolatine.utils.actions.Action0;

import java.util.List;

/**
 * @class ITodoListBLL
 * @brief
 */
public interface ITodoListBLL extends IBLL {
    void create(String label, TodoListColor color);

    void update(TodoList list);

    void delete(TodoList list, Action0 success);

    void toggleCompleted(TodoList list);

    void sortByLabel(Action<List<TodoList>> success);

    void sortByLabelDesc(Action<List<TodoList>> success);

    void sortByUpdateDate(Action<List<TodoList>> success);

    void sortByUpdateDateDesc(Action<List<TodoList>> success);

    void sortCompletedByLabel(Action<List<TodoList>> success);

    void sortCompletedByLabelDesc(Action<List<TodoList>> success);

    void sortCompletedByUpdateDate(Action<List<TodoList>> success);

    void sortCompletedByUpdateDateDesc(Action<List<TodoList>> success);
}
