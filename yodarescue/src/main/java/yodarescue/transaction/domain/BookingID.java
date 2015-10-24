package yodarescue.transaction.domain;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BookingID {

  private final String value;

  public BookingID(String value) {
    super();
    Validate.isTrue(StringUtils.isNumeric(value), "'value' parameter has to be numeric (found '%s')", value);
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static BookingID valueOf(String value) {
    return new BookingID(value);
  }
  
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return "#" + value;
  }

}
