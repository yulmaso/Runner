package com.yulmaso.game.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.yulmaso.game.Box2d.UserData;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Tools.Animation;

public class B2DSprite {

    protected Body body;
    protected UserData userData;
    protected Animation animation;
    protected float width;
    protected float height;

    public B2DSprite(Body body) {
        this.body = body;
        animation = new Animation();
        this.userData = (UserData) body.getUserData();
    }

    public void setAnimation(String nameOfPic, int numberOfColumns, int numberOfRows, int tileSize, float frameDuration) {
        Texture img = new Texture(nameOfPic);
        TextureRegion[] animationFrames = new TextureRegion[numberOfColumns * numberOfRows];
        TextureRegion[][] tempFrames = TextureRegion.split(img, tileSize, tileSize);
        int index = 0;
        for (int i = 0; i < numberOfRows; i++){
            for (int j = 0; j < numberOfColumns; j++){
                animationFrames[index++] = tempFrames[i][j];
            }
        }
        animation.setFrames(animationFrames, frameDuration);
        width = animationFrames[0].getRegionWidth();
        height = animationFrames[0].getRegionHeight();
    }

    public void update(float dt) {
        animation.update(dt);
    }

    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(animation.getFrame(), (body.getPosition().x *  Constants.PPM  - width / 2), (int) (body.getPosition().y * Constants.PPM  - height / 2));
        sb.end();
    }

    public Body getBody() { return body; }
    public Vector2 getPosition() { return body.getPosition(); }
    public float getWidth() { return width; }
    public float getHeight() { return height; }

}
