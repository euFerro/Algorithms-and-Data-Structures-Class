
public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
        
        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }        
    }

    
    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    
    /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }
    
    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }    

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element)  { // O(1)
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }
    
    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) { // O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1)
            return tail.element;
        
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.element);
    }
    
    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Integer elem = null;
        
        if (index == count-1) { // se for o ultimo, não precisa percorrer a lista
            elem = tail.element;
            tail.element = element;
            return elem;
        }
        
        Node aux = head; 
        for(int i=0; i<index; i++) { // vai ate a posicao index
            aux = aux.next;
        }
        elem = aux.element;
        aux.element = element;
        return (elem);
    }    
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }    
    
    
    ////////////////////////////////////////////////////////////////
    
    
    /**
     * Insere um elemento em uma determinada posicao da lista.
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {
        if (index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }
        //cria nodo que vai ser adicionado
        Node n = new Node(element);

        // encadear o nodo na criado
        if (index == 0) // insercao no primeiro
        {
            if (count == 0)
            {
                tail = n;
            }
            else
            {
                n.next = head;
            }
            head = n;
        }
        else if (index == count) // insercao no fim
        {
            tail.next = n;
            tail = n;
        }
        else // insercao no meio
        {
            Node ant = head;
            // percorre lista do head ate anterior do index para fazer o "desvio" de referencias (next)
            for (int i = 0; i < index-1; i++)
            {
                ant = ant.next;
            }
            n.next = ant.next;
            ant.next = n;
        }
        // atualiza o contador
        count++;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        // se a lista estiver vazia
        if (count == 0)
        {
            return false;
        }
        // se o caso for remover o primeiro
        if (element.equals(head.element))
        {
            head = head.next;
            if (count == 1)
            {
                tail = null;
            }
            count--;
            return true;
        }
        // cria nodos auxiliares para pesquisa na linked list
        Node ant = head; // referencia para o anterior
        Node aux = head.next; // referencia aponta para o elemnto que esta sendo verificado

        while (aux != null)
        {
            if (aux.element.equals(element))
            {
                if (aux == tail)
                {
                    tail = ant;
                    tail.next = null;
                }
                else
                {
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
            aux = aux.next;
            ant = ant.next;
        }

        return false;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException();// erro
        }
        // se remocaodo do primeiro
        if (index == 0)
        {
            Integer elem = head.element;
            head = head.next;
            if (count == 1)
            {
                tail = null;
            }
            count--;
            return elem;
        }

        Node ant = head;
        for (int i = 0; i < index-1; i++)
        {
            ant = ant.next;
        }

        if (index == count-1)  // reamocao last
        {
            tail = ant;
            tail.next = null;
        }
        else // remocao meio
        {
            ant.next = ant.next.next; // endereco (next) do ant 
        }

        Integer elem = ant.next.element;
        count--;
        return elem;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        Node aux = head;
        for (int i = 0; i < count; i++)
        {
            if (aux.element.equals(element))
            {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Retorna true se a lista contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = head;
        while (aux != null)
        {
            if (aux.element.equals(element))
            {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

   // checks if a LinkedListOfInteger is equal to another
    public boolean equals(LinkedListOfInteger lista) {

        if (count != lista.size())
        {
            return false;
        }

        Node aux1 = head;
        Node aux2 = lista.head;
        boolean isEqual = true;

        while(aux1 != null)
        {
            if (aux1.element.equals(aux2.element))
            {
                isEqual = true;
            }
            else
            {
                isEqual = false;
                return isEqual; 
            }
            aux1 = aux1.next;
            aux2 = aux2.next;
        }

        return isEqual;
    }


}
