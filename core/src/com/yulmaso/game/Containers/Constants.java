package com.yulmaso.game.Containers;

import com.badlogic.gdx.math.Vector2;

public class Constants {

    public static final String NAME = "Platformer Game";

    public static final float WIDTH = 384f; //pixels
    public static final float HEIGHT = 216f; //pixels

    public static final float PPM = 100; // pixels per meter ratio = 100 pixels in one meter

    public static final float SCALE = 3;

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    public static final int SCORE_MULTIPLIER = 10;

    public static int SCORE = 0;

    //player
    public static final Vector2 PLAYER_DEFAULT_POSITION = new Vector2(45f, 45f);

    public static final float PLAYER_DEFAULT_X = 45f;
    public static final float PLAYER_DEFAULT_Y = 45f;
    public static final float MOVING_LINEAR_VELOCITY = 1f;
    public static final float PLAYER_WIDTH = 19f;
    public static final float PLAYER_HEIGHT = 24f;
    public static final float PLAYER_DENSITY = 0.5f;
    public static final float PLAYER_GRAVITY_SCALE = 3f;

    //enemy
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-2f, 0);
    public static final float ENEMY_X = 384f;
    public static final float ENEMY_Y = 95f;
    public static final float ENEMY_DENSITY = PLAYER_DENSITY;

    //platforms
    public static final float PLATFORM_X = WIDTH / 2;
    public static final float PLATFORM_BOTTOM_Y = 3f;
    public static final float PLATFORM_TOP_Y = 100f;
    public static final float PLATFORM_WIDTH = 192f;
    public static final float PLATFORM_HEIGHT = 0.1f;
    public static final float PLATFORM_DENSITY = 0;

    //limiters

    //background
    public static final int BACKGROUND_TILE_SIZE = 64;
    public static final int SPEED = 250;


}
