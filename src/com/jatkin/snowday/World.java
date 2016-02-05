package com.jatkin.snowday;

import com.jatkin.snowday.snowflake.FlakeFactory;
import com.jatkin.snowday.snowflake.Snowflake;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

/**
 * This class controls all physics for SnowDay.
 *
 * Created by Jarrett on 02/04/16.
 */
public class World {
    private float gravity;
    private List<Snowflake> flurry;
    private Wind wind;
    private int flakeCountTarget;


    public World() { this(2); } // FIXME magic number

    public World(int gravity) {
        this.gravity = gravity;
        flurry = new ArrayList<>();
        wind = new Wind();
        flakeCountTarget = 200;// FIXME magic number
    }

    /**
     * Advance the snow animation 1 frame
     */
    public void tick(int screenWidth, int screenHeight) {
        wind.tick();
        manageSnowflakeCount(screenWidth, screenHeight);
        edgeWrapSnowflakes(screenWidth, screenHeight);
        updateSnowflakePosition();
    }

    /**
     * Wrap flakes around edged of the screen.
     */
    private void edgeWrapSnowflakes(int screenWidth, int screenHeight) {
        flurry.forEach(snowflake -> {
            if (snowflake.getPosition().x > screenWidth)
                snowflake.getPosition().x = 0;
            else if (snowflake.getPosition().x < 0)
                snowflake.getPosition().x = screenWidth;
        });
    }

    /**
     * Reset off screen flakes.
     * @param screenWidth
     * @param screenHeight
     */
    private void manageSnowflakeCount(int screenWidth, int screenHeight) {
        flurry.removeIf(flake -> flake.getPosition().y > screenHeight);

        int newFlakeCount = (int)Math.sqrt(flakeCountTarget - flurry.size());
        for (int i = 0; i < newFlakeCount; i++)
            flurry.add(FlakeFactory.genRandomSnowflake(screenWidth));

    }

    /**
     * Apply wind, gravity and rotation to all the snowflakes
     */
    private void updateSnowflakePosition() {
        for (Snowflake flake : flurry) {
            PVector flakePosition = flake.getPosition();
            float weight = flake.getWeight();

            float downwardsMotion = weight*gravity;
            float windMotion = (wind.getSpeed() / weight);

            flake.getSpeed().set(windMotion, downwardsMotion);
            flakePosition.add(flake.getSpeed());

            flake.setRotation(flake.getRotation() + flake.getRotationSpeed());
        }
    }

    /**
     * Render all the snowflakes this world has onto the surface
     * @param surface
     */
    public void render(PGraphics surface) {
        for (Snowflake flake : flurry) {
            flake.render(surface);
        }
    }


    public float getGravity() {
        return gravity;
    }
}
