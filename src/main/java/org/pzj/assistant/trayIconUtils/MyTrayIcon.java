package org.pzj.assistant.trayIconUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTrayIcon extends JFrame {
    private static final String IMAGE_PATH = "/statics/images/faz.png";

    public MyTrayIcon(){
        setTitle("选项卡面板");
        setBounds(400, 400, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setForeground(Color.black);//设置标签前景色
        label.setFont(new Font("微软雅黑", Font.BOLD, 16));//设置标签字体，大小，加粗
        label.setHorizontalAlignment(SwingConstants.CENTER);//设置标签内容居中对齐
        label.setText("请查看系统托盘中的变化！");
        add(label);
        setVisible(true);
    }

    /**
     * 发出提醒
     * @param caption
     * @param text
     * @param leven
     * @throws AWTException
     */
    public static void displayTray(String caption,String text,MessageType leven) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage(MyTrayIcon.class.getResource(IMAGE_PATH));
        java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image, caption);
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("健康小助手");
        tray.add(trayIcon);
        trayIcon.displayMessage(caption, text, leven);
        tray.remove(trayIcon);
    }

    /**
     * 添加图标
     * @throws AWTException
     */
    public static void addTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage(MyTrayIcon.class.getResource(IMAGE_PATH));
        PopupMenu pop = new PopupMenu();//创建弹出式菜单
        MenuItem menu = new MenuItem("退出");//创建菜单项
        //给菜单项添加事件监听器，单击时退出系统
        menu.addActionListener(e -> System.exit(0));
        pop.add(menu);

        java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image,"健康小助手",pop);
        trayIcon.setImageAutoSize(true);

        tray.add(trayIcon);

    }
}
