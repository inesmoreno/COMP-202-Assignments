// Ines Moreno 260731240
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
  public static void main (String[]args){
    //char [][] board ={{'x','x','o'},{'o',' ','x'},{'x','o','o'}};
    //checkForObviousMove(board);
    //checkForWinner(board);
    //getAIMove(board);
    play();
    //checkForWinner (board);
    
    
    
  }
  //A method that creates an nxn board
  public static char[][] createBoard (int n){
    char [][] board = new char[n][n];
    // populate array
    for(int i=0; i< board.length; i++) {
      for(int j=0; j<board[i].length;j++) {
        board[i][j]=' ';
        //System.out.print(board[i][j]);
      }
      // System.out.println ();
      
    }
    return board;
  }
  // B. method that displays board
  public static void displayBoard (char[][]board){
    int countrow = 0;
    for(int i=0;i<=(2*board.length); i++){
      int countcol = 0;
      countrow++;
      int j=0;
      int k=0;
      while(j<=(2*board.length)) {
        if(j%2==0) {
          System.out.print('+');
          j++;
        } else  {
          System.out.print('-');
          j++;
        }
      }
      System.out.println();
      i++;
      if(i>2*board.length){
        break;
      }        
      while(k<=(2*board.length)){
        if(k%2==0){
          System.out.print('|');
          k++;
          countcol++;
        }else{
          System.out.print(board[i-countrow][k-countcol]);
          k++;
        }   
      }
      System.out.println(); 
    }
    
  }
