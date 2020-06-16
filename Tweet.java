//Ines Moreno
//260731240
import java.util.HashSet;
import java.io.*;

public class Tweet {
  
  //attributes
  private  String userAccount;
  private  String date;
  private  String time;
  private String message;
  public static HashSet<String> stopWords;
  
  //constructor
  public Tweet(String userAccount, String date, String time, String message) { 
    this.userAccount = userAccount;
    this.date = date;
    this.time = time;
    this.message = message;
  }
  
  //get methods
  public String getDate(){
    return this.date;
  }
  public String getTime(){
    return this.time;
  }
  public String getMessage(){
    return this.message;
  }
  public String getUserAccount(){
    return this.userAccount;
  }
  
  // toString method
  public String toString(){
    String returnString = this.userAccount +"\t"+ this.date+"\t"+ this.time+"\t"+ this.message;
    
    return returnString;
  }
  
  
  // checkMessage method
  public boolean checkMessage(){
    if (stopWords == null){
      throw new NullPointerException("Error checking the stopWords database: The file of stopWords has not been loaded yet");
    }
    String [] words = getMessage().split(" ");
    int counter = 0;
    for(int i=0; i<words.length;i++){
      words[i]=words[i].replace(".","");
      words[i]=words[i].replace(",","");
      words[i]=words[i].replace(";","");
      words[i]=words[i].replace(":","");
      for(char c = 97;c<=122;c++){
        char cUpper = Character.toUpperCase(c);
        words[i]=words[i].replace(cUpper,c);  
      }
      
      if( !stopWords.contains(words[i])){
        counter++;
      }
    }
    if (0<counter && counter <16){
      return true;
    }else{
      return false;
    }
  }
  
  // method isBefore
  public boolean isBefore (Tweet t1, String date, String time){
    String [] timet1 = t1.time.split(":");
    String [] timetocompare = time.split(":");
    String [] datet1 = t1.date.split("-");
    String [] datetocompare = date.split("-");
    boolean isBefore = false; 
    if(Integer.parseInt(datet1[0])<Integer.parseInt(datetocompare[0])){
      isBefore = true; 
    }else if (Integer.parseInt(datet1[0])==Integer.parseInt(datetocompare[0])){
      if(Integer.parseInt(datet1[1])<Integer.parseInt(datetocompare[1])){
        isBefore = true;
      }else if (Integer.parseInt(datet1[1])==Integer.parseInt(datetocompare[1])){
        if (Integer.parseInt(datet1[2])<Integer.parseInt(datetocompare[2])){
          isBefore = true;
        } else if (Integer.parseInt(datet1[2])==Integer.parseInt(datetocompare[2])){
          if (Integer.parseInt(timet1[0])<Integer.parseInt(timetocompare[0])){
            isBefore = true;
          }else if (Integer.parseInt(timet1[0])==Integer.parseInt(timetocompare[0])){
            if (Integer.parseInt(timet1[1])<Integer.parseInt(timetocompare[1])){
              isBefore =true;
            }else if (Integer.parseInt(timet1[1])==Integer.parseInt(timetocompare[1])){
              if (Integer.parseInt(timet1[2])<Integer.parseInt(timetocompare[2])){
                isBefore = true;
              }
            }
          }
        }
      }
    }
    return isBefore;
  }
  
  // method loadStopWords
  public static void loadStopWords(String fileName) {
    stopWords = new HashSet<String>();
    try{
      FileReader fr = new FileReader(fileName);
      
      BufferedReader br = new BufferedReader(fr);
      String currentLine = br.readLine();
      while(currentLine != null){
        stopWords.add(currentLine);
        currentLine = br.readLine();
      }
      br.close();
      fr.close(); 
      
    }catch (IOException e){
      System.out.println("Something went wrong");
    }
  }
  
  
  public static void main(String[] args) { 
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
