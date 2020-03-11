package com.yulmaso.game.Tools;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.yulmaso.game.Entities.Player;
import com.yulmaso.game.States.PlayState;

public class CollisionHandler implements ContactListener {
    private Player player;
    private PlayState playState;
    public boolean playerDead = false;

    public CollisionHandler(Player player, PlayState playState) {
        this.player = player;
        this.playState = playState;
    }


    @Override
    public void beginContact(Contact contact) {
        Body A = contact.getFixtureA().getBody();
        Body B = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsPlayer(A) && BodyUtils.bodyIsEnemy(B)) ||
                (BodyUtils.bodyIsEnemy(B) && BodyUtils.bodyIsPlayer(B))){
            playerDead = true;
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }
    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
