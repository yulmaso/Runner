package com.yulmaso.game.Box2d;

import com.badlogic.gdx.math.Vector2;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Containers.UserDataType;

public class EnemyData extends UserData {

    private Vector2 currentPosition;
    private Vector2 linearVelocity;

    public EnemyData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.ENEMY;
        linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
    }

    public Vector2 getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Vector2 currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }
}
