package org.canyonsdistrict.chapter10;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ItsSnowingApp extends JFrame{
    private SnowflakePanel panel;
    public ItsSnowingApp(){
        panel = new SnowflakePanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        add(panel);
        setSize(screenSize);
    }
}
