package com.yulmaso.game.Box2d;

import com.yulmaso.game.Containers.PlatformType;
import com.yulmaso.game.Containers.UserDataType;

public class PlatformData extends UserData {

    private PlatformType type;

    public PlatformData(PlatformType type) {
        userDataType = UserDataType.PLATFORM;
        this.type = type;
    }
}
