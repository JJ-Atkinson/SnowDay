package com.jatkin.snowday.snowflake;

/**
 * Created by Jarrett on 02/05/16.
 */
public class FlakeFactory {

    public static Snowflake genRandomSnowflake(int maxXLoc) {
        Snowflake flake = new SquareSnowflake();
        flake.setWeight((float)(Math.random()/2)+1);      // FIXME: magic numbers
        flake.setRotationSpeed((float)(Math.random()*Math.PI/18d));
        flake.getPosition().x = (int)(Math.random()*maxXLoc);
        return flake;
    }

}
