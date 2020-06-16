//Ines Moreno 260731240
public class Reservation {
  //atributes
  private String name;
  private Room roomReserved;
  
  //constructor
  public Reservation(Room roomReserved, String name) { 
    this.name= name;
    this.roomReserved = roomReserved;
  }
  //get methods
  public String getName(){
    return this.name;
  }
  public Room getRoom(){
    return this.roomReserved;
  }
 
   
  public static void main(String[] args) { 
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
