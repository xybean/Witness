package com.xybean.witness.demo.model;

import android.content.Context;

import com.xybean.witness.model.LogModel;

/**
 * Author @xybean on 2019/2/21.
 */
public class RouterLogModel implements LogModel {

    private Context from;
    private Class<?> to;
    private static final String TAG = "ROUTER";

    public static RouterLogModel create(Context from, Class<?> to) {
        return new RouterLogModel(from, to);
    }

    private RouterLogModel(Context from, Class<?> to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String format() {
        return "from " + from.getClass().getCanonicalName() + " to " + to.getCanonicalName();
    }

    @Override
    public String tag() {
        return TAG;
    }
}
