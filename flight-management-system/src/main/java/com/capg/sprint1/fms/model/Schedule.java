package com.capg.sprint1.fms.model;

import java.time.LocalDate;

public class Schedule {
	 Airport sourceAirport, destinationAirport;
	 LocalDate arrivalTime , departureTime;
	 public Schedule() {
		// TODO Auto-generated constructor stub
	}
	public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDate arrivalTime, LocalDate departureTime) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public LocalDate getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDate getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

