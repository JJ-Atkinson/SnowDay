package com.jatkin.snowday;

import static java.lang.Math.*;

/**
 * Created by Jarrett on 02/05/16.
 */
public class Wind {
    private final static float maxWind = 6;
    private final static int maxDurationInMs = 5000;
    private final static int minDurationInMs = 2000;
    private float targetSpeed = 0;
    private float speed = 0;
    private long windStopTime = 0;

    public void tick() {
        long now = System.currentTimeMillis();
        if (now > windStopTime)
            calculateNewWind();
        else
            interpolateWindSpeed();
    }

    private void calculateNewWind() {
        float newWindSpeed = (float)sqrt(random()*maxWind*maxWind);
        if (random()>0.5) newWindSpeed = -newWindSpeed;
        int newDuration = (int) (random() * (maxDurationInMs - minDurationInMs)) + minDurationInMs;

        targetSpeed = newWindSpeed;
        windStopTime = newDuration + System.currentTimeMillis();
    }

    private void interpolateWindSpeed() {
        float speedDiff = targetSpeed - speed;
        float speedChange = (float) (sqrt(abs(speedDiff))/15);

        if (speedDiff > 0)
            speed += speedChange;
        else
            speed -= speedChange;
    }

    public float getSpeed() {
        return speed;
    }
}
