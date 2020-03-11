package com.yulmaso.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Containers.PlatformType;
import com.yulmaso.game.Entities.Background;
import com.yulmaso.game.Entities.Enemy;
import com.yulmaso.game.Entities.Platform;
import com.yulmaso.game.Entities.Player;
import com.yulmaso.game.Entities.Score;
import com.yulmaso.game.Tools.BodyUtils;
import com.yulmaso.game.Tools.CollisionHandler;
import com.yulmaso.game.Tools.WorldUtils;

import static com.yulmaso.game.Containers.Constants.PPM;

import java.util.HashMap;

public class PlayState extends State {

    private World world;
    private Box2DDebugRenderer b2dRenderer;
    private OrthographicCamera b2dCamera;
    private CollisionHandler collisionHandler;
    private float MANUAL_PPM = 100;

    private Player player;
    private Enemy enemy;
    private Background background;
    private Score score;
    private HashMap<PlatformType, Platform> platforms;

    private int distanceCount = 0;
    private float previousPosition = 0;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        world = WorldUtils.createWorld();
        collisionHandler = new CollisionHandler(player, this);
        world.setContactListener(collisionHandler);
        b2dRenderer = new Box2DDebugRenderer();

        player = new Player(WorldUtils.createPlayer(world));
        enemy = new Enemy(WorldUtils.createEnemy(world));

        background = new Background();
        background.setVector(Constants.ENEMY_LINEAR_VELOCITY.x, 0);
        score = new Score();
        Constants.SCORE = 0;

        platforms = new HashMap<PlatformType, Platform>();
        for (PlatformType platformType : PlatformType.values()){
            Platform platform = new Platform(WorldUtils.createPlatform(world, platformType));
            platforms.put(platformType, platform);
        }

        b2dCamera = new OrthographicCamera();
        b2dCamera.setToOrtho(false, Constants.WIDTH / PPM, Constants.HEIGHT / PPM);
        b2dCamera.update();
    }

    private void gameOver(){
        //player.getBody().setType(BodyDef.BodyType.DynamicBody);

        //TODO: анимация проигрыша + экран
        player.setDead();
        gsm.set(new MenuState(gsm));
    }

    @Override
    protected void handleInput() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.UP){
                    player.moveUp();
                }
                if (keycode == Input.Keys.DOWN){
                    player.moveDown();
                }
                if (keycode == Input.Keys.RIGHT){
                    player.moveRight();
                }
                if (keycode == Input.Keys.LEFT){
                    player.moveLeft();
                }
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.UP){
                    player.resetUpMovement();
                }
                if (keycode == Input.Keys.DOWN){
                    player.resetDownMovement();
                }
                if (keycode == Input.Keys.RIGHT){
                    player.resetRightMovement();
                }
                if (keycode == Input.Keys.LEFT){
                    player.resetLeftMovement();
                }
                return false;
            }
            @Override
            public boolean keyTyped(char character) {
                return false;
            }
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }
            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }
            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }
            @Override
            public boolean scrolled(int amount) {

                MANUAL_PPM += amount;

                b2dCamera.setToOrtho(false, Constants.WIDTH/ MANUAL_PPM, Constants.HEIGHT/ MANUAL_PPM);
                b2dCamera.update();
                batch.setProjectionMatrix(b2dCamera.combined);

                return false;
            }
        });
    }

    private void createEnemy(Body body){
        if (!BodyUtils.bodyInBounds(body)){
            if (BodyUtils.bodyIsEnemy(body)){
                enemy = new Enemy(WorldUtils.createEnemy(world));
            }
            world.destroyBody(body);
        }
    }

    @Override
    public void update(float dt) {

        player.update(dt);
        enemy.update(dt);
        background.update(dt);

        float temp = enemy.getBodyX() * PPM;
        if (temp < previousPosition) distanceCount += (int) previousPosition - temp;
        else distanceCount += (int) Constants.ENEMY_X - temp;
        previousPosition = temp;
        score.update(distanceCount);
        Constants.SCORE = distanceCount;

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);
        for (Body body : bodies){
            createEnemy(body);
        }

        world.step(dt, 6 ,2);
    }

    @Override
    public void render(float dt) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        b2dRenderer.render(world, b2dCamera.combined);
        handleInput();
        if (collisionHandler.playerDead){
            gameOver();
        }

        background.render(batch);

        enemy.render(batch);
        player.render(batch);

        score.render(batch);
    }

    @Override
    public void dispose() {
    }
}
