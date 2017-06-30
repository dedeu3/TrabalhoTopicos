package br.cripto;

import br.cripto.Criptografador;
import br.cripto.pwGenerator;
import java.util.Random;

public class Principal {

    public static void main(String[] args) throws Exception {
        pwGenerator pwGen = new pwGenerator("dinheiro", "ferrari", "pizza", 1994);
        Criptografador aes = new Criptografador("lv39eptlvuhaqqsr");

        String senha = pwGen.generateNew();
        String senhaCriptografada = aes.encrypt(senha);
        String senhaDescriptografada = aes.decrypt(senhaCriptografada);
        
        System.out.println("Senha Gerada: " + senha);
        System.out.println("Senha Criptografada: " + senhaCriptografada);
        System.out.println("Senha Descriptografada: " + senhaDescriptografada);
        aes.encrypt(senha);

    }

}