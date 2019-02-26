package com.xybean.witness.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xybean.witness.Witness;

public class StrictModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strict_mode);

        findViewById(R.id.btn_strict).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Witness.setStrictMode(true);
            }
        });

        findViewById(R.id.btn_log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Witness.s("STRICT", "hello strict world!");
            }
        });

        findViewById(R.id.btn_close_strict).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Witness.setStrictMode(false);
            }
        });

        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Witness.postLog();
            }
        });

    }
}
