
public class AppExercicios {

    public static void main(String[] args) {
        
        Exercicios e = new Exercicios();
        
        for(int i=10; i<300; i+=10) {
            
            int a[] = new int[i]; // Cria o array

            // Inicializa o array
            for(int j = 0; j < a.length; j++) {
                a[j] = 1;
            }
            int nroOp = e.exercicio3(a);
            System.out.println(i+";"+nroOp);
        }
    } 
    
}
