package io.pisoft.study.test.spring;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class ChangeResistantMockFactory {

	private Object outerInstance;

	public ChangeResistantMockFactory(Object outerInstance) {
		this.outerInstance = outerInstance;
	}

	@SuppressWarnings("unchecked")
	public <T> T implementAbstractMethods(Class<T> clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(NoOp.INSTANCE);
		return (T) enhancer.create(new Class[] { outerInstance.getClass() }, new Object[] { outerInstance });
	}

}
