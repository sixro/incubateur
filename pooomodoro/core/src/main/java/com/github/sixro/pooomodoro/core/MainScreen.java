package com.github.sixro.pooomodoro.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.viewport.*;
import com.github.sixro.pooomodoro.core.mainscreen.TimerUI;
import com.github.sixro.pooomodoro.core.util.UIUtils;

public class MainScreen implements Screen, CountdownTimer.Listener {

	private static final int MINUTES = 60 * 1000;
	private static final int TOMATO_RUN_MILLIS        = 25 * MINUTES;
	private static final int TOMATO_PAUSE_MILLIS      =  5 * MINUTES;
	private static final int TOMATO_LONG_PAUSE_MILLIS = 15 * MINUTES;
	
	private static final int WORLD_WIDTH = 900;
	private static final int WORLD_HEIGHT = 480;
	
	private final Camera camera;
	private final Viewport viewport;
	private final Stage stage;
	private final InputMultiplexer inputHandler;
	
	private Texture mainBgTexture;
	
	private Image mainBg;
	
	private Group btnbarTomato;
	private ImageButton btnTomatoRun;
	private ImageButton btnTomatoPause;
	private ImageButton btnTomatoLongPause;

	private TimerUI timerUI;
	
	private Sound alarm;
	private Sound tick;
	private long tickID;

	private CountdownTimer timer;
	
	private int doneCount = 0;
	private Texture txtrDone;

	private SpriteBatch spriteBatch;
	private Animation animBird;
	private float elapsedTime;
	
	public MainScreen() {
		super();
		this.camera = new OrthographicCamera();
		this.viewport = new ScalingViewport(Scaling.fillY, WORLD_WIDTH, WORLD_HEIGHT, camera);
		this.stage = new Stage(viewport);
		
		this.spriteBatch = new SpriteBatch();
		this.elapsedTime = 0;
		
		this.inputHandler = new InputMultiplexer(stage);
	}

