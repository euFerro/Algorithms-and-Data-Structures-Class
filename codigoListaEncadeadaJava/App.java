
public class App {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);

        LinkedListOfInteger lista2 = new LinkedListOfInteger();
        lista2.add(19);
        lista2.add(4);
        lista2.add(10);
        
        System.out.println(lista);
       
        System.out.println("Elemento armazenado na "
                + "segunda posicao da lista: " +lista.get(1));

        System.out.println("Elemento armazenado na "
                + "ultima posicao da lista: " +lista.get(lista.size()-1));    
        
        lista.set(0,0);
        lista.set(5,14);
        System.out.println(lista);

        lista.remove(0);
        lista.remove(14);
        lista.remove(8);

        System.out.println("depois de remover começo (element: 0) meio (element: 8) fim (element: 14)");
        System.out.println(lista);

        lista.add(0, 19);

        System.out.println("depois de add(0, 19) por index");
        System.out.println(lista);

        lista.removeByIndex(2);

        System.out.println("depois de removeByIndex(2)");
        System.out.println(lista);

        System.out.println("depois contains(10)");
        System.out.println(lista.contains(10));

        System.out.println("depois de indexOf(element: 4)");
        System.out.println(lista.indexOf(10));

        System.out.println("depois de equals(LinkedListOfInteger: lista2)");
        System.out.println(lista.equals(lista2));
        System.out.println("\n"+lista);
        System.out.println(lista2);
    }
}
