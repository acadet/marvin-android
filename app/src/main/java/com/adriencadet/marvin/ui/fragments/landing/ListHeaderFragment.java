package com.adriencadet.marvin.ui.fragments.landing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adriencadet.marvin.R;
import com.adriencadet.marvin.ui.fragments.BaseFragment;

import butterknife.ButterKnife;

/**
 * @class ListHeaderFragment
 * @brief
 */
public class ListHeaderFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment;

        fragment = inflater.inflate(R.layout.fragment_list_header, container, false);
        ButterKnife.bind(this, fragment);

        return fragment;
    }
}
