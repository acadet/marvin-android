package com.adriencadet.marvin.ui.activities;

import android.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

import java.util.Map;

/**
 * @class BaseActivity
 * @brief
 */
public abstract class BaseActivity extends Activity {
    public void setFragment(int resourceId, Fragment fragment) {
        getFragmentManager()
            .beginTransaction()
            .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
            .replace(resourceId, fragment)
            .addToBackStack(fragment.getClass().getSimpleName())
            .commit();
    }

    public void setFragments(Map<Integer, Fragment> fragments, boolean keepInStack) {
        FragmentTransaction t = getFragmentManager().beginTransaction();

        t.setCustomAnimations(R.animator.fade_in, R.animator.fade_out);
        for (Map.Entry<Integer, Fragment> e : fragments.entrySet()) {
            t.replace(e.getKey().intValue(), e.getValue());
        }

        if (keepInStack) {
            t.addToBackStack(null);
        }

        t.commit();
    }

    public void setFragments(Map<Integer, Fragment> fragments) {
        setFragments(fragments, true);
    }
}
