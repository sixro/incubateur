package eventstore4j;

import java.util.*;

/**
 * Represents an <a href="https://en.wikipedia.org/wiki/Event_store" target="_blank" >event store</a>.
 */
public interface EventStore
{
  void store(EventObject event);

  List<EventObject> find(Map<String, Object> matchingValues);

  EventObject last(Map<String, Object> matchingValues);

}
