package com.github.sixro.fraudinvestigator2.fraud1.model;

public enum EFraudEnvironment
{
  TEST_WITH_LIVE_CHAINS (1, "Catene di produzione"),
  PRODUCTION            (2, "Produzione"),
  FULL_TEST             (3, "Catene di test");

  private final String description;
  private int code;

  EFraudEnvironment(int code, String description)
  {
    this.description = description;
    this.code = code;
  }

  /**
   * Find a EFraudEnvironment object given the code
   *
   * @param   The EFraudEnvironment code
   *
   * @return  The EFraudEnvironment object if found, null otherwise
   */
  public static EFraudEnvironment getEFraudEnvironment(int code)
  {
    for (EFraudEnvironment eFraudEnvironment : EFraudEnvironment.values())
    {
      if(code == eFraudEnvironment.getCode())
      {
        return eFraudEnvironment;
      }
    }

    return null;
  }

  public static EFraudEnvironment[] getTestingEnvironment()
  {
    EFraudEnvironment[] eFraudEnvironments = new EFraudEnvironment[2];

    eFraudEnvironments[0] = TEST_WITH_LIVE_CHAINS;
    eFraudEnvironments[1] = FULL_TEST;

    return eFraudEnvironments;
  }

  /**
   * @return The EFraudEnvironment code
   */
  public int getCode()
  {
    return code;
  }

  /**
   * @return The EFraudEnvironment description
   */
  public String getDescription()
  {
    return description;
  }
}