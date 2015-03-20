package com.husq.test.model.proxy.jdkproxy;

import java.lang.reflect.Method;

public interface MyinvocationHandle {
	public Object invoke(Object proxy, Method method);
}
