package org.smacknologs.test.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.smacknologs.test.framework.core.AbstractStep;



/**
 * Sample Step 
 * 
 * @author Saum
 */
public class EncryptUserName extends AbstractStep<String, String> {
    private static final Logger LOGGER = LogManager.getLogger(EncryptUserName.class);

    private String key;

    public EncryptUserName(String c) {
	super("EncryptUserName");
	this.key = c;
    }

    @Override
    protected String doExecute(String input) throws StepException {

	LOGGER.info("Key - " + key + ", Input - " + input);

	return input + "/topics";
    }
}
