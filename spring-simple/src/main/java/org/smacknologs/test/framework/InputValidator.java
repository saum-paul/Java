package org.smacknologs.test.framework;

import java.util.Set;

public interface InputValidator {

    void validate(TestInputs inputs);

    public class DefaultInputValidator implements InputValidator {

	private String[] requiredKeys;

	public DefaultInputValidator(String[] requiredKeys) {
	    this.requiredKeys = requiredKeys;
	}

	@Override
	public void validate(TestInputs inputs) {
	    Set<String> keySet = inputs.keySet();
	    StringBuilder sb = new StringBuilder();
	    for (String key : requiredKeys) {
		if (!keySet.contains(key))
		    sb.append(key).append(", ");
	    }

	    String missingInput = sb.toString();

	    if (missingInput.isEmpty())
		throw new IllegalArgumentException("Required inputs = [" + missingInput + "] are missing.");
	}
    }
}
