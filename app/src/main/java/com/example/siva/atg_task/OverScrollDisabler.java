package com.example.siva.atg_task;

import android.view.View;

/**
 * Created by siva on 22/9/18.
 */

public class OverScrollDisabler {

    public static void disableOverScroll(View view)
    {
        view.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }
}
