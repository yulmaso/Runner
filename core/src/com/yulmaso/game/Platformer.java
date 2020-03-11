package com.yulmaso.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.States.GameStateManager;
import com.yulmaso.game.States.PlayState;

public class Platformer extends ApplicationAdapter {

	private SpriteBatch batch;
	private GameStateManager gsm;
	private OrthographicCamera camera;
	private OrthographicCamera hudCam;

	public OrthographicCamera getCamera(){ return camera;}
	public OrthographicCamera getHudCam(){ return hudCam;}
	public SpriteBatch getBatch() { return batch; }

	@Override
	public void create () {
		//camera = new OrthographicCamera(Constants.WIDTH, Constants.HEIGHT);
		//camera.setToOrtho(false, camera.viewportWidth / 2, camera.viewportHeight / 2);
		//camera.update();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);

		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);


		gsm = new GameStateManager(this);
		gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
	}


}
