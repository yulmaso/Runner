package com.yulmaso.game.Box2d;

import com.badlogic.gdx.math.Vector2;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Containers.UserDataType;

public class PlayerData extends UserData {

    private final Vector2 defaultPosition = new Vector2(Constants.PLAYER_DEFAULT_POSITION);
    private Vector2 currentPosition;

    public PlayerData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.PLAYER;
    }

    public Vector2 getDefaultPosition() {
        return defaultPosition;
    }

    public Vector2 getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Vector2 currentPosition) {
        this.currentPosition = currentPosition;
    }
}
