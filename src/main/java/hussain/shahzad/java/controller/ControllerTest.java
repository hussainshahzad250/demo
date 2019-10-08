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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

//	@Autowired
//	private ScheduledAnnotationBeanPostProcessor postProcessor;

//	@Autowired
//	private ScheduledTask scheduledTask;

	@Autowired
	private ObjectMapper objectMapper;

	private static final String SCHEDULED_TASKS = "scheduledTasks";

//	@GetMapping(value = "/stopScheduler")
//	public String stopSchedule() {
//		logger.info("Stoping task....");
//		postProcessor.postProcessBeforeDestruction(scheduledTask, SCHEDULED_TASKS);
//		logger.info("Stopped.");
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
		return null;
//		Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
//		if (!setTasks.isEmpty()) {
//			return objectMapper.writeValueAsString(setTasks);
//		} else {
//			return "No running tasks !";
//		}
	}
}