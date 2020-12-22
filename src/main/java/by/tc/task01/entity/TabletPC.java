package by.tc.task01.entity;

import java.io.Serializable;

public class TabletPC implements Appliance, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2436820450050795257L;

	public static final String _TABLET_PC = "TabletPC";
	
	public static final String _BLUE = "Blue";
	public static final String _RED = "Red";
	public static final String _GREEN = "Green";
	
	private int batteryCapacity;
	private int displayInches;
	private int memoryROM;
	private int flashMemoryCapacity;
	private Color color;

	public static enum Color {
		BLUE(_BLUE), RED(_RED), GREEN(_GREEN);

		private Color(String color) {
			this.color = color;
		}

		private String color;

		public String getColor() {
			return color;
		}
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public int getDisplayInches() {
		return displayInches;
	}

	public void setDisplayInches(int displayInches) {
		this.displayInches = displayInches;
	}

	public int getMemoryROM() {
		return memoryROM;
	}

	public void setMemoryROM(int memoryROM) {
		this.memoryROM = memoryROM;
	}

	public int getFlashMemoryCapacity() {
		return flashMemoryCapacity;
	}

	public void setFlashMemoryCapacity(int flashMemoryCapacity) {
		this.flashMemoryCapacity = flashMemoryCapacity;
	}

	public String getColor() {
		return color.getColor();
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public TabletPC(int batteryCapacity, int displayInches, int memoryROM, int flashMemoryCapacity, Color color) {
		super();
		this.batteryCapacity = batteryCapacity;
		this.displayInches = displayInches;
		this.memoryROM = memoryROM;
		this.flashMemoryCapacity = flashMemoryCapacity;
		this.color = color;
	}

	@Override
	public String toString() {
		return "TabletPC [batteryCapacity=" + batteryCapacity + ", displayInches=" + displayInches + ", memoryROM="
				+ memoryROM + ", flashMemoryCapacity=" + flashMemoryCapacity + ", color=" + color.getColor() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batteryCapacity;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + displayInches;
		result = prime * result + flashMemoryCapacity;
		result = prime * result + memoryROM;
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
		TabletPC other = (TabletPC) obj;
		if (batteryCapacity != other.batteryCapacity)
			return false;
		if (color != other.color)
			return false;
		if (displayInches != other.displayInches)
			return false;
		if (flashMemoryCapacity != other.flashMemoryCapacity)
			return false;
		if (memoryROM != other.memoryROM)
			return false;
		return true;
	}

}
