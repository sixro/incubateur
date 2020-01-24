package com.github.sixro.fraudinvestigator2.fraud1.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

public class MaxMindResponse implements Serializable
{
  private static final long serialVersionUID = 7089768134339493271L;

  private String custPhoneInBillingLoc;
  private String shipCityPostalMatch;
  private String queriesRemaining;
  private String cityPostalMatch;
  private String highRiskCountry;
  /**
   * Sarebbe bello trasformarlo in booleano....
   */
  private String anonymousProxy;
  private String binPhoneMatch;
  private String binNameMatch;
  private String countryMatch;
  private String ip_longitude;
  private String ip_latitude;
  private String carderEmail;
  private String explanation;
  /**
   * Country code relativo all'ip
   */
  private String countryCode;
  private boolean fromCache;
  /**
   * Country code della carta di credito
   */
  private String binCountry;
  private String proxyScore;
  private String maxmindID;
  private String riskScore;
  private String ip_region;
  private String binMatch;
  private String freeMail;
  private String distance;
  private String binPhone;
  private String ip_city;
  private String binName;
  private String ip_isp;
  private String ip_org;
  private String score;
  private String err;
  private long id;
  
  public MaxMindResponse() 
  {

  }

  /**
   * Restituisce un'istanza di un oggetto MaxMindResponse 
   *
   * @param fraudMaxMind      Oggetto FraudMaxMind con i dati della richiesta MaxMind
   *
   * @return MaxMindResponse  Oggetto con i dati della risposta di MaxMind
   * @since                   1.0
   */
  /*
  public static MaxMindResponse getMaxMindResponse(final FraudMaxMind fraudMaxMind)
  {
    MaxMindResponse response = new MaxMindResponse();

    response.setAnonymousProxy(fraudMaxMind.getAnonymousProxy());
    response.setProxyScore(fraudMaxMind.getProxyScore());
    response.setCountryCode(fraudMaxMind.getCountryIP());
    response.setBinCountry(fraudMaxMind.getCountryCC());
    response.setMaxmindID(fraudMaxMind.getIdMaxMind());
    response.setFreeMail(fraudMaxMind.getFreeEmail());
    response.setBinPhone(fraudMaxMind.getBinPhone());
    response.setScore(fraudMaxMind.getFraudScore());
    response.setBinName(fraudMaxMind.getBinName());
    response.setErr(fraudMaxMind.getError());
    response.setId(fraudMaxMind.getId());

    return response;
  }

   */
  
  /**
   * Restituisce un'istanza di un oggetto MaxMindResponse
   *
   * @return a fake {@link MaxMindResponse}
   */
  /*
  public static MaxMindResponse maxMindFakeResponse (final MaxMindRequest request)
  {
    MaxMindResponse fakeResponse = new MaxMindResponse();

    fakeResponse.setMaxmindID(request.getOrderReference().getOrderId());
    fakeResponse.setBinName("THE CHASE MANHATTAN BANK");
    fakeResponse.setBinPhone("302-575-5450");
    fakeResponse.setAnonymousProxy("No");
    fakeResponse.setProxyScore("0.00");
    fakeResponse.setCountryCode("IT");
    fakeResponse.setBinCountry("US");
    fakeResponse.setFreeMail("No");
    fakeResponse.setScore("4.51");
    fakeResponse.setErr("...");
    fakeResponse.setId(11);

    return fakeResponse;
  }

   */

  public String getCityPostalMatch ()
  {
    if(cityPostalMatch == null)
    {
      return "";
    }
    return cityPostalMatch.toUpperCase();
  }

  /**
   * @return il country code della carta di credito
   */
  public String getBinCountry ()
  {
    if(binCountry == null)
    {
      return "";
    }
    return binCountry.toUpperCase();
  }

  public String getBinNameMatch ()
  {
    if(binNameMatch == null)
    {
      return "";
    }
    return binNameMatch.toUpperCase();
  }

