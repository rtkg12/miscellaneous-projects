import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args){
        GameStart();
    }

    public static void GameStart(){
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play a game called Odds and Evens");
        System.out.print("What's your name?");
        String name = input.nextLine();
        System.out.print("Hi " + name + ", what do you choose (O)dds or (E)vens?");
        String UserChoice = input.next();

        if(UserChoice.equalsIgnoreCase("o")){
            System.out.println("You chose Odds. The computer will be Evens");
        }
        else {
            System.out.println("You chose Evens. The computer will be Odds.");
        }
        System.out.println("-------------------------------------------------");

        System.out.print("How many fingers do you put out?");
        int fingers = input.nextInt();

        Random rand = new Random();
        int computer = rand.nextInt(6);

        System.out.print("The computer plays " + computer);

        System.out.println("-------------------------------------------------");

        int sum = fingers + computer;
        String decision;
        System.out.println("The sum is " + sum);

        if(sum%2==0){
            System.out.println("The sum is even");
            decision = "e";
        }
        else {
            System.out.println("The sum is odd");
            decision = "o";
        }

        if(UserChoice.equalsIgnoreCase(decision)){
            System.out.println("You win!");
        }

        else {
            System.out.println("The computer wins.");
        }
    }


}
