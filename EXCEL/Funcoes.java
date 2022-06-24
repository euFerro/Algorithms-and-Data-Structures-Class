package com.algoritmos;
import java.util.stream.IntStream;
import java.util.ArrayList;


public class Funcoes {

    // Complexidade linear
    public int fa(int n) {
        int cont = 0;
        for(int i=0; i<n; i++){
            cont++;
        }
        return cont;
    }

    // Complexidade quadrática
    public int fb(int n) {
        int cont = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                cont++;
            }
        }
        return cont;
    }

    // Complexidade quadrática O(n²)
    public int fc(int n) {
        int cont = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<2*i;j++){
                cont++;
            }
        }
        return cont;
    }

    // Complexidade logarítmica log(n)
    public int fd(int n) {
        int cont = 0;
        for(int i=1; i<n; i=i+i)
            cont++;
        return cont;
    }

    // Complexidade n log(n)
    public int fe(int n) {
        int cont = 0;
        for(int i=1; i<n; i++){
            for(int j=1; j<n; j=j+j)
                cont++;
        }
        return cont;
    }

    // Complexidade cúbica
    public int ff(int n) {
        int cont = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                for(int k=0; k<n; k++)
                    cont++;
        }
        return cont;
    }

    // Complexidade quadrática
    public int fg(int n) {
        int cont = 0;
        for(int i=0; i<n; i++)
            for(int j=i; j<i+2; j++)
                for(int k=0; k<n; k++)
                    cont++;
        return cont;
    }
    
    // Complexidade linear
    public int fh(int n) {
        int cont = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<i+2; j++){
                for(int k=j; k<j+3; k++){
                    cont++;
                }
            }
        }
            
        return cont;
    }
    
    public int getTotalSequencias(int v) {
        int partial_sum = 0, contagem=0;
        int[] arr = IntStream.rangeClosed(1, v).toArray();
        
        for (int i = 0; i < v; i++){
            System.out.println(arr[i]);
            partial_sum -= arr[i];
            if (partial_sum == 0)
                contagem++;
        }
        return contagem;
    }
}
