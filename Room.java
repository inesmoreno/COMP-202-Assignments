// Ines Moreno 260731240
//Q1 a)
public class Room {
  //attributes
  private  String type;
  private  double prize;
  private  boolean availability;
  
  //constructor
  public Room(String type) { 
    if (type != "double" && type != "queen" && type != "king"){
      throw new IllegalArgumentException("No room of such type can be created.");
    }
    this.type=type;
    
    if (type == "double"){
      this.prize=90;
    }else if(type=="queen"){
      this.prize = 110;
    }else{
      this.prize= 150;
    }
    
    this.availability = true;
  }
  
  // get methods
  public String getType(){
    return this.type;
  }
  public double getPrize(){
    return this.prize;
  }
  public boolean getAvailability(){
    return this.availability;
  }
  
  // change availability method
  public void changeAvailability (){
    if(this.availability == true){
      this.availability=false;
    }else{
      this.availability=true;
    }   
  }
  
  // find available room method 
  public Room findAvailableRoom(Room [] rooms, String type){
    Room availableRoom = null;
    for (int i=0; i<rooms.length; i++){
      if(rooms[i].availability && rooms[i].type.equals(type)){
        availableRoom = rooms[i];

        
      }
      if (availableRoom != null){
        break;
      }
        
  }
    return availableRoom;
    
  }
   
   
 
  public static void main(String[] args) { 
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
