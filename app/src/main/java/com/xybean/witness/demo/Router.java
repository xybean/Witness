package com.xybean.witness.demo;

import android.content.Context;
import android.content.Intent;

import com.xybean.witness.Witness;
import com.xybean.witness.demo.model.RouterLogModel;

/**
 * Author @xybean on 2019/2/21.
 */
public class Router {

    public static void startActivity(Context from, Class<?> to) {
        Witness.i(RouterLogModel.create(from, to));
        from.startActivity(new Intent(from, to));
    }

    public static void startActivity(Context from, Class<?> to, Hook hook) {
        Witness.i(RouterLogModel.create(from, to));
        hook.run(from, to);
    }

    interface Hook {
        void run(Context from, Class<?> to);
    }

}
