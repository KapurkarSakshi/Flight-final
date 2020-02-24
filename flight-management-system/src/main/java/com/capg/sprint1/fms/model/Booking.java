package com.capg.sprint1.fms.model;
import java.time.LocalDate;
import java.util.*;

	public class Booking {
		 long bookingId;
	     User userId;
	     LocalDate bookingDate; 
	     List<Passenger> passengerList;
	     double ticketCost;
	     Flight flight;
	     Integer noOfPassengers;
	     public Map<Long,Booking> getBooking() {
	    	 return null;
	     }
	 
	     public Booking() {
	       }

		public long getBookingId() {
			return bookingId;
		}

		public void setBookingId(long bookingId) {
			this.bookingId = bookingId;
		}

		public User getUserId() {
			return userId;
		}

		public void setUserId(User userId) {
			this.userId = userId;
		}

		public LocalDate getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(LocalDate bookingDate) {
			this.bookingDate = bookingDate;
		}

		public List<Passenger> getPassengerList() {
			return passengerList;
		}

		public void setPassengerList(List<Passenger> passengerList) {
			this.passengerList = passengerList;
		}

		public double getTicketCost() {
			return ticketCost;
		}

		public void setTicketCost(double ticketCost) {
			this.ticketCost = ticketCost;
		}

		public Flight getFlight() {
			return flight;
		}

		public void setFlight(Flight flight) {
			this.flight = flight;
		}

		public Integer getNoOfPassengers() {
			return noOfPassengers;
		}

		public void setNoOfPassengers(Integer noOfPassengers) {
			this.noOfPassengers = noOfPassengers;
		}

		public Booking(long bookingId, User userId,LocalDate bookingDate, List<Passenger> passengerList,
				double ticketCost, Flight flight, Integer noOfPassengers) {
			super();
			this.bookingId = bookingId;
			this.userId = userId;
			this.bookingDate = bookingDate;
			this.passengerList = passengerList;
			this.ticketCost = ticketCost;
			this.flight = flight;
			this.noOfPassengers = noOfPassengers;
		}

		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
			result = prime * result + (int) (bookingId ^ (bookingId >>> 32));
			result = prime * result + ((flight == null) ? 0 : flight.hashCode());
			result = prime * result + ((noOfPassengers == null) ? 0 : noOfPassengers.hashCode());
			result = prime * result + ((passengerList == null) ? 0 : passengerList.hashCode());
			long temp;
			temp = Double.doubleToLongBits(ticketCost);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
			Booking other = (Booking) obj;
			if (bookingDate == null) {
				if (other.bookingDate != null)
					return false;
			} else if (!bookingDate.equals(other.bookingDate))
				return false;
			if (bookingId != other.bookingId)
				return false;
			if (flight == null) {
				if (other.flight != null)
					return false;
			} else if (!flight.equals(other.flight))
				return false;
			if (noOfPassengers == null) {
				if (other.noOfPassengers != null)
					return false;
			} else if (!noOfPassengers.equals(other.noOfPassengers))
				return false;
			if (passengerList == null) {
				if (other.passengerList != null)
					return false;
			} else if (!passengerList.equals(other.passengerList))
				return false;
			if (Double.doubleToLongBits(ticketCost) != Double.doubleToLongBits(other.ticketCost))
				return false;
			if (userId == null) {
				if (other.userId != null)
					return false;
			} else if (!userId.equals(other.userId))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", bookingDate=" + bookingDate
					+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", flight=" + flight
					+ ", noOfPassengers=" + noOfPassengers + "]";
		}
	     
	}
