
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(1);
        l.add(3);
        l.add(5);
        l.add(7);
        l.add(9);
        l.add(3);
        
        System.out.println(l);
        System.out.println("size="+l.size());
        
        l.set(0, 2);
        l.set(2, 4);
        System.out.println(l);
        
        System.out.println("IndexOf 4 = " + l.indexOf(4));
        System.out.println("IndexOf 15 = " + l.indexOf(15));
        
        System.out.println("Contem 2? " + l.contains(2));
        System.out.println("Contem 9? " + l.contains(9));
        System.out.println("Contem 12? " + l.contains(12));
        
        System.out.println(l);
        l.add(0,1);
        l.add(l.size(),11);
        l.add(4,6);
        System.out.println(l);
        
        Integer subList[] = l.subList(2, 5);
        for(int i=0; i<subList.length; i++)
            System.out.println("SubList["+i+"]="+subList[i]);
        
        System.out.println("Removeu 3? " + l.remove(3));
        System.out.println("Removeu 13? " + l.remove(13));
        System.out.println("Removeu 1? " + l.remove(1));
        System.out.println("Removeu 11? " + l.remove(11));
        System.out.println(l);
        System.out.println("Removeu " + l.removeByIndex(0));

        // Copia pilha para fila
        System.out.println("\nCOPIA PARA FILA");
        FilaArray fila = new FilaArray();
        Stack pilha = new Stack();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        int pilha_size = pilha.size();
        FilaArray.copiaParaFila(fila, pilha);

        for (int i = 0; i < pilha_size; i++) {
            System.out.println("Fila: " + fila.dequeue());
        }
    }
}
