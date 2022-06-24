

public class Stack {

    // Atributos da Stack
    private Node topo;
    private int count;

    // Classe Node
    private class Node {
        int element;
        Node next;

        // Contrutor Node
        public Node(int element) {
            this.element = element;
        }
    }

    // Construtor Stack
    public Stack() {
        this.count = 0;
        this.topo = null;
    }

    /**
     * Coloca Node no topo da lista
     * @param element
     */
    public void push(int element) {
        Node n = new Node(element);
        n.next = topo;
        topo = n;
    }

    /**
     * Retorna elemento do topo da pilha
     */
    public int top() {
        return topo.element;
    }

    /**
     * Remove elemento do topo da pilha
     */
    public void pop() {
        topo = topo.next;
    }

    /**
     * Deleta elementos (Nodes) da lista
     */
    public void clear() {
        topo = null;
    }

}