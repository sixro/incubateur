package com.github.sixro.fraudinvestigator2.fraud1.model;

public enum EOrderStatus
{
  MANUAL_CHECK  ("MANUAL_CHECK"),
  DENIED_FRAUD  ("DENIED_FRAUD"),
  OLD_FRAUD     ("OLD_FRAUD"),
  HIGH_RISK     ("HIGH_RISK"),
  LOW_RISK      ("LOW_RISK"),
  NO_FRAUD      ("NO_FRAUD"),
  DENIED        ("DENIED");

  private final String code;

  EOrderStatus(String code)
  {
    this.code = code;
  }

  /**
   * Find a EOrderStatus object given the code
   *
   * @param   The EOrderStatus code
   *
   * @return  The EOrderStatus object if found, null otherwise
   */
  public static EOrderStatus getEOrderStatus(String code)
  {
    for(EOrderStatus eOrderStatus : EOrderStatus.values())
    {
      if(code.equalsIgnoreCase(eOrderStatus.getCode()))
      {
        return eOrderStatus;
      }
    }

    return null;
  }

  /**
   * @return The EOrderStatus code
   */
  public String getCode()
  {
    return code;
  }

  /**
   * True se lo stato dell'ordine e' DENIED o DENIED_FRAUD, false altrimenti.
   *
   * @param EOrderStatus      Codice della risposta
   * @return                  Boolean
   */
  public static boolean isAnywayDenied(String orderStatus)
  {
    if(orderStatus.equalsIgnoreCase(EOrderStatus.DENIED.code) || orderStatus.equalsIgnoreCase(EOrderStatus.DENIED_FRAUD.code))
      return true;
    else
      return false;
  }

  /**
   * True se la risposta del Fraud20 e' DENIED_FRAUD.
   * 
   * @param EOrderStatus      Codice della risposta
   * @return                  Boolean
   */
  public static boolean isDeniedAndFraud(String orderStatus)
  {
    if(orderStatus.equalsIgnoreCase(EOrderStatus.DENIED_FRAUD.code))
      return true;
    else
      return false;
  }

  /**
   * Restituisce true se la risposta del Fraud20 e' stata MANUAL_CHECK.
   *
   * @param EOrderStatus      Codice della risposta
   * @return                  Boolean
   */
  public static boolean isForcedInManual(String orderStatus)
  {
    if(null != orderStatus && orderStatus.equalsIgnoreCase(EOrderStatus.MANUAL_CHECK.code))
      return true;
    else
      return false;
  }
}


