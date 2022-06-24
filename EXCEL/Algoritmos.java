package com.algoritmos;

/**
 *
 * @author Gustavo Scholze
 */
public class Algoritmos {

    public static void main(String[] args) {
        Funcoes f  = new Funcoes();
        
        for(int n=10; n<10000; n+=50) {
            long r = f.fh(n);
            System.out.println(n+";"+r);
        }
        //int c = f.getTotalSequencias(15);
        //System.out.println(c);
    }
}
