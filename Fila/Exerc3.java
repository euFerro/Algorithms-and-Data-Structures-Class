public class Exerc3 {

    public List concatenarFilas(Queue a, Queue b) {
        
        List c = new List();
        
        for (int i = 0; i < a.size(); i++)
        {
            Integer element = a.dequeue;
            c.add(element);
            a.enqueue(element);
        }

        for (int i = 0; i < b.size(); i++)
        {
            Integer element = b.dequeue;
            c.add(element);
            a.enqueue(element);
        }
        return c;
    }

}