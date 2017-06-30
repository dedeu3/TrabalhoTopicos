package br.cripto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class pwGenerator {

    private String p1;
    private String p2;
    private String p3;
    private int pin;

    public pwGenerator(String p1, String p2, String p3, int pin) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.pin = pin;
    }

    public String generateNew() {

        int lengthP1 = p1.length();
        int lengthP2 = p2.length();
        int lengthP3 = p3.length();
        Random rnd = new Random();

        String pass[] = new String[3];
        pass[0] = stringShard(rnd.nextInt(p1.length()), p1);
        pass[1] = stringShard(rnd.nextInt(p2.length()), p2);
        pass[2] = stringShard(rnd.nextInt(p3.length()), p3);

        List<String> senhas = Arrays.asList(pass);
        Collections.shuffle(senhas);

        String finalPass = senhas.get(0) + senhas.get(1) + senhas.get(2) + (char) (48 + rnd.nextInt(57 - 48)) + (char) (48 + rnd.nextInt(57 - 48)) + (char) (33 + rnd.nextInt(47 - 33)) + (char) (33 + rnd.nextInt(47 - 33));

        return finalPass;
    }

    private String stringShard(int initPos, String palavra) {
        Random rnd = new Random();
        int oi = rnd.nextInt((palavra.length() + 1) - (initPos + 1));

        return palavra.substring(initPos, (initPos + oi) + 1);
    }

    public String uncryptPass(String pass, int pin) {
        char[] charPass = pass.toCharArray();
        int maior = returnHigher(pin);

        for (int i = 0; i < charPass.length; i++) {
            charPass[i] = (char) ((char) (int) charPass[i] - maior);
        }

        return "";
    }

    public String cryptPass(String pass, int pin) {
        char[] charPass = pass.toCharArray();
        int maior = returnHigher(pin);

        for (int i = 0; i < charPass.length; i++) {
            charPass[i] = (char) ((char) (int) charPass[i] + maior);
        }

        return "";
    }

    private int returnHigher(int pin) {
        char[] chars = ("" + pin).toCharArray();
        int[] _pins = new int[4];
        
        _pins[0] = Integer.parseInt(chars[0]+"");
        _pins[1] = Integer.parseInt(chars[1]+"");
        _pins[2] = Integer.parseInt(chars[2]+"");
        _pins[3] = Integer.parseInt(chars[3]+"");

        int max = Arrays.stream(_pins).max().getAsInt();
        return max;
    }
    
    
}