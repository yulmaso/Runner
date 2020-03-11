package com.yulmaso.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yulmaso.game.Containers.Constants;

public class MenuState extends State {

    private Texture background;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("StartScreenViolet.png");
        camera.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
        batch.setProjectionMatrix(camera.combined);


    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.X)) gsm.set(new PlayState(gsm));
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) gsm.set(new PlayState(gsm));
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render(float dt) {
        handleInput();
        batch.begin();
        batch.draw(background, 0, 0, Constants.WIDTH, Constants.HEIGHT);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
