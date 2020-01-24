package net.sixro.platformer.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.sixro.platformer.GameMain;
import net.sixro.platformer.handlers.GameStateManager;

public abstract class GameState {

    protected GameStateManager gsm;
    protected GameMain game;
    protected SpriteBatch sb;
    protected OrthographicCamera cam;
    protected OrthographicCamera hudCam;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        this.game = gsm.getGame();
        this.sb = this.game.getSpriteBatch();
        this.cam = this.game.getCamera();
        this.hudCam = this.game.getHUDCamera();
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();
}
