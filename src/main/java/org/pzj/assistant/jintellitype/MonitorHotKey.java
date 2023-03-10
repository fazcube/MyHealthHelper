package org.pzj.assistant.jintellitype;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.melloware.jintellitype.JIntellitypeConstants;
import lombok.extern.slf4j.Slf4j;
import org.pzj.assistant.trayIconUtils.MyTrayIcon;
import org.pzj.assistant.utils.GetTime;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Slf4j
@Configuration
public class MonitorHotKey implements ApplicationRunner {

    public static final int STAND_UP_KEY = 1; // 起立监听键id
    public static final int WATER_KEY = 2; // 喝水监听键id
    public static final int STAND_UP_INTERVAL = 60 * 60; // 久坐提醒间隔时间 单位秒
    public static final int WATER_INTERVAL = 30 * 60; // 久坐提醒间隔时间 单位秒

    @Override
    public void run(ApplicationArguments args) throws AWTException {
        // 注册快捷键
        JIntellitype.getInstance().registerHotKey(STAND_UP_KEY, JIntellitypeConstants.MOD_SHIFT + JIntellitype.MOD_ALT + JIntellitype.MOD_CONTROL,'R');
        JIntellitype.getInstance().registerHotKey(WATER_KEY, JIntellitypeConstants.MOD_SHIFT + JIntellitype.MOD_ALT + JIntellitype.MOD_CONTROL,'W');
        HotkeyListener hotkeyListener = id -> {
            switch (id) {
                case STAND_UP_KEY:
                    System.out.println("推迟一小时久坐提醒！");
                    try {
                        MyTrayIcon.displayTray("推迟一小时久坐提醒！","下次提醒时间："+
                                GetTime.getHowManySecond(STAND_UP_INTERVAL) +"！", java.awt.TrayIcon.MessageType.INFO);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    break;
                case WATER_KEY:
                    System.out.println("推迟半小时喝水提醒！");
                    try {
                        MyTrayIcon.displayTray("推迟半小时喝水提醒！","下次提醒时间："+
                                GetTime.getHowManySecond(WATER_INTERVAL) +"！", java.awt.TrayIcon.MessageType.INFO);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        };
        JIntellitype.getInstance().addHotKeyListener(hotkeyListener); // 添加监听器
//        MyTrayIcon.addTray(); // 初始化状态栏图标
        log.info("==========快捷键监听初始化完成==========");
    }
}
