package com.github.sixro.fraudinvestigator2.fraud1.model;

/**
 * Gli attributi di questa classe non possono mai essere nulli, viene infatti utilizzata in {@link Order}, che alimenta, come parametro l'esecuzione 
 * delle regole MVEL.<br/>
 * Quindi gli attributi di classe vengono istanziati di default a stringa vuota e costruttori e setter possono modificare questo valore solo se appunto 
 * il valore fornito non &egrave; nullo.
 *
 */
public class Passenger
{
  private String countryCode = "";
  private String firstName = "";
  private String lastName = "";

  public Passenger()
  {

  }

  /**
   * Solo parametri non nulli o vuoti vanno a valorizzare realmente gli attributi di classe.
   * @param firstName
   * @param lastName
   * @param countryCode
   */
  public Passenger(String firstName, String lastName, String countryCode)
  {
    setCountryCode(countryCode);
    setFirstName(firstName);
    setLastName(lastName);
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    if(firstName != null && !firstName.isEmpty())
    {
      this.firstName = firstName;
    }
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    if(lastName != null && !lastName.isEmpty())
    {
      this.lastName = lastName;
    }
  }

  public String getPassengerFullName()
  {
    return this.lastName + " " + this.firstName;
  }

  public String getCountryCode()
  {
    return countryCode;
  }

  public void setCountryCode(String countryCode)
  {
    if(countryCode != null && !countryCode.isEmpty())
    {
      this.countryCode = countryCode;
    }
  }
  
  @Override
  public String toString()
  {
    StringBuilder stringBuilder = new StringBuilder();
    
    return stringBuilder.append(lastName).append(" ")
                        .append(firstName).append(" (")
                        .append(countryCode).append(")").toString();
  }
}
