package org.pzj.assistant.task;

import org.pzj.assistant.trayIconUtils.MyTrayIcon;
import org.pzj.assistant.utils.GetTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class StandUpTask {

    @Scheduled(cron = "10 0/1 * * * ?")
    public void standUpTask() {
        new Thread(()->{
            System.out.println("--------久坐--------"+ GetTime.getNowTime());
            try {
                MyTrayIcon.displayTray("久坐提醒！","已经坐了很久了，该起身活动活动啦！", java.awt.TrayIcon.MessageType.INFO);
            }catch (AWTException e){
                e.printStackTrace();
            }
        });
    }
}