  public String getAnonymousProxy ()
  {
    if(anonymousProxy == null)
    {
      return "";
    }
    return anonymousProxy.toUpperCase();
  }

  /**
   * @return lo score come <code>Integer</code> invece che come stringa
   */
  public BigDecimal getScoreAsInt()
  {
    if(null == score || score.isEmpty())
    {
      return BigDecimal.ZERO;
    }
    try
    {
      BigDecimal bigDecimal = new BigDecimal(score);
      return bigDecimal;
    }
    catch (NumberFormatException e)
    {
      return BigDecimal.ZERO;
    }
  }
  
  public String getScore ()
  {
    if(score == null)
    {
      return "";
    }
    return score;
  }

  public String getIp_city ()
  {
    if(ip_city == null)
    {
      return "";
    }
    return ip_city;
  }

  public String getCountryMatch ()
  {
    if(countryMatch == null)
    {
      return "";
    }
    return countryMatch.toUpperCase();
  }

  public String getBinPhoneMatch ()
  {
    if(binPhoneMatch == null)
    {
      return "";
    }
    return binPhoneMatch.toUpperCase();
  }

  public String getIp_isp ()
  {
    if(ip_isp == null)
    {
      return "";
    }
    return ip_isp;
  }

  public String getBinMatch ()
  {
    if(binMatch == null)
    {
      return "";
    }
    return binMatch.toUpperCase();
  }

  public String getFreeMail ()
  {
    if(freeMail == null)
    {
      return "";
    }
    return freeMail.toUpperCase();
  }

  public String getDistance ()
  {
    if(distance == null)
    {
      return "";
    }
    return distance;
  }

  public String getCustPhoneInBillingLoc ()
  {
    if(custPhoneInBillingLoc == null)
    {
      return "";
    }
    return custPhoneInBillingLoc;
  }

  public String getShipCityPostalMatch ()
  {
    if(shipCityPostalMatch == null)
    {
      return "";
    }
    return shipCityPostalMatch;
  }

  public String getBinPhone ()
  {
    if(binPhone == null)
    {
      return "";
    }
    return binPhone;
  }

  public String getIp_latitude ()
  {
    if(ip_latitude == null)
    {
      return "";
    }
    return ip_latitude;
  }

  public String getMaxmindID ()
  {
    if(maxmindID == null)
    {
      return "";
    }
    return maxmindID;
  }

  public String getCarderEmail ()
  {
    if(carderEmail == null)
    {
      return "";
    }
    return carderEmail;
  }

  public String getIp_longitude ()
  {
    if(ip_longitude == null)
    {
      return "";
    }
    return ip_longitude;
  }

  public String getQueriesRemaining ()
  {
    if(queriesRemaining == null)
    {
      return "";
    }
    return queriesRemaining;
  }

  public String getExplanation ()
  {
    if(explanation == null)
    {
      return "";
    }
    return explanation;
  }

  /**
   * @return il country code relativo all'ip della chiamata.
   */
  public String getCountryCode ()
  {
    if(countryCode == null)
    {
      return "";
    }
    return countryCode.toUpperCase();
  }

  public String getRiskScore ()
  {
    if(riskScore == null)
    {
      return "";
    }
    return riskScore;
  }

  public String getIp_region ()
  {
    if(ip_region == null)
    {
      return "";
    }
    return ip_region;
  }

  public String getProxyScore ()
  {
    if(proxyScore == null)
    {
      return "";
    }
    return proxyScore;
  }

  public String getHighRiskCountry ()
  {
    if(highRiskCountry == null)
    {
      return "";
    }
    return highRiskCountry;
  }

  public String getBinName ()
  {
    if(binName == null)
    {
      return "";
    }
    return binName.toUpperCase();
  }

  public String getIp_org ()
  {
    if(ip_org == null)
    {
      return "";
    }
    return ip_org;
  }

  public String getErr ()
  {
    if(err == null)
    {
      return "";
    }
    return err;
  }

  public void setCityPostalMatch (String cityPostalMatch)
  {
    this.cityPostalMatch = cityPostalMatch;
  }

