package com.github.sixro.vaadin.ui;

import com.vaadin.ui.*;

public class HorizontalLayoutBuilder {

	private HorizontalLayout layout;

	private HorizontalLayoutBuilder() {
		layout = new HorizontalLayout();
	}
	
	public static HorizontalLayoutBuilder aHorizontalLayout() {
		return new HorizontalLayoutBuilder();
	}
	
	public HorizontalLayoutBuilder withSizeFull() {
		layout.setSizeFull();
		return this;
	}
	
	public HorizontalLayoutBuilder withWidth(String widthAsText) {
		layout.setWidth(widthAsText);
		return this;
	}
	
	public HorizontalLayoutBuilder withComponent(Component component) {
		layout.addComponent(component);
		return this;
	}
	
	public HorizontalLayoutBuilder withExpandRatio(Component component, float ratio) {
		layout.setExpandRatio(component, ratio);
		return this;
	}
	
	public HorizontalLayout build() {
		return layout;
	}
	
}
