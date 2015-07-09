package com.github.sixro.tryvaadin;

import static com.github.sixro.vaadin.ui.VerticalLayoutBuilder.*;
import static com.github.sixro.vaadin.ui.HorizontalLayoutBuilder.*;

import com.vaadin.Application;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {

	private Window window;

	@Override
	public void init() {
		window = new Window("Tryvaadin");
		setMainWindow(window);

		HorizontalSplitPanel menuAndContent = new HorizontalSplitPanel();
		menuAndContent.setHeight("100%");
		VerticalLayout verticalLayout = aVerticalLayout()
			.withSizeFull()
			.withComponent(topBar())
			//.withComponent(menuAndContent)
			.withComponent(new Label("are"))
			//.withExpandRatio(menuAndContent, 1.0f)
			.build();
		window.setContent(verticalLayout);
		
		/*
		HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
		splitPanel.setSizeFull();
		splitPanel.setSplitPosition(20.0f);
		splitPanel.addStyleName(Reindeer.SPLITPANEL_SMALL);
		window.setContent(splitPanel);
		
		Button button = new Button("Click Me");
		button.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				window.addComponent(new Label("Thank you for clicking"));
			}
		});
	
		VerticalLayout rightPanel = new VerticalLayout();
		rightPanel.setStyleName(Reindeer.LAYOUT_BLUE);
		rightPanel.setSizeFull();
		splitPanel.setFirstComponent(rightPanel);
		
		Label appTitle = new Label("Tryvaadin");
		rightPanel.addComponent(appTitle);
		appTitle.addStyleName(Reindeer.LABEL_H1);
		Accordion accordion = new Accordion();
		rightPanel.addComponent(accordion);
		accordion.setSizeFull();

		// Some components to put in the Accordion.
		Label l1 = new Label("There are no previously saved actions.");
		Label l2 = new Label("There are no saved notes.");
		Label l3 = new Label("There are currently no issues.");


		// Add the components as tabs in the Accordion.
		accordion.addTab(l1, "Saved actions", null);
		accordion.addTab(l2, "Notes", null);
		accordion.addTab(l3, "Issues", null);
		
//		Panel rightMenu = new Panel("Menu");
//		rightMenu.setSizeFull();
//		rightPanel.addComponent(rightMenu);
//		rightMenu.addComponent(new Label("a menu voice"));
		
		splitPanel.setSecondComponent(button);
		*/
	}

	private AbstractLayout topBar() {
		Label appName = new Label("Tryvaadin");
		appName.setSizeUndefined();
		appName.addStyleName(Reindeer.LABEL_H1);

		Button loggedInUser = new Button("a User");
		loggedInUser.setWidth("100");

		TextField searchField = new TextField("");
		searchField.setInputPrompt("Search");
		searchField.setSizeUndefined();
		searchField.setWidth("100");

		HorizontalLayout bar = aHorizontalLayout()
				.withWidth("100%")
				.withComponent(appName)
				.withComponent(loggedInUser)
				.withComponent(searchField)
				.build();
		bar.setComponentAlignment(appName, Alignment.TOP_LEFT);
		bar.setComponentAlignment(loggedInUser, Alignment.MIDDLE_RIGHT);
		bar.setComponentAlignment(searchField, Alignment.MIDDLE_RIGHT);
		bar.setExpandRatio(appName, 1.0f);
		bar.setStyleName(Reindeer.LAYOUT_BLACK);
		bar.setMargin(true);
		return bar;
	}

}
