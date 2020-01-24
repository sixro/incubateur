package com.github.sixro.minihabits.html;

import java.util.Date;

import com.badlogic.gdx.*;
import com.badlogic.gdx.backends.gwt.*;
import com.github.sixro.minihabits.core.MiniHabits;
import com.github.sixro.minihabits.core.util.libgdx.text.DateTimeFormatter;
import com.google.gwt.i18n.client.DateTimeFormat;

public class MiniHabitsHtml extends GwtApplication {
	
	private static final String TAG = MiniHabitsHtml.class.getSimpleName();
	
	// FIXME verificare se ora HTML funziona dopo un riavvio
	@Override
	public ApplicationListener getApplicationListener() {
		return new MiniHabits(new DateTimeFormatter() {
			
			@Override
			public Date parse(String text, String pattern) {
				Gdx.app.log(TAG, "parsing text '" + text + "' using pattern '" + pattern + "' ...");
				Date date = DateTimeFormat.getFormat(pattern).parse(text);
				Gdx.app.log(TAG, "... returning " + date);
				return date;
			}
			
			@Override
			public String format(Date date, String pattern) {
				Gdx.app.log(TAG, "formatting date " + date + " using pattern '" + pattern + "' ...");
				String text = DateTimeFormat.getFormat(pattern).format(date);
				Gdx.app.log(TAG, "... returning '" + text + "'");
				return text;
			}
		});
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 800);
	}

//	@Override
//	public ApplicationListener createApplicationListener() {
//		return new MiniHabits();
//	}
	
}
