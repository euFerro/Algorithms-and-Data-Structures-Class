
import java.util.EmptyStackException;


public class StackArray {
    // Atributos
    private int count;
    private Integer pilha[];
    
    // construtor
    public StackArray() {
        pilha = new Integer[10];
        count = 0;
    }
    
    // insere o elemento e no topo da pilha
    public void push(Integer element) {
        if (count == pilha.length) // se a pilha estiver cheia
            throw new FullStackException("Pilha cheia!");
        
        pilha[count] = element;
        count++;
    }

    // remove e retorna o elemento do topo da pilha 
    // (erro se a pilha estiver vazia)
    public Integer pop() {
        if (count == 0) // se a pilha esta vazia
            throw new EmptyStackException(); // erro
        Integer num = pilha[count-1];
        pilha[count-1] = null;
        count--;
        return num;
    }

    // retorna, mas não remove, o elemento do topo da 
    // pilha (erro se a pilha estiver vazia)
    public Integer top() {
        if (count == 0) // se a pilha esta vazia
            throw new EmptyStackException(); // erro
        return pilha[count-1];
    }

    // retorna o número de elementos da pilha
    public int size() {
        return count;
    }

    // retorna true se a pilha estiver vazia, e ]
    // false caso contrário
    public boolean isEmpty() {
        return count == 0;
    }

    // esvazia a pilha   
    public  void clear() {
        pilha = new Integer[10];
        count = 0;
    }
    
}
