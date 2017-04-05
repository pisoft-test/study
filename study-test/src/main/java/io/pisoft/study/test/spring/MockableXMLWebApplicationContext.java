package io.pisoft.study.test.spring;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class MockableXMLWebApplicationContext extends XmlWebApplicationContext {

	@Override
	public Object getBean(String name) throws BeansException {
		Object bean = super.getBean(name);
		replaceFieldValueWithMockableBean(bean);
		return bean;
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		T bean = super.getBean(name, requiredType);
		replaceFieldValueWithMockableBean(bean);
		return bean;
	}

	@Override
	public Object getBean(String name, Object... args) throws BeansException {
		Object bean = super.getBean(name, args);
		replaceFieldValueWithMockableBean(bean);
		return bean;
	}

	public <T> T getBean(Class<T> requiredType) throws BeansException {
		T bean = super.getBean(requiredType);
		replaceFieldValueWithMockableBean(bean);
		return bean;
	}

	private List<Field> getAllFields(Class<?> type) {
		if (type.getSuperclass() == null) {
			return Arrays.asList(type.getDeclaredFields());
		}
		List<Field> currentFields = new ArrayList<Field>(Arrays.asList(type.getDeclaredFields()));
		currentFields.addAll(getAllFields(type.getSuperclass()));
		return currentFields;
	}

	private void replaceFieldValueWithMockableBean(Object bean) {
		System.out.println("----------------");
		try {
			Set<String> fieldNames = MockableBeanInjector.getMockedFieldNames();
			for (String fieldName : fieldNames) {
				List<Field> fields = getAllFields(bean.getClass());
				for (Field field : fields) {
					if (field.getName().equals(fieldName)) {
						field.setAccessible(true);
						field.set(bean, MockableBeanInjector.getBean(fieldName));
					}
				}
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
}
