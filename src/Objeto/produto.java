package Objeto;
public class produto {
     //atributos
    private String codigo = "";
    private String marca = "";
    private String tamanho ="";
    private String modelo = "";
    private String cor = "";
    private String quantidade = "";
    private String preco = "";
    private String filtro = "";
    private String pesquisa = "";
    
    //GET e SET
    public String getcodigo() {
        return codigo;
    }

    public String getmarca() {
        return marca;
    }

    public String gettamanho() {
        return tamanho;
    }

    public String getmodelo() {
        return modelo;
    }
    
    public String getcor() {
        return cor;
    }
    public String getquantidade(){
        return quantidade;
    }
     public String getpreco(){
        return preco;
    }
     public String getfiltro() {
        return filtro;
    }
    public String getpesquisa(){
        return pesquisa;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setmarca(String marca) {
        this.marca = marca;
   // public String setmarca() {
   //    return marca;
    }
    public void settamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }

    public void setcor(String cor) {
        this.cor = cor;
    }
    public void setquantidade(String quantidade){
        this.quantidade = quantidade; 
    }
    public void setpreco(String preco){
        this.preco = preco; 
    }
     public void setfiltro(String filtro) {
        this.filtro = filtro;
    }
    public void setpesquisa(String pesquisa){
        this.pesquisa = pesquisa;
    }
    public void limpaProduto(){
       codigo = "";
       marca = "";
       tamanho = "";
       modelo = "";
       cor = "";
       quantidade = "";
       preco = "";
    }   
    
}


