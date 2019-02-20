package com.xybean.witness.demo;

import android.app.Application;

import com.xybean.witness.Witness;
import com.xybean.witness.demo.log.BuglyLogger;

/**
 * Author @xybean on 2019/2/20.
 */
public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Witness.init(this, new BuglyLogger());
    }
}
