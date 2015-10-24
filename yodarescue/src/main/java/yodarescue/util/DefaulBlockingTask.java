package yodarescue.util;

import glue.fx.BlockingTask;

public abstract class DefaulBlockingTask<T> extends BlockingTask<T> {

  public DefaulBlockingTask() {
    super("Loading...", "-fx-font-family: \"Tahoma\", \"Helvetica\", serif; -fx-font-size: 0.9em;");
  }

}
