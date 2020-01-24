package db4idlers;

import org.apache.commons.lang3.builder.*;

public class Dealer {

	public static enum Channel { company, others };
	
	private String code;
	private String name;
	private Channel channel;
	private String address;
	private String zipcode;
	private String city;
	private String province;
	
	public Dealer(String code, String name, Channel channel, String address, String zipcode, String city, String province) {
		super();
		this.code = code;
		this.name = name;
		this.channel = channel;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.province = province;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Channel getChannel() {
		return channel;
	}

	public String getAddress() {
		return address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public static Dealer valueOf(String code, String name, String channelCode, String address, String zipcode, String city, String province) {
		Channel channel = channelCode.equalsIgnoreCase("I3")
			? Channel.company
			: Channel.others;
		return new Dealer(channelCode, name, channel, address, zipcode, city, province);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,  obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
