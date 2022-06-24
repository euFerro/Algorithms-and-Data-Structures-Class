package umasolucao.dados;

import java.util.Comparator;

public class OrdemNome implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (((Pessoa)o1).getNome().compareTo(((Pessoa)o2).getNome()) < 0)
            return -1;
            else if (((Pessoa)o1).getNome().compareTo(((Pessoa)o2).getNome()) > 0)
            return 1;
        return 0;
    }
    
}
