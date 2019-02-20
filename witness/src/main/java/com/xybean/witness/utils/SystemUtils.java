package com.xybean.witness.utils;

/**
 * Author @xybean on 2019/1/10.
 */
public class SystemUtils {

    /**
     * 获取当前进程id
     *
     * @return 进程id
     */
    public static int currentPid() {
        return android.os.Process.myPid();
    }

    /**
     * 获取当前线程id
     *
     * @return 线程id
     */
    public static int currentTid() {
        return android.os.Process.myTid();
    }

}
