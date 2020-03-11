package com.yulmaso.game.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Containers.Fonts;
import static com.yulmaso.game.Containers.Constants.SCORE_MULTIPLIER;

public class Score {

    private TextureRegion[] numbers;
    private TextureRegion[] score;

    private Fonts font = Fonts.NUMBERS_MEDIUM;
    private final int sizeOfScore = 8;

    private float X;
    private float Y;

    public Score(){

        X = font.getTileWidth();
        Y = Constants.HEIGHT - font.getTileHeight() ;

        Texture texture = new Texture(font.getNameOfPic());
        numbers = new TextureRegion[font.getTileWidth() * font.getTileHeight()];
        TextureRegion[][] tempFrames = TextureRegion.split(texture, font.getTileWidth(),  font.getTileHeight());
        int index = 0;
        for (int i = 0; i < font.getNumberOfRows(); i++){
            for (int j = 0; j < font.getNumberOfColumns(); j++){
                numbers[index++] = tempFrames[i][j];
            }
        }
    }

    public void update(int distance){
        distance *= SCORE_MULTIPLIER;
        score = new TextureRegion[sizeOfScore];
        for (int i = 0; i < sizeOfScore; i++){
            double divider = Math.pow(10, sizeOfScore - i);
            int argument = (int) Math.abs(distance / divider);
            score[i] = numbers[argument];
            distance = distance - argument * (int)divider;
        }
    }

    public void  render(SpriteBatch batch){
        batch.begin();
        for (int i = 0; i < sizeOfScore; i++){
            batch.draw(score[i], X + font.getTileWidth() * i, Y);
        }
        batch.end();
    }

}
