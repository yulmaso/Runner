package com.yulmaso.game.Containers;

import java.util.HashMap;

public enum StreetTileType {

    SECONDFLOOR_BEGINNING_HOUSE(0, "SECONDFLOOR_BEGINNING_HOUSE"),
    SECONDFLOOR_DARKWINDOW_HOUSE(1, "SECONDFLOOR_DARKWINDOW_HOUSE"),
    SECONDFLOOR_LITWINDOW_HOUSE(2, "SECONDFLOOR_LITWINDOW_HOUSE"),
    SECONDFLOOR_ENDING_HOUSE(3, "SECONDFLOOR_ENDING_HOUSE"),
    SIDEWALK_DARKWINDOW_LIGHT(4, "SIDEWALK_DARKWINDOW_LIGHT"),

    FIRSTFLOOR_TRASH_BEGINNING_HOUSE(5, "FIRSTFLOOR_TRASH_BEGINNING_HOUSE"),
    FIRSTFLOOR_HOUSE_LITWINDOW(6, "FIRSTFLOOR_HOUSE_LITWINDOW"),
    FIRSTFLOOR_HOUSE_DARKWINDOW(7, "FIRSTFLOOR_HOUSE_DARKWINDOW"),
    FIRSTFLOOR_DOOR_ENDING_HOUSE(8, "FIRSTFLOOR_DOOR_ENDING_HOUSE"),
    ROAD_OUTLET(9, "ROAD_OUTLET"),

    SIDEWALK_TRASH_LIGHT(10, "SIDEWALK_TRASH_LIGHT"),
    SIDEWALK_LITWINDOW_LIGHT(11, "SIDEWALK_LITWINDOW_LIGHT"),
    SIDEWALK_DARKWINDOW(12, "SIDEWALK_DARKWINDOW"),
    SIDEWALK_DOOR(13, "SIDEWALK_DOOR"),
    SIDEWALK_TRASH(14, "SIDEWALK_TRASH"),

    ROAD_1(15, "ROAD_1"),
    ROAD_2(16, "ROAD_2"),
    ROAD_BEGINNING_RAMP(17, "ROAD_BEGINNING_RAMP"),
    ROAD_ENDING_RAMP(18, "ROAD_ENDING_RAMP"),
    UNUSED_TILE(19, "UNUSED_TILE");


    private int id;
    private String name;
    //private float damage;

    public static final int TILE_SIZE = 64;


    StreetTileType(int id, String name){
        this.id = id;
        this.name = name;
    }

    private static HashMap<Integer, StreetTileType> tileMap = new HashMap<Integer, StreetTileType>();

    static {
        for (StreetTileType streetTileType : StreetTileType.values()){
            tileMap.put(streetTileType.getId(), streetTileType);
        }
    }

    public static StreetTileType getTileTypeById(int id){
        return tileMap.get(id);
    }

    public static String getNameById(int id){
        return tileMap.get(id).name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
