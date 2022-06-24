

public class BinarySearchTreeOfInteger {

    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }


    // Atributos
    private int count; //contagem do numero de nodos
    private Node root; //referencia para o nodo raiz


    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(Integer element) {
        root =  add(root, element, null);
        count++;
    }
    private Node add(Node n, Integer element, Node father) {
        if ( n == null ) {
            Node aux = new Node(element);
            aux.father = father;
            return aux;
        }
        if (n.element.compareTo(element) < 0) {
            n.right = add(n.right, element, n);
        }
        else {
            n.left = add(n.left, element, n);
        }
        return n;
    }

    public Integer getLeft(Integer element) {
        return null;
    }

    public Integer getRight(Integer element) {
        return null;
    }

    public Integer getParent(Integer element) {
        return null;
    }

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subárvore da esquerda
            positionsPreAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res); //Visita a subárvore da esquerda
            positionsPosAux(n.right, res); //Visita a subárvore da direita
            res.add(n.element); //Visita o nodo
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subárvore da esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        LinkedListOfInteger res = new LinkedListOfInteger();
        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != null) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != null) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    public String strTraversalCentral() {
        return strTraversalCentral(root);
    }

    private String strTraversalCentral(Node n) {
        return null;
    }

    public boolean contains(Integer element) {
        Node aux = searchNodeRef(element, root);
        return (aux != null);
    }

    private Node searchNodeRef(Integer element, Node target) {
        if (target == null || element == null) {
            return null;
        }
        int c = target.element.compareTo(element);
        if (c == 0)
            return target;
        else if (c > 0)
            return searchNodeRef(element, target.left);
        else
            return searchNodeRef(element, target.right);
    }

    public boolean remove(Integer element) {
        // Se element for nulo ou arvore vazia
        if( element == null || root == null)
            return false;

        // Procura por element a partir da raiz
        Node aux = searchNodeRef(element,root);

        // Se nao achou element
        if (aux == null)
            return false;

        // Se achou, faz a remocao
        remove(aux);
        count--;
        return true;
    }

    // Faz a remocao do nodo recebido por parametro.
    private void remove(Node n) {
        // Guarda quem eh o pai de n
        Node pai = n.father;

        // Se remocao de nodo folha
        if (n.left==null && n.right==null) {
            if (n == root) { // se tem apenas um elemento na arvore
                root = null;
            }
            else {
                if (pai.left == n)
                    pai.left = null;
                else
                    pai.right = null;
            }
        }
        // Se remocao de nodo com dois filhos
        else if (n.left!=null && n.right!=null) {
            // Pega a referencia para o nodo que contem
            // o menor elemento da subarvore da direita
            Node menor = smallest(n.right);
            // Copia o menor elemento para o nodo "n"
            n.element = menor.element;
            // Chama o metodo para remover o nodo
            remove(menor);
        }
        // Se remocao de um nodo com um unico filho a direita
        else if (n.left == null) {
            if (n == root) { // se remocao da raiz
                root = n.right;
                root.father = null;
            }
            else {
                if (pai.left == n) // Se for um filho a esq do pai
                    pai.left = n.right;
                else
                    pai.right = n.right;
            }
            n.right.father = pai;
        }
        // Se remocao de um nodo com um unico filho a esquerda
        else {
            if (n == root) { // se remocao da raiz
                root = n.left;
                root.father = null;
            }
            else {
                if (pai.left == n)
                    pai.left = n.left;
                else
                    pai.right = n.left;
            }
            n.left.father = pai;
        }
    }

    // Procura pelo menor elemento a partir do nodo
    // "n" recebido por parametro. Quando encontrar,
    // retorna a referencia para ele.
    private Node smallest(Node n) {
        if (n == null)
            return null;
        if (n.left == null) // se nao tem elemento a esquerda
            return n;
        return smallest(n.left);
    }

    /**
     * Retorna o maior elemento da arvore.
     * @return maior elemento
     */
    public Integer getBiggest() {
        return null;
    }

    public Integer set(Integer old, Integer element) {
        // Procurar por "old". Se encontrar, remover
        // old e inserir element, para manter as
        // propriedades da ABP.
        return null;
    }

    public boolean isExternal(int element) {
        return false;
    }

    public boolean isInternal(int element) {
        return false;
    }

    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }

}
