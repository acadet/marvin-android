package com.adriencadet.marvin.models.dao.interfaces;

import com.adriencadet.marvin.models.beans.Reminder;

import java.util.List;

/**
 * @class IReminderDAO
 * @brief
 */
public interface IReminderDAO {
    void create(Reminder reminder);

    void update(Reminder reminder);

    void delete(Reminder reminder);

    void flagAsDone(Reminder reminder);

    void flagAsUndone(Reminder reminder);

    Reminder find(String id);

    List<Reminder> sortByLabel();

    List<Reminder> sortByLabelDesc();

    List<Reminder> sortByDate();

    List<Reminder> sortByDateDesc();

    List<Reminder> sortByUpdateDate();

    List<Reminder> sortByUpdateDateDesc();

    List<Reminder> sortDoneByLabel();

    List<Reminder> sortDoneByLabelDesc();

    List<Reminder> sortDoneByDate();

    List<Reminder> sortDoneByDateDesc();

    List<Reminder> sortDoneByUpdateDate();

    List<Reminder> sortDoneByUpdateDateDesc();

}
