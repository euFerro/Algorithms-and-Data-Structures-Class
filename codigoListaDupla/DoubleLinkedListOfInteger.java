
public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao atual.
    private Node current;    
    // Contador do numero de elementos da lista.
    private int count;

     private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // Atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza count
        count++;      
    }
    
    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) throws IndexOutOfBoundsException {
         if (index < 0 || index > count ) // indice invalido
        	throw new IndexOutOfBoundsException();
        // Implementar este método
    }
    
    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++)
        {
            if (aux.element.equals(element))
            {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }        
        Node aux = this.getNodeIndex(index);
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
        return aux.element;
    }

    /**
     * Retorna o Nodo baseado no index recebido
     * @param index a posicao da lista
     * @return Nodo (referência)
     */
    private Node getNodeIndex(int index) {
        Node aux = null;

        if (index < count/2)
        {
            aux = header.next;
            for (int i = 0; i < index; i++)
                aux = aux.next;
        }
        else
        {
            aux = trailer.prev;
            for (int i = count-1; i > index; i--)
                aux = trailer.prev;

        }
        return aux;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = this.getNodeIndex(index);
        return aux.element;
    }
    
   /**
    * Substitui o elemento armanzenado em uma determinada posicao da lista pelo Integer indicado
    * @param index a posicao da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posicao da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = this.getNodeIndex(index);
        Integer elemAntigo = aux.element;
        aux.element = element;
        return elemAntigo;
    }    
   
    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) {
        // Verifica os index
        if (fromIndex < 0 || toIndex > size())
        {
            throw new IndexOutOfBoundsException();
        }
        if (fromIndex > toIndex)
        {
            throw new IllegalArgumentException();
        }

        // Cria array
        Integer a[] = new Integer[toIndex-fromIndex];

        // Set aux reference to Node in fromIndex
        Node temp = getNodeIndex(fromIndex);

        // Go through linked list
        for (int i = 0; i < (toIndex-fromIndex); i++)
        {
            a[i] = temp.element;
            temp = temp.next;
        }

        return a;
    }  
    
    
    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }
    
    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }
    
    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }
        
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }    
    
    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o fim).
     */
    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     * @return elemento da posicao corrente
     */
    public Integer next() {
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }      

    /**
     * Invert linked list's elements
     */
    public void reverse() {
        Node a = header.next;
        Node b = trailer.prev;

        for (int i = 0; i < (size()/2); i++)
        {
            Integer aux = a.element;
            a.element = b.element;
            b.element = aux;
            a = a.next;
            b = b.prev;
        }
    }

    /**
     * Remove duplicate elements
     */
    public void unique() {
        Node a = header.next;
        Node b = header.next;

        for (int i = 0; i < size(); i++)
        {
            b = header.next;
            for (int j = 0; j < size(); j++)
            {
                if (a.element.equals(b.element))
                {
                    b.prev.next = b.next;
                    b.next.prev = b.prev;
                }
                b = b.next;
            }
            a = a.next;
        }
    }


}
