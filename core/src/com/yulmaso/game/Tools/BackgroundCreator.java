package com.yulmaso.game.Tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yulmaso.game.Containers.StreetTileType;

import java.util.HashMap;
import java.util.Random;

public class BackgroundCreator {

    private int numberOfRows = 4;
    private boolean justStarted = true;
    private HashMap<StreetTileType, TextureRegion> tiles = new HashMap<StreetTileType, TextureRegion>();
    private StreetTileType[] lastColumn;

    public BackgroundCreator() {

        lastColumn = new StreetTileType[numberOfRows];

        for (int i = 0; i < numberOfRows; i++) lastColumn[i] = StreetTileType.UNUSED_TILE; //КОСТЫЛЬ!

        Texture background = new Texture("background-street2.png");
        TextureRegion[][] tempFrames = TextureRegion.split(background, 64, 64);

        int index = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 5; j++){
                tiles.put(StreetTileType.getTileTypeById(index), tempFrames[i][j]);
                index++;
            }
        }
    }

    public TextureRegion[] generateBackgroundColumn(){
        StreetTileType[] newLastColumn = new StreetTileType[numberOfRows];
        TextureRegion[] column = new TextureRegion[numberOfRows];
        Random random = new Random();

        int[] temp;
        int value;

        //generating ROAD (0 row)
        if (!lastColumn[0].equals(StreetTileType.ROAD_BEGINNING_RAMP)){ // проверка не была ли предыдущая плитка с началом пандуса
            temp = new int[4];
            temp[0] = StreetTileType.ROAD_1.getId();
            temp[1] = StreetTileType.ROAD_2.getId();
            temp[2] = StreetTileType.ROAD_BEGINNING_RAMP.getId();
            temp[3] = StreetTileType.ROAD_OUTLET.getId();
            value = temp[random.nextInt(4)];

            column[0] = tiles.get(StreetTileType.getTileTypeById(value));
            newLastColumn[0] = StreetTileType.getTileTypeById(value);
        } else {
            column[0] = tiles.get(StreetTileType.ROAD_ENDING_RAMP);
            newLastColumn[0] = StreetTileType.ROAD_ENDING_RAMP;
        }

        //generating sidewalk (1 ROW)
        if (justStarted){
            column[1] = tiles.get(StreetTileType.SIDEWALK_TRASH_LIGHT);
            newLastColumn[1] = StreetTileType.SIDEWALK_TRASH_LIGHT;
        } else {
            switch(lastColumn[1]){ //сверяем с плиткой слева
                case SIDEWALK_DARKWINDOW_LIGHT: { //если предыдущая плитка была освещенной под темным окном
                    column[1] = tiles.get(StreetTileType.SIDEWALK_LITWINDOW_LIGHT);
                    newLastColumn[1] = StreetTileType.SIDEWALK_LITWINDOW_LIGHT;
                } break;

                case SIDEWALK_TRASH_LIGHT: { // если предыдущая плитка была освещённой помойкой
                    column[1] = tiles.get(StreetTileType.SIDEWALK_LITWINDOW_LIGHT);
                    newLastColumn[1] = StreetTileType.SIDEWALK_LITWINDOW_LIGHT;
                } break;

                case SIDEWALK_LITWINDOW_LIGHT: { // если предыдущая плитка была под светлым окном
                    temp = new int[3];
                    temp[0] = StreetTileType.SIDEWALK_DARKWINDOW.getId();
                    temp[1] = StreetTileType.SIDEWALK_DARKWINDOW_LIGHT.getId();
                    temp[2] = StreetTileType.SIDEWALK_DOOR.getId();
                    value = temp[random.nextInt(3)];

                    column[1] = tiles.get(StreetTileType.getTileTypeById(value));
                    newLastColumn[1] = StreetTileType.getTileTypeById(value);
                } break;

                case SIDEWALK_DARKWINDOW: { // если предыдущая плитка была под темным окном
                    temp = new int[3];
                    temp[0] = StreetTileType.SIDEWALK_DARKWINDOW.getId();
                    temp[1] = StreetTileType.SIDEWALK_DARKWINDOW_LIGHT.getId();
                    temp[2] = StreetTileType.SIDEWALK_DOOR.getId();
                    value = temp[random.nextInt(3)];

                    column[1] = tiles.get(StreetTileType.getTileTypeById(value));
                    newLastColumn[1] = StreetTileType.getTileTypeById(value);
                } break;

                case SIDEWALK_DOOR: { // если предыдущая плитка была под дверью
                    temp = new int[2];
                    temp[0] = StreetTileType.SIDEWALK_TRASH.getId();
                    temp[1] = StreetTileType.SIDEWALK_TRASH_LIGHT.getId();
                    value = temp[random.nextInt(2)];

                    column[1] = tiles.get(StreetTileType.getTileTypeById(value));
                    newLastColumn[1] = StreetTileType.getTileTypeById(value);
                } break;

                case SIDEWALK_TRASH: { //если предыдущая плитка была темной помойкой
                    temp = new int[2];
                    temp[0] = StreetTileType.SIDEWALK_DARKWINDOW.getId();
                    temp[1] = StreetTileType.SIDEWALK_DARKWINDOW_LIGHT.getId();
                    value = temp[random.nextInt(2)];

                    column[1] = tiles.get(StreetTileType.getTileTypeById(value));
                    newLastColumn[1] = StreetTileType.getTileTypeById(value);
                } break;
            }
        }

        //generating first floor (2 ROW)
        switch (newLastColumn[1]){ //сверяем с нижней, только что сгенерированной, плиткой
            case SIDEWALK_DARKWINDOW_LIGHT: { // если нижняя плитка освещена под тёмным окном
                column[2] = tiles.get(StreetTileType.FIRSTFLOOR_HOUSE_DARKWINDOW);
                newLastColumn[2] = StreetTileType.FIRSTFLOOR_HOUSE_DARKWINDOW;
            } break;

            case SIDEWALK_TRASH_LIGHT: { // если нижняя плитка - освещённая помойка
                column[2] = tiles.get(StreetTileType.FIRSTFLOOR_TRASH_BEGINNING_HOUSE);
                newLastColumn[2] = StreetTileType.FIRSTFLOOR_TRASH_BEGINNING_HOUSE;
            } break;

            case SIDEWALK_LITWINDOW_LIGHT: { // если нижняя плитка - под светлым окном
                column[2] = tiles.get(StreetTileType.FIRSTFLOOR_HOUSE_LITWINDOW);
                newLastColumn[2] = StreetTileType.FIRSTFLOOR_HOUSE_LITWINDOW;
            } break;

            case SIDEWALK_DARKWINDOW: { // если нижняя плитка - под темным окном
                column[2] = tiles.get(StreetTileType.FIRSTFLOOR_HOUSE_DARKWINDOW);
                newLastColumn[2] = StreetTileType.FIRSTFLOOR_HOUSE_DARKWINDOW;
            } break;

            case SIDEWALK_DOOR: { //если нижняя плитка - с дверью
                column[2] = tiles.get(StreetTileType.FIRSTFLOOR_DOOR_ENDING_HOUSE);
                newLastColumn[2] = StreetTileType.FIRSTFLOOR_DOOR_ENDING_HOUSE;
            } break;

            case SIDEWALK_TRASH: { //если нижняя плитка - тёмная помойка
                column[2] = tiles.get(StreetTileType.FIRSTFLOOR_TRASH_BEGINNING_HOUSE);
                newLastColumn[2] = StreetTileType.FIRSTFLOOR_TRASH_BEGINNING_HOUSE;
            } break;
        }

        //generating second floor (3 ROW)
        switch (newLastColumn[2]){ //сверяем с нижней, только что сгенерированной, плиткой
            case FIRSTFLOOR_TRASH_BEGINNING_HOUSE: { //если нижняя плитка - помойка
                column[3] = tiles.get(StreetTileType.SECONDFLOOR_BEGINNING_HOUSE);
                newLastColumn[3] = StreetTileType.SECONDFLOOR_BEGINNING_HOUSE;
            } break;

            case FIRSTFLOOR_DOOR_ENDING_HOUSE: { //если нижняя плитка - дверь
                column[3] = tiles.get(StreetTileType.SECONDFLOOR_ENDING_HOUSE);
                newLastColumn[3] = StreetTileType.SECONDFLOOR_ENDING_HOUSE;
            } break;

            default: {
                temp = new int[2];
                temp[0] = StreetTileType.SECONDFLOOR_DARKWINDOW_HOUSE.getId();
                temp[1] = StreetTileType.SECONDFLOOR_LITWINDOW_HOUSE.getId();
                value = temp[random.nextInt(2)];

                column[3] = tiles.get(StreetTileType.getTileTypeById(value));
                newLastColumn[3] = StreetTileType.getTileTypeById(value);
            }
        }

        justStarted = false;
        lastColumn = newLastColumn;

        return column;
    }
}
