import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class Logic {

    public String getInput () {
        //gets input, but with string
        Scanner keyboard = new Scanner(System.in);
        String a = keyboard.nextLine();
        return a;
    }

    public int getIntPut () {
        //gets input, but with INT
        Scanner keyboard = new Scanner(System.in);
        int a = keyboard.nextInt();
        return a;
    }

    public String shift (String c, int shift) {
        //shifts a letter by x amounts of steps
        char ch2 = c.charAt(0);
        if (Character.isLetter(ch2)){

        }else {
            return c;
        }
        char ch = c.charAt(0);
        int strNum = (int)ch - 97;
        int realShift;
        if (shift < 0) {
            if (strNum + shift > 25) {
                realShift = (strNum + shift) - 26;
            } else {
                realShift = strNum + shift;

            }
        }else {
            if (strNum + shift > 25) {
                realShift = (strNum + shift) - 26;

            } else {
                realShift = strNum + shift;
            }
        }
        if (realShift < 0) {
            realShift = 26 + realShift;
        }
        if (realShift == 0) {
            return "a";
        }
        char ans = (char)(realShift + 97);
        String answer = String.valueOf(ans);
        return answer;

    }

    public String EncryptCesar (int key, String str) {
        Logic a = new Logic();
        String encypted ="";
        for (int x = 0; x < str.length(); x++) {
            if (str.substring(x, x+1).equals(" ")){
                encypted = encypted + " ";

            }else {
                encypted = encypted + a.shift(str.substring(x, x + 1), key);
            }
        }

        return encypted;

    }

    public int findLetterRep (String str) {
        //finds how many of the same letter are in a string
        int conter = 0;
        for (int j = 0; j < str.length(); j++) {
            for (int i = 0; i < str.length(); i++) {
                if (str.substring(j, j + 1).equals(str.substring(i, i + 1))) {
                    if (j != i) {
                        conter = conter + 1;
                    }
                }
            }
        }
        conter = conter/2;
        return conter;
    }

    public String encryptCipher (String key, String str) {
        //Setting up all the arrays and object stuff
        Logic logic = new Logic();
        str = str.toLowerCase();
        key = key.toLowerCase();
        String[] newAlpha = new String[26 + logic.findLetterRep(key)];
        String[] alphaBet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};


        //Making new alphabet
        for (int x = 0; x < key.length(); x++) {
            newAlpha[x] = key.substring(x, x + 1);
        }
        int numOfSkip= 0;
        for (int y = 0; y < (26); y++) {
            int counter = 0;

            for (int i =0; i < key.length();i++ ) {
                if (key.substring(i, i + 1).equals(alphaBet[y])) {
                    counter =1;
                }
            }
            if (counter > 0) {
                numOfSkip = numOfSkip + 1;
            }else {
                newAlpha[y + key.length()-numOfSkip] = alphaBet[y];

            }
        }




        //Changing the letters
        String encrypted = "";
        for (int one = 0; one < str.length(); one++) {
            char ch = str.charAt(one);
            if (str.substring(one, one + 1).equals(" ")) {
                encrypted = encrypted + " ";
            }else if (!Character.isLetter(ch)){
                encrypted = encrypted + str.substring(one, one + 1);
            }else {
                for (int ab = 0; ab < 26; ab++) {
                    if(str.substring(one, one + 1).equals(alphaBet[ab])) {
                        encrypted = encrypted +  newAlpha[ab];
                        break;

                    }
                }
            }
        }
        return encrypted;

    }




}
