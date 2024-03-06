package org.canyonsdistrict.chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempSnowflakeFrame extends JFrame {
    private Snowflake component;
    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            component.fall(3);
        }
    }
    public TempSnowflakeFrame(){
        component = new Snowflake(100, 100, 25, 10, 6);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) Math.round(screenSize.getWidth());
        int screenHeight = (int) Math.round(screenSize.getHeight());
        add(component);
        setSize(screenSize);
        var listener = new TimerListener();
        final int DELAY = 1;
        var timer = new Timer(DELAY, listener);
        timer.start();
    }
}
