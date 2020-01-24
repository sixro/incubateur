package com.github.sixro.fraudinvestigator2.fraud1.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IOvation
{

  private BigDecimal ruleScore = BigDecimal.ZERO.setScale(2, RoundingMode.UP);
  private boolean rulesMatched = false;
  private String deviceAlias;
  private String trackingNr;
  private String resultCode;
  private String realIP;
  private String reason;
  private String deviceType;

  public IOvation ()
  {

  }

  public BigDecimal getRuleScore ()
  {
    return ruleScore;
  }

  public void setRuleScore (BigDecimal ruleScore)
  {
    this.ruleScore = ruleScore;
  }

  public boolean isRulesMatched ()
  {
    return rulesMatched;
  }

  public void setRulesMatched (boolean rulesMatched)
  {
    this.rulesMatched = rulesMatched;
  }

  public String getDeviceAlias ()
  {
    return deviceAlias;
  }

  public void setDeviceAlias (String deviceAlias)
  {
    this.deviceAlias = deviceAlias;
  }

  public String getTrackingNr ()
  {
    return trackingNr;
  }

  public void setTrackingNr (String trackingNr)
  {
    this.trackingNr = trackingNr;
  }

  public String getResultCode ()
  {
    return resultCode;
  }

  public void setResultCode (String resultCode)
  {
    this.resultCode = resultCode;
  }

  public String getRealIP ()
  {
    return realIP;
  }

  public void setRealIP (String realIP)
  {
    this.realIP = realIP;
  }

  public String getReason ()
  {
    return reason;
  }

  public void setReason (String reason)
  {
    this.reason = reason;
  }

  public String getDeviceType ()
  {
    return deviceType;
  }

  public void setDeviceType (String deviceType)
  {
    this.deviceType = deviceType;

  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
