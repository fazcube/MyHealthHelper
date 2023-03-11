package org.pzj.assistant.task;

import org.pzj.assistant.trayIconUtils.MyTrayIcon;
import org.pzj.assistant.utils.GetTime;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class StandUpTask {

    public static final long STAND_TIME = 60 * 1000;

    @Async
    @Scheduled(initialDelay = STAND_TIME,fixedDelay = STAND_TIME)
    public void standUpTask() {
        System.out.println("--------久坐--------"+ GetTime.getNowTime());
        try {
            MyTrayIcon.displayTray("久坐提醒！","已经坐了很久了，该起身活动活动啦！", java.awt.TrayIcon.MessageType.INFO);
        }catch (AWTException e){
            e.printStackTrace();
        }
    }
}
