package com.capg.sprint1.fms.service;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.sprint1.fms.dao.BookingDaoImpl;
import com.capg.sprint1.fms.exception.BookingIdException;
import com.capg.sprint1.fms.exception.InvalidNameException;
import com.capg.sprint1.fms.model.Booking;
import com.capg.sprint1.fms.model.Passenger;

public class BookingServiceImpl implements BookingService {
	BookingDaoImpl bookingDao=new BookingDaoImpl();
	Booking booking=new Booking();

	public Booking modifyBooking(Booking booking) {
		return bookingDao.modifyBooking(booking);
	}

	
	public boolean deleteBooking(long bookingId) throws BookingIdException {
		long bkngId=booking.getBookingId();
		boolean flag=validateBookingId(bkngId);
		if(!flag) {
			throw new BookingIdException("Booking id should contains only four digits");
			}
		if(!BookingDaoImpl.bookingNo.containsKey(bookingId)) {
			throw new BookingIdException("Error :BookingId not found");
		}
		
		return bookingDao.deleteBooking(bookingId);
	}

	public LocalDate modifyByDate(long bookingId, LocalDate date) throws BookingIdException {
		if(!BookingDaoImpl.bookingNo.containsKey(bookingId)) {
			throw new BookingIdException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		return bookingDao.modifyByDate(bookingId, date);
	}

	public Passenger deleteByPassenger(long bookingId, String passengerName) throws BookingIdException,InvalidNameException{
		if(!BookingDaoImpl.bookingNo.containsKey(bookingId)) {
			throw new BookingIdException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		else {
			if(BookingDaoImpl.bookingNo.get(bookingId).getPassengerList().stream().filter(p->p.getPassengerName().equalsIgnoreCase(passengerName)).count()==0) {
				throw new InvalidNameException("Error: Name not found, Please enter valid name");
			}
		}
			return   bookingDao.deleteByPassenger(bookingId,passengerName);
		
	}

	public  Passenger addByPassenger(long bookingId, Passenger p) throws BookingIdException {
		if(!BookingDaoImpl.bookingNo.containsKey(bookingId)) {
			throw new BookingIdException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		return bookingDao.addByPassenger(bookingId, p);
	}

	public static boolean checkMatches(String regex, CharSequence input) {
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(input);
		return m.find() && m.group().equals(input);
		}

	@Override
	public boolean validateBookingId(long BookingId) throws BookingIdException {
		String str=String.valueOf(BookingId);
		 boolean flag=false;
		 flag=checkMatches("[0-9]{4}",str);
		return flag;
	}


}
