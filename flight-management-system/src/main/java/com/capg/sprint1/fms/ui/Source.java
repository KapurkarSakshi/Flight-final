package com.capg.sprint1.fms.ui;

import java.time.LocalDate;
import java.util.*;

import com.capg.sprint1.fms.exception.BookingIdException;
import com.capg.sprint1.fms.exception.InvalidNameException;
import com.capg.sprint1.fms.model.*;
import com.capg.sprint1.fms.service.*;

public class Source {

	public static void main(String[] args) throws BookingIdException ,InvalidNameException{
		BookingServiceImpl bkngSrvObj=new BookingServiceImpl();
		Scanner in=new Scanner(System.in);
		System.out.println("Choose the modification: \n 1.Cancel \n 2.Modify ");
		int choose1=in.nextInt();
		if(choose1==1) {
			System.out.println("Enter the bookingId");
			long bookingId=in.nextLong();
			try {
				bkngSrvObj.deleteBooking(bookingId);
				System.out.println("Deleted");
				}
			 catch(BookingIdException ex) {
				 System.out.println(ex.getMessage());
				 }
		}
			
			else {
			System.out.println("Choose the type of Modification :");
			System.out.println("1.Booking Date \n2.List of Passengers \n");
			int choose2=in.nextInt();
			switch(choose2) {
			case 1: System.out.println("You have chosed the Booking Date option to change the date");
			        System.out.println("Enter the date in yyyy,mm,dd  order");
			        int yyyy=in.nextInt();
			        int mm=in.nextInt();
			        int dd=in.nextInt();
       		        
			        LocalDate date= LocalDate.of(yyyy,mm,dd);
			        try {
			        System.out.println("Enter the below details: \nBookingId:");
					long bookingId=in.nextLong();
			        bkngSrvObj.modifyByDate(bookingId,date);
			        System.out.println("Your Updated booking date is :"+date);
			        }
			        catch(BookingIdException e) {System.out.println(e.getMessage());}
				    break;
				
			case 2: System.out.println("You have choose the Name to add or to delete of Passenger List"+ "\n 1.add"+"\n 2.delete");
			int choose3=in.nextInt();
			switch(choose3) {
			case 1:System.out.println("Enter the passenger details :"+"1.PnrNumber");
			        long pnrNumber=in.nextLong();
			        System.out.println("2.PassengerName");
			        String passengerName=in.next();
			        System.out.println("3.PassengerAge");
			        int passengerAge=in.nextInt();
			        System.out.println("4.PassengerUIN");
			        long passengerUIN=in.nextLong();
			        System.out.println("5.Luggage weight");
			        double Luggage=in.nextDouble();
				    Passenger p =new Passenger(pnrNumber,passengerName,passengerAge,passengerUIN,Luggage);
				    System.out.println("Enter the below details:" +"\nBookingId (to which the passenger details are to be added):");
					long bookingId=in.nextLong();
					try {
				    bkngSrvObj.addByPassenger(bookingId,p);}
					catch(BookingIdException e) {System.out.println(e.getMessage());}
				    System.out.println(" Passenger details Added");
				    break;
				    
			case 2 :System.out.println("Enter the Passenger Name ");
			         String passgName=in.next()+in.nextLine();
			         System.out.println("Enter the below details: \n bookingId:");
		 			 bookingId=in.nextLong();
			         try {
			             bkngSrvObj.deleteByPassenger(bookingId,passgName);
			             System.out.println("Deleted successfully");
			             }
			         catch(InvalidNameException ex) {System.out.println(ex.getMessage());}
			         catch(BookingIdException ex) {System.out.println(ex.getMessage()); }
			        break;
			default:System.out.println("Invalid input");
			        break;
			      }
			}
		}
	in.close();}

}
