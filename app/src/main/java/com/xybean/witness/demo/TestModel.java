package com.xybean.witness.demo;

import com.xybean.witness.model.JsonModel;

/**
 * Author @xybean on 2019/2/19.
 */
public class TestModel extends JsonModel {

    private Test test;

    public static TestModel create(Test t) {
        return new TestModel(t);
    }

    private TestModel(Test model) {
        this.test = model;
    }

    @Override
    public String format() {
        return test.toString();
    }

    @Override
    public String tag() {
        return test.toString();
    }
}