	@Override
	public void show() {
		Skin skin = new Skin(Gdx.files.internal("skins/default/skin.json"));

		alarm = Gdx.audio.newSound(Gdx.files.internal("sx/alarm-short.mp3"));
		tick = Gdx.audio.newSound(Gdx.files.internal("sx/264498__foolboymedia__tick-tock.wav"));
		
		mainBgTexture = new Texture(Gdx.files.internal("main-bg.png"));
		mainBgTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		mainBg = new Image(new TextureRegionDrawable(new TextureRegion(mainBgTexture)));
		stage.addActor(mainBg);

		btnbarTomato = new Group();
		stage.addActor(btnbarTomato);
		
		int btnWidth = 130;
		int btnHeight = 70;
		int middleButtonX = (WORLD_WIDTH - btnWidth) /2;
		btnbarTomato.setPosition(middleButtonX - btnWidth -3, 10);
		
		btnTomatoRun = new ImageButton(newImageButtonStyle(skin, "play.png"));
		btnTomatoRun.setSize(btnWidth, btnHeight);
		btnTomatoRun.addListener(aChangeListenerStartingTimerOf(TOMATO_RUN_MILLIS));
		btnbarTomato.addActor(btnTomatoRun);

		btnTomatoPause = new ImageButton(newImageButtonStyle(skin, "pause.png"));
		btnTomatoPause.setPosition(btnWidth +3, 0);
		btnTomatoPause.setSize(btnWidth, btnHeight);
		btnTomatoPause.addListener(aChangeListenerStartingTimerOf(TOMATO_PAUSE_MILLIS));
		btnbarTomato.addActor(btnTomatoPause);
		
		btnTomatoLongPause = new ImageButton(newImageButtonStyle(skin, "long-pause.png"));
		btnTomatoLongPause.setSize(btnWidth, btnHeight);
		btnTomatoLongPause.setPosition((btnWidth +3) *2, 0);
		btnTomatoLongPause.addListener(aChangeListenerStartingTimerOf(TOMATO_LONG_PAUSE_MILLIS));
		btnbarTomato.addActor(btnTomatoLongPause);

		ImageButton btnOptions = new ImageButton(newImageButtonStyle(skin, "options.png"));
		btnOptions.setSize(60, 60);
		btnOptions.setPosition(90, 10);
		stage.addActor(btnOptions);

		Texture btnFacebookTexture = new Texture(Gdx.files.internal("facebook.png"));
		btnFacebookTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		ImageButton btnFacebook = new ImageButton(new TextureRegionDrawable(new TextureRegion(btnFacebookTexture)));
		btnFacebook.setSize(60, 60);
		btnFacebook.setPosition(740, 10);
		stage.addActor(btnFacebook);

		Texture btnTwitterTexture = new Texture(Gdx.files.internal("twitter.png"));
		btnTwitterTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		ImageButton btnTwitter = new ImageButton(new TextureRegionDrawable(new TextureRegion(btnTwitterTexture)));
		btnTwitter.setSize(60, 60);
		btnTwitter.setPosition(740, 80);
		stage.addActor(btnTwitter);
		
		timerUI = new TimerUI(skin);
		timerUI.setPosition((viewport.getWorldWidth() - timerUI.width()) /2, (viewport.getWorldHeight() - timerUI.getHeight()) /2);
		timerUI.setVisible(false);
		timerUI.setOnCancel(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				timer.stop();
			}
		});
		stage.addActor(timerUI);
		
		txtrDone = new Texture(Gdx.files.internal("done.png"));
		
		TextureRegion[] keyFrames = new TextureRegion[4];
		Texture texture01 = new Texture(Gdx.files.internal("bird01.png"));
		texture01.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Texture texture02 = new Texture(Gdx.files.internal("bird02.png"));
		texture02.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Texture texture03 = new Texture(Gdx.files.internal("bird03.png"));
		texture03.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		keyFrames[0] = new TextureRegion(texture02);
		keyFrames[1] = new TextureRegion(texture01);
		keyFrames[2] = new TextureRegion(texture02);
		keyFrames[3] = new TextureRegion(texture03);
		animBird = new Animation(0.2f, keyFrames);
		
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setCatchMenuKey(true);
		Gdx.input.setInputProcessor(inputHandler);
	}

	private ChangeListener aChangeListenerStartingTimerOf(final int millis) {
		return new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				timer = new CountdownTimer(millis);
				timer.addListener(MainScreen.this);
				timer.start();
			}
		};
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.78f, 0.78f, 0.78f, 1f);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();

		elapsedTime += delta;
		
		spriteBatch.begin();
		TextureRegion keyFrame = animBird.getKeyFrame(elapsedTime, true);
		spriteBatch.draw(keyFrame, 50, 50);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		mainBgTexture.dispose();
		
		timerUI.dispose();
		
		stage.dispose();
	}

	@Override
	public void onStart(CountdownTimer timer) {
		btnbarTomato.setVisible(false);
		timerUI.setVisible(true);
		
		tickID = tick.loop(1f);
	}

	@Override
	public void onChange(CountdownTimer timer, long remaining) {
		timerUI.setRemainingTime(remaining);
	}

	@Override
	public void onTerminate(CountdownTimer timer) {
		tick.stop(tickID);
		alarm.play(1f);
		
		btnbarTomato.setVisible(true);
		timerUI.setVisible(false);
		
		Image imgDone = new Image(new TextureRegionDrawable(new TextureRegion(txtrDone)));
		imgDone.setPosition(90 + doneCount * (imgDone.getWidth() + 3), WORLD_HEIGHT - imgDone.getHeight() -10);
		stage.addActor(imgDone);

		doneCount++;
	}

	@Override
	public void onStop(CountdownTimer timer) {
		btnbarTomato.setVisible(true);
		timerUI.setVisible(false);

		tick.stop(tickID);
	}

	// TODO rimuovere gestendo il tutto con gli assets...
	private ImageButtonStyle newImageButtonStyle(Skin skin, String imageUpName) {
		Texture txtr = new Texture(Gdx.files.internal(imageUpName));
		txtr.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		return UIUtils.newImageButtonStyle(skin, txtr);
	}

}
