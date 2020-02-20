package org.smacknologs.test.framework;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestInputs {

    private Map<String, TestInput<?>> inputs;

    private TestInputs(TestInputsBuilder builder) {
	inputs = Collections.unmodifiableMap(new HashMap<>(builder.builderMap));
    }

    public Number getLong(String key) {
	return (Long) inputs.get(key).get();
    }

    public String getString(String key) {
	return (String) inputs.get(key).get();
    }

    public Set<String> keySet() {
	return inputs.keySet();
    }
    
 

    @Override
    public String toString() {
	return "TestInputs [inputs=" + inputs + "]";
    }


    public static class TestInputsBuilder {

	private Map<String, TestInput<?>> builderMap = new HashMap<>();

	public TestInputsBuilder put(String name, TestInput<?> input) {
	    this.builderMap.put(name, input);
	    return this;
	}

	public TestInputs build() {
	    return new TestInputs(this);
	}
    }
}