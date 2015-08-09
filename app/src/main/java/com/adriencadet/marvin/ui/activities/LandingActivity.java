package com.adriencadet.marvin.ui.activities;

import android.app.Fragment;
import android.os.Bundle;

import com.adriencadet.marvin.R;
import com.adriencadet.marvin.ui.fragments.landing.ListFooterFragment;
import com.adriencadet.marvin.ui.fragments.landing.ListHeaderFragment;
import com.adriencadet.marvin.ui.fragments.landing.ReminderListFragment;

import java.util.HashMap;
import java.util.Map;

public class LandingActivity extends BaseActivity {

    private void _showReminderList() {
        Map<Integer, Fragment> fragmentMap;

        fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.landing_header, new ListHeaderFragment());
        fragmentMap.put(R.id.landing_footer, new ListFooterFragment());
        fragmentMap.put(R.id.landing_body, new ReminderListFragment());

        setFragments(fragmentMap, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        _showReminderList();
    }
}
