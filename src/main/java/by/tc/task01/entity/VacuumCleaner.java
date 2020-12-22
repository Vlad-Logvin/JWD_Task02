package by.tc.task01.entity;

import java.io.Serializable;

public class VacuumCleaner implements Appliance, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7090896132527541763L;

	public static final String _VACUUM_CLEANER = "VacuumCleaner";

	public static final String _A = "A";
	public static final String _B = "B";
	public static final String _C = "C";

	public static final String _A2 = "A2";
	public static final String _AX = "AX";
	public static final String _AX00 = "AX00";

	public static final String _ALL_IN_ALL = "all-in-all";
	public static final String _NOT_ALL_IN_ALL = "not-all-in-all";

	private int powerConsumption;
	private int motorSpeedRegulation;
	private double cleaningWidth;
	private WandType wandType;
	private FilterType filterType;
	private BagType bagType;

	public static enum FilterType {
		A(_A), B(_B), C(_C);

		private FilterType(String filterType) {
			this.filterType = filterType;
		}

		private String filterType;

		public String getFilterType() {
			return filterType;
		}
	}

	public String getFilterType() {
		return filterType.getFilterType();
	}

	public void setFilterType(FilterType filterType) {
		this.filterType = filterType;
	}

	public static enum BagType {
		A2(_A2), AX(_AX), AX00(_AX00);

		private BagType(String bagType) {
			this.bagType = bagType;
		}

		private String bagType;

		public String getBagType() {
			return bagType;
		}
	}

	public String getBagType() {
		return bagType.getBagType();
	}

	public void setBagType(BagType bagType) {
		this.bagType = bagType;
	}

	public static enum WandType {
		allInAll(_ALL_IN_ALL), notAllInAll(_NOT_ALL_IN_ALL);

		private WandType(String wandType) {
			this.wandType = wandType;
		}

		private String wandType;

		public String getWandType() {
			return wandType;
		}
	}

	public String getWandType() {
		return wandType.getWandType();
	}

	public void setWandType(WandType wandType) {
		this.wandType = wandType;
	}

	public VacuumCleaner(int powerConsumption, FilterType filterType, BagType bagType, WandType wandType,
			int motorSpeedRegulation, double cleaningWidth) {
		super();
		this.powerConsumption = powerConsumption;
		this.filterType = filterType;
		this.bagType = bagType;
		this.wandType = wandType;
		this.motorSpeedRegulation = motorSpeedRegulation;
		this.cleaningWidth = cleaningWidth;
	}

	public int getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public int getMotorSpeedRegulation() {
		return motorSpeedRegulation;
	}

	public void setMotorSpeedRegulation(int motorSpeedRegulation) {
		this.motorSpeedRegulation = motorSpeedRegulation;
	}

	public double getCleaningWidth() {
		return cleaningWidth;
	}

	public void setCleaningWidth(double cleaningWidth) {
		this.cleaningWidth = cleaningWidth;
	}

	@Override
	public String toString() {
		return "VacuumCleaner [powerConsumption=" + powerConsumption + ", filterType=" + filterType.getFilterType()
				+ ", bagType=" + bagType.getBagType() + ", wandType=" + wandType.getWandType()
				+ ", motorSpeedRegulation=" + motorSpeedRegulation + ", cleaningWidth=" + cleaningWidth + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bagType == null) ? 0 : bagType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cleaningWidth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((filterType == null) ? 0 : filterType.hashCode());
		result = prime * result + motorSpeedRegulation;
		result = prime * result + powerConsumption;
		result = prime * result + ((wandType == null) ? 0 : wandType.hashCode());
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
		VacuumCleaner other = (VacuumCleaner) obj;
		if (bagType != other.bagType)
			return false;
		if (Double.doubleToLongBits(cleaningWidth) != Double.doubleToLongBits(other.cleaningWidth))
			return false;
		if (filterType != other.filterType)
			return false;
		if (motorSpeedRegulation != other.motorSpeedRegulation)
			return false;
		if (powerConsumption != other.powerConsumption)
			return false;
		if (wandType != other.wandType)
			return false;
		return true;
	}

}
