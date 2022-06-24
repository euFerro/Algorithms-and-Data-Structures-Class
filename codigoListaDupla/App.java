
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(10);
        l.add(20);
        l.add(30);
        
        System.out.println(l);
        System.out.println("size=" + l.size());

        l.remove(20);

        System.out.println(l);
        System.out.println("size=" + l.size());

        l.removeByIndex(1);

        System.out.println(l);
        System.out.println("size=" + l.size());

        l.set(0, 69);

        System.out.println(l);
        System.out.println("size=" + l.size());

        l.add(10);
        l.add(20);
        l.add(30);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.remove(69);

        System.out.println(l);
        System.out.println("size=" + l.size());

        l.reverse();

        System.out.println(l);
        System.out.println("size=" + l.size());

        l.unique();

        System.out.println(l);
        System.out.println("size=" + l.size());




    }
}
