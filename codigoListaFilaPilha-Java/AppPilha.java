
public class AppPilha {
    public static void main(String[] args) {
        //Stack pilha = new Stack();
        StackArray pilha = new StackArray();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        
        int tam = pilha.size();
        for(int i=0; i<tam; i++)
            System.out.println(pilha.pop());
        
    }
}
