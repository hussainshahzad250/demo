package com.hussain.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Set;

@Slf4j
@RestController
public class ControllerTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

	private static final String SCHEDULED_TASKS = "scheduledTasks";

	@Autowired
    private ScheduledAnnotationBeanPostProcessor postProcessor;

//	@Autowired
//    private ScheduledTask scheduledTask;

	@Autowired
    private ObjectMapper objectMapper;

//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        log.info("The time is now {}", DATE_FORMAT.format(new Date()));
//    }

//    @GetMapping(value = "/stopScheduler")
//    public String stopSchedule() {
//        postProcessor.postProcessBeforeDestruction(scheduledTask, SCHEDULED_TASKS);
//        return "OK";
//    }
//
//    @GetMapping(value = "/startScheduler")
//    public String startSchedule() {
//        postProcessor.postProcessAfterInitialization(scheduledTask, SCHEDULED_TASKS);
//        return "OK";
//    }

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