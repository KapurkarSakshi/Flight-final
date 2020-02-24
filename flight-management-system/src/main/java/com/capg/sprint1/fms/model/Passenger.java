package com.capg.sprint1.fms.model;

public class Passenger {
	 long pnrNumber;
	 String passengerName;
	 int passengerAge;
	 long passengerUIN;
	 double Luggage;
	 
	 public Passenger() {
       }

	public Passenger(long pnrNumber, String passengerName, int passengerAge, long passengerUIN, double luggage) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.Luggage = luggage;
	}

	public long getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(long pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public long getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(long passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public double getLuggage() {
		return Luggage;
	}

	public void setLuggage(double luggage) {
		Luggage = luggage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Luggage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + passengerAge;
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + (int) (passengerUIN ^ (passengerUIN >>> 32));
		result = prime * result + (int) (pnrNumber ^ (pnrNumber >>> 32));
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
		Passenger other = (Passenger) obj;
		if (Double.doubleToLongBits(Luggage) != Double.doubleToLongBits(other.Luggage))
			return false;
		if (passengerAge != other.passengerAge)
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (passengerUIN != other.passengerUIN)
			return false;
		if (pnrNumber != other.pnrNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passenger [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", Luggage=" + Luggage + "]";
	}
	 
	 
}
