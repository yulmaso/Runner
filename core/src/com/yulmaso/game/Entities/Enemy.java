package com.yulmaso.game.Entities;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.yulmaso.game.Box2d.EnemyData;
import com.yulmaso.game.Containers.Constants;

public class Enemy extends B2DSprite{

    public Enemy(Body body) {
        super(body);
        body.setLinearVelocity(Constants.ENEMY_LINEAR_VELOCITY);
        setAnimation("bomb.png", 3, 1, 15, 1f/9f);
    }

    public void setVelocity() {
        body.setLinearVelocity(Constants.ENEMY_LINEAR_VELOCITY);
    }

    public void resetMovement(){
        body.setLinearVelocity(new Vector2(0, 0));
    }

    public EnemyData getUserData() {
        return (EnemyData)userData;
    }

    public float getBodyX(){
        return body.getPosition().x;
    }
}
