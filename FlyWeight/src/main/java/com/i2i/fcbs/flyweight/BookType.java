package com.i2i.fcbs.flyweight;

//FlyWeight
public class BookType {
	private final String type;
	private final String distrubutor;
	private final String otherData;

	public BookType(String type, String distrubutor, String otherData) {
		this.type = type;
		this.distrubutor = distrubutor;
		this.otherData = otherData;
	}

	public String getType() {
		return type;
	}

	public String getDistrubutor() {
		return distrubutor;
	}

	public String getOtherData() {
		return otherData;
	}

	@Override
	public String toString() {
		return "BookType{" +
				"type='" + type + '\'' +
				", distrubutor='" + distrubutor + '\'' +
				", otherData='" + otherData + '\'' +
				'}';
	}
}
