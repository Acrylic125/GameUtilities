package com.acrylic.games;

import com.acrylic.ui.BaseUI;

public interface Game extends BaseUI, Runnable {

    /** The main game Thread. **/
    Thread getGameThread();

    /** Checks if the game is still running. **/
    boolean isRunning();

    /** The first method to get called tp start up everything. **/
    void start();

    /** The closing method. **/
    void end();

    /** Game Loop **/
    @Override
    default void run() {
        long lastTime = System.nanoTime();
        float amountOfTicks = 60f;
        double ns = 1_000_000_000 / amountOfTicks; //Amount of nanoseconds per tick
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        long updates = 0;
        while (isRunning()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            //
            while(delta >= 1) {
                //update();
                updates++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Frames: " + frames);
                frames = 0;
                //updates = 0;
            }
        }
        end();
    }
}
