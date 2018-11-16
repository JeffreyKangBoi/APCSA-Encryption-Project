public class Run {

    public static void main(String args[]) {
        Logic a = new Logic();
        Decrypt b = new Decrypt();
        int things = 0;
        System.out.println("This program is a cipher program which combines a ceasar cipher and a keyword cipher.");
        System.out.println("It can decrypted and encrypt the combination of these ciphers.");
        System.out.println("The ceaser cipher key is a int, while the keyword key is a string");
        System.out.println("Remember the key, or you might lose the message forever!");
        while (things == 0) {
            System.out.println("Do you want to encrypt(e) or decrypt(d)?");
            String EncryptorDecrypt = a.getInput().toLowerCase();
            String encrypted;
            String dencrypted;
            if (EncryptorDecrypt.equals("e")) {
                System.out.println("What is your string to encrypt?");
                String str = a.getInput();
                System.out.println("What is your key for the keyword cipher?");
                String keyword = a.getInput();
                System.out.println("What is your key for the caesar cipher?");
                int shift = a.getIntPut();
                encrypted = a.EncryptCesar(shift, str);
                encrypted = a.encryptCipher(keyword, encrypted);
                System.out.println("Here is the encrypted string:");
                System.out.println(encrypted);

            }else if (EncryptorDecrypt.equals("d")) {
                System.out.println("What is your string to decrypt?");
                String dstr = a.getInput();
                System.out.println("What is your key for the keyword cipher?");
                String dkeyword = a.getInput();
                System.out.println("What is your key for the caesar cipher?");
                int dshift = a.getIntPut();
                dencrypted = b.DecryptCipher(dkeyword, dstr);
                dencrypted = a.EncryptCesar(-dshift, dencrypted);
                System.out.println("Here is the decrypted string:");
                System.out.println(dencrypted);
            }else {
                System.out.println("Please put d or e");
            }
            System.out.println("Press y to continue");
            String go = a.getInput().toLowerCase();
            if (go.equals("y")) {
                System.out.println("Another one");
            }else {
                things= 1;
            }



        }

    }
}
