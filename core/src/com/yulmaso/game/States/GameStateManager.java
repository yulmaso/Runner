package com.yulmaso.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yulmaso.game.Platformer;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;
    public Platformer game;

    public GameStateManager(Platformer game){
        states = new Stack<State>();
        this.game = game;
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(float dt){
        states.peek().render(dt);
    }

}
