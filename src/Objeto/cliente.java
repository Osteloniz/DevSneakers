
package Objeto;

public class cliente {
    
    //atributos
    private String nome = "";
    private String cpf = "";
    private String telefone ="";
    private String sexo = "";
    private String endereco = "";
    private String cidade = "";
    private String estado = "";
    private String email = "";
    
    //GET e SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void limpaCliente(){
       nome = "";
       cpf = "";
       telefone = "";
       sexo = "";
       endereco = "";
       cidade = "";
       estado = "";
       email = "";
    }   
    
}

