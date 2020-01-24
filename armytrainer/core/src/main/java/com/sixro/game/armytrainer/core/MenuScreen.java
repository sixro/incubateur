package com.sixro.game.armytrainer.core;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sixro.game.armytrainer.core.util.*;

public class MenuScreen extends AbstractScreen {

	private final Game game;
	
	private Sound sndClick;
	
	private ImageButton btnOptions;
	private TextButton btnMakeATest;
	private TextButton btnTrain;
	private TextButton btnLogs;

	//private InputMultiplexer multiInputProcessor;

	public MenuScreen(Viewport viewport, Skin skin, BaseSettings settings, AssetManager assetManager, Game game) {
		super(viewport, skin, settings, assetManager);
		this.game = game;
	}

	@Override
	public void show() {
		super.show();
		
		Texture bgTexture = getAssetManager().get("background.png", Texture.class);
		getStage().addActor(new Image(bgTexture));

		Texture hudTopTexture = getAssetManager().get("hud-main-top5.png", Texture.class);// new Texture(Gdx.files.internal("hud-main-top5.png"));
		
		Image hudTop = new Image(hudTopTexture);
		hudTop.setPosition(0, 800 - hudTop.getHeight());
		getStage().addActor(hudTop);

		sndClick = getAssetManager().get("click.mp3", Sound.class); //Gdx.audio.newSound(Gdx.files.internal("click.mp3"));
		
		Texture hudOptionsTexture = getAssetManager().get("hud-options2.png", Texture.class);//new Texture(Gdx.files.internal("hud-options2.png"));
		
		btnOptions = new ImageButton(new TextureRegionDrawable(new TextureRegion(hudOptionsTexture)));
		btnOptions.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				sndClick.play(1f);
				
				final CheckBox cbImageHighQuality = new CheckBox("Image High Quality", getSkin());
				Dialog dialog = new Dialog("Options", getSkin()) {
					protected void result (Object object) {
						System.out.println("Chosen: " + object);
						
						getSettings().setImagesHighQuality(cbImageHighQuality.isChecked());
					}
				};
				BasicSkinUtils.customizeDialog(dialog);

				dialog.setKeepWithinStage(false);
				dialog.clearActions();
				
				Table contentTable = dialog.getContentTable();
				contentTable.add(new Slider(0f, 1f, 0.2f, false, getSkin()));
				contentTable.row();
				contentTable.add(new Slider(0f, 1f, 0.2f, false, getSkin()));
				contentTable.row();
				contentTable.add(cbImageHighQuality);

				dialog
					.button("Yes", true)
					.button("No", false)
					.key(Keys.ENTER, true)
					.key(Keys.ESCAPE, false)
					.key(Keys.BACK, false);
				dialog.setWidth(420);
				dialog.setHeight(500);
				GridPoint2 point = ViewportUtils.pointToCenter(dialog, getViewport());
				Gdx.app.log("MENU", "screen.w,h: " + getViewport().getWorldWidth() + "," + getViewport().getWorldHeight());
				Gdx.app.log("MENU", "dialog.x,y: " + point + ", w: " + dialog.getWidth() + ", h: " + dialog.getHeight());
				dialog.setPosition(-400, point.y);

				//dialog.show(stage, moveTo(point.x, point.y, .250f));
				dialog.addAction(moveTo(point.x, point.y, .250f));
				getStage().addActor(dialog);
			}

		});
		getStage().addActor(btnOptions);

		Label lblPushups = new Label("88", getSkin(), "paragraph-bold");
		lblPushups.setPosition(100, 750);
		lblPushups.setColor(Color.BLACK);
		getStage().addActor(lblPushups);

		Label lblSitups = new Label("88", getSkin(), "paragraph-bold");
		lblSitups.setPosition(250, 750);
		lblSitups.setColor(Color.BLACK);
		getStage().addActor(lblSitups);

		Label lblRunning = new Label("88:88", getSkin(), "paragraph-bold");
		lblRunning.setPosition(365, 750);
		lblRunning.setColor(Color.BLACK);
		getStage().addActor(lblRunning);

		Label lblScore = new Label("210", getSkin(), "paragraph-bold");
		lblScore.setPosition(202, 682);
		lblScore.setColor(Color.BLACK);
		getStage().addActor(lblScore);

		final Runnable backToMainScreen = new Runnable() {
			@Override
			public void run() {
				Gdx.app.log("btnMakeATest.onCancel", "setting active screen to menu...");
				game.setScreen(MenuScreen.this);
			}
		};
		btnMakeATest = new TextButton("Make a test", getSkin());
		btnMakeATest.setBounds(250, 320, 220, 48);
		btnMakeATest.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				MakeATestScreen screen = new MakeATestScreen(
						getViewport(), 
						getSkin(), 
						getSettings(), 
						getAssetManager()
				);
				screen.onCancel(backToMainScreen);
				game.setScreen(screen);
			}
		});
		getStage().addActor(btnMakeATest);
		
		btnTrain = new TextButton("Train", getSkin());
		btnTrain.setBounds(250, 260, 220, 48);
		btnTrain.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				TrainScreen screen = new TrainScreen(
						getViewport(), 
						getSkin(), 
						getSettings(), 
						getAssetManager()
				);
				screen.onCancel(backToMainScreen);
				game.setScreen(screen);
			}
		});
		getStage().addActor(btnTrain);
		
		btnLogs = new TextButton("Logs", getSkin());
		btnLogs.setBounds(250, 200, 220, 48);
		btnLogs.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				LogsScreen screen = new LogsScreen(
						getViewport(), 
						getSkin(), 
						getSettings(), 
						getAssetManager()
				);
				screen.onCancel(backToMainScreen);
				game.setScreen(screen);
			}
		});
		getStage().addActor(btnLogs);

		onCancel(new Runnable() {
			@Override
			public void run() {
				Dialog dialog = new Dialog("Exit", getSkin()) {
					protected void result (Object object) {
						sndClick.play(1f);
						
						if (Boolean.FALSE.equals(object))
							return;
						
						// NOTE: we need this to let the sound playing when
						//       the user tells us he want to exit...
						try { Thread.sleep(200); } 
						catch (InterruptedException e) { }
						
						Gdx.app.postRunnable(new Runnable() {
							public void run() {
								Gdx.app.exit();
							}
						});
					}
				};
				BasicSkinUtils.customizeDialog(dialog);
				dialog
					.text("Are you sure?")
					.button("Yes", true)
					.button("No", false)
					.key(Keys.ENTER, true)
					.key(Keys.ESCAPE, false)
					.key(Keys.BACK, false);
	
				dialog.setColor(Color.RED);
				dialog.setWidth(420);
				dialog.setHeight(180);
				GridPoint2 point = ViewportUtils.pointToCenter(dialog, getViewport());
				dialog.setX(point.x);
				dialog.setY(point.y);
				
				getStage().addActor(dialog);
			}
		});
	}
	
}
