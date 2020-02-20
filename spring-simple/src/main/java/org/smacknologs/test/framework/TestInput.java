package org.smacknologs.test.framework;

public class TestInput<T> {

    private T value;

    private TestInput(T input) {
	this.value = input;
    }

    public static TestInput<Long> instanceOf(Long value) {
	return new TestInput<>(value);
    }

    public static TestInput<String> instanceOf(String value) {
	return new TestInput<>(value);
    }

    public T get() {
	return this.value;
    }

    @Override
    public String toString() {
	return "\n\tTestInput [value=" + value + "]";
    }
}