package umasolucao.dados;

public interface CadastroPessoas {

    /**
     * Adiciona uma nova pessoa na colecao
     * @param p Pessoa a ser adicionada
     * @return true de houve insercao, false em caso contrario
     */
    public abstract boolean adicionaPessoa(Pessoa p);


    /**
     * Consulta pessoa com o nome indicado
     * @param nome nome da pessoa a ser consultada
     * @return Pessoa com o nome indicado, null em caso contrario
     */
    public abstract Pessoa consultaPorNome(String nome);


    /**
     * Remove pessoa com o nome indicado
     * @param nome nome da pessoa a ser removida
     * @return true se houve remocao, false em caso contrario
     */
    public abstract boolean removePessoaPorNome(String nome);


    /**
     * Consulta a quantidade de pessoas cadastradas
     * @return quantidade de pessoas cadastradas
     */
    public abstract int quantidadeAtual();


    /**
     * Remove todas as pessoas cadastradas
     */
    public abstract void limpar();


    /**
     * Consulta colecao de pessoas
     * @return copia da colecao de pessoas
     */
    public abstract Pessoa[] getColecao();


    public abstract Pessoa[] getColecaoOrdemNome();


    public abstract Pessoa[] getColecaoOrdemNumTelefone();
}
