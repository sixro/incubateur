package net.sixro.platformer.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import net.sixro.platformer.GameMain;
import net.sixro.platformer.handlers.B2DVars;
import net.sixro.platformer.handlers.GameStateManager;

import static net.sixro.platformer.handlers.B2DVars.PPM;

public class Play extends GameState {

    private World world;
    private Box2DDebugRenderer b2dr;
    private OrthographicCamera b2dCam;

    public Play(GameStateManager gsm) {
        super(gsm);
        this.world = new World(new Vector2(0, -9.81f), true);
        this.b2dr = new Box2DDebugRenderer();
        this.b2dCam = new OrthographicCamera();
        this.b2dCam.setToOrtho(false, GameMain.V_WIDTH /PPM, GameMain.V_HEIGHT /PPM);

        // create platform
        BodyDef bdef = new BodyDef();
        bdef.position.set(160 /PPM, 120 /PPM);
        bdef.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(bdef);

        PolygonShape pshape = new PolygonShape();
        pshape.setAsBox(50 /PPM, 5 /PPM);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = pshape;
        body.createFixture(fdef);

        // create falling box
        bdef.position.set(160 /PPM, 200 /PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);
        pshape.setAsBox(5 /PPM, 5 /PPM);
        fdef.shape = pshape;
        //fdef.restitution = 1f;
        body.createFixture(fdef);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        world.step(dt, 6, 2);
    }

    @Override
    public void render() {
        // clear screen
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw Box2D
        b2dr.render(world, b2dCam.combined);
    }

    @Override
    public void dispose() {
        world.dispose();
        b2dr.dispose();
    }
}
