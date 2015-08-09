package com.adriencadet.marvin.ui.fragments.landing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adriencadet.marvin.R;
import com.adriencadet.marvin.ui.events.ActiveOnlyEvent;
import com.adriencadet.marvin.ui.events.AddReminderEvent;
import com.adriencadet.marvin.ui.events.AddTodoListEvent;
import com.adriencadet.marvin.ui.events.CompletedOnlyEvent;
import com.adriencadet.marvin.ui.events.RemindersSelectedEvent;
import com.adriencadet.marvin.ui.events.TodoListsSelectedEvent;
import com.adriencadet.marvin.ui.events.sort.SortActiveRemindersEvent;
import com.adriencadet.marvin.ui.events.sort.SortActiveTodoListsEvent;
import com.adriencadet.marvin.ui.events.sort.SortCompletedTodoListsEvent;
import com.adriencadet.marvin.ui.events.sort.SortDoneRemindersEvent;
import com.adriencadet.marvin.ui.fragments.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * @class ListHeaderFragment
 * @brief
 */
public class ListHeaderFragment extends BaseFragment {

    public enum HeaderContent {
        REMINDERS,
        TODO_LISTS
    }

    public enum HeaderState {
        ACTIVE,
        COMPLETED
    }

    private HeaderContent _currentContent;
    private HeaderState   _currentState;

    @Bind(R.id.fragment_list_header_active_bar)
    ImageView _activeBar;

    @Bind(R.id.fragment_list_header_completed_label)
    TextView _completedLabel;

    @Bind(R.id.fragment_list_header_completed_bar)
    ImageView _completedBar;

    public EventBus getBus() {
        return EventBus.getDefault();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment;

        fragment = inflater.inflate(R.layout.fragment_list_header, container, false);
        ButterKnife.bind(this, fragment);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _currentContent = HeaderContent.REMINDERS;
        _currentState = HeaderState.ACTIVE;

        getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getBus().unregister(this);
    }

    public void onEventMainThread(RemindersSelectedEvent event) {
        if (_currentContent == HeaderContent.REMINDERS) {
            return;
        }

        _currentContent = HeaderContent.REMINDERS;
        _currentState = HeaderState.ACTIVE;
        _activeBar.setVisibility(View.VISIBLE);
        _completedLabel.setText(getString(R.string.done_reminders_label));
        _completedBar.setVisibility(View.INVISIBLE);
    }

    public void onEventMainThread(TodoListsSelectedEvent event) {
        if (_currentContent == HeaderContent.TODO_LISTS) {
            return;
        }
        _currentContent = HeaderContent.TODO_LISTS;
        _currentState = HeaderState.ACTIVE;
        _activeBar.setVisibility(View.INVISIBLE);
        _completedLabel.setText(getString(R.string.completed_list_label));
        _completedBar.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.fragment_list_header_sort)
    public void onSort(View view) {
        if (_currentContent == HeaderContent.REMINDERS) {
            if (_currentState == HeaderState.ACTIVE) {
                getBus().post(new SortActiveRemindersEvent());
            } else {
                getBus().post(new SortDoneRemindersEvent());
            }
        } else {
            if (_currentState == HeaderState.ACTIVE) {
                getBus().post(new SortActiveTodoListsEvent());
            } else {
                getBus().post(new SortCompletedTodoListsEvent());
            }
        }
    }

    @OnClick(R.id.fragment_list_header_add)
    public void onAdd(View view) {
        if (_currentContent == HeaderContent.REMINDERS) {
            getBus().post(new AddReminderEvent());
        } else {
            getBus().post(new AddTodoListEvent());
        }
    }

    @OnClick(R.id.fragment_list_header_active)
    public void onActiveSelected(View view) {
        if (_currentState == HeaderState.ACTIVE) {
            return;
        }

        _currentState = HeaderState.ACTIVE;
        _activeBar.setVisibility(View.VISIBLE);
        _completedBar.setVisibility(View.INVISIBLE);
        getBus().post(new ActiveOnlyEvent());
    }

    @OnClick(R.id.fragment_list_header_completed)
    public void onCompletedSelected(View view) {
        if (_currentState == HeaderState.COMPLETED) {
            return;
        }

        _currentState = HeaderState.COMPLETED;
        _activeBar.setVisibility(View.INVISIBLE);
        _completedBar.setVisibility(View.VISIBLE);
        getBus().post(new CompletedOnlyEvent());
    }
}
