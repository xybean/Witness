package com.xybean.witness.demo;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Author @xybean on 2019/2/20.
 */
public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "", false);
    }
}
