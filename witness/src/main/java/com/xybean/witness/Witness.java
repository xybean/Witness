package com.xybean.witness;

import android.content.Context;

import com.xybean.witness.core.DefaultLogger;
import com.xybean.witness.core.ILogger;
import com.xybean.witness.model.LogModel;

/**
 * Author @xybean on 2019/1/10.
 */
public final class Witness {

    private static volatile boolean isStrictMode = false;

    private static ILogger loggerDelegate = new DefaultLogger();

    public static void init(Context context, ILogger logger) {
        if (logger == null) {
            logger = new DefaultLogger();
        }
        loggerDelegate = logger;
        loggerDelegate.init(context);
    }

    public static void v(LogModel model) {
        loggerDelegate.v(model.tag(), model.format());
    }

    public static void i(LogModel model) {
        loggerDelegate.i(model.tag(), model.format());
    }

    public static void d(LogModel model) {
        loggerDelegate.d(model.tag(), model.format());
    }

    public static void w(LogModel model) {
        loggerDelegate.w(model.tag(), model.format());
    }

    public static void e(LogModel model) {
        loggerDelegate.e(model.tag(), model.format());
    }

    public static void s(LogModel model) {
        if (isStrictMode) {
            loggerDelegate.d(model.tag(), model.toString());
        }
    }

    public static void v(String tag, String log) {
        loggerDelegate.v(tag, log);
    }

    public static void i(String tag, String log) {
        loggerDelegate.i(tag, log);
    }

    public static void d(String tag, String log) {
        loggerDelegate.d(tag, log);
    }

    public static void w(String tag, String log) {
        loggerDelegate.w(tag, log);
    }

    public static void e(String tag, String log) {
        loggerDelegate.e(tag, log);
    }

    public static void s(String tag, String log) {
        if (isStrictMode) {
            loggerDelegate.d(tag, log);
        }
    }

    /**
     * 主动上报日志
     */
    public static void postLog(boolean closeStrictMode) {
        loggerDelegate.postLog();
        if (closeStrictMode) {
            setStrictMode(false);
        }
    }

    public static void postLog() {
        postLog(true);
    }

    public static void addExt(Context context, String key, String value) {
        loggerDelegate.addExt(context, key, value);
    }

    public static void removeExt(Context context, String key) {
        loggerDelegate.removeExt(context, key);
    }

    /**
     * 只允许在主线程调用该方法
     *
     * @param strictMode 是否开启严格模式
     */
    public static void setStrictMode(boolean strictMode) {
        isStrictMode = strictMode;
    }

}
