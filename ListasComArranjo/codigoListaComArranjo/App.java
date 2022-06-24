

public class App {
    public static void main(String[] args) {
        ListArrayOfInteger lista = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        
        System.out.println(lista);
       
        System.out.println("Elemento armazenado na "
                + "primeira posicao da lista: " +lista.get(0));
        
        System.out.println("Substituiu o elemento: " + lista.set(1,5));
        System.out.println(lista);
        
        System.out.println("Removeu 6? " + lista.remove(6));

        System.out.println("Conteudo da lista:");
        System.out.println(lista);
        
        System.out.println("lista contem 6? " + lista.contains(6));
        System.out.println("lista contem 8? " + lista.contains(8));
        
        lista.add(0,1);
        lista.add(2,7);
        
        System.out.println("Conteudo da lista:");
        System.out.println(lista);    
    }
}
