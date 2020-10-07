package com.acrylic.ui;

import javax.swing.*;
import java.awt.*;

/**
 * AbstractCanvasUI is the core class of Canvas based UIs.
 * This class extends Canvas and implements the BaseUI interface.
 *
 * The purpose of thi class is to have a less verbose approach
 * to creating UIs.
 */
public abstract class AbstractCanvasUI extends Canvas implements BaseUI {

    private final String title;
    private final JFrame jFrame;

    public AbstractCanvasUI(String title) {
        this(title,Toolkit.getDefaultToolkit().getScreenSize());
    }

    private AbstractCanvasUI(String title,Dimension dimension) {
        this(title,(int) dimension.getWidth(),(int) dimension.getHeight());
    }

    public AbstractCanvasUI(String title, int width, int height) {
        this.title = title;
        setSize(width, height);
        jFrame = new JFrame(title);
        jFrame.add(this);
        jFrame.pack();
        setupJFrame();
        setupCanvas();
    }

    private void setupCanvas() {
        setPreferredSize(jFrame.getPreferredSize());
        setMaximumSize(jFrame.getMaximumSize());
        setMinimumSize(jFrame.getMinimumSize());
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public JFrame getJFrame() {
        return jFrame;
    }
}
