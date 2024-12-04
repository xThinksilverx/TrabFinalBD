public class Organizador {
    private int id;
    private String nome;
    private String email;
    private NotificacaoEmail notificacao;

    public Organizador(int id, String nome, String email, NotificacaoEmail notificacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.notificacao = notificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotificacaoEmail getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(NotificacaoEmail notificacao) {
        this.notificacao = notificacao;
    }

    @Override
    public String toString() {
        return "Organizador [id=" + id + ", nome=" + nome + ", email=" + email + ", notificacao=" + notificacao + "]";
    }
}
