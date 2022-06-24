package umasolucao.dados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CadastroPessoasArrayList implements CadastroPessoas {
    private ArrayList<Pessoa> colecao;   // Colecao de Pessoas


    /**
     * Construtor
     */
    public CadastroPessoasArrayList() {
        colecao = new ArrayList<Pessoa>();
    }

    /**
     * Adiciona uma nova pessoa na colecao
     * @param p Pessoa a ser adicionada
     * @return true de houve insercao, false em caso contrario
     */
    public boolean adicionaPessoa(Pessoa p) {
        return colecao.add(p);
    }

    /**
     * Consulta pessoa com o nome indicado
     * @param nome nome da pessoa a ser consultada
     * @return Pessoa com o nome indicado, null em caso contrario
     */
    public Pessoa consultaPorNome(String nome) {
        for(Pessoa p : colecao) {
            if(p.getNome().equals(nome))
                return p;
        }
        return null;
    }

    /**
     * Remove pessoa com o nome indicado
     * @param nome nome da pessoa a ser removida
     * @return true se houve remocao, false em caso contrario
     */
    public boolean removePessoaPorNome(String nome) {
        Pessoa p = consultaPorNome(nome);
        if(p != null)
            return colecao.remove(p);
        return false;
    }

    /**
     * Consulta a quantidade de pessoas cadastradas
     * @return quantidade de pessoas cadastradas
     */
    public int quantidadeAtual() {
        return colecao.size();
    }

    /**
     * Remove todas as pessoas cadastradas
     */
    public void limpar() {
        colecao.clear();
    }

    /**
     * Consulta colecao de pessoas
     * @return copia da colecao de pessoas
     */
    public Pessoa[] getColecaoOrdemNome() {
        Collections.sort(colecao, new OrdemNome());
        Pessoa[] copia = new Pessoa[colecao.size()];
        copia = colecao.toArray(copia);
        return copia;
    }

    /**
     * Consulta colecao de pessoas
     * @return copia da colecao de pessoas
     */
    public Pessoa[] getColecaoOrdemNumTelefone() {
        Collections.sort(colecao, new OrdemNumTelefone());
        Pessoa[] copia = new Pessoa[colecao.size()];
        copia = colecao.toArray(copia);
        return copia;
    }

    @Override
    public Pessoa[] getColecao() {
        Pessoa[] copia = new Pessoa[colecao.size()];
        copia = colecao.toArray(copia);
        return copia;
    }

}
