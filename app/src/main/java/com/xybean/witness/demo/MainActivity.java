package com.xybean.witness.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xybean.witness.Witness;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Witness.addExt(this, "UserId", "11111");

        findViewById(R.id.btn_post_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.startActivity(MainActivity.this, LogPostActivity.class);
            }
        });

        findViewById(R.id.btn_exp_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.startActivity(MainActivity.this, ExceptionActivity.class);
            }
        });

        findViewById(R.id.btn_strict_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.startActivity(MainActivity.this, StrictModeActivity.class);
            }
        });

    }
}
