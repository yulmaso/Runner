package com.yulmaso.game.Tools;

import com.badlogic.gdx.physics.box2d.Body;
import com.yulmaso.game.Box2d.UserData;
import com.yulmaso.game.Containers.UserDataType;

public class BodyUtils {

    public static boolean bodyIsPlayer(Body body){
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.PLAYER;
    }

    public static boolean bodyInBounds(Body body) {
        UserData userData = (UserData) body.getUserData();

        switch (userData.getUserDataType()) {
            case PLAYER:
            case ENEMY:
                return body.getPosition().x + userData.getWidth() / 2 > 0;
        }

        return true;
    }

    public static boolean bodyIsEnemy(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.ENEMY;
    }

}
