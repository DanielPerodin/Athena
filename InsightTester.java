
/**
 * This program takes data from a user's Chess.com account and gives them insights based on that data. 
 * This program also allows users to easily transcribe their chess games, and will save the game to a .txt file. 
 * Additionally, data from the game (the opening used, who won/lost, who played as black/white, etc.) will be 
 * stored to another .txt file which contains that player's "profile" based on all other games they have transcribed 
 * using this program if they have used it before.
 *
 * Daniel Perodin
 * 2/4/2023
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class InsightTester
{
     public static void main(String[] args) throws IOException
    {
        int numGames = 0;
        int wins = 0;
        int draws = 0;
        String readLatestElo = "1";
        
        //initialize array for game length
        String [] gameLength = new String [22];
        
        gameLength[0] = "1 min";
        gameLength[1] = "1|1";
        gameLength[2] = "2|1";
        gameLength[3] = "30 sec";
        //Verify that this is how the string for 20 sec|1 would appear in a .txt file
        gameLength[4] = "20 sec|1";
        gameLength[5] = "3 min";
        gameLength[6] = "3|2";
        gameLength[7] = "5 min";
        gameLength[8] = "5|5";
        gameLength[9] = "5|2";
        gameLength[10] = "10 min";
        gameLength[11] = "15|10";
        gameLength[12] = "30 min";
        gameLength[13] = "10|5";
        gameLength[14] = "20 min";
        gameLength[15] = "60 min";
        gameLength[16] = "1 day";
        gameLength[17] = "3 days";
        gameLength[18] = "7 days";
        gameLength[19] = "2 days";
        gameLength[20] = "5 days";
        gameLength[21] = "14 days";
        
        //lengths of arrays, use in for loops later
       int gameDurationLength = gameLength.length;
        
        
        //inittialize variables for game length (use to print in display and for counters when reading file)
        String bulletOneMin = "1 min";
        String bulletOneVOne = "1|1";
        String bulletTwoVOne = "2|1";
        String bulletThirtySec = "30 sec";
       //Verify that this is how the string for 20 sec|1 would appear in a .txt file
        String bulletTwentyVOne = "20 sec|1";
        
        String blitzThreeMin = "3 min";
        String blitzThreeVTwo = "3|2";
        String blitzFiveMin = "5 min";
        String blitzFiveVFive = "5|5";
        String blitzFiveVTwo = "5|2";
        
        String rapidTenMin = "10 min";
        String rapidFifteenVTen = "15|10";
        String rapidThirtyMin = "30 min";
        String rapidTenVFive = "10|5";
        String rapidTwentyMin = "20 min";
        String rapidSixtyMin = "60 min";
        
        String dailyOneDay = "1 day";
        String dailyThreeDays = "3 days";
        String dailySevenDays = "7 days";
        String dailyTwoDays = "2 days";
        String dailyFiveDays = "5 days";
        String dailyFourteen  = "14 days";
        
        
         Scanner in = new Scanner(System.in);
         Scanner input = new Scanner(System.in);
         Scanner input2 = new Scanner(System.in);
         Scanner input3 = new Scanner(System.in);
        
        System.out.println("Which service would you like to use?: ");
        System.out.println("[A] Chess.com analysis");
        System.out.println("[B] Over the board recording");
        System.out.println("[C] Game Database");
        String service = in.next();
        
        if (service.equalsIgnoreCase("A"))
        {
        
        System.out.println("What is the name of the .txt file you have uploaded? (please make sure to include the .txt in the name): ");
        String dotText = input3.nextLine();
        
        
        File fileName = new File(dotText);
        Scanner inFile = new Scanner(fileName);
        
       
        
        System.out.println("Please type your Chess.com username: ");
        String username = input.next();
        
       
        
        while( inFile.hasNextLine() )
        {
            String line = inFile.nextLine();
            
            if (line.equals(username))
        {
            

            
          String ThirdToken = inFile.nextLine( );
          readLatestElo = ThirdToken.substring(1, ThirdToken.indexOf(")"));
          System.out.println("latest Elo: " + readLatestElo);
          break;
        }
        
    }
    
    
    int latestElo  = Integer.parseInt(readLatestElo);
    
    File fileName2 = new File(dotText);
        Scanner inFile2 = new Scanner(fileName2);
    
        while( inFile2.hasNext() )
        {
        
        String token = inFile2.nextLine( );      //read next token (Line) from file
    
        
        //find numGames
        
        if (Arrays.asList(gameLength).indexOf(token) >= 0)
        {
          String SecondaryToken = inFile2.nextLine( );
        if (SecondaryToken.equals(username))
          {
            String TertiaryToken = inFile2.nextLine( );
            String FourthToken = inFile2.nextLine( );
            String FifthToken = inFile2.nextLine( );
            String SixthToken = inFile2.nextLine( );
              if(SixthToken.equals("1"))
              {
                  wins++;
              }
              else if (SixthToken.equals("½"))
              {
                draws++;
                }
            
            }
//this assumes that the user has typed in the username with 0 mistakes
        else if (1 > 0)
        {
        String tokenThree = inFile2.nextLine( );
        String tokenFour = inFile2.nextLine( );
        String tokenFive = inFile2.nextLine( );
        String tokenSix = inFile2.nextLine( );
        String tokenSeven = inFile2.nextLine( );
        if (tokenSeven.equals("1"))
        {
        wins++;
        }
        else if (tokenSeven.equals("½"))
              {
                draws++;
                }
    }
          numGames++;
    }
    
    
}
        

    
//prompt user for desired elo, store value in an int, have message ready if they put it incorrectly
System.out.println();    
System.out.println("Please write your desired elo: ");
String desiredEloString = input2.nextLine();
int desiredElo = Integer.parseInt(desiredEloString);
//ask user if there any players which they would like to exclude from the data because they play unrated games with that player


//round this value up!!!!! Account for when win % is less than 50%!!! Cast (wins/numGames) to a double!!

double  winPercentage = wins / (numGames * 1.0) ;
      int eloDifference = desiredElo - latestElo;
      
      if (winPercentage > 0.5)
      {
      //This forumula treats draws like losses, FIX!
      double GamesNeededToReachEloDouble = eloDifference / ((16.0 * winPercentage) - 8.0);
      int GamesNeededToReachElo = (int)(GamesNeededToReachEloDouble) + 1;
      System.out.println("Number of games needed to reach desired elo: " + GamesNeededToReachElo);
      }
    
    else 
    { //this isn't true if the user says they want to lose elo
        System.out.println();
        System.out.println("Your win percentage from the provided data is not high enough to increase your elo as you play more games, please try checkers.");
        
    }

      

int losses = numGames - wins - draws;
System.out.println();
System.out.println("Number of games played: " + numGames);
System.out.println("Wins: " + wins);
System.out.println("Draws: " + draws);
System.out.println("losses: " + losses);
System.out.println();
System.out.println("Win percentage: " + (winPercentage * 100) + "%");
System.out.println();
}
else if (service.equalsIgnoreCase("B"))
{

    System.out.println();
    System.out.println("Input today's date (mm.dd.yyyy): ");
    String theDate = in.next();
    System.out.println("Input your name: ");
    String name = in.next();
    
   File check1 = new File (name + ".txt");
   PrintWriter writer2 = null;
   if (check1.exists() == false)
   {File playerProfileFile = new File("C:\\Users\\perod\\Athena\\" + name + ".txt");
    playerProfileFile.createNewFile();
    writer2 = new PrintWriter("C:\\Users\\perod\\Athena\\" + name + ".txt");
        
    writer2.println("Games:");
    writer2.println();
    writer2.println("Wins:");
    writer2.println();
    writer2.println("Losses:");
    writer2.println();
    writer2.println("Draws:");
    writer2.println();
    writer2.println("Losses:");
    writer2.println();
    writer2.println("Openings as white:");
    writer2.println();
    writer2.println("Openings as black:");
    writer2.println();
    writer2.println("Time controls:");
    writer2.println();
    
}
    writer2.close();//here

    Scanner inFile4 = new Scanner("C:\\Users\\perod\\Athena\\" + name + ".txt");

    System.out.println("Input your opponent's name: ");
    String oppName = in.next();
    
    
    File check2 = new File (oppName + ".txt");
    PrintWriter writer3 = null;
   if (check2.exists() == false)
   {File playerProfileFile = new File("C:\\Users\\perod\\Athena\\" + oppName + ".txt");
    playerProfileFile.createNewFile();
    writer3 = new PrintWriter("C:\\Users\\perod\\Athena\\" + oppName + ".txt");
    
    writer3.println("Games:");
    writer3.println();
    writer3.println("Wins:");
    writer3.println();
    writer3.println("Losses:");
    writer3.println();
    writer3.println("Draws:");
    writer3.println();
    writer3.println("Losses:");
    writer3.println();
    writer3.println("Openings as white:");
    writer3.println();
    writer3.println("Openings as black:");
    writer3.println();
    writer3.println("Time controls:");
    writer3.println();
}
writer3.close();

Scanner inFile5 = new Scanner("C:\\Users\\perod\\Athena\\" + oppName + ".txt");    

    //in case multiple games happen between the same people in one day
    int r = (int)(Math.random() * (899001) + 1000);
    
    String randomNum = String.valueOf(r);
    
    String newFileName = name + " vs " + oppName + "-" + theDate + "-" + randomNum + ".txt";
    
   
    
 
      File theFile = new File ("C:\\Users\\perod\\Athena\\" + newFileName);   
        
    PrintWriter writer = new PrintWriter("C:\\Users\\perod\\Athena\\" + newFileName);

    
    
    
    System.out.println("Who is playing as white?: ");
    String whoWhite = in.next();
    String whoBlack = "";
    
    int whiteGames1 = 0; 
    int blackGames1 = 0;
     int whiteGames2 = 0; 
    int blackGames2 = 0;
    
   PrintWriter writer5 = null;
   PrintWriter writer6 = null; 
   
    if (whoWhite.equals(name))
    {whoBlack = oppName;
    while (inFile4.hasNext())
{String token2 = inFile4.nextLine( );
 if (token2.indexOf("Games:") > -1)
 {      while (inFile4.hasNextLine())
     {String lineReader = inFile4.nextLine( );
         if (lineReader.equals("*"))
        {whiteGames1++;}
        else if (lineReader.equals("#"))
        {blackGames1++;}
        else
        {writer5 = new PrintWriter("C:\\Users\\perod\\Athena\\" + name + ".txt");
        writer5.println("*");
    writer5.println();}
     
        }
     
    }
}
}//find the index of the white game coordinate in the 'Games' line for the name.txt doc- 
    //-and add 1
    else
    {whoBlack = name;
    while (inFile5.hasNext())
{String token2 = inFile5.nextLine( );
 if (token2.indexOf("Games:") > -1)
 { String lineReader = inFile5.nextLine( );
     while (inFile5.hasNextLine())
     {if (lineReader.equals("*"))
        {whiteGames1++;}
        else if (lineReader.equals("#"))
        {blackGames1++;}
     else
        {writer6 = new PrintWriter("C:\\Users\\perod\\Athena\\" + oppName + ".txt");
        writer6.println("*");
    writer6.println();}
        }
     
    }
}} //find the index of the black game coordinate in the 'Games' line for the oppName.txt doc- 
    //-and add 1
    if(writer5 != null)
    {writer5.close();}
     
    if(writer6 != null)
    {writer6.close();}
    
    System.out.println("Is there a time control? (please respond yes or no): ");
    String ifTime = in.next();
    in.nextLine(); //Consume remaining newLine
    String time = "";
     if (ifTime.equalsIgnoreCase("yes") || ifTime.equalsIgnoreCase("y"))
   {System.out.println("What is the time control?: ");
    time = in.nextLine();} 
    
    writer.println(theDate + " " + name + " versus " + oppName + ":");
    writer.print(whoWhite + " played as white and " + whoBlack + " played as black.");
   if(ifTime.equalsIgnoreCase("yes") || ifTime.equalsIgnoreCase("y"))
   {writer.print(" The time control on this game was " + time + ".");}
    writer.println();
    writer.println();
    
    
    int moveNum = 0;
    System.out.println("Each player will input their respective moves using algebraic notation. The notation for a player resigning is 'Resigns'.");
     System.out.println("The notation for a draw is the final move followed by '1/2-1/2' with a space in between (for example b5 1/2-1/2).");
     
     
     if (ifTime.equalsIgnoreCase("yes") || ifTime.equalsIgnoreCase("y"))
   {System.out.println("To indicate a player has run out of time, input '-' as their final move.");}
   
     System.out.println();
   
   String theMove = "";
   
   
  ArrayList<String> moves = new ArrayList<String>();
  moves.add("");
  moves.add("");
   
  String theGameOpening = "Unable to identify opening.";
  String link = "";
  int whoWon = 0;  
 int matrixRows = 0;
 int j = 0;
 int arrayListIndex = 2;
 String [][] obj = new String [0][0];
 CheckList matrixObject = new CheckList(obj);
    while(moves.get(moves.size() -1).indexOf("#") == -1)
    {
    System.out.println(whoWhite + ":");
    theMove = in.nextLine();
    moveNum++;
    
    String printMove = moveNum + ". " + theMove;
    moves.add(printMove);
    
    if (moveNum == 1)
    {
    matrixRows = CheckList.findRowNum(printMove);
    if(matrixRows == 0)
{
theGameOpening = "Unable to identify opening.";
}
}

String [][] openingsMatrix = new String[matrixRows][11];
if (moveNum == 1 && matrixRows != 0)
    {    
    String [][] z = CheckList.firstMoveCut(printMove, matrixRows);
    
    for (int h = 0; h < z.length; h++)
    {
    openingsMatrix[h] = z[h];
    }
    if (matrixRows == 1) //only match to an opening was White's first move
{
    
    link = openingsMatrix[0][openingsMatrix[0].length - 1];
    theGameOpening = openingsMatrix[0][0] + " " + link;
    }

else
{
for (int i = 0; i < openingsMatrix.length; i++)
{
if (printMove.equalsIgnoreCase(openingsMatrix[i][1]))
{

    link = openingsMatrix[i][openingsMatrix[i].length - 1];
     theGameOpening = openingsMatrix[i][0] + " " + link;
    }
}
}
 } 
    

    
if (matrixRows != 1 && matrixRows != 0 && j != 1 && j != 0) //this statement in parentheses checks that no definitive matches have already been found 
{
String [][] q = matrixObject.cutOpenings(moves);
j = q.length;
matrixObject.setOpenings(q);
    
    if (j == 1)
{

    link = q[0][q[0].length - 1];
    theGameOpening = q[0][0] + " " + link;
    }
else{ for (int x = 0; x < q.length; x++)
{
if ((q[x][moveNum]).indexOf(moves.get(moveNum + 1)) != -1) 
{link = q[x][q[x].length - 1];
theGameOpening = q[0][0] + " " + link;}
}
}
}

    
    
    
    
    
    if (theMove.indexOf("#") > -1) 
    {writer.println(printMove);
        writer.println();
        writer.println(whoWhite + " won.");
        writer.print("The opening for this game was: " + theGameOpening);
        whoWon++;
        break;}
    
    if (theMove.equalsIgnoreCase("Resigns") || theMove.equalsIgnoreCase("Resign"))
    {writer.println(printMove);
        break;}
    
        if (theMove.equalsIgnoreCase("-"))
    {writer.println(printMove);
       writer.println();
       writer.println(whoBlack + " won on time.");
       writer.print("The opening for this game was: " + theGameOpening);
        whoWon++;
        break;}
        
    if(theMove.indexOf("1/2-1/2") > -1)
    {writer.println(printMove.substring(0, printMove.indexOf("1/2-1/2")));
        writer.println("1/2-1/2");
        writer.println();
        writer.println("Game drawn.");
    writer.print("The opening for this game was: " + theGameOpening);
        whoWon++;
        break;}
    
    System.out.println(whoBlack + ":");
    theMove = in.nextLine();
    

    printMove += " " + theMove; 
    if (moveNum == 1 && matrixRows != 0 && matrixRows != 1)
    {
    String [][] u = CheckList.firstBlackMoveCut(printMove, openingsMatrix);
    matrixObject.setOpenings(u); //set the 2d array
    j = u.length;
    
    if (j == 1)
{

    link = u[0][u[0].length - 1];
    theGameOpening = u[0][0] + " " + link;
    }


else{
    int s = 0;
for (int k = 0; k < u.length; k++)
{
    if (s == 0){
if (printMove.equalsIgnoreCase(u[k][1]))
{
link = u[k][u[k].length - 1];
theGameOpening = u[k][0] + " " + link;
s++;
}}
}
    }
}
    
    if(theMove.indexOf("1/2-1/2") > -1)
    {writer.println(printMove.substring(0, printMove.indexOf("1/2-1/2")));
        writer.println("1/2-1/2");
        writer.println();
        writer.println("Game drawn.");
    writer.print("The opening for this game was: " + theGameOpening);
        whoWon++;
        break;}
        
         if (theMove.equalsIgnoreCase("-"))
    {writer.println(printMove);
       writer.println();
       writer.println(whoWhite + " won on time.");
       writer.print("The opening for this game was: " + theGameOpening);
        whoWon++;
        break;}
        
 writer.println(printMove);
    moves.remove(arrayListIndex);
    moves.add(printMove);
    
    
    arrayListIndex++;
     if (moveNum > 1 && matrixRows != 1 && matrixRows != 0 && j != 1 && j != 0)
{
String [][] q = matrixObject.cutOpenings(moves);
j = q.length;
matrixObject.setOpenings(q);
   
  
   if (j == 1)
{

    
    link = q[0][q[0].length - 1];
    
    
theGameOpening = q[0][0] + " " + link;
}
else{
    int s = 0;
for (int k = 0; k < q.length; k++)
{
    if (s == 0){
if (printMove.equalsIgnoreCase(q[k][1]))
{
link = q[k][q[k].length - 1];
theGameOpening = q[k][0] + " " + link;
s++;
}}
}
    }
}

 if (theMove.equalsIgnoreCase("Resigns") || theMove.equalsIgnoreCase("Resign"))
    { writer.println();
        writer.println(whoWhite + " won.");
        writer.print("The opening for this game was: " + theGameOpening);
        whoWon++;
        break;}
    
}





if (whoWon == 0)
{writer.println();
        writer.println(whoBlack + " won.");
    writer.print("The opening for this game was: " + theGameOpening);}

writer.close();

System.out.println("Game over");
System.out.println("The opening for this game was: " + theGameOpening);
}
else if (service.equalsIgnoreCase("C"))
{
System.out.println();
System.out.println("Please input your name: ");
String theName = in.next();

//search Athena for .txt files with the user's name in the file name
//present the games by the file names to the user

//if user wants to search for an opponent search those files (if any) for the first "x" moves and add them to an array. Pass each opening array through the ChekList class to identify which 
//++openings the opponent uses (Checklist must be told whether the user is white or black)
}
else
{
System.out.println();
System.out.println("Unfortunately that is not a valid input.");
}
}
}

