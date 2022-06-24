
public class AppFila {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        
        System.out.println("Primeiro elemento da fila: " + q.head());
        System.out.println("Total de elementos da fila: " + q.size());
        
        System.out.println("Elementos da fila: ");
        while(!q.isEmpty())
            System.out.println(q.dequeue());
        
        System.out.println("Total de elementos da fila: " + q.size());
        
    }
}
