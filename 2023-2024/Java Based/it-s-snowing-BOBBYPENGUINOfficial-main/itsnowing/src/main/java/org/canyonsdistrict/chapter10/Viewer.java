package org.canyonsdistrict.chapter10;

import javax.swing.*;

public class Viewer {

    public static void main(String[] args) {
        var frame = new ItsSnowingApp();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
