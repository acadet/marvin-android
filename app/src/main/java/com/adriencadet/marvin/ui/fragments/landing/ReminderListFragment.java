package com.adriencadet.marvin.ui.fragments.landing;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adriencadet.marvin.R;

import butterknife.ButterKnife;

/**
 * @class ReminderListFragment
 * @brief
 */
public class ReminderListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment;

        fragment = inflater.inflate(R.layout.fragment_reminder_list, container, false);
        ButterKnife.bind(this, fragment);

        return fragment;
    }
}
