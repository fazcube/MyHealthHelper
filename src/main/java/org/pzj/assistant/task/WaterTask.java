package org.pzj.assistant.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WaterTask {

    @Scheduled(cron = "*/30 * * * * ?")
    public void waterTask(){
        System.out.println("--------喝水--------"+new Date());

    }
}
