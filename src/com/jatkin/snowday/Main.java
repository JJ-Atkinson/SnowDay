package com.jatkin.snowday;

import processing.core.PApplet;
import processing.core.PGraphics;

/**
 * Created by Jarrett on 02/04/16.
 */
public class Main extends PApplet {

    public static void main(String[] args) {PApplet.main(Main.class.getCanonicalName());}

    final int backgroundColor = color(0, 146, 178);
    final World world = new World();

    /**
     * Processing 3 has changed the basic format for starting an app from raw
     * java. Size now must be called from `settings`.
     */
    @Override
    public void settings() {
        size(500, 300, FX2D);
    }

    @Override
    public void draw() {
        fill(255);
        noStroke();

        background(backgroundColor);
        world.tick(sketchWidth(), sketchHeight());
        world.render(getGraphics());
    }
}
