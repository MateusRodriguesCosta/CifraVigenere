/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecrifa;

import javax.swing.JOptionPane;

/**
 *
 * @author MATEUS
 */

public class Vigenere {
    
    public static void main(String[] args) {
        boolean opcao = false;
        while(opcao == false){
            String chave = JOptionPane.showInputDialog(null,"Digite a palavra chave em maiusculo:");
            String mensagem = JOptionPane.showInputDialog(null,"Digite a mensagem a ser cifrada/decifrada: ");
            String encriptada = cifrar(mensagem, chave);        
            JOptionPane.showMessageDialog(null, "MENSAGEM CIFRADA: "+cifrar(mensagem, chave)+"\nMENSAGEM DECIFRADA: "+decifrar(encriptada, chave));
            String op = JOptionPane.showInputDialog(null,"Deseja realizar novamente essa operacao? ");
            if(op.equals("s") || op.equals("S") || op.equals("sim") || op.equals("SIM")){                
                opcao = false;
            }else{
                opcao = true;
                JOptionPane.showMessageDialog(null, "OBRIGADO!");
            }
        }
        
        
    }
 
    static String cifrar(String texto, final String chave) {
        String res = "";
        texto = texto.toUpperCase();
        for (int i = 0, j = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + chave.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % chave.length();
        }
        return res;
    }
 
    static String decifrar(String texto, final String chave) {
        String res = "";
        texto = texto.toUpperCase();
        for (int i = 0, j = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - chave.charAt(j) + 26) % 26 + 'A');
            j = ++j % chave.length();
        }
        return res;
    }
}
