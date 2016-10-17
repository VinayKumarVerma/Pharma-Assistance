/**
 * 
 */
package com.pharma.vo;

import java.io.Serializable;

/**
 * @author vinay.v
 * 
 *         This an value Object class with private data member and their
 *         respective getter and setter methods and an overridden toString
 *         method.
 */
@SuppressWarnings("serial")
public class BatchVO implements Serializable {
	private String batchCode;
	private String medicineCode;
	private String medicineName;
	private String medicineTypeCode;
	private String medicineTypeName;
	private int weight;
	private String weightRange;
	private String careLevel;
	private double shippingCharge;
	private double price;
	private boolean refrigeration;
	private double totalCost;

	/**
	 * @return the batchCode
	 */
	public String getBatchCode() {
		return batchCode;
	}

	/**
	 * @param batchCode
	 *            the batchCode to set
	 */
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	/**
	 * @return the medicineCode
	 */
	public String getMedicineCode() {
		return medicineCode;
	}

	/**
	 * @param medicineCode
	 *            the medicineCode to set
	 */
	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	/**
	 * @return the medicineName
	 */
	public String getMedicineName() {
		return medicineName;
	}

	/**
	 * @param medicineName
	 *            the medicineName to set
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	/**
	 * @return the medicineTypeCode
	 */
	public String getMedicineTypeCode() {
		return medicineTypeCode;
	}

	/**
	 * @param medicineTypeCode
	 *            the medicineTypeCode to set
	 */
	public void setMedicineTypeCode(String medicineTypeCode) {
		this.medicineTypeCode = medicineTypeCode;
	}

	/**
	 * @return the medicineTypeName
	 */
	public String getMedicineTypeName() {
		return medicineTypeName;
	}

	/**
	 * @param medicineTypeName
	 *            the medicineTypeName to set
	 */
	public void setMedicineTypeName(String medicineTypeName) {
		this.medicineTypeName = medicineTypeName;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the weightRange
	 */
	public String getWeightRange() {
		return weightRange;
	}

	/**
	 * @param weightRange
	 *            the weightRange to set
	 */
	public void setWeightRange(String weightRange) {
		this.weightRange = weightRange;
	}

	/**
	 * @return the careLevel
	 */
	public String getCareLevel() {
		return careLevel;
	}

	/**
	 * @param careLevel
	 *            the careLevel to set
	 */
	public void setCareLevel(String careLevel) {
		this.careLevel = careLevel;
	}

	/**
	 * @return the shippingCharge
	 */
	public double getShippingCharge() {
		return shippingCharge;
	}

	/**
	 * @param shippingCharge
	 *            the shippingCharge to set
	 */
	public void setShippingCharge(double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the refrigeration requirement
	 */
	public boolean isRefrigeration() {
		return refrigeration;
	}

	/**
	 * @param refrigeration
	 *            the refrigeration to set
	 */
	public void setRefrigeration(boolean refrigeration) {
		this.refrigeration = refrigeration;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/*
	 * This is an overridden toString method to based on available properties to
	 * reduce the message passings
	 */
	@Override
	public String toString() {
		return "BatchVO [batchCode=" + batchCode + ", medicineCode="
				+ medicineCode + ", medicineName=" + medicineName
				+ ", medicineTypeCode=" + medicineTypeCode
				+ ", medicineTypeName=" + medicineTypeName + ", weight="
				+ weight + ", weightRange=" + weightRange + ", careLevel="
				+ careLevel + ", shippingCharge=" + shippingCharge + ", price="
				+ price + ", refrigeration=" + refrigeration + ", totalCost="
				+ totalCost + "]";
	}

}
