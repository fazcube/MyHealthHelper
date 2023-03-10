package org.pzj.assistant.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StandUpTask {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void standUpTask(){
        System.out.println("--------久坐--------"+new Date());
    }
}
