package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Speakers implements Appliance, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8550308786156618172L;

	public static final String _SPEAKERS = "Speakers";

	private int powerConsumption;
	private int numberOfSpeakers;
	private Double[] frequencyRange = new Double[2];
	private int cordLength;

	public Speakers(int powerConsumption, int numberOfSpeakers, Double[] frequencyRange, int cordLength) {
		super();
		this.powerConsumption = powerConsumption;
		this.numberOfSpeakers = numberOfSpeakers;
		this.frequencyRange = frequencyRange;
		this.cordLength = cordLength;
	}

	public int getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public int getNumberOfSpeakers() {
		return numberOfSpeakers;
	}

	public void setNumberOfSpeakers(int numberOfSpeakers) {
		this.numberOfSpeakers = numberOfSpeakers;
	}

	public Double[] getFrequencyRange() {
		return frequencyRange;
	}

	public void setFrequencyRange(Double[] frequencyRange) {
		this.frequencyRange = frequencyRange;
	}

	public int getCordLength() {
		return cordLength;
	}

	public void setCordLength(int cordLength) {
		this.cordLength = cordLength;
	}

	@Override
	public String toString() {
		return "Speakers [powerConsumption=" + powerConsumption + ", numberOfSpeakers=" + numberOfSpeakers
				+ ", frequencyRange=" + Arrays.toString(frequencyRange) + ", cordLength=" + cordLength + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cordLength;
		result = prime * result + Arrays.hashCode(frequencyRange);
		result = prime * result + numberOfSpeakers;
		result = prime * result + powerConsumption;
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
		Speakers other = (Speakers) obj;
		if (cordLength != other.cordLength)
			return false;
		if (!Arrays.equals(frequencyRange, other.frequencyRange))
			return false;
		if (numberOfSpeakers != other.numberOfSpeakers)
			return false;
		if (powerConsumption != other.powerConsumption)
			return false;
		return true;
	}
	
	
}
