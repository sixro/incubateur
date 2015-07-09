package com.github.sixro.vaadin.ui;

import com.vaadin.ui.*;

public class VerticalLayoutBuilder {

	private VerticalLayout layout;

	private VerticalLayoutBuilder() {
		layout = new VerticalLayout();
	}
	
	public static VerticalLayoutBuilder aVerticalLayout() {
		return new VerticalLayoutBuilder();
	}
	
	public VerticalLayoutBuilder withSizeFull() {
		layout.setSizeFull();
		return this;
	}
	
	public VerticalLayoutBuilder withComponent(Component component) {
		layout.addComponent(component);
		return this;
	}
	
	public VerticalLayoutBuilder withExpandRatio(Component component, float ratio) {
		layout.setExpandRatio(component, ratio);
		return this;
	}
	
	public VerticalLayout build() {
		return layout;
	}
	
}
