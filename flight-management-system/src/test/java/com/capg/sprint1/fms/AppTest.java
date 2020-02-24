package com.capg.sprint1.fms;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.*;
import com.capg.sprint1.fms.dao.BookingDaoImpl;
import com.capg.sprint1.fms.exception.BookingIdException;
import com.capg.sprint1.fms.model.*;
import com.capg.sprint1.fms.service.*;

public class AppTest 
{
  static BookingService service=new BookingServiceImpl();
  static BookingDaoImpl dao=new BookingDaoImpl();
  
   
    Map<Long,Booking> bookingNo= BookingDaoImpl.bookingNo;
	
   @BeforeEach
       public void setup() {
	 dao=new BookingDaoImpl();
	 	}
    
    @Test
    public void test() throws BookingIdException  {
    	Flight f1=new Flight(880,"Model1","Carrier1",100);
    	  User u1=new User("Type1",1239,"Sak","passwrd",964090742,"sakshikapurkar@gmail.com");
    	  LocalDate dt1= LocalDate.of(2001,1,1);
    	  List<Passenger> l1=new ArrayList<Passenger>();
 	 	Passenger p1=new Passenger(1,"chinnu",20,20201205,10.55);
  	         l1.add(p1);
    	Booking b1= new Booking(1234,u1,dt1,l1,2000,f1,20);
    	bookingNo.put(b1.getBookingId(),b1);
    	long BookingId=b1.getBookingId();
    	dao.addByPassenger(BookingId, p1);
      assertEquals(1234,dao.addByPassenger(BookingId, p1));
    	
    }
    
    
    
   
}
