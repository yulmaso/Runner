package com.yulmaso.game.Tools;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.yulmaso.game.Box2d.EnemyData;
import com.yulmaso.game.Box2d.PlatformData;
import com.yulmaso.game.Box2d.PlayerData;
import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Containers.EnemyType;
import com.yulmaso.game.Containers.PlatformType;
import com.yulmaso.game.Entities.Platform;

import static com.yulmaso.game.Containers.Constants.PLAYER_DEFAULT_Y;
import static com.yulmaso.game.Containers.Constants.PPM;

public class WorldUtils {

    public static World createWorld(){
        return new World(Constants.WORLD_GRAVITY, true);
    }

    public static Body createPlayer(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(Constants.PLAYER_DEFAULT_X / PPM, PLAYER_DEFAULT_Y / PPM);
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.PLAYER_WIDTH / PPM, Constants.PLAYER_HEIGHT / PPM);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        fdef.density = Constants.PLAYER_DENSITY;

        body.createFixture(fdef);
        body.setGravityScale(0);
        body.setUserData(new PlayerData(Constants.PLAYER_WIDTH / PPM, Constants.PLAYER_HEIGHT / PPM));
        shape.dispose();
        return body;
    }

    public static Body createEnemy(World world){
        EnemyType enemyType = RandomUtils.getRandomEnemyType();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(Constants.ENEMY_X / PPM, RandomUtils.getRandomEnemyY() / PPM);
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(enemyType.getWidth(), enemyType.getHeight());

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        body.resetMassData();
        body.createFixture(fdef);
        body.setGravityScale(Constants.PLAYER_GRAVITY_SCALE);
        body.setUserData(new EnemyData(enemyType.getWidth(), enemyType.getHeight()));
        shape.dispose();
        return body;
    }

    public static Body createPlatform(World world, PlatformType type){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(type.getX() / PPM, type.getY() / PPM);
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.PLATFORM_WIDTH / PPM * 2, Constants.PLATFORM_HEIGHT / PPM);

        FixtureDef fdef = new FixtureDef();
        fdef.density = type.getDensity();
        fdef.shape = shape;
        body.resetMassData();
        body.createFixture(fdef);
        body.setUserData(new PlatformData(type));
        shape.dispose();
        return body;
    }

}
