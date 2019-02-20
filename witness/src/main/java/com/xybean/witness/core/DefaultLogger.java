package com.xybean.witness.core;

import android.content.Context;
import android.util.Log;

/**
 * Author @xybean on 2019/2/19.
 */
public class DefaultLogger implements ILogger {

    @Override
    public void v(String tag, String log) {
        Log.v(tag, log);
    }

    @Override
    public void i(String tag, String log) {
        Log.i(tag, log);
    }

    @Override
    public void d(String tag, String log) {
        Log.d(tag, log);
    }

    @Override
    public void w(String tag, String log) {
        Log.w(tag, log);
    }

    @Override
    public void e(String tag, String log) {
        Log.e(tag, log);
    }

    @Override
    public void postLog() {
        // do nothing
    }

    @Override
    public void addExt(Context context, String key, String value) {
        // do nothing
    }

    @Override
    public void removeExt(Context context, String key) {
        // do nothing
    }
}
