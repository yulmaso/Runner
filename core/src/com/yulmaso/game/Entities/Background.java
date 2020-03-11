package com.yulmaso.game.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Tools.BackgroundCreator;

import java.util.ArrayList;

import static com.yulmaso.game.Containers.Constants.BACKGROUND_TILE_SIZE;
import static com.yulmaso.game.Containers.Constants.SPEED;

public class Background {

    private ArrayList<TextureRegion[]> backgroundData;
    private BackgroundCreator backgroundCreator;

    private int numberOfColumns;
    private int numberOfRows;
    private int speedArgument = 0;

    private Vector2 movementVector;

    public Background(){
        numberOfColumns = Math.round(Constants.WIDTH) / BACKGROUND_TILE_SIZE + 2;
        numberOfRows = Math.round(Constants.HEIGHT) / BACKGROUND_TILE_SIZE;

        backgroundData = new ArrayList<TextureRegion[]>();
        backgroundCreator = new BackgroundCreator();
        for (int i = 0; i < numberOfColumns; i++){
            backgroundData.add(backgroundCreator.generateBackgroundColumn());
        }
    }

    public void setVector(float dx, float dy){
        movementVector = new Vector2(dx, dy);
    }

    public void update(float dt){
        speedArgument += dt * SPEED;

        if (speedArgument >= BACKGROUND_TILE_SIZE){
            backgroundData.remove(0);
            backgroundData.add(backgroundCreator.generateBackgroundColumn());
            speedArgument = 0;
        }

    }

    public void render(SpriteBatch batch){
        batch.begin();
        for (int i = 0; i < backgroundData.size(); i++){
            for (int j = 0; j < (backgroundData.get(0).length); j++){
                batch.draw(backgroundData.get(i)[j], (float)i * BACKGROUND_TILE_SIZE - speedArgument, (float)j * BACKGROUND_TILE_SIZE, (float)BACKGROUND_TILE_SIZE, (float)BACKGROUND_TILE_SIZE);
            }
        }
        batch.end();
    }

}
