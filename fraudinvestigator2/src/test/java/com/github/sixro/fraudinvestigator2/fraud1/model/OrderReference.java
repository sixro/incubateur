package com.github.sixro.fraudinvestigator2.fraud1.model;

import java.io.Serializable;

public class OrderReference implements Serializable
{
  private static final long serialVersionUID = -4780764460497028398L;

  private int transactionNum;
  private String partnerId;
  private String orderId;
  private String merchantDomain;


  public OrderReference(final String merchantDomain, final String orderId, final int transactionNum)
  {
    this.transactionNum = transactionNum;
    this.partnerId  = merchantDomain;
    this.merchantDomain  = merchantDomain;
    this.orderId    = orderId;
  }

  public String getPartnerId ()
  {
    return partnerId;
  }

  public void setPartnerId (String partnerId)
  {
    this.partnerId = partnerId;
  }

  public String getOrderId ()
  {
    return orderId;
  }

  public void setOrderId (String orderId)
  {
    this.orderId = orderId;
  }
  
  public int getTransactionNum()
  {
    return transactionNum;
  }

  public void setTransactionNum(int transactionNum)
  {
    this.transactionNum = transactionNum;
  }
  
  @Override
  public String toString ()
  {
    return new StringBuilder().append(this.getPartnerId())
                              .append(this.getOrderId())
                              .append("/")
                              .append(this.getTransactionNum()).toString();
  }

  public String getMerchantDomain()
  {
    return merchantDomain;
  }
}
