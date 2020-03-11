package com.yulmaso.game.States;


import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Platformer;

public abstract class State {

    protected OrthographicCamera camera;
    protected OrthographicCamera hudCam;
    protected GameStateManager gsm;
    protected SpriteBatch batch;
    protected Platformer game;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        game = gsm.game;
        camera = game.getCamera();
        hudCam = game.getHudCam();
        batch = game.getBatch();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(float dt);
    public abstract void dispose();
}
