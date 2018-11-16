public class Decrypt {
    public String DecryptCipher (String key, String str) {
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
            } else{
                for (int ab = 0; ab < 26; ab++) {
                    if(str.substring(one, one + 1).equals(newAlpha[ab])) {
                        encrypted = encrypted +  alphaBet[ab];
                        break;

                    }
                }
            }
        }
        return encrypted;

    }
}