  public void setBinCountry (String binCountry)
  {
    this.binCountry = binCountry;
  }

  public void setBinNameMatch (String binNameMatch)
  {
    this.binNameMatch = binNameMatch;
  }

  public void setAnonymousProxy (String anonymousProxy)
  {
    this.anonymousProxy = anonymousProxy;
  }

  public void setScore (String score)
  {
    this.score = score;
  }

  public void setIp_city (String ip_city)
  {
    this.ip_city = ip_city;
  }

  public void setCountryMatch (String countryMatch)
  {
    this.countryMatch = countryMatch;
  }

  public void setBinPhoneMatch (String binPhoneMatch)
  {
    this.binPhoneMatch = binPhoneMatch;
  }

  public void setIp_isp (String ip_isp)
  {
    this.ip_isp = ip_isp;
  }

  public void setBinMatch (String binMatch)
  {
    this.binMatch = binMatch;
  }

  public void setFreeMail (String freeMail)
  {
    this.freeMail = freeMail;
  }

  public void setDistance (String distance)
  {
    this.distance = distance;
  }

  public void setCustPhoneInBillingLoc (String custPhoneInBillingLoc)
  {
    this.custPhoneInBillingLoc = custPhoneInBillingLoc;
  }

  public void setShipCityPostalMatch (String shipCityPostalMatch)
  {
    this.shipCityPostalMatch = shipCityPostalMatch;
  }

  public void setBinPhone (String binPhone)
  {
    this.binPhone = binPhone;
  }

  public void setIp_latitude (String ip_latitude)
  {
    this.ip_latitude = ip_latitude;
  }

  public void setMaxmindID (String maxmindID)
  {
    this.maxmindID = maxmindID;
  }

  public void setCarderEmail (String carderEmail)
  {
    this.carderEmail = carderEmail;
  }

  public void setIp_longitude (String ip_longitude)
  {
    this.ip_longitude = ip_longitude;
  }

  public void setQueriesRemaining (String queriesRemaining)
  {
    this.queriesRemaining = queriesRemaining;
  }

  public void setExplanation (String explanation)
  {
    this.explanation = explanation;
  }

  public void setCountryCode (String countryCode)
  {
    this.countryCode = countryCode;
  }

  public void setRiskScore (String riskScore)
  {
    this.riskScore = riskScore;
  }

  public void setIp_region (String ip_region)
  {
    this.ip_region = ip_region;
  }

  public void setProxyScore (String proxyScore)
  {
    this.proxyScore = proxyScore;
  }

  public void setHighRiskCountry (String highRiskCountry)
  {
    this.highRiskCountry = highRiskCountry;
  }

  public void setBinName (String binName)
  {
    this.binName = binName;
  }

  public void setIp_org (String ip_org)
  {
    this.ip_org = ip_org;
  }

  public void setErr (String err)
  {
    this.err = err;
  }

  public boolean isFromCache()
  {
    return fromCache;
  }

  public void setFromCache(boolean fromCache)
  {
    this.fromCache = fromCache;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  /*
  public boolean isInError()
  {
    return getErr() != null && !getErr().isEmpty()
        && getErr().startsWith(MaxMindService.MAXMIND_COMUNICATION_EXCEPTION);
  }

   */

  @Override
  public String toString ()
  {
//    StringBuilder stringBuilder = new StringBuilder();
//
//    stringBuilder.append("Score=").append(this.score)
//                 .append(", FreeMail=").append(this.freeMail)
//                 .append(", AnonymousProxy=").append(this.anonymousProxy)
//                 .append(", CountryCode=").append(this.countryCode)
//                 .append(", BinCountry=").append(this.binCountry)
//                 .append(", BinName=").append(this.binName)
//                 .append(", BinPhone=").append(this.binPhone)
//                 .append(", MaxmindID=").append(this.maxmindID)
//                 .append(", Err=").append(this.err);
//
//    return stringBuilder.toString();
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
