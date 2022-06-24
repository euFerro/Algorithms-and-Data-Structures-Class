
import java.util.EmptyStackException;


public class Stack {

    private class Node {
        public Integer element;
        public Node next;
        public Node (Integer elem) {
            element = elem;
            next = null;
        }
    }
    
    // Atributos
    private Node topo;
    private int count;
    
    // insere o elemento e no topo da pilha
    public void push(Integer element) {
        Node n = new Node(element);
        if(count>0)
            n.next = topo;
        topo = n;
        count++;
    }

    // remove e retorna o elemento do topo da pilha 
    // (erro se a pilha estiver vazia)
    public Integer pop() {
        if (count == 0) // se a pilha esta vazia
            throw new EmptyStackException(); // erro
        Integer elem = topo.element;
        topo = topo.next;
        count--;
        return elem;
    }

    // retorna, mas não remove, o elemento do topo da 
    // pilha (erro se a pilha estiver vazia)
    public Integer top() {
        if (count == 0) // se a pilha esta vazia
            throw new EmptyStackException(); // erro
        return topo.element;
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
        topo = null;
        count = 0;
    }

}
