package by.tc.task01.entity;

import java.io.Serializable;

public class Refrigerator implements Appliance, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3204447984510377133L;

	public static final String _REFRIGERATOR = "Refrigerator";

	private int powerConsumption;
	private double weight;
	private double freezerCapacity;
	private double overallCapacity;
	private double height;
	private double width;

	public Refrigerator(int powerConsumption, double weight, double freezerCapacity, double overallCapacity,
			double height, double width) {
		super();
		this.powerConsumption = powerConsumption;
		this.weight = weight;
		this.freezerCapacity = freezerCapacity;
		this.overallCapacity = overallCapacity;
		this.height = height;
		this.width = width;
	}

	public int getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getFreezerCapacity() {
		return freezerCapacity;
	}

	public void setFreezerCapacity(double freezerCapacity) {
		this.freezerCapacity = freezerCapacity;
	}

	public double getOverallCapacity() {
		return overallCapacity;
	}

	public void setOverallCapacity(double overallCapacity) {
		this.overallCapacity = overallCapacity;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Refrigerator [powerConsumption=" + powerConsumption + ", weight=" + weight + ", freezerCapacity="
				+ freezerCapacity + ", overallCapacity=" + overallCapacity + ", height=" + height + ", width=" + width
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(freezerCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(overallCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + powerConsumption;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refrigerator other = (Refrigerator) obj;
		if (Double.doubleToLongBits(freezerCapacity) != Double.doubleToLongBits(other.freezerCapacity))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(overallCapacity) != Double.doubleToLongBits(other.overallCapacity))
			return false;
		if (powerConsumption != other.powerConsumption)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}
	
	
}
