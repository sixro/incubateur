package yodarescue.transaction;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Transaction {

  public static enum Status { joined, not_joined };
  public static enum VolagratisGateway { 
    globalcollect, 
    netgiro, 
    paypal, 
    vegas,
    unknown
  };
  public static enum VegasGateway {
    globalcollect,
    netgiro,
    paypal,
    redsys,
    redsys_tpvpc,
    sofort
  };
  
  private Status status;
  private VolagratisGateway volagratisGateway;
  private VegasGateway vegasGateway;

  private Transaction(Status status, VolagratisGateway volagratisGateway, VegasGateway vegasGateway) {
    super();
    this.status = status;
    this.volagratisGateway = volagratisGateway;
    this.vegasGateway = vegasGateway;
  }

  public static Transaction vegas(Status status, VegasGateway vegasGateway) {
    return new Transaction(status, VolagratisGateway.vegas, vegasGateway);
  }
  
  public static Transaction noVegas(Status status, VolagratisGateway volagratisGateway) {
    if (VolagratisGateway.vegas.equals(volagratisGateway))
      throw new IllegalArgumentException(VolagratisGateway.vegas + " cannot be accepted by 'noVegas' factory method");
    return new Transaction(status, volagratisGateway, null);
  }
  
  public Status getStatus() {
    return status;
  }

  public VolagratisGateway getVolagratisGateway() {
    return volagratisGateway;
  }

  public VegasGateway getVegasGateway() {
    return vegasGateway;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
