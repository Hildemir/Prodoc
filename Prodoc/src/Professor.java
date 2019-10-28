import java.util.LinkedList;

public class Professor {

    private String cpf;
    private String senha;
    private String nome;
    private String email;
    private String telefone;
    private String departamento;
    private int pontuacao;
    private LinkedList <String> especialidade;

    public Professor(String cpf, String senha, String nome, String email, String telefone, String departamento, LinkedList<String> especialidade) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.departamento = departamento;
        this.pontuacao = 0;
        this.especialidade = new LinkedList<>();
        this.especialidade = especialidade;    //se especialidade for uma lista null, this.especialidade vai referenciar a lista null na lista(especialidade) e nada muda (na teroia...)
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    public void incrementarPontuacao(int pontuacao){
        this.pontuacao = this.pontuacao + pontuacao;
    }

    public LinkedList<String> getEspecialidade() {
        return especialidade;
    }

}
