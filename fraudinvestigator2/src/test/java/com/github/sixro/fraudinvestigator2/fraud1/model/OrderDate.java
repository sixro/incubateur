
package com.github.sixro.fraudinvestigator2.fraud1.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OrderDate
{
  private final Calendar calendarDate = Calendar.getInstance();

  public OrderDate(final Date orderDate)
  {
    calendarDate.setTime(orderDate);
  }

  public int getOrderDateYear()
  {
    return calendarDate.get(Calendar.YEAR);
  }

  public int getOrderDateMonth()
  {
    return calendarDate.get(Calendar.MONTH);
  }

  public int getOrderDateDay()
  {
    return calendarDate.get(Calendar.DAY_OF_MONTH);
  }

  public int getOrderDateHour()
  {
    return calendarDate.get(Calendar.HOUR_OF_DAY);
  }

  public int getOrderDateMinute()
  {
    return calendarDate.get(Calendar.MINUTE);
  }

  public int getOrderDateSecond()
  {
    return calendarDate.get(Calendar.SECOND);
  }

  public Date getDate(){
    return calendarDate.getTime();
  }
  
  public String getOrderDayName()
  {
    switch (calendarDate.get(Calendar.DAY_OF_WEEK))
    {
      case Calendar.MONDAY: 
        return "monday";
      case Calendar.TUESDAY: 
        return "tuesday";
      case Calendar.WEDNESDAY: 
        return "wednesday";
      case Calendar.THURSDAY: 
        return "thursday";
      case Calendar.FRIDAY: 
        return "friday";
      case Calendar.SATURDAY: 
        return "saturday";
      case Calendar.SUNDAY: 
        return "sunday";
    }
    return "";
  }

  @Override
  public String toString() {
    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss,SSS Z").format(getDate());
  }

}
