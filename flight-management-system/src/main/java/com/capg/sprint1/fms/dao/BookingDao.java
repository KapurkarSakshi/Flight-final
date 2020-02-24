package com.capg.sprint1.fms.dao;
import java.time.LocalDate;

import com.capg.sprint1.fms.exception.BookingIdException;
import com.capg.sprint1.fms.exception.InvalidNameException;
import com.capg.sprint1.fms.model.*;

public interface BookingDao {
	
	 public boolean deleteBookingByBookingId(long bookingId) throws BookingIdException, BookingIdException;
	 public  LocalDate modifyBookingByDate(long bookingId,LocalDate date) throws BookingIdException;
	 public  Passenger addPassenger(long bookingId,Passenger p) throws BookingIdException;
	 public  Passenger deletePassenger(long bookingId,String passengerName) throws BookingIdException,InvalidNameException;

}
