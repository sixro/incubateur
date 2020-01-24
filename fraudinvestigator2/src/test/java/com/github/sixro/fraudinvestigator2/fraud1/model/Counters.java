package com.github.sixro.fraudinvestigator2.fraud1.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

public class Counters
{
  private Map<Integer, Long> creditCardMap = new HashMap<Integer, Long>();
  private Map<Integer, Long> ipAddressMap = new HashMap<Integer, Long>();
  private Map<Integer, Long> emailMap = new HashMap<Integer, Long>();

  public Counters()
  {

  }

  public void addCreditCardMap(int key, long value)
  {
    creditCardMap.put(key, value);
  }

  public void addEmailMap(int key, long value)
  {
    emailMap.put(key, value);
  }

  public void addIpAddressMap(int key, long value)
  {
    ipAddressMap.put(key, value);
  }

  /**
   * @return the creditCardMap
   */
  public Map<Integer, Long> getCreditCardMap()
  {
    return creditCardMap;
  }

  /**
   * @return the ipAddressMap
   */
  public Map<Integer, Long> getIpAddressMap()
  {
    return ipAddressMap;
  }

  /**
   * @return the emailMap
   */
  public Map<Integer, Long> getEmailMap()
  {
    return emailMap;
  }
  
  /**
   * @return the cc1day
   */
  public long getCc1day()
  {
    return creditCardMap.get(1);
  }

  /**
   * @return the cc2day
   */
  public long getCc2day()
  {
    return creditCardMap.get(2);
  }

  /**
   * @return the cc3day
   */
  public long getCc3day()
  {
    return creditCardMap.get(3);
  }

  /**
   * @return the cc4day
   */
  public long getCc4day()
  {
    return creditCardMap.get(4);
  }

  /**
   * @return the cc5day
   */
  public long getCc5day()
  {
    return creditCardMap.get(5);
  }

  /**
   * @return the cc6day
   */
  public long getCc6day()
  {
    return creditCardMap.get(6);
  }

  /**
   * @return the cc7day
   */
  public long getCc7day()
  {
    return creditCardMap.get(7);
  }

  /**
   * @return the cc8day
   */
  public long getCc8day()
  {
    return creditCardMap.get(8);
  }

  /**
   * @return the cc9day
   */
  public long getCc9day()
  {
    return creditCardMap.get(9);
  }

  /**
   * @return the cc10day
   */
  public long getCc10day()
  {
    return creditCardMap.get(10);
  }

  /**
   * @return the cc11day
   */
  public long getCc11day()
  {
    return creditCardMap.get(11);
  }

  /**
   * @return the cc12day
   */
  public long getCc12day()
  {
    return creditCardMap.get(12);
  }

  /**
   * @return the cc13day
   */
  public long getCc13day()
  {
    return creditCardMap.get(13);
  }

  /**
   * @return the cc14day
   */
  public long getCc14day()
  {
    return creditCardMap.get(14);
  }

  /**
   * @return the cc15day
   */
  public long getCc15day()
  {
    return creditCardMap.get(15);
  }

  /**
   * @return the email1day
   */
  public long getEmail1day()
  {
    return emailMap.get(1);
  }

  /**
   * @return the email2day
   */
  public long getEmail2day()
  {
    return emailMap.get(2);
  }

  /**
   * @return the email3day
   */
  public long getEmail3day()
  {
    return emailMap.get(3);
  }

  /**
   * @return the email4day
   */
  public long getEmail4day()
  {
    return emailMap.get(4);
  }

  /**
   * @return the email5day
   */
  public long getEmail5day()
  {
    return emailMap.get(5);
  }

  /**
   * @return the email6day
   */
  public long getEmail6day()
  {
    return emailMap.get(6);
  }

  /**
   * @return the email7day
   */
  public long getEmail7day()
  {
    return emailMap.get(7);
  }

  /**
   * @return the email8day
   */
  public long getEmail8day()
  {
    return emailMap.get(8);
  }

  /**
   * @return the email9day
   */
  public long getEmail9day()
  {
    return emailMap.get(9);
  }

  /**
   * @return the email10day
   */
  public long getEmail10day()
  {
    return emailMap.get(10);
  }

  /**
   * @return the email11day
   */
  public long getEmail11day()
  {
    return emailMap.get(11);
  }

  /**
   * @return the email12day
   */
  public long getEmail12day()
  {
    return emailMap.get(12);
  }

  /**
   * @return the email13day
   */
  public long getEmail13day()
  {
    return emailMap.get(13);
  }

  /**
   * @return the email14day
   */
  public long getEmail14day()
  {
    return emailMap.get(14);
  }

  /**
   * @return the email15day
   */
  public long getEmail15day()
  {
    return emailMap.get(15);
  }

  /**
   * @return the ipAddress1day
   */
  public long getIpAddress1day()
  {
    return ipAddressMap.get(1);
  }

  /**
   * @return the ipAddress2day
   */
  public long getIpAddress2day()
  {
    return ipAddressMap.get(2);
  }

  /**
   * @return the ipAddress3day
   */
  public long getIpAddress3day()
  {
    return ipAddressMap.get(3);
  }

  /**
   * @return the ipAddress4day
   */
  public long getIpAddress4day()
  {
    return ipAddressMap.get(4);
  }

  /**
   * @return the ipAddress5day
   */
  public long getIpAddress5day()
  {
    return ipAddressMap.get(5);
  }

  /**
   * @return the ipAddress6day
   */
  public long getIpAddress6day()
  {
    return ipAddressMap.get(6);
  }

  /**
   * @return the ipAddress7day
   */
  public long getIpAddress7day()
  {
    return ipAddressMap.get(7);
  }

  /**
   * @return the ipAddress8day
   */
  public long getIpAddress8day()
  {
    return ipAddressMap.get(8);
  }

  /**
   * @return the ipAddress9day
   */
  public long getIpAddress9day()
  {
    return ipAddressMap.get(9);
  }

  /**
   * @return the ipAddress10day
   */
  public long getIpAddress10day()
  {
    return ipAddressMap.get(10);
  }

  /**
   * @return the ipAddress11day
   */
  public long getIpAddress11day()
  {
    return ipAddressMap.get(11);
  }

  /**
   * @return the ipAddress12day
   */
  public long getIpAddress12day()
  {
    return ipAddressMap.get(12);
  }

  /**
   * @return the ipAddress13day
   */
  public long getIpAddress13day()
  {
    return ipAddressMap.get(13);
  }

  /**
   * @return the ipAddress14day
   */
  public long getIpAddress14day()
  {
    return ipAddressMap.get(14);
  }

  /**
   * @return the ipAddress15day
   */
  public long getIpAddress15day()
  {
    return ipAddressMap.get(15);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
