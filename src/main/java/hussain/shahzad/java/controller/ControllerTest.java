/*************************************************************************
* 
* SATIN CREDITCARE NETWORK LIMITED CONFIDENTIAL
* __________________
* 
*  [2018] SATIN CREDITCARE NETWORK LIMITED
*  All Rights Reserved.
* 
* NOTICE:  All information contained herein is, and remains the property of SATIN CREDITCARE NETWORK LIMITED, and
* The intellectual and technical concepts contained herein are proprietary to SATIN CREDITCARE NETWORK LIMITED
* and may be covered by India and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission
* is obtained from SATIN CREDITCARE NETWORK LIMITED.
*/
package hussain.shahzad.java.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ControllerTest {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	private static final Logger log = LoggerFactory.getLogger(ControllerTest.class);

	@Autowired
	private ScheduledAnnotationBeanPostProcessor postProcessor;

//	@Autowired
//	private ScheduledTask scheduledTask;

	@Autowired
	private ObjectMapper objectMapper;

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		log.info("The time is now {}", DATE_FORMAT.format(new Date()));
	}

	private static final String SCHEDULED_TASKS = "scheduledTasks";

//	@GetMapping(value = "/stopScheduler")
//	public String stopSchedule() {
//		postProcessor.postProcessBeforeDestruction(scheduledTask, SCHEDULED_TASKS);
//		return "OK";
//	}
//
//	@GetMapping(value = "/startScheduler")
//	public String startSchedule() {
//		postProcessor.postProcessAfterInitialization(scheduledTask, SCHEDULED_TASKS);
//		return "OK";
//	}

	@GetMapping(value = "/listScheduler")
	public String listSchedules() throws JsonProcessingException {
		Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
		if (!setTasks.isEmpty()) {
			return objectMapper.writeValueAsString(setTasks);
		} else {
			return "No running tasks !";
		}
	}
}