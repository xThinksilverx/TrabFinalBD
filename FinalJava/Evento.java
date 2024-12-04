import java.sql.Date;

public class Evento {
    private int id;
    private Organizador organizador;
    private Local local;
    private Date data;
    private String descricao;
    private int quantidadePessoas;

    public Evento(int id, Organizador organizador, Local local, Date data, String descricao, int quantidadePessoas) {
        this.id = id;
        this.organizador = organizador;
        this.local = local;
        this.data = data;
        this.descricao = descricao;
        this.quantidadePessoas = quantidadePessoas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    @Override
    public String toString() {
        return "Evento: " + descricao + ", Local: " + local.getNome() + ", Data: " + data.toString();
    }
}
