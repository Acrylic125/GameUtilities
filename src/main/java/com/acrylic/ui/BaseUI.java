package com.acrylic.ui;

import javax.swing.*;
import java.awt.*;

public interface BaseUI {

    JFrame getJFrame();

    String getTitle();

    int getWidth();

    int getHeight();

    /** Renders the UI **/
    void render();

    default void setIcon(Image icon) {
        getJFrame().setIconImage(icon);
    }

    /** Converts the width and height to a Dimension object. **/
    default Dimension getDimension() {
        return new Dimension(getWidth(),getHeight());
    }

    /** Sets up JFrame with default settings. **/
    default void setupJFrame() {
        Dimension dimension = getDimension();
        JFrame jFrame = getJFrame();
        jFrame.setPreferredSize(dimension);
        jFrame.setMaximumSize(dimension);
        jFrame.setMinimumSize(dimension);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

}
