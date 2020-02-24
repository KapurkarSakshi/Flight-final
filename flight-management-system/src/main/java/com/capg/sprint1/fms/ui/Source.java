package com.capg.sprint1.fms.ui;
import java.time.LocalDate;
import java.util.*;

import com.capg.sprint1.fms.exception.BookingIdException;
import com.capg.sprint1.fms.exception.InvalidNameException;
import com.capg.sprint1.fms.model.*;
import com.capg.sprint1.fms.service.*;

public class Source {

	public static void main(String[] args) {
		char x = 'y';
		BookingServiceImpl bkngSrvObj = new BookingServiceImpl();
		Scanner in = new Scanner(System.in);
		long bookingId = 0;
		int choose1 = 0;
		int choose2 = 0;
		int choose3 = 0;
		String passgName;
		do {
			System.out.println("Choose the modification: \n 1.Cancel \n 2.Modify ");
			try {
				choose1 = in.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Please enter valid type : integer");
				 
			}

			if (choose1 == 1) {
				System.out.println("Enter the bookingId");
				try {
					bookingId = in.nextLong();
				} catch (InputMismatchException ex) {
					System.out.println("Please enter valid type : integer ");
					 
				}
				try {
					bkngSrvObj.deleteBookingByBookingId(bookingId);
					System.out.println("Deleted");
				} catch (BookingIdException ex) {
					System.out.println(ex.getMessage());
				} catch (InputMismatchException ex) {
					System.out.println("Please enter valid type : integer ");
					 
				}

			}

			else if (choose1 == 2) {
				System.out.println("Choose the type of Modification :");
				System.out.println("1.Booking Date \n2.List of Passengers \n");
				try {
				choose2 = in.nextInt();}
				catch (InputMismatchException ex) {
					System.out.println("Please enter valid type : integer ");
				}
				switch (choose2) {
				case 1:
					System.out.println("You have chosed the Booking Date option to change the date");
					System.out.println("Enter the date in yyyy,mm,dd  order");
					int yyyy = in.nextInt();
					int mm = in.nextInt();
					int dd = in.nextInt();
					LocalDate date = LocalDate.of(yyyy, mm, dd);
					try {
						System.out.println("Enter the below details: \nBookingId:");
						try {
						bookingId = in.nextLong();}
						catch (InputMismatchException ex) {
							System.out.println("Please enter valid type : integer ");}
						bkngSrvObj.modifyBookingByDate(bookingId, date);
						System.out.println("Your Updated booking date is :" + date);
					} catch (BookingIdException e) {
						System.out.println(e.getMessage());
					}

					break;

				case 2:
					System.out.println("You have choose the Name to add or to delete of Passenger List" + "\n 1.add"
							+ "\n 2.delete");
					choose3 = in.nextInt();
					switch (choose3) {
					case 1:
						System.out.println("Enter the passenger details :" + "1.PnrNumber");
						long pnrNumber = in.nextLong();
						System.out.println("2.PassengerName");
						String passengerName = in.next();
						System.out.println("3.PassengerAge");
						int passengerAge = in.nextInt();
						System.out.println("4.PassengerUIN");
						long passengerUIN = in.nextLong();
						System.out.println("5.Luggage weight");
						double Luggage = in.nextDouble();
						Passenger p = new Passenger(pnrNumber, passengerName, passengerAge, passengerUIN, Luggage);
						System.out.println("Enter the below details:"
								+ "\nBookingId (to which the passenger details are to be added):");

						try {
							bookingId = in.nextLong();
						} catch (InputMismatchException ex) {
							System.out.println("Please enter valid type : integer ");
						}
						try {
							bkngSrvObj.addPassenger(bookingId, p);
						} catch (BookingIdException e) {
							System.out.println(e.getMessage());
						}
						System.out.println(" Passenger details Added");
						break;

					case 2:
						System.out.println("Enter the Passenger Name ");
						passgName = in.next() + in.nextLine();
						System.out.println("Enter the below details: \n bookingId:");
						try {
							bookingId = in.nextLong();
						} catch (InputMismatchException ex) {
							System.out.println("Please enter valid type : integer ");
						}
						try {
							bkngSrvObj.deletePassenger(bookingId, passgName);
							System.out.println("Deleted successfully");
						} catch (InvalidNameException ex) {
							System.out.println(ex.getMessage());
						} catch (BookingIdException ex) {
							System.out.println(ex.getMessage());
						}
						break;
					default:
						System.out.println("Invalid input");
						break;
					}
				}
			} else {
				System.out.println("Invalid input");
			}

			System.out.println("Are you want to continue : (y/n)");
			in.next();
			x = in.next().charAt(0);
		} while (x != 'n');

	}
}
