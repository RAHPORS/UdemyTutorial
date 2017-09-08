package com.rahpors.UdemyTutorial.componet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ramon on 7/09/17.
 */

@Component("taskComponent")
public class TaskComponent {
    private static final Log LOG = LogFactory.getLog(TaskComponent.class);

    @Scheduled(fixedDelay = 2000)
    public void doTask(){
        LOG.info("TIME IS: "+new Date());
    }
}
