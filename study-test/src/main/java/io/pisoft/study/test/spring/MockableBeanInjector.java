package io.pisoft.study.test.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MockableBeanInjector {

	private static Map<String, Object> mockedBeans = new HashMap<>();

	public static void mockBean(String name, Object bean) {
		mockedBeans.put(name, bean);
	}

	public static Object getBean(String fieldName) {
		return mockedBeans.get(fieldName);
	}

	public static Set<String> getMockedFieldNames() {
		return mockedBeans.keySet();
	}

	public static void clear() {
		mockedBeans.clear();
	}

}
