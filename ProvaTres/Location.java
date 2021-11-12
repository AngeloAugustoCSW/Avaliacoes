import java.util.Objects;

public class Location {
    private String id;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private Estabelecimento estabelecimento;
    
    public Location(
       String id,
       String cep,
       String rua,
       String numero,
       String bairro,
       String cidade, 
       Estabelecimento estabelecimento
     ) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estabelecimento = estabelecimento;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setCep(String cep){
        this.cep = cep;
    }
    public void setRua(String rua){
        this.rua = rua;
    }
    public void setNum(String numero){
        this.numero = numero;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public void setEstabelecimento(Estabelecimento estabelecimento){
        this.estabelecimento = estabelecimento;
    }
    public String getId(){
        return id;
    }
    public String getCep(){
        return cep;
    }
    public String getRua(){
        return rua;
    }
    public String getNum(){
        return numero;
    }
    public String getBairro(){
        return bairro;
    }
    public String getCidade(){
        return cidade;
    }
    public Estabelecimento getEstabelecimento(){
        return estabelecimento;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
        return Objects.equals(this.getId(), location.getId());
    }

    @Override
    public String toString(){
		return "ID: " + getId() + "\n"
            + "Cep: " + getCep() + "\n"
            + "Rua: " + getRua() + "\n"
            + "Numero " + getNum() +  "\n"
            + "bairro: " + getBairro() + "\n"
            + "cidade: " + getCidade() + "\n";
    }
    public String dadosEndereco(){
		return "ID: " + getId() + "\n"
            + "Cep: " + getCep() + "\n"
            + "Rua: " + getRua() + "\n"
            + "Numero " + getNum() +  "\n"
            + "bairro: " + getBairro() + "\n"
            + "cidade: " + getCidade() + "\n";
    }
}
