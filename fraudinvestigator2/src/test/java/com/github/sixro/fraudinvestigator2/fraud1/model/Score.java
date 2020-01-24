package com.github.sixro.fraudinvestigator2.fraud1.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Score 
{
  private BigDecimal departureAirportCountryCode = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal arrivalAirportCountryCode = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal outboundRouteDiscount = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal returnRouteDiscount = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal contactPhoneNumber = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
//  private BigDecimal iOvationEvidence = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal freeEmailDomain = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal passengerName = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal binCreditCard = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal outboundRoute = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  @Deprecated
  private BigDecimal contactEmail = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal userCountry = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal contactName = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal returnRoute = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal creditCard = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal ipAddress = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private boolean iovationRulesMatched = false;
  private boolean differentCreditCard = false;

  private boolean isTemporaryEmail =false;
  private BigDecimal temporaryEmail = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal partialDomain = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  @Deprecated
  private BigDecimal partialEmail = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal emailName = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  @Deprecated 
  private BigDecimal emailStartWith = BigDecimal.ZERO.setScale(2, RoundingMode.UP);

  private BigDecimal iOvationRuleScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private String iOvationDeviceAlias;
  private String iOvationTrackingNr;
  private String iOvationResultCode;
  private String iOvationRealIP;
  private String iOvationReason;
  
  private BigDecimal hotelCountryScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal hotelCityScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal trainDepartureCountryScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal trainArrivalCountryScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal trainDepartureCityScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal trainArrivalCityScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal holidaysDestinationScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private BigDecimal transactionAttemptsByUuid = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private int        differentCreditCardCounter = 0;
  private int        differentCreditCardTimeLast = 0;
  private int        differentCreditCardTimeTotal = 0;
  
  public BigDecimal getDepartureAirportCountryCode()
  {
    return departureAirportCountryCode;
  }

  public void setDepartureAirportCountryCode(BigDecimal departureAirportCountryCode)
  {
    this.departureAirportCountryCode = departureAirportCountryCode;
  }

  public BigDecimal getArrivalAirportCountryCode()
  {
    return arrivalAirportCountryCode;
  }

  public void setArrivalAirportCountryCode(BigDecimal arrivalAirportCountryCode)
  {
    this.arrivalAirportCountryCode = arrivalAirportCountryCode;
  }

  public BigDecimal getContactPhoneNumber()
  {
    return contactPhoneNumber;
  }

  public synchronized void setContactPhoneNumber(BigDecimal contactPhoneNumber)
  {
    this.contactPhoneNumber = this.contactPhoneNumber.add(contactPhoneNumber);
  }

  public BigDecimal getFreeEmailDomain()
  {
    return freeEmailDomain;
  }

  public void setFreeEmailDomain(BigDecimal freeEmailDomain)
  {
    this.freeEmailDomain = freeEmailDomain;
  }

  public BigDecimal getPassengerName()
  {
    return passengerName;
  }

  public synchronized void setPassengerName(BigDecimal passengerName)
  {
    this.passengerName = this.passengerName.add(passengerName);
  }

  public BigDecimal getTemporaryEmail()
  {
    return temporaryEmail;
  }

  public void setTemporaryEmail(BigDecimal temporaryEmail)
  {
    this.temporaryEmail = temporaryEmail;
  }

  public BigDecimal getBinCreditCard()
  {
    return binCreditCard;
  }

  public void setBinCreditCard(BigDecimal binCreditCard)
  {
    this.binCreditCard = binCreditCard;
  }
  
//  
//  email_score > matcha nicola.bettari@rumbo.com (no wild cards)
//  email_domain_score > matcha il dominio @rumbo.com (eventualmente @rumbo.* - nice to have)
//  email_name_score > ha senso come start with del nome, matcha nicola.bettari*, es. nicola.bettari123, nicola.bettari
//  email_is_temporary > true/false
  
  @Deprecated
  public BigDecimal getPartialEmail()
  {
    return partialEmail;
  }
  @Deprecated
  public void setPartialEmail(BigDecimal partialEmail)
  {
    this.partialEmail = partialEmail;
  }

  public BigDecimal getContactEmail()
  {
    return contactEmail;
  }

  public void setContactEmail(BigDecimal contactEmail)
  {
    this.contactEmail = contactEmail;
  }

  public BigDecimal getUserCountry()
  {
    return userCountry;
  }

  public void setUserCountry(final BigDecimal userCountry)
  {
    this.userCountry = userCountry;
  }

  public BigDecimal getContactName()
  {
    return contactName;
  }

  public void setContactName(BigDecimal contactName)
  {
    this.contactName = contactName;
  }

  public BigDecimal getCreditCard()
  {
    return creditCard;
  }

  public void setCreditCard(BigDecimal creditCard)
  {
    this.creditCard = creditCard;
  }

  public BigDecimal getIpAddress()
  {
    return ipAddress;
  }

  public void setIpAddress(BigDecimal ipAddress)
  {
    this.ipAddress = ipAddress;
  }

  public BigDecimal getOutboundRoute()
  {
    return outboundRoute;
  }

  public void setOutboundRoute(BigDecimal outboundRoute)
  {
    this.outboundRoute = outboundRoute;
  }

  public BigDecimal getReturnRoute()
  {
    return returnRoute;
  }

  public void setReturnRoute(BigDecimal returnRoute)
  {
    this.returnRoute = returnRoute;
  }

  public BigDecimal getReturnRouteDiscount()
  {
    return returnRouteDiscount;
  }

  public void setReturnRouteDiscount(BigDecimal returnRouteDiscount)
  {
    this.returnRouteDiscount = returnRouteDiscount;
  }

  public BigDecimal getOutboundRouteDiscount()
  {
    return outboundRouteDiscount;
  }

  public void setOutboundRouteDiscount(BigDecimal outboundRouteDiscount)
  {
    this.outboundRouteDiscount = outboundRouteDiscount;
  }

  public BigDecimal getPartialDomain ()
  {
    return partialDomain;
  }

  public void setPartialDomain (BigDecimal partialDomain)
  {
    this.partialDomain = partialDomain;
  }

  public BigDecimal getEmailStartWith ()
  {
    return emailStartWith;
  }

  public void setEmailStartWith (BigDecimal emailStartWith)
  {
    this.emailStartWith = emailStartWith;
  }

  public boolean isDifferentCreditCard()
  {
    return differentCreditCard;
  }
  
  public boolean isTemporaryEmail()
  {
    return isTemporaryEmail;
  }
  
  public void setIsTemporaryEmail(boolean isTemporaryEmail)
  {
    this.isTemporaryEmail = isTemporaryEmail;
  }
  

  public void setDifferentCreditCard(boolean differentCreditCard)
  {
    this.differentCreditCard = differentCreditCard;
  }

//  public BigDecimal getiOvationEvidence()
//  {
//    return iOvationEvidence;
//  }
//
//  public void setiOvationEvidence(BigDecimal iOvationEvidence)
//  {
//    this.iOvationEvidence = iOvationEvidence;
//  }

  public boolean isIovationRulesMatched()
  {
    return iovationRulesMatched;
  }

  public void setIovationRulesMatched(boolean iovationRulesMatched)
  {
    this.iovationRulesMatched = iovationRulesMatched;
  }

  public BigDecimal getIovationRuleScore()
  {
    return iOvationRuleScore;
  }

  public void setIovationRuleScore(BigDecimal iOvationRuleScore)
  {
    this.iOvationRuleScore = iOvationRuleScore;
  }

  public String getIovationDeviceAlias()
  {
    return iOvationDeviceAlias;
  }

  public void setIovationDeviceAlias(String iOvationDeviceAlias)
  {
    this.iOvationDeviceAlias = iOvationDeviceAlias;
  }

  public String getIovationTrackingNr()
  {
    return iOvationTrackingNr;
  }

  public void setIovationTrackingNr(String iOvationTrackingNr)
  {
    this.iOvationTrackingNr = iOvationTrackingNr;
  }

  public String getIovationResultCode()
  {
    return iOvationResultCode;
  }

  public void setIovationResultCode(String iOvationResultCode)
  {
    this.iOvationResultCode = iOvationResultCode;
  }

  public String getIovationRealIP()
  {
    return iOvationRealIP;
  }

  public void setIovationRealIP(String iOvationRealIP)
  {
    this.iOvationRealIP = iOvationRealIP;
  }

  public String getIovationReason()
  {
    return iOvationReason;
  }

  public void setIovationReason(String iOvationReason)
  {
    this.iOvationReason = iOvationReason;
  }

  public BigDecimal getHotelCountryScore ()
  {
    return hotelCountryScore;
  }

  public void setHotelCountryScore (BigDecimal hotelCountryScore)
  {
    this.hotelCountryScore = hotelCountryScore;
  }

  public BigDecimal getHotelCityScore ()
  {
    return hotelCityScore;
  }

  public void setHotelCityScore (BigDecimal hotelCityScore)
  {
    this.hotelCityScore = hotelCityScore;
  }

  public BigDecimal getTrainDepartureCountryScore ()
  {
    return trainDepartureCountryScore;
  }

  public void setTrainDepartureCountryScore (BigDecimal trainDepartureCountryScore)
  {
    this.trainDepartureCountryScore = trainDepartureCountryScore;
  }

  public BigDecimal getTrainArrivalCountryScore ()
  {
    return trainArrivalCountryScore;
  }

  public void setTrainArrivalCountryScore (BigDecimal trainArrivalCountryScore)
  {
    this.trainArrivalCountryScore = trainArrivalCountryScore;
  }

  public BigDecimal getTrainDepartureCityScore ()
  {
    return trainDepartureCityScore;
  }

  public void setTrainDepartureCityScore (BigDecimal trainDepartureCityScore)
  {
    this.trainDepartureCityScore = trainDepartureCityScore;
  }

  public BigDecimal getTrainArrivalCityScore ()
  {
    return trainArrivalCityScore;
  }

  public void setTrainArrivalCityScore (BigDecimal trainArrivalCityScore)
  {
    this.trainArrivalCityScore = trainArrivalCityScore;
  }

  public BigDecimal getHolidaysDestinationScore ()
  {
    return holidaysDestinationScore;
  }

  public void setHolidaysDestinationScore (BigDecimal holidaysDestinationScore)
  {
    this.holidaysDestinationScore = holidaysDestinationScore;
  }

  public BigDecimal getTransactionAttemptsByUuid ()
  {
    return transactionAttemptsByUuid;
  }

  public void setTransactionAttemptsByUuid (BigDecimal transactionAttemptsByUuid)
  {
    this.transactionAttemptsByUuid = transactionAttemptsByUuid;
  }

  public int getDifferentCreditCardCounter()
  {
    return differentCreditCardCounter;
  }

  public void setDifferentCreditCardCounter(int differentCreditCardCounter)
  {
    this.differentCreditCardCounter = differentCreditCardCounter;
  }

  public int getDifferentCreditCardTimeLast()
  {
    return differentCreditCardTimeLast;
  }

  public void setDifferentCreditCardTimeLast(int differentCreditCardTimeLast)
  {
    this.differentCreditCardTimeLast = differentCreditCardTimeLast;
  }

  public int getDifferentCreditCardTimeTotal()
  {
    return differentCreditCardTimeTotal;
  }

  public void setDifferentCreditCardTimeTotal(int differentCreditCardTimeTotal)
  {
    this.differentCreditCardTimeTotal = differentCreditCardTimeTotal;
  }

  public BigDecimal getEmailName()
  {
    return emailName;
  }

  public void setEmailName(BigDecimal emailName)
  {
    this.emailName = emailName;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}