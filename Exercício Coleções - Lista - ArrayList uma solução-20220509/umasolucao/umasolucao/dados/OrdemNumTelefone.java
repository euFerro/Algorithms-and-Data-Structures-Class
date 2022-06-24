package umasolucao.dados;

import java.util.Comparator;



public class OrdemNumTelefone implements Comparator {
    
    @Override
    public int compare(Object o1, Object o2) {
        if (((Pessoa)o1).getTelefone() < ((Pessoa)o2).getTelefone())
            return -1;
        else if (((Pessoa)o1).getTelefone() > ((Pessoa)o2).getTelefone())
            return 1;
        return 0;
    }
    

}
