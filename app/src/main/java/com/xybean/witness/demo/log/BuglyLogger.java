package com.xybean.witness.demo.log;

import android.content.Context;

import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.CrashReport;
import com.xybean.witness.core.ILogger;
import com.xybean.witness.demo.R;

/**
 * Author @xybean on 2019/2/20.
 */
public class BuglyLogger implements ILogger {
    @Override
    public void init(Context context) {
        CrashReport.initCrashReport(context.getApplicationContext(), context.getResources().getString(R.string.bugly_app_id), true);
    }

    @Override
    public void v(String tag, String log) {
        BuglyLog.v(tag, log);
    }

    @Override
    public void i(String tag, String log) {
        BuglyLog.i(tag, log);
    }

    @Override
    public void d(String tag, String log) {
        BuglyLog.d(tag, log);
    }

    @Override
    public void w(String tag, String log) {
        BuglyLog.w(tag, log);
    }

    @Override
    public void e(String tag, String log) {
        BuglyLog.e(tag, log);
    }

    @Override
    public void postLog() {
        CrashReport.postCatchedException(new LogWrapperException());
    }

    @Override
    public void addExt(Context context, String key, String value) {
        CrashReport.putUserData(context, key, value);
    }

    @Override
    public void removeExt(Context context, String key) {
        CrashReport.removeUserData(context, key);
    }
}
