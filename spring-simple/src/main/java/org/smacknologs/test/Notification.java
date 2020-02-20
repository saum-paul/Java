package org.smacknologs.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notification {
    private List<String> errors = new ArrayList<>();

    public void addError(String message) {
	errors.add(message);
    }

    public boolean hasErrors() {
	return !errors.isEmpty();
    }

    public String errorMessage() {
	return errors.stream().collect(Collectors.joining(", "));
    }
}
