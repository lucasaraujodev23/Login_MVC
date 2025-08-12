package android.lucasaraujo.loginmvc.datamodel;

public class UsuarioDataModel {
    public static final String TABELA = "usuarios";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";

    public static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela += "CREATE TABLE " + TABELA + "(";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME + " text, ";
        queryCriarTabela += EMAIL + " texx ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }
}
