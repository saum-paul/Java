package org.saum.thoughtworks;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.saum.thoughtworks.scheduler.Break;
import org.saum.thoughtworks.scheduler.ScheduleBuilder;
import org.saum.thoughtworks.scheduler.Scheduler;
import org.saum.thoughtworks.scheduler.SimpleScheduler;
import org.saum.thoughtworks.scheduler.Topic;

/**
 * 
 * Client Class to input Topic and create a schedule.
 * 
 * Run Options : 
 * java Client
 * java Client 2019-11-14T09:00:00
 * java Client 2019-11-14T09:00:00 input.txt
 * 
 * @author Saum
 *
 */
public class Client {
	private static final Logger LOGGER = LogManager.getLogger(Client.class);

	public static void main(String[] args) {
		TopicFactory tf = new TopicFactory();
		String startDateTime = LocalDate.now().atTime(9, 0).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		
		String inputFile = "input.txt";
		
		if(args.length>0) 
			startDateTime = args[0];
		
		if(args.length>1) 
			inputFile = args[1];
		
		ScheduleBuilder scheduleBuilder = null;
		try {
		scheduleBuilder = new ScheduleBuilder(startDateTime);
		} catch (DateTimeParseException e) {
			LOGGER.error("\n\n\t\tInvalid Date format, correct format is (2019-11-14T09:00:00). Exiting aplication.", e.getMessage());
			System.exit(0);
		}
		scheduleBuilder.tracks(2);
		scheduleBuilder.addBreak(Break.LUNCH);

		List<Topic> topics = new ArrayList<>();
		try (Scanner sc = new Scanner(new File(inputFile))) {

			while (sc.hasNextLine()) {
				topics.add(tf.make(sc.nextLine()));

			}
		} catch (FileNotFoundException e) {
			LOGGER.error("\n\n\t\tInput File was Not Found, exiting aplication.", e.getMessage());
			System.exit(0);
		}

		Scheduler scheduler = new SimpleScheduler(scheduleBuilder);
		LOGGER.info(scheduler.populateSchedule(topics));

	}

}
