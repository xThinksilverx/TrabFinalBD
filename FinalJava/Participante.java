public class Participante extends Pessoa {
    private String telefone;
    private Notificacao notificacao;

    public Participante(int id, String nome, String telefone, Notificacao notificacao) {
        super(id, nome);
        this.telefone = telefone;
        this.notificacao = notificacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }
}
