package org.pzj.assistant.trayIconUtils;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Slf4j
public class MyTrayIcon extends JFrame {
    private static final String IMAGE_PATH = "/statics/images/faz.png";
    private static final SystemTray TRAY = SystemTray.getSystemTray();

//    public MyTrayIcon(){
//        setTitle("选项卡面板");
//        setBounds(400, 400, 400, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        final JLabel label = new JLabel();
//        label.setForeground(Color.black);//设置标签前景色
//        label.setFont(new Font("微软雅黑", Font.BOLD, 16));//设置标签字体，大小，加粗
//        label.setHorizontalAlignment(SwingConstants.CENTER);//设置标签内容居中对齐
//        label.setText("请查看系统托盘中的变化！");
//        add(label);
//        setVisible(true);
//    }

    /**
     * 发出提醒
     * @param caption
     * @param text
     * @param leven
     * @throws AWTException
     */
    public static synchronized void displayTray(String caption,String text,MessageType leven) throws AWTException {
        if (SystemTray.isSupported()){
            Image image = Toolkit.getDefaultToolkit().createImage(MyTrayIcon.class.getResource(IMAGE_PATH));
            java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image, caption);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("健康小助手");
            TRAY.add(trayIcon);
            trayIcon.displayMessage(caption, text, leven);
            try {
                Thread.sleep(7*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            TRAY.remove(trayIcon); // 需要休眠几秒才能关闭，否则会直接关闭tray导致程序直接退出
        }else {
            log.error("该设备不支持系统托盘！");
        }
    }

    /**
     * 添加图标
     * @throws AWTException
     */
//    public static void addTray() throws AWTException {
//
//        Image image = Toolkit.getDefaultToolkit().createImage(MyTrayIcon.class.getResource(IMAGE_PATH));
//        PopupMenu pop = new PopupMenu();//创建弹出式菜单
//        MenuItem menu = new MenuItem("退出");//创建菜单项
//        //给菜单项添加事件监听器，单击时退出系统
//        menu.addActionListener(e -> System.exit(0));
//        pop.add(menu);
//
//        java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image,"健康小助手",pop);
//        trayIcon.setImageAutoSize(true);
//
//        TRAY.add(trayIcon);
//
//    }
}
