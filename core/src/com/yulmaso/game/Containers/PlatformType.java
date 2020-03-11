package com.yulmaso.game.Containers;


import com.yulmaso.game.Entities.Platform;

import java.util.HashMap;

public enum PlatformType {

    PLATFORM_TOP(0, 0,145f, 0),
    PLATFORM_BOTTOM(1,0, 3f, 0);

    private int id;
    private float x;
    private float y;
    private float density;

    private static HashMap<Integer, PlatformType> ids = new HashMap<Integer, PlatformType>();

    static {
        for (PlatformType type : PlatformType.values()){
            ids.put(type.id, type);
        }
    }

    PlatformType(int id, float x, float y, float density) {
        this.x = x;
        this.y = y;
        this.density = density;
    }

    public float getX() { return x; }

    public float getY() {
        return y;
    }

    public float getDensity() {
        return density;
    }

    public static PlatformType getTypeByID(int id){
        return ids.get(id);
    }

}
