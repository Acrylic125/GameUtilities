package com.acrylic.games;

import com.acrylic.ui.AbstractCanvasUI;

import java.awt.*;
import java.awt.image.BufferStrategy;

public abstract class AbstractGame extends AbstractCanvasUI implements Game {

    private final Thread thread;
    private boolean isRunning = false;

    public AbstractGame(String title) {
        super(title);
        thread = new Thread(this);
        start();
    }

    public AbstractGame(String title, int width, int height) {
        super(title, width, height);
        thread = new Thread(this);
        start();
    }

    @Override
    public synchronized void start() {
        if (isRunning) return;
        isRunning = true;
        thread.start();
    }

    @Override
    public synchronized void end() {
        if (!isRunning) return;
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Thread getGameThread() {
        return thread;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(0,0,getWidth(),getHeight());

        graphics.dispose();
        bufferStrategy.show();
    }

}
