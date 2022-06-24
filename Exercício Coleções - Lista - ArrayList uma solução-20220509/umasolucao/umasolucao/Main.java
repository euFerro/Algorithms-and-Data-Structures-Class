package umasolucao;

import umasolucao.dados.*;
import umasolucao.ui.Agenda;

public class Main {

    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoasArrayList();
        Agenda agenda = new Agenda(cadastro);
        agenda.executa();
    }

}
