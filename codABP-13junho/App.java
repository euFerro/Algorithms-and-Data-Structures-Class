
public class App {
    public static void main(String[] args) {
        BinarySearchTreeOfInteger b = new BinarySearchTreeOfInteger();
        b.add(15);
        b.add(23);
        b.add(9);
        b.add(11);
        b.add(2);
        b.add(20);
        b.add(38);
        System.out.println(b.positionsCentral());
        System.out.println("Contem 4? " + b.contains(4));
        System.out.println("Contem 20? " + b.contains(20));
        System.out.println("=====");
        b.GeraDOT();
        
        b.remove(15);
        System.out.println("===== Apos remocao do 15");
        b.GeraDOT(); 
        
        b.remove(23);
        System.out.println("===== Apos remocao do 23");
        b.GeraDOT();   
        
        b.remove(11);
        System.out.println("===== Apos remocao do 11");
        b.GeraDOT();          
     }
   
}
