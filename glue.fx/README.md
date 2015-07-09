# glue.fx

A small framework to put a lot of panels in one single application using JavaFX.


## TODO

  1. Support multiple operation that can see in the outline
    * Content of tab should resize within the main window. BUG: when the panel is shown it has a size larger than expected
    * On tab selection, the corresponding outline menu voice as to be selected
	* On a tab close, outlineView should have no selection
	* ~~_SPIKE_ Add support for FontAwesome icons~~
    * ~~SceneBuilder accept a Menu created using MenuBuilder~~
    * ~~SceneBuilder create 1st level menu using specified Menu~~
    * ~~MenuBuilder allows the addition of 2 levels of menu~~
    * ~~SceneBuilder create 2st level menu using specified Menu~~
    * ~~On a click of the outline item, a new tab is open with the name of the MenuAction~~
    * ~~If a tab with the name already exists, it is shown~~
    * ~~Menu voices with childern does not open a new tab~~
    * ~~MenuAction has to be constructed with an ID of FXML~~
    * ~~When a tab is created the content is created with the FXML of the MenuAction~~
  1. User can configure Preferences
    * SceneBuilder accept a Preference
    * PreferenceBuilder allows the addition of sections in prefs
    * PreferenceBuilder allows the addition of pages for sections
    * If some preferences are _required_, the Preferences appears on application startup
	* On the StatusBar there is a button useful to open Preferences
  1. As a user I can have a view showing data in a table/grid
    * ~~Create an FXML with a Table or Grid~~
  1. Application has a logo
    * ~~SceneBuilder accept an image as logo~~
    * ~~SceneBuilder setup the ImageView containing logo with width and height of the image so that we can allow any logo~~
    * ~~SceneBuilder setup the min width of left part of split pane using logo width~~
    * ~~SceneBuilder allows the setting of a bg color so that if the user enlarge the left part, the logo remains consistent~~
  1. As a user I can have a view allowing me to update fields
    * ~~Create an FXML with some fields and a Save/Cancel buttons~~
  1. `BlockingTask`
    * ~~Add a `onDone` listener called whenever a task is done so that it is simple to re-enable some parts of the UI~~

  1. Authentication & authorization
  1. i18n
  1. Form Validation
