
import java.util.LinkedList;

public class GeneralTreeOfInteger {

    // Classe interna Node
    private class Node {
        // Atributos da classe Node
        public Node father;
        public Integer element;
        public LinkedList<Node> subtrees;
        // Métodos da classe Node
        public Node(Integer element) {
            father = null;
            this.element = element;
            subtrees = new LinkedList<>();
        }
        private void addSubtree(Node n) {
            n.father = this;
            subtrees.add(n);
        }
        private boolean removeSubtree(Node n) {
            n.father = null;
            return subtrees.remove(n);
        }
        public Node getSubtree(int i) {
            if ((i < 0) || (i >= subtrees.size())) {
                throw new IndexOutOfBoundsException();
            }
            return subtrees.get(i);
        }
        public int getSubtreesSize() {
            return subtrees.size();
        }
    }

    
    
    // Atributos da classe GeneralTreeOfInteger
    private Node root;
    private int count;

    
    
    // Metodos da classe GeneralTreeOfInteger
    
    /**
     * Metodo construtor.
     */
    public GeneralTreeOfInteger() {
        root = null;
        count = 0;
    }
    
    /**
     * Retorna o numero total de elementos da arvore.
     * @return count
     */
    public int size() {
        return count;
    }
    
    // Procura por "elem" a partir de "n" seguindo um
    // caminhamento pre-fixado. Retorna a referencia
    // para o nodo no qual "elem" esta armazenado.
    // Se não encontrar "elem", ele retorna NULL.
    private Node searchNodeRef(Integer elem, Node n) {
        Node aux = null;
        
        if (n != null) { 
            // Visita a raiz
            if (n.element.equals(elem)) { // se achou elem
                return n; // retorna a referencia para o nodo onde ele esta
            }
            else { // Visita os filhos
                for (int i=0; i<n.getSubtreesSize(); i++) {
                    aux = searchNodeRef(elem,n.getSubtree(i));
                    if (aux != null)
                        return aux;
                }
            }
        }
        
        return null;
    }
    
    
    /**
     * Adiciona elem como filho de father
     * @param elem elemento a ser adicionado na arvore.
     * @param father pai do elemento a ser adicionado.
     * @return true se encontrou father e adicionou elem na arvore, 
     * false caso contrario.
     */
    public boolean add(Integer elem, Integer father) {
        // Primeiro cria o nodo
        Node n = new Node(elem);
       
        if (father == null) { // Se insercao na raiz
            if (root == null) { // se arvore vazia 
                root = n;
                count++;
                return true;
            }
            else { // se arvore nao vazia
                 root.father = n;
                 n.addSubtree(root);
                 root = n;
                 count++;
                 return true;
            }
        }
        else { // procura pelo father
            Node refNodoPai = searchNodeRef(father,root); // procura por father a partir de root
            if (refNodoPai != null) { // se achou o pai
                refNodoPai.addSubtree(n);
                n.father = refNodoPai;
                count++;
                return true;
            }
        }
        
        return false;
    }
    

    /**
     * Verifica se elem esta ou não na arvore.
     * @param elem a ser procurado.
     * @return true se achar elem, e false caso contrario.
     */
    public boolean contains (Integer elem) {
        Node aux = searchNodeRef(elem,root);
        if (aux == null)
            return false;
        else
            return true;
    }
    
    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento em largura.
     * @return lista com os elementos da arvore na ordem do caminhamento em largura
     */
    public LinkedList<Integer> positionsWidth() {
        LinkedList<Integer> lista = new LinkedList<>();
        
        if (root != null) {
            Queue<Node> fila = new Queue<>();
            fila.enqueue(root);
            while (!fila.isEmpty()) { // enquanto a fila nao estiver vazia
                Node aux = fila.dequeue();
                lista.add(aux.element); // "visita a raiz"
                for (int i=0; i<aux.getSubtreesSize(); i++) { // coloca cada nodo filho na fila
                    fila.enqueue(aux.getSubtree(i));
                }
            }
        }
                    
        return lista;
    }    
    

    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento pre-fixado.
     * @return lista com os elementos da arvore na ordem do caminhamento pre-fixado
     */    
    public LinkedList<Integer> positionsPre() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPreAux(root,lista);        
        return lista;
    }  
    private void positionsPreAux(Node n, LinkedList<Integer> lista) {
        if (n != null) {
            // Visita a raiz
            lista.add(n.element);
            
            // Visita os filhos
            for(int i=0; i<n.getSubtreesSize(); i++) {
                positionsPreAux(n.getSubtree(i),lista);
            }
        } 
    }


    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento pos-fixado.
     * @return lista com os elementos da arvore na ordem do caminhamento pos-fixado
     */     
    public LinkedList<Integer> positionsPos() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPosAux(root,lista);
        return lista;
    }  
    
    private void positionsPosAux(Node n, LinkedList<Integer> lista) {
        if (n != null) {
            // Visita os filhos
            for(int i=0; i<n.getSubtreesSize(); i++) {
                positionsPosAux(n.getSubtree(i),lista);
            }
            
            // Visita a raiz
            lista.add(n.element);
        } 
    }    
    

    /**
     * Retorna em que nivel em que elem esta armazenado. 
     * @param element a ser buscado
     * @return nivel no qual element esta, ou -1 se 
     * nao encontrou element.
     */
    public int level(Integer element) {
        // IMPLEMENTE ESTE METODO !!
        return 0;
       
    }     
    
    
    /**
     * Remove o galho da arvore que tem element na raiz. A 
     * remocao inclui o nodo que contem "element".
     * @param element elemento que sera removido junto com sua 
     * subarvore.
     * @return true se achou element e removeu o galho, false 
     * caso contrario.
     */
    public boolean removeBranch(Integer element) { 
        if ( root != null ) {
            if (root.element.equals(element)) { // element esta na raiz, arvore fica vazia
                root = null;
                count = 0;
                return true;
            }
            else {
                Node aux = searchNodeRef(element,root);
                if (aux == null) // se não achou
                    return false;
                int c = countNodes(aux);
                count = count - c; // atualiza count
                Node pai = aux.father;
                pai.removeSubtree(aux);
                return true;
            }
        }
        return false;
        
    }

    // Conta o numero de nodos da subarvore cuja raiz eh passada por parametro
    private int countNodes(Node n) {
        if (n == null)
            return 0;
        int c = 0;
        for (int i=0; i<n.getSubtreesSize(); i++) {
            c = c + countNodes(n.getSubtree(i));
        }
        
        return c + 1;
    }    
    
    
    ///////////////////////////////////////////
    // Codigos abaixo geram saida para GraphViz
    
    public void geraNodosDOT(Node n)
    {
        System.out.println("node [shape = circle];\n");
        
        LinkedList<Integer> L = new LinkedList<>();
        L = positionsWidth();

        for (int i = 0; i< L.size(); i++ )
        {
            // node1 [label = "1"]
            System.out.println("node" + L.get(i) + " [label = \"" +  L.get(i) + "\"]") ;
        }
    }

    public void geraConexoesDOT(Node n)
    {
        for (int i=0; i<n.getSubtreesSize(); i++)
        {
            Node aux = n.getSubtree(i);
            System.out.println("node" + n.element + " -> " + "node" + aux.element + ";");
            geraConexoesDOT(aux);
        }
    }
    
    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public void geraDOT()
    {
        if (root != null) {
            System.out.println("digraph g { \n");
            // node [style=filled];

            geraNodosDOT(root);

            geraConexoesDOT(root);
            System.out.println("}\n");
        }
    }    
}
