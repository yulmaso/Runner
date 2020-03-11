package com.yulmaso.game.Entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.yulmaso.game.Box2d.PlayerData;
import com.yulmaso.game.Containers.Constants;

public class Player extends B2DSprite{

    private float upMovement = 0;
    private float downMovement = 0;
    private float leftMovement = 0;
    private float rightMovement = 0;

    public Player(Body body) {
        super(body);
        setAnimation("ScottRunning.png", 4, 2, 64, 1f/15f);
    }

    public PlayerData getUserData() {
        return (PlayerData) userData;
    }

    public void moveUp(){
        setMovement(new Vector2(rightMovement + leftMovement, Constants.MOVING_LINEAR_VELOCITY));
        upMovement = Constants.MOVING_LINEAR_VELOCITY;
        resetDownMovement();
    }
    public void moveDown(){
        setMovement(new Vector2(rightMovement + leftMovement, -Constants.MOVING_LINEAR_VELOCITY));
        downMovement = -Constants.MOVING_LINEAR_VELOCITY;
        resetUpMovement();
    }
    public void moveLeft(){
        setMovement(new Vector2(-Constants.MOVING_LINEAR_VELOCITY, upMovement + downMovement));
        leftMovement = -Constants.MOVING_LINEAR_VELOCITY;
        resetRightMovement();
    }
    public void moveRight(){
        setMovement(new Vector2(Constants.MOVING_LINEAR_VELOCITY, upMovement + downMovement));
        rightMovement = Constants.MOVING_LINEAR_VELOCITY;
        resetLeftMovement();
    }



    public void resetUpMovement(){
        setMovement(new Vector2(rightMovement + leftMovement, downMovement));
        upMovement = 0;
    }
    public void resetDownMovement(){
        setMovement(new Vector2(rightMovement + leftMovement, upMovement));
        downMovement = 0;
    }
    public void resetRightMovement(){
        setMovement(new Vector2(leftMovement, upMovement + downMovement));
        rightMovement = 0;
    }
    public void resetLeftMovement(){
        setMovement(new Vector2(rightMovement, upMovement + downMovement));
        leftMovement = 0;
    }

    public void resetMovement() {
        setMovement(new Vector2(0,0));
        upMovement = 0;
        downMovement = 0;
        leftMovement = 0;
        rightMovement = 0;
    }

    private void setMovement(Vector2 vector2){
        if (body != null) body.setLinearVelocity(vector2);
    }

    public void setDead() {

        body.setGravityScale(Constants.PLAYER_GRAVITY_SCALE);


    }
}
