package com.xybean.witness.demo.aspect;

import com.xybean.witness.Witness;
import com.xybean.witness.model.ThrowableModel;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * Author @xybean on 2019/2/20.
 */
@Aspect
public class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.xybean.witness.demo..*(..))", throwing = "throwable")
    public void anyFuncThrows(Throwable throwable) {
        Witness.w(ThrowableModel.create(throwable));
    }

}
