package com.github.sixro.pooomodoro.core.mainscreen;

import org.apache.commons.lang3.StringUtils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.sixro.pooomodoro.core.util.UIUtils;

public class TimerUI extends Group {

	private static final long MINUTES = 60 * 1000;

	private Label lblTimer;

	private Texture btnCancelTexture;
	private ImageButton btnTomatoCancel;
	
	public TimerUI(Skin skin) {
		super();
		lblTimer = new Label("00:00", skin, "title");
		addActor(lblTimer);
		
		btnCancelTexture = new Texture(Gdx.files.internal("cancel.png"));
		btnCancelTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		btnTomatoCancel = new ImageButton(UIUtils.newImageButtonStyle(skin, btnCancelTexture));
		btnTomatoCancel.setPosition(lblTimer.getWidth() + 3, 10);
		addActor(btnTomatoCancel);
	}

	public void setRemainingTime(long millis) {
		millis = setupTimeToAvoidImmediateChange(millis);
		
		int minutes = (int) (millis / MINUTES);
		int seconds = (int) (millis - (minutes * MINUTES)) / 1000;
		String timerText = StringUtils.leftPad(Integer.toString(minutes), 2, '0') + ":" + StringUtils.leftPad(Integer.toString(seconds), 2, '0');
		
		lblTimer.setText(timerText);
	}
	
	public void setOnCancel(ChangeListener changeListener) {
		btnTomatoCancel.addListener(changeListener);
	}

	public float width() {
		return lblTimer.getWidth() + btnTomatoCancel.getWidth() + 3;
	}
	
	public void dispose() {
		btnCancelTexture.dispose();
	}

	private long setupTimeToAvoidImmediateChange(long millis) {
		if (millis % 1000 != 0)
			millis = ((millis / 1000) +1) * 1000;
		return millis;
	}

}
