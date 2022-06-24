
public class Exercicios {

    public int getTotalSequencias(int v) {
        return 0;
    }
    
    public int exercicio1(int A[]) {
        int cont = 0;
        int s = 0;
        for (int i=0; i< A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = j; k < A.length; k++) {
                    s = s + A[k];
                    cont++;
                }
            }
        }
        return cont;
    }

    public int exercicio2(int A[]) {
        int cont = 0;
        int s = 0;
        for (int i=1; i< A.length; i+=2) {
            s = s + A[i];
            cont++;
        }
        return cont;
    }

    public int exercicio3(int A[]) {
        int cont = 0;
        int s = 0;
        for (int i=0; i< A.length; i++)
            for (int j=0; j<i; j++) {
                s = s + A[j];
                cont++;
            }
        return cont;
    }

    public int exercicio4(int A[]) {
        int cont = 0;

        return cont;
    }    
}
