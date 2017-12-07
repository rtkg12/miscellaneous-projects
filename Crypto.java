public class Crypto {
    public static void main(String[] args){
        String cyphertext = encryptString("How are you?",  5, 3);
       // String caesaralphabet = shiftAlphabet(21);
        System.out.println("Cyphertext is: " + cyphertext);
        //System.out.println(caesaralphabet);

        String plaintext = decryptify(cyphertext, 5);

        System.out.println("plain text is: " + plaintext);


    }

    public static String normalizeText(String text){
        text = text.replace(" ", "");
        text= text.replaceAll("[. , : ; ’ ! \" ? ( )]", "");
        text = text.toUpperCase();

        System.out.println("Input text is: " + text);
        return text;
    }

    public static String obify(String text){
        text = text.replace("A", "OBA");
        text = text.replace("E", "OBE");
        text = text.replace("I", "OBI");
        text = text.replace("O", "OBO");
        text = text.replace("U", "OBU");
        return text;


    }

    public static String unobify(String text){
        text = text.replace("OBA", "A");
        text = text.replace("OBE", "E");
        text = text.replace("OBI", "I");
        text = text.replace("OBO", "O");
        text = text.replace("OBU", "U");
        return text;


    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String caesarify(String text, int shift){
        String alphabet = shiftAlphabet(0);
        String caesaralphabet = shiftAlphabet(shift);
        String shiftedtext = "";
        for(int i=0; i<text.length(); i++ ){
            char currentchar = text.charAt(i);
            int index = alphabet.indexOf(currentchar);

            //text = text.replace(text.charAt(i), caesaralphabet.charAt(index));

            shiftedtext = shiftedtext + caesaralphabet.charAt(index);

        }
        return shiftedtext;
    }

    public static String groupify(String text, int group){
        String groupedtext = "";
        for(int i=0; i<text.length(); i++){
            if(i==0) {groupedtext = groupedtext + text.charAt(i);}

            else if(i%group!=0){
                groupedtext = groupedtext + text.charAt(i);
            }

            else {groupedtext = groupedtext + " " + text.charAt(i);}
        }

        while((groupedtext.length() - groupedtext.lastIndexOf(" "))!=group+1){
            groupedtext = groupedtext + "x";
        }

        return groupedtext;
    }

    public static String encryptString(String text, int shift, int group){
        String normalized = normalizeText(text);
        String obfuscated = obify(normalized);
        String caesarshifted = caesarify(obfuscated, shift);
        String grouped = groupify(caesarshifted, group);
        String encryptedText = grouped;
        return encryptedText;
    }

    public static String ungroupify(String text){
        text = text.replace(" ", "");
        text = text.replace("x", "");
        return text;
    }

    public static String decryptify(String text, int shift){
        int decryptkey = -1*shift;
        String ungrouped = ungroupify(text);
        String caesarunshifted = caesarify(ungrouped, decryptkey);
        String unobfuscated = unobify(caesarunshifted);
        unobfuscated = unobify(unobfuscated);

        return unobfuscated;
    }
}
