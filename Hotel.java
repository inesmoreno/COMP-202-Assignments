// Ines Moreno 260731240
import java.util.NoSuchElementException;
import java.util.Arrays;
public class Hotel {
  //attributes
  private String name;
  private Room[] rooms;
  private Reservation[] reservations;
  
  //constructor
  public Hotel(String name, Room[] rooms) { 
   this.name= name;
   Room[] copyRooms = new Room[rooms.length];
        for(int i=0; i< copyRooms.length; i++) {
            copyRooms[i] = rooms[i];
        }
   this.rooms = copyRooms;
  this.reservations = new Reservation[0];
  }
  
  //add reservation methos
  private void addReservation(Reservation r){
    Reservation[] updatedReservations = new Reservation [this.reservations.length+1];
      for(int i=0; i<this.reservations.length; i++){
      updatedReservations[i] = this.reservations [i];
    }
    updatedReservations [this.reservations.length] = r;
    this.reservations = updatedReservations;
    }
  //remove Reservation method
  private void removeReservation (String name, String type){
    int index=0;
    Reservation reservationToRemove = null;
    for (int i=0; i<this.reservations.length; i++){
      if(this.reservations[i].getName().equals(name) && this.reservations[i].getRoom().getType().equals(type)){
        reservationToRemove = reservations[i];
        index = i;
      }
  }
    if (reservationToRemove == null){
      throw new NoSuchElementException();
    }else{
      reservationToRemove.getRoom().changeAvailability();
  Reservation [] reservationsLeft = new Reservation[this.reservations.length-1];
  for(int i=0; i<reservationsLeft.length; i++){
    if(i<index){
      reservationsLeft[i] = this.reservations[i]; 
    }else{
    reservationsLeft[i] = this.reservations[i+1];    
  }
  }
  this.reservations = reservationsLeft;
  }
  }
  
  //createReservation method
  public void createReservation (String name, String type){
    Room availableRoom = rooms[0].findAvailableRoom(this.rooms, type);
    if(availableRoom == null){
      System.out.println("Sorry "+name+", we have no available rooms of the desired type.");
    }else{
      availableRoom.changeAvailability();
      Reservation r = new Reservation (availableRoom, name);
      addReservation(r);
      System.out.println ("You have successfully reserved a "+type+" room under the name of "+name);
    }
      
  }
  // cancel reservation method
  public void cancelReservation (String name, String type){
    try {
      removeReservation(name, type);
      System.out.println(name+",your reservation for a "+type+" has been successfully cancelled");
      
    } catch (NoSuchElementException e){
      System.out.println("There is no reservation for a "+type+" room under the name of "+name);
    }
  }
  
  //printInvoice
  
  public void printInvoice (String name){
    double owes = 0;
    boolean found = false;
    for (int i=0; i<this.reservations.length; i++){
      if(this.reservations[i].getName().equals(name)){
        owes = owes + this.reservations[i].getRoom().getPrize();
        found = true;
      }
  }
    if(!found){
      System.out.println("No reservations have been made at this name");
    }else{
    System.out.println (name +"'s invoice is of $"+owes+".");
    }
  }
  
  //toString
  public String toString(){
    String s1 = "Hotel name: " + this.name;
    String s2 = "Available rooms: ";
    int availableDouble=0;
    int availableQueen =0;
    int availableKing = 0;
    for (int i=0; i<this.rooms.length; i++){
      if(this.rooms[i].getAvailability() == true && this.rooms[i].getType() =="double"){
        availableDouble++;
      }else if (this.rooms[i].getAvailability() == true && this.rooms[i].getType() == "queen"){
        availableQueen++;
      }else if (this.rooms[i].getAvailability() == true && this.rooms[i].getType() == "king"){
        availableKing++;
      }
    }
    String returnString = s1 + "\n"+s2+availableDouble+" double, "+ availableQueen+ " queen, "+ availableKing +" king.";

        return returnString;
  }
  
  
  public static void main(String[] args) { 
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
