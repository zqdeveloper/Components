package com.component.base;

import java.lang.reflect.Method;

public class MethodInfo {
    public String methodName;
    public Method m;
    public boolean single;

    public MethodInfo(String methodName, Method m, boolean single) {
        this.methodName = methodName;
        this.m = m;
        this.single = single;
    }
}
