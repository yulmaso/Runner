package com.yulmaso.game.Entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class Button {

    //center at x, y
    private float x;
    private float y;
    private float width;
    private float height;

    private String nameOfPic;
    private int numderOfFrames;
    private OrthographicCamera camera;

    private boolean isClicked;
    private String text;
    private Texture texture;
    private Vector3 vector;

    public Button(float x, float y, String nameOfPic, OrthographicCamera camera) {
        this.x = x;
        this.y = y;
        this.nameOfPic = nameOfPic;
        this.camera = camera;

        vector = new Vector3();
        texture = new Texture(nameOfPic);
    }

    public void update(float dt){
    }


}
