package org.pzj.assistant.task;

import org.pzj.assistant.trayIconUtils.MyTrayIcon;
import org.pzj.assistant.utils.GetTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class WaterTask {

    @Scheduled(cron = "0/10 * * * * ?")
    public void waterTask(){
        new Thread(()->{
            System.out.println("--------喝水--------"+ GetTime.getNowTime());
            try {
                MyTrayIcon.displayTray("喝水提醒！","已经很久没喝水了，快喝杯水吧！", java.awt.TrayIcon.MessageType.INFO);
            }catch (AWTException e){
                e.printStackTrace();
            }
        }).start();
    }
}
