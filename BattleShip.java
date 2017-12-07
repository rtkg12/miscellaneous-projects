import java.util.*;

public class BattleShip {
    //int[][] map = new int[10][10];

    public static void main(String[] args){
        int[][] map = new int[10][10];
        //printMap(map);
        intro(map);
        computer(map);
        battle(map);
    }

   public static void intro(int[][] map){
        System.out.println("***** Welcome to Battleship *****");
        System.out.println("Right now, the sea is empty");
        printMap(map);

        Scanner input = new Scanner(System.in);

        for(int i=1; i<=5; i++){

            System.out.print("Enter X coordinate for your ship no " + i + ": ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your ship no " + i + ": ");
            int y = input.nextInt();

            if(x >9 || y>9 || map[x][y]!=0){
                System.out.println("Invalid. Please try again");
                i--;
            }
            else {
            map[x][y]=1; }
        }

        printMap(map);
       System.out.println("");

   }

   public static void computer(int[][] map) {
       Random rand1 = new Random();
       for (int i = 1; i <= 5; i++) {
           int x = rand1.nextInt(10);
           int y = rand1.nextInt(10);
           System.out.println(i + ". Ship deployed");
           map[x][y]=2;}
       }


   public static void battle(int[][] map) {
       Scanner input = new Scanner(System.in);
       int playerlives = 5;
       int computerlives = 5;
       int x, y;
       Random rand = new Random();

       while(playerlives > 0 && computerlives > 0){
           System.out.println("YOUR TURN");
           System.out.print("Enter X coordinate: ");
           x = input.nextInt();
           System.out.print("Enter Y coordinate: ");
           y = input.nextInt();


           //Computer vs Computer for testing
           //x = rand.nextInt(10);
           //y = rand.nextInt(10);

           if(x >9 || y>9){
               System.out.println("Invalid");
               continue;
           }
           else {
               if(map[x][y]==1){
                   System.out.println("You attacked your own ship. It's going down...");
                   map[x][y]=3;
                   playerlives--;
               }

               else if(map[x][y]==2){
                   System.out.println("You found an enemy ship. Good job!");
                   map[x][y]=3;
                   computerlives--;
               }

               else {
                   System.out.println("You missed");
               }

            }
           System.out.println("COMPUTER'S TURN");
           x = rand.nextInt(10);
           y = rand.nextInt(10);

           if(map[x][y]==1){
               System.out.println("Your ship has been attacked");
               map[x][y]=3;
               playerlives--;
           }

           else if(map[x][y]==2){
               System.out.println("Enemy ship going down");
               map[x][y]=3;
               computerlives--;
           }

           else {
               System.out.println("Computer missed");
           }

           printMap(map);
           System.out.println("Your ships: "+ playerlives + " | Computer's ships: " + computerlives );
           System.out.println("-------------------------------------------------------------------------");


       }

       if(playerlives!=0) {
           System.out.println("YOU WIN");
       }
       else {System.out.println("YOU LOSE");}

   }

    public static void printMap(int[][] map){
        System.out.println("   0 1 2 3 4 5 6 7 8 9   ");

        for(int i=0; i<map.length; i++){
            System.out.print(i + " |");

            for(int j=0; j<map[i].length; j++){
                if(map[i][j]==0 || map[i][j]==2){
                    System.out.print(" |");
                }
                else if(map[i][j]==1){
                    System.out.print("@|");
                }

                else if(map[i][j]==3){
                    System.out.print("X|");
                }

            }
            System.out.println(" " + i);


        }
       System.out.println("   0 1 2 3 4 5 6 7 8 9   ");

   }

  /* public static void changeMap(int[][] map, int x, int y, String player){
       if(player.equalsIgnoreCase("user")){
           map[x][y] = 1;
       }
       else if(player.equalsIgnoreCase("computer")){
           map[x][y] = 2;
       }
       else if(player.equalsIgnoreCase("hit")){
           map[x][y] = 3;
       }
   } */

}
