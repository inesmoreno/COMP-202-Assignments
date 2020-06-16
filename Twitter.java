//Ines Moreno
//260731240

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.HashMap;
import java.util.Arrays;

public class Twitter {
  
  //attribute
  private ArrayList<Tweet> tweets;
  
  //constructor
  public Twitter() { 
    this.tweets = new ArrayList<Tweet> ();
  }
  
  // loadDB 
  public void loadDB (String fileName){
    try {
      FileReader fr = new FileReader(fileName);
      
      BufferedReader br = new BufferedReader(fr);
      String currentLine = br.readLine();
      while(currentLine != null){
        String [] tweetContent = currentLine.split("\t");
        Tweet t1 = new Tweet(tweetContent[0], tweetContent[1], tweetContent[2], tweetContent[3]);
        if (t1.checkMessage()){
          tweets.add(t1);
        }
        currentLine = br.readLine();
      }
      br.close();
      fr.close();
      
    }catch (IOException e){
    }
    sortTwitter();
  }
  
  // sort
  public void sortTwitter(){
    int firstElement =0;
    while(firstElement < tweets.size()-1){
      int indexMin = firstElement;
      for (int i =firstElement +1; i< tweets.size(); i++){
        if (tweets.get(0).isBefore(getTweet(i),getTweet(indexMin).getDate(),getTweet(indexMin).getTime())){
          indexMin = i;
        }
      }
      Tweet temp = getTweet(indexMin);
      tweets.set(indexMin, getTweet(firstElement));
      tweets.set(firstElement, temp);
      firstElement ++;
    }
  }
  
  
  // get methods
  public int getSizeTwitter(){
    return tweets.size();
  }
  
  public Tweet getTweet (int i){
    return tweets.get(i);
  }
  
  // print 
  public String printDB(){
    String returnString = "";
    for(int i=0; i< getSizeTwitter(); i++){
      returnString =returnString + tweets.get(i).toString()+"\n";
    }
    return returnString;
  }
  
  // range Tweets
  public ArrayList<Tweet> rangeTweets (Tweet t1, Tweet t2){
    ArrayList<Tweet> rangeTweets = new ArrayList<Tweet>();
    int indext1= tweets.indexOf(t1);
    int indext2= tweets.indexOf(t2);
    if(indext1<=indext2){
      rangeTweets = new ArrayList<Tweet>(tweets.subList(indext1, indext2+1));
      
    } else{
      rangeTweets = new ArrayList<Tweet>(tweets.subList(indext2, indext1+1));
    }
    return rangeTweets;
  }
  // saveDB
  public void saveDB (String fileName){
    try{
      FileWriter fw = new FileWriter (fileName);
      BufferedWriter bw = new BufferedWriter (fw);
      for(int i=0; i< getSizeTwitter(); i++){
        bw.write(tweets.get(i).toString());
        bw.newLine();
      }
      bw.close();
      bw.close();
    }catch (IOException e){
    }
  }
  
  // trending topic
  
  
  public String trendingTopic(){
    HashMap <String, Integer> m = new HashMap<String, Integer>();
    for(int i=0; i< tweets.size(); i++){
      String [] wordsInMessage = tweets.get(i).getMessage().split(" ");
      for(int j=0; j<wordsInMessage.length; j++){
        wordsInMessage[j]=wordsInMessage[j].replace(".","");
        wordsInMessage[j]=wordsInMessage[j].replace(",","");
        wordsInMessage[j]=wordsInMessage[j].replace(";","");
        wordsInMessage[j]=wordsInMessage[j].replace(":","");
        for(char c = 97;c<=122;c++){
          char cUpper = Character.toUpperCase(c);
          wordsInMessage[j]=wordsInMessage[j].replace(cUpper,c);  
        }
        String word = wordsInMessage[j];
        if(Tweet.stopWords.contains(word)){
        }else if(m.containsKey(word)){
          int value = m.get(word);
          m.put(word,value+1);    
        }else{
          m.put(word,1);
        }
        
      }
    }
    
    HashMap.Entry<String,Integer> maxEntry =null;
    for( HashMap.Entry<String, Integer> entry :m.entrySet()){
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
        maxEntry = entry;
      }
    }
    Integer maxValue= maxEntry.getValue();
    String trendingWord = null;
    for(HashMap.Entry<String, Integer> entry: m.entrySet()){
      if(maxValue.equals(entry.getValue())){
        trendingWord = entry.getKey();
        break;
      }
    }
    return trendingWord;  
  }
  
  //main 
  public static void main(String[] args) { 
    Twitter example = new Twitter();
    Tweet.loadStopWords("stopWords.txt");
    example.loadDB("tweets.txt");
    System.out.println("The number of tweets is: " + example.getSizeTwitter());
    System.out.println(example.rangeTweets(example.getTweet(4),example.getTweet(2)));
    
  }
}

/* ADD YOUR CODE HERE */


