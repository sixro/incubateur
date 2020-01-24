package com.github.sixro.fraudinvestigator2.fraud1.model;

public class Airport
{
  private String countryCode;
  private String idAirport;

  public Airport()
  {

  }

  /**
   * Crea un oggetto di tipo Airport
   *
   * @param idAirport     Codice IATA dell'aeroporto
   * @param countryCode   Country code del paese in cui si trova l'aeroporto
   */
  public Airport(String idAirport, String countryCode)
  {
    this.countryCode = countryCode;
    this.idAirport = idAirport;
  }

  public String getCountryCode()
  {
    return countryCode;
  }

  public void setCountryCode(String countryCode)
  {
    this.countryCode = countryCode;
  }

  public String getIdAirport()
  {
    return idAirport;
  }

  public void setIdAirport(String idAirport)
  {
    this.idAirport = idAirport;
  }
}
