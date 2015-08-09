package com.adriencadet.marvin.models.bll.interfaces;

import com.adriencadet.marvin.models.beans.Reminder;
import com.adriencadet.marvin.models.bll.utils.FriendlyDate;
import com.coshx.chocolatine.utils.actions.Action;

import java.util.List;

/**
 * @class IReminderBLL
 * @brief
 */
public interface IReminderBLL {
    //void create(String label, Date date);

    void create(String label, FriendlyDate date);

    //void update(String label, Date date);

    void update(Reminder reminder, FriendlyDate date);

    void reschedule(Reminder reminder, FriendlyDate date);

    void delete(Reminder reminder);

    void toggleDone(Reminder reminder);

    void sortByLabel(Action<List<Reminder>> success);

    void sortByLabelDesc(Action<List<Reminder>> success);

    void sortByDate(Action<List<Reminder>> success);

    void sortByDateDesc(Action<List<Reminder>> success);

    void sortByUpdateDate(Action<List<Reminder>> success);

    void sortByUpdateDateDesc(Action<List<Reminder>> success);

    void sortDoneByLabel(Action<List<Reminder>> success);

    void sortDoneByLabelDesc(Action<List<Reminder>> success);

    void sortDoneByDate(Action<List<Reminder>> success);

    void sortDoneByDateDesc(Action<List<Reminder>> success);

    void sortDoneByUpdateDate(Action<List<Reminder>> success);

    void sortDoneByUpdateDateDesc(Action<List<Reminder>> success);

}
