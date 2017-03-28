package io.pisoft.study.core.jpa;

public class Orders {
	public static Order asc(final String fieldName) {
		return new Order() {

			@Override
			public String generate() {
				return fieldName;
			}
		};
	}

	public static Order desc(final String fieldName) {
		return new Order() {

			@Override
			public String generate() {
				return String.format("%s desc", fieldName);
			}
		};
	}
}
