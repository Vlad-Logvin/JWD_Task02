package by.tc.task01.entity;

import java.io.Serializable;

public class Laptop implements Appliance, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5804955983835742648L;

	public static final String _LAPTOP = "Laptop";
	
	public static final String _WINDOWS = "Windows";
	public static final String _LINUX = "Linux";
	public static final String _MAC_OS = "Mac_OS";

	private double batteryCapacity;
	private OS os;
	private int memoryRom;
	private int systemMemory;
	private double cpu;
	private int displayInchs;

	public Laptop(double batteryCapacity, OS os, int memoryRom, int systemMemory, double cpu, int displayInchs) {
		super();
		this.batteryCapacity = batteryCapacity;
		this.os = os;
		this.memoryRom = memoryRom;
		this.systemMemory = systemMemory;
		this.cpu = cpu;
		this.displayInchs = displayInchs;
	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public static enum OS {
		WINDOWS(_WINDOWS), LINUX(_LINUX), MAC_OS(_MAC_OS);

		OS(String os) {
			_os = os;
		}

		private String _os;

		public String get_os() {
			return _os;
		}
	}

	public String getOs() {
		return os.get_os();
	}

	public void setOs(OS os) {
		this.os = os;
	}

	public int getMemoryRom() {
		return memoryRom;
	}

	public void setMemoryRom(int memoryRom) {
		this.memoryRom = memoryRom;
	}

	public int getSystemMemory() {
		return systemMemory;
	}

	public void setSystemMemory(int systemMemory) {
		this.systemMemory = systemMemory;
	}

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	public int getDisplayInchs() {
		return displayInchs;
	}

	public void setDisplayInchs(int displayInchs) {
		this.displayInchs = displayInchs;
	}

	@Override
	public String toString() {
		return "Laptop [batteryCapacity=" + batteryCapacity + ", os=" + os.get_os() + ", memoryRom=" + memoryRom
				+ ", systemMemory=" + systemMemory + ", cpu=" + cpu + ", displayInchs=" + displayInchs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(batteryCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cpu);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + displayInchs;
		result = prime * result + memoryRom;
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + systemMemory;
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
		Laptop other = (Laptop) obj;
		if (Double.doubleToLongBits(batteryCapacity) != Double.doubleToLongBits(other.batteryCapacity))
			return false;
		if (Double.doubleToLongBits(cpu) != Double.doubleToLongBits(other.cpu))
			return false;
		if (displayInchs != other.displayInchs)
			return false;
		if (memoryRom != other.memoryRom)
			return false;
		if (os != other.os)
			return false;
		if (systemMemory != other.systemMemory)
			return false;
		return true;
	}
	
	
}