// C. method writeOnBoard
  public static void writeOnBoard(char[][]board, char c, int x, int y){
    if (x>=board.length){
      throw new IllegalArgumentException("Wrong row number,there are only "+ board.length+" rows on your board.");
    }
    if(y>=board.length){
      throw new IllegalArgumentException("Wrong column number, there are only "+board.length+" columns on your board.");
    }
    if (board[x][y]!=' '){
      throw new IllegalArgumentException("There is already something on that cell, pick another one");
    }       
    
    board[x][y] = c;
   
    
    
  }
  //D. Method getUserMove
  public static void getUserMove(char[][]board){
    
    Scanner read = new Scanner(System.in);
    System.out.println("Where do you want to move?");
    int x = read.nextInt();
    int y = read.nextInt();
    while (x >=board.length || y >=board.length || board[x][y]!=' '){
      if (x >=board.length){
        System.out.println("Wrong row number,there are only "+ board.length+" rows on your board, pick another move");
      }
      if(y >=board.length){
        System.out.println("Wrong column number, there are only "+board.length+" columns on your board, pick another move");
        
      }else{ 
        System.out.print("There is already something written in that cell, pick another one");
      }
      x = read.nextInt();
      y = read.nextInt();
    }
    
    writeOnBoard(board, 'x', x, y);
    displayBoard(board); 
  }
  //E. check for obvious move
  public static boolean checkForObviousMove(char[][]board){
    boolean obvious= false;
    if (checkObvious(board,'o','x')== true){
      obvious = checkObvious(board,'o','x');
      checkObvious(board,'o','x');
                         }else if(checkObvious (board, 'x','o')== true){
                           obvious = checkObvious (board, 'x','o');
                           checkObvious (board, 'x','o');
                         }
                         return obvious;   
                         }
  
  //F. getAI move method
  public static void getAIMove(char[][]board){
    if (checkForObviousMove(board) == true){
      checkForObviousMove(board);
    }else{
      Random gen = new Random();
      int x = gen.nextInt(board.length);
      int y = gen.nextInt(board.length);
      while (board[x][y]!=' '){
        x = gen.nextInt(board.length);
        y = gen.nextInt(board.length);
      }
      writeOnBoard(board,'o', x,y);
      displayBoard(board);
    }
 
  }
  //G. check for winner
  public static char checkForWinner (char[][]board){
    char winner=' ';
    for (int i=0; i<board.length; i++){
      int countO = 1;
      for( int j=0; j<board[i].length;j++){
        char a= board[i][j];
        if(j+1>=board.length){
          break;
        }
        if(board[i][j+1]==a){
          countO++;
        }
        if (countO==board[i].length){
        winner= a;
      }
      }
    }
    if(winner == ' '){
      for (int j=0; j<board.length; j++){
        int countO = 1;
        for( int i=0; i<board[j].length;i++){
          char a= board[i][j];
          if(i+1>=board.length){
          break;
        }
          if(board[i+1][j]==a){
            countO++;
          }
           if (countO==board[j].length){
         winner = a;
        }
        }
      }
    }
    
    
    if(winner == ' '){
      int countO=1;
      for(int i=0,j=0; i<board.length;i++,j++){
        if(j+1>=board.length){
          break;
        }
        char a= board[i][j];
        if(board[i+1][j+1]==a){
          countO++;
        }
        if (countO==board.length){
        winner =a;
      }
      }
    }
    if(winner == ' '){
      int countO =1;
      for(int i=0,j=board.length-1; i<board.length && j>=0;i++,j--){
        if(i+1>=board.length || j-1<0){
          break;
        }
        char a= board[i][j];
        if(board[i+1][j-1]==a){
          countO++;
        }
        if (countO==board.length){
        winner =a;
      }
      }
    }  
    return winner;
  }
  // H.play game
  public static void play(){
    Scanner read = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = read.nextLine();
    System.out.println("Welcome, "+name+"! Are you ready to play?");
    System.out.println("Please enter the dimensions of your board:");
    int dimension = read.nextInt();
    char[][] board = createBoard(dimension);
    Random gen = new Random();
    int toss = gen.nextInt(2);
    System.out.println ("The result of the toss is:"+toss);
    char winner = checkForWinner(board);
    if(toss==0){
      System.out.println("You have the first move");
      while (winner == ' '){
        if (winner != ' '){
          break;
        }
        getUserMove(board);
        winner = checkForWinner(board);
        if (winner != ' '){
          break;
        }
        System.out.println("The AI made its move:");
        getAIMove(board);
        winner = checkForWinner (board);
      }
      
    }else{
      System.out.println("The AI has the first move");
      while (winner == ' '){
        if (winner != ' '){
          break;
        }
        System.out.println("The AI made its move:");
        getAIMove(board);
        winner = checkForWinner(board);
        if (checkForWinner(board) != ' '){
          break;
        }
        getUserMove(board);
        winner = checkForWinner(board);
      }
    }
    System.out.println ("GAME OVER!");
    if (winner == 'x'){
      System.out.println("You won!");
    }else if (winner == 'o'){
      System.out.println("You lost!");
    }else{
      System.out.println("There is no winner");
    }
  }
  // helper method to check obvious move
  public static boolean checkObvious (char[][] board, char a, char b){
   boolean obvious = false;
  for (int i=0; i<board.length; i++){
      int countO = 0;
      int space=0;
      int numSpaces=0;
      for( int j=0; j<board[i].length;j++){
        if(board[i][j]==a){
          countO++;
        }else if(board[i][j]!=b){
          numSpaces++;
          space=j;
        }
      }
      
      if (countO==board[i].length-1 && numSpaces==1){
        obvious = true;
        writeOnBoard(board,'o',i,space);
        break;
      }
    }
    if(obvious != true){
      for (int j=0; j<board.length; j++){
        int countO = 0;
        int space=0;
        int numSpaces = 0;
        for( int i=0; i<board[j].length;i++){
          if(board[i][j]==a){
            countO++;
          }else if(board[i][j]!=b){
            space=i;
            numSpaces++;
          }
        }
        
        if (countO==board[j].length-1 && numSpaces==1){
          obvious = true;
          writeOnBoard(board,'o',space,j);
          break;
        }
      }
    }
    
    
    if(obvious != true){
      int countO = 0;
      int space=0;
      int numSpaces =0;
      for(int i=0,j=0; i<board.length;i++,j++){
        if(board[i][j]==a){
          countO++;
        }else if(board[i][j]!=b){
          space=i;
          numSpaces++;
           
        }
      }
      
      if (countO==board.length-1 && numSpaces==1){
        obvious = true;
        writeOnBoard(board,'o',space,space);
      }
    }
    if(obvious != true){
      int countO =0;
      int spaceX=0;
      int spaceY=0;
      int numSpaces =0;
      for(int i=0,j=board.length-1; i<board.length && j>=0;i++,j--){
        if(board[i][j]==a){
          countO++;
        }else if(board[i][j]!=b){
          spaceX=i;
          spaceY=j;
          numSpaces++;
        }
      }
      if (countO==board.length-1 && numSpaces==1){
        obvious = true;
        writeOnBoard(board,'o',spaceX,spaceY);
      }
    }
    return obvious;
  }
  
  
}