package com.github.sixro.fraudinvestigator2.fraud1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Estensione di {@link ArrayList} che definisce il metodo containsOnly e il containsAtLeastOneMatch ed il metodo hasElementsContainedByString
 * 
 * @author ggiachetti
 *
 * @param <E>
 */
public class ExtendedList<E> extends ArrayList<E>
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ExtendedList()
  {
    super();
  }
  
  public ExtendedList(final List<E> list)
  {
    super(list);
  }
  
  /**
   * @param test
   * @return true se l'unico elemento contenuto dall'istanza di classe coincide con il parametro passato.
   */
  public boolean containsOnly(Object test)
  {
    return this.size() == 1 && this.contains(test);
  }
  
  /**
   * @param list
   * @return <code>true</code> se la lista passata come parametro possiede almeno un elemento comune con l'istanza di classe.
   */
  public boolean containsAtLeastOneMatch (final List<E> list)
  {
    for (E obj : list)
    {
      if(this.contains(obj))
        return true;
    }
    return false;
  }
  
  /**
   * @param string
   * @return true solo le questa lista contiene stringhe ed almeno una di esse, avente lunghezza superiore o uguale ai 3 caratteri, &egrave; contenuta nel parametro.
   */
  public boolean hasElementsContainedByString(final String string)
  {
    boolean toBeReturned = false;
    for(E obj: this)
    {
      if(obj instanceof String)
      {
        if(((String)obj).length() >= 3)
        {
          toBeReturned = string.contains((String)obj);
          if(toBeReturned)
          {
            return true;
          }
        }
      }
      else
      {
        return false;
      }
    }
    return toBeReturned;
  }
  
}
