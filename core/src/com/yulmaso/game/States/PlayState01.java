package com.yulmaso.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.yulmaso.game.Containers.Constants;
import static com.yulmaso.game.Containers.Constants.PPM;

public class PlayState01 extends State {

    World world;
    Box2DDebugRenderer b2dr;

    private OrthographicCamera b2dcam;

    public PlayState01(GameStateManager gsm) {
        super(gsm);

        world = new World(Constants.WORLD_GRAVITY, true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(160 / PPM, 3 / PPM));
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.WIDTH / PPM , 1 / PPM);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        body.createFixture(fdef);


        bodyDef.position.set(160 / PPM, 200 / PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);

        shape.setAsBox(5 / PPM, 5 / PPM);
        fdef.shape = shape;
        fdef.restitution = 1f;
        body.createFixture(fdef);

        b2dcam = new OrthographicCamera();
        b2dcam.setToOrtho(false, Constants.WIDTH / PPM, Constants.HEIGHT / PPM);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        world.step(dt, 6, 2);
    }

    @Override
    public void render(float dt) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        b2dr.render(world, b2dcam.combined);
    }

    @Override
    public void dispose() {

    }
}
