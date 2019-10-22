package apllication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException{

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number");
		int number = sc.nextInt();
		
		System.out.println("Check-in date (dd/MM/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.println("Check-Out date (dd/MM/yyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date ");
		}
		else {
			Reservation reservation = new Reservation(number, checkOut, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Check-in date (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.println("Check-Out date (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			String error = reservation.upDate(checkIn, checkOut);
			if (error != null) {
			System.out.println("Error in reservation: " + error);
			
			System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();

	}

}
