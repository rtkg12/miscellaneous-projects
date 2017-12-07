import java.util.*;
public class FractionCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("This program is a Fraction Calculator");
        System.out.println("It will add, subtract, multiple and divide fractions until you quit (Q)");

        String operation = getOperation(input);

        Fraction fraction1 = getFraction(input);
        Fraction fraction2 = getFraction(input);

        if(operation.equals("+")){System.out.println(fraction1.add(fraction2).toString());}
        if(operation.equals("-")){System.out.println(fraction1.subtract(fraction2).toString());}
        if(operation.equals("*")){System.out.println(fraction1.multiply(fraction2).toString());}
        if(operation.equals("/")){System.out.println(fraction1.divide(fraction2).toString());}

    }

    public static String getOperation(Scanner input){
        System.out.print("Please enter an operation (+, -, *, /, = or Q to quit");

        String userInput = input.next();

        while(!userInput.equals("+") && !userInput.equals("-") && !userInput.equals("*") && !userInput.equals("/") && !userInput.equals("=") &&!userInput.equals("Q")){
            System.out.print("Invalid Input (+, -, *, /, = or Q to quit");
            userInput = input.next();
        }

        return userInput;

    }

    public static boolean validFraction(String input){
        boolean isNegative = false;

        if(input.substring(0,1).equals("-")){
            input = input.replace("-", "");
            isNegative = true;
        }

        int slashposition = input.indexOf("/");

        if(slashposition==-1){
            String num = input;
            if(isNumber(num)){return true;}
            else{return false;}
        }

        else{
            String num = input.substring(0, slashposition);
            String den = input.substring(slashposition+1);

            if(isNumber(num) && isNumber(den) && !den.equals("0")){
                int numerator = Integer.parseInt(num);
                int denominator = Integer.parseInt(den);
                return true;
            }
            else {return false;}
        }
    }

    public static boolean isNumber(String input){
        if(input.equals("")){
            return false;
        }

        else{
            if(input.matches("[0-9]+")){
                return true;
            }
            else { return false;}
        }
    }

    public static Fraction getFraction(Scanner input){
        System.out.print("Please enter a fraction (a/b) or integer(a): ");
        String userInput = input.next();

        while(!validFraction(userInput)){
            System.out.print("Invalid Fraction. Please enter a fraction (a/b) or integer (a) where b is not zero");
            userInput = input.next();
        }

        boolean isNegative = false;

        if(userInput.substring(0,1).equals("-")){
            userInput = userInput.replace("-", "");
            isNegative = true;
        }

        int slashposition = userInput.indexOf("/");

        if(slashposition==-1){
            int num = Integer.parseInt(userInput);

            if(isNegative==true){num = -1 * num;}

            Fraction output = new Fraction(num);
            return output;
        }

        else{
            String num = userInput.substring(0, slashposition);
            String den = userInput.substring(slashposition+1);

            int numerator = Integer.parseInt(num);
            int denominator = Integer.parseInt(den);

            if(isNegative==true){numerator *= -1;}

            Fraction output = new Fraction(numerator, denominator);
            return output;
        }

    }
}
