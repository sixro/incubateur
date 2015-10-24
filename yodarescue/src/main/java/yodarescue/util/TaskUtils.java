package yodarescue.util;

import javafx.concurrent.Task;

public class TaskUtils {

  private TaskUtils() { }
  
  public static void run(Task<?> task) {
    Thread thread = new Thread(task, task.getClass().getSimpleName());
    thread.setDaemon(true);
    thread.start();
  }
  
}
