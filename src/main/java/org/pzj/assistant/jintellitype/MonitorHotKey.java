package org.pzj.assistant.jintellitype;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.melloware.jintellitype.JIntellitypeConstants;
import lombok.extern.slf4j.Slf4j;
import org.pzj.assistant.trayIconUtils.MyTrayIcon;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Slf4j
@Configuration
public class MonitorHotKey implements ApplicationRunner {

    public static final int STAND_UP_KEY = 1; // 起立监听键
    public static final int WATER_KEY = 2; // 喝水监听键

    @Override
    public void run(ApplicationArguments args) throws AWTException {
        JIntellitype.getInstance().registerHotKey(STAND_UP_KEY, JIntellitypeConstants.MOD_SHIFT + JIntellitype.MOD_ALT + JIntellitype.MOD_CONTROL,'R');
        JIntellitype.getInstance().registerHotKey(WATER_KEY, JIntellitypeConstants.MOD_SHIFT + JIntellitype.MOD_ALT + JIntellitype.MOD_CONTROL,'W');
        HotkeyListener hotkeyListener = id -> {
            switch (id) {
                case STAND_UP_KEY:
                    System.out.println("久坐提醒！");
                    try {
                        MyTrayIcon.displayTray("久坐提醒！","已经坐了很久了，起来走走吧！", java.awt.TrayIcon.MessageType.INFO);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    break;
                case WATER_KEY:
                    System.out.println("喝水提醒！");
                    try {
                        MyTrayIcon.displayTray("喝水提醒！","已经很久没喝水了，喝点水吧！", java.awt.TrayIcon.MessageType.INFO);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        };
        JIntellitype.getInstance().addHotKeyListener(hotkeyListener);
        MyTrayIcon.addTray();
        log.info("==========快捷键监听初始化完成==========");
    }
}
