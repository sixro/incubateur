package glue.fx;

import javafx.stage.Stage;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

public class MainWindowJavaFXTest {

  @Rule public JUnitRuleMockery context = new JUnitRuleMockery() {{
    setImposteriser(ClassImposteriser.INSTANCE);
    setThreadingPolicy(new Synchroniser());
  }};
  private Stage primaryStage = context.mock(Stage.class, "primaryStage");
  private MainWindowJavaFX mainWindow = new MainWindowJavaFX();
  
  @Before public void setup() {
    mainWindow.setPrimaryStage(primaryStage);
  }
  
  @Test
  @Ignore("Cannot be tested 'cause Stage.show is final!")
  public void show() {
    context.checking(new Expectations() {{ 
      oneOf(primaryStage).show();
    }});
    
    mainWindow.show();
  }

}
