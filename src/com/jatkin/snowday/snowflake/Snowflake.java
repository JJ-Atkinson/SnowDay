package com.jatkin.snowday.snowflake;

import processing.core.PGraphics;
import processing.core.PVector;

/**
 * Created by Jarrett on 02/04/16.
 */
public abstract class Snowflake {

    private float weight = 1;
    private float rotation = 0;
    private float rotationSpeed = 0;
    final private PVector position = new PVector();
    final private PVector speed = new PVector();

    /**
     * Render this flake on the surface
     * @param surface
     */
    abstract public void render(PGraphics surface);


    public float getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public PVector getPosition() {
        return position;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public PVector getSpeed() {
        return speed;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
