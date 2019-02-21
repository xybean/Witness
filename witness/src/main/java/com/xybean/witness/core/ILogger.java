package com.xybean.witness.core;

import android.content.Context;

/**
 * Author @xybean on 2019/2/19.
 */
public interface ILogger {

    void init(Context context);

    void v(String tag, String log);

    void i(String tag, String log);

    void d(String tag, String log);

    void w(String tag, String log);

    void e(String tag, String log);

    void postLog();

    void addExt(Context context, String key, String value);

    void removeExt(Context context, String key);

    void clearAllExt(Context context);

}
