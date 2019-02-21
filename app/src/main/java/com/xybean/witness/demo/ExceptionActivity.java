package com.xybean.witness.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xybean.witness.Witness;

public class ExceptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);

        findViewById(R.id.btn_exp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ExceptionThrow e = new ExceptionThrow();
                    e.throwException();
                } catch (Exception e) {
                }
            }
        });

        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Witness.postLog(true);
            }
        });

    }

    private static class ExceptionThrow {

        void throwException() throws Exception {
            throw new IllegalArgumentException();
        }

    }
}
