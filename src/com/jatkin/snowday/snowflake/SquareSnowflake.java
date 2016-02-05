package com.jatkin.snowday.snowflake;

import processing.core.PConstants;
import processing.core.PGraphics;

/**
 * Created by Jarrett on 02/04/16.
 */
public class SquareSnowflake extends Snowflake {
    private final float size = 13;

    @Override
    public void render(PGraphics surface) {
        surface.pushMatrix();

        surface.translate(getPosition().x, getPosition().y - size/2);
        surface.rotate(getRotation());
        surface.rectMode(PConstants.CENTER);
        surface.rect(0, 0, size, size);

        surface.popMatrix();
    }

}
