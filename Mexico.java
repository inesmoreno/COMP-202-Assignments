//Ines Moreno 260731240

public class Mexico {
  
  public static void main (String[] args){ 
    double buy= Double.valueOf(args[0]);
    double bet= Double.valueOf(args[1]);
    playMexico (buy,bet);
    
  }
  // 1a: a method to simulate the dice roll
  public static int diceRoll(){
    int roll = (int) (Math.random()*6)+1;
    System.out.print (roll + " ");
    return roll;
  }
  
  // 1b: a method to compute the score of a player
  public static int getScore (int dice1, int dice2){
    String sdice1 = "" +dice1;
    String sdice2 = "" +dice2;
    if (dice1<=dice2){
      String sscore = sdice2+sdice1;
      int score= Integer.parseInt(sscore);
      System.out.println (score);
      return score;
    }else{
      String sscore = sdice1+sdice2;
      int score= Integer.parseInt (sscore);
      System.out.println (score);
      return score;
    }
    
  }
  // 1d: a method to simulate one round of Mexico
  public static int playOneRound (String player){
    System.out.print( player + " rolled: ");
    int dice1=diceRoll();
    int dice2=diceRoll();
    System.out.println ("");
    System.out.print(player + "'s score is ");
    int score = getScore(dice1, dice2);
    return score;
    
    
  }
  // 1d: a method to determine the winner of one round
  public static String getWinner (int scoreG, int scoreD){
    String winner = "Player";
    
    //tie if they score the same
    if (scoreG == scoreD){
      winner= "None";
      System.out.println ("It'a a tie. Roll again!");
      
      //21 roll:Mexico, automatically wins
    }else if (scoreG==21) {
      winner = "Giulia";
      System.out.println ("Giulia wins this round");
      
    } else if (scoreD==21){
      winner = "David";
      System.out.println ("David wins this round");
      
      
      //doubles win over mixed rolls, if both doubles they're ranked numerically 66>55>...11 
    }else if(scoreG==66||scoreG==55||scoreG==44||scoreG==33||scoreG==22||scoreG==11){
      winner = "Giulia";
      System.out.println ("Giulia wins this round");
      
      
    }else if(scoreD==66||scoreD==55||scoreD==44||scoreD==33||scoreD==22||scoreD==11){
      winner = "David";
      System.out.println ("David wins this round");
      
      
      //mixed rolls ranked based on numerical value
    }else if(scoreG>scoreD){
      winner = "Giulia";
      System.out.println("Giulia wins this round");
      
      
    }else{
      winner = "David";
      System.out.println ("David wins this round");
      
      
    }
    return winner;
    
  }
  //  1e:  method to check if the buy in and the base bet are set correctly 
  public static boolean canPlay (double buy, double bet){
    boolean gameallowed = (bet<=buy && buy%bet==0);
    return gameallowed;
  }
  // 1f: a method to simulate a game of Mexico
  public static void playMexico (double buy, double bet){
    if (canPlay(buy, bet) == false){
      System.out.println ("The fund is insufficient for the players to play.");
      
    }else{
      double fundG= buy;
      double fundD= buy;
      int roundnumber=1;
      while(fundG!=0 && fundD!=0){
        System.out.println ("\n"+"Round " + roundnumber + "\n");
        int scoreG = playOneRound("Giulia");
        int scoreD = playOneRound("David");
        String winner = getWinner(scoreG,scoreD);
        if (winner == "None"){
          
        }else if(winner =="Giulia"){
          fundD = fundD-bet;
        }else{
          fundG = fundG-bet;
        }
        roundnumber++;
      }
      if (fundG==0){
        System.out.println ("\n"+"David won the game!");
      }else{
        System.out.println("\n" + "Giulia won the game!");
      }
      
      
    }
  }}

  
