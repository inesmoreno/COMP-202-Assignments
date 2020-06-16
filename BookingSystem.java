import java.util.Scanner;
import java.util.Random;

public class BookingSystem {
    
    private static String[] typeOfRooms = {"double","queen","king"};
    private static Random r = new Random(123);
    
    //returns a random String from the above array. 
    private static String getRandomType(){
        int index = r.nextInt(typeOfRooms.length);
        return typeOfRooms[index];
    }
    //returns a random number of rooms between 5 and 50.
    private static int getRandomNumberOfRooms(){
        return r.nextInt(50)+1;
    }
    //End of provided code. 
    
    public static void main(String[] args){
        //Ines Moreno
        //260731240
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome to the COMP 202 Booking System");
        System.out.println("Please enter the name of the hotel you'd like to book");   
       String name = read.nextLine();
       Room[] rooms = new Room[getRandomNumberOfRooms()];
       for(int i=0; i <rooms.length; i++){
         rooms[i] = new Room (getRandomType());
       }
       Hotel h1 = new Hotel (name, rooms);
       int choice = 0;
         while (choice != 5){
       System.out.println("**********************************************************************************************************");
       System.out.println("Welcome to "+name+". Chose one of the following options:");
       System.out.println("1)Make a reservation");
       System.out.println("2)Cancel a reservation");
       System.out.println("3)See an invoice");
       System.out.println("4)See hotel info");
       System.out.println("5)Exit the Booking System");
       System.out.println("**********************************************************************************************************");
       choice = read.nextInt();
       if(choice==1){
         System.out.println ("Please enter your name:");
         String customerName = read.nextLine();
         customerName = read.nextLine();
         System.out.println ("What type of room would you like to reserve?");
         String typeDesired = read.nextLine();
         h1.createReservation(customerName, typeDesired);
       }else if(choice ==2){
         System.out.println ("Please enter the name of the reservation");
         String cancellerName = read.nextLine();
         cancellerName = read.nextLine();
         System.out.println ("Please enter what type of room was reserved");
         String typeCancelled = read.nextLine();
         h1.cancelReservation(cancellerName, typeCancelled);
       }else if (choice == 3){
         System.out.println ("Please enter your name:");
         String customerName = read.nextLine();
         customerName = read.nextLine();
         h1.printInvoice(customerName);         
       }else if(choice==4){
         System.out.println("Here is the hotel info:");
         System.out.println(h1.toString());
       
       }
       }
       System.out.println ("It was a pleasure doing bussiness with you!");
       }
       
                            
    
}
