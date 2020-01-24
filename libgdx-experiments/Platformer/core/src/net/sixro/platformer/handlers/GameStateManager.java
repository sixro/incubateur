package net.sixro.platformer.handlers;

import net.sixro.platformer.GameMain;
import net.sixro.platformer.states.GameState;
import net.sixro.platformer.states.Play;

import java.util.Stack;

public class GameStateManager {

    private GameMain game;
    private Stack<GameState> gameStates;

    public static final int PLAY = 912837;

    public GameStateManager(GameMain game) {
        this.game = game;
        this.gameStates = new Stack<GameState>();
        pushState(PLAY);

    }

    public GameMain getGame() {
        return game;
    }

    public void update(float dt) {
        gameStates.peek().update(dt);
    }

    public void render() {
        gameStates.peek().render();
    }

    private GameState getState(int state) {
        if (state == PLAY) return new Play(this);
        return null;
    }

    private void setState(int state) {
        popState();
        pushState(state);
    }

    public void pushState(int state) {
        gameStates.push(getState(state));
    }

    public void popState() {
        GameState gameState = gameStates.pop();
        gameState.dispose();
    }

}
