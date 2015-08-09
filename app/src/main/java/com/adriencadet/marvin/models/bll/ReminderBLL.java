package com.adriencadet.marvin.models.bll;

import com.adriencadet.marvin.models.beans.Reminder;
import com.adriencadet.marvin.models.bll.interfaces.IReminderBLL;
import com.adriencadet.marvin.models.bll.utils.FriendlyDate;
import com.adriencadet.marvin.models.dao.interfaces.IReminderDAO;
import com.adriencadet.marvin.utils.BackgroundTask;
import com.coshx.chocolatine.utils.actions.Action;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.Date;
import java.util.List;

/**
 * @class ReminderBLL
 * @brief
 */
class ReminderBLL extends BaseBLL implements IReminderBLL {
    private IReminderDAO _dao;

    ReminderBLL(IReminderDAO dao) {
        _dao = dao;
    }

    private DateTime _getMidnightOfDay() {
        DateTime now = DateTime.now();
        DateTime outcome = DateTime.now();

        outcome.minusHours(now.getHourOfDay());
        outcome.minusMinutes(now.getMinuteOfDay());
        outcome.minusSeconds(now.getSecondOfDay());

        return outcome;
    }

    private Date _toDate(FriendlyDate date) {
        DateTime outcome;

        switch (date) {
            case LATER:
                outcome = DateTime.now().plusHours(2);
                break;
            case TONIGHT:
                outcome = _getMidnightOfDay().plusHours(18);
                break;
            case TOMORROW:
                outcome = DateTime.now().plusDays(1);
                break;
            case TOMORROW_NIGHT:
                outcome = _getMidnightOfDay().plusDays(1).plusHours(18);
                break;
            case WEEKEND:
                outcome = DateTime.now();
                outcome.plusDays(DateTimeConstants.SATURDAY - outcome.getDayOfWeek());
                break;
            case NEXT_WEEK_END:
                outcome = DateTime.now();
                if (outcome.getDayOfWeek() == DateTimeConstants.SATURDAY) {
                    outcome.plusDays(7);
                } else {
                    // Sunday
                    outcome.plusDays(6);
                }
                break;
            case NEXT_WEEK:
                outcome = DateTime.now().plusDays(7);
                break;
            default:
                outcome = DateTime.now();
                break;
        }

        return outcome.toDate();
    }

    @Override
    public void create(String label, FriendlyDate date) {
        Reminder r = new Reminder();

        r.setLabel(label.trim());
        r.setDate(_toDate(date));
        r.setWasDone(false);

        _dao.create(r);
    }

    @Override
    public void update(Reminder reminder, FriendlyDate date) {
        reminder.setLabel(reminder.getLabel().trim());
        reminder.setDate(_toDate(date));
        _dao.update(reminder);
    }

    @Override
    public void reschedule(Reminder reminder, FriendlyDate date) {
        reminder.setDate(_toDate(date));
        _dao.update(reminder);
    }

    @Override
    public void delete(Reminder reminder) {
        _dao.delete(reminder);
    }

    @Override
    public void toggleDone(Reminder reminder) {
        if (reminder.getWasDone()) {
            _dao.flagAsUndone(reminder);
        } else {
            _dao.flagAsDone(reminder);
        }
    }

    @Override
    public void sortByLabel(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortByLabel();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortByLabelDesc(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortByLabelDesc();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortByDate(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortByDate();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortByDateDesc(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortByDateDesc();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortByUpdateDate(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortByUpdateDateDesc();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortByUpdateDateDesc(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortByUpdateDateDesc();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortDoneByLabel(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortDoneByLabel();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortDoneByLabelDesc(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortDoneByDateDesc();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortDoneByDate(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortDoneByDate();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortDoneByDateDesc(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortDoneByDateDesc();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortDoneByUpdateDate(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortDoneByUpdateDate();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }

    @Override
    public void sortDoneByUpdateDateDesc(Action<List<Reminder>> success) {
        BackgroundTask<List<Reminder>> t = new BackgroundTask<List<Reminder>>() {
            @Override
            protected List<Reminder> doInBackground(Void... params) {
                return _dao.sortByUpdateDateDesc();
            }

            @Override
            protected void onPostExecute(List<Reminder> reminders) {
                super.onPostExecute(reminders);

                success.run(reminders);
            }
        };

        run(t);
    }
}
