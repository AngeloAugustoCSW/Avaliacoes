import java.util.Objects;

public class Estabelecimento {
    private String id;
    private String nome;
    private String dtAbertura;
    private Location endereco;
    protected Estabelecimento(
        String id, 
        String nome, 
        String dtAbertura, 
        String cep, 
        String rua, 
        String numero, 
        String bairro, 
        String cidade
        ){
        this.id = id;
        this.nome = nome;
        this.dtAbertura = dtAbertura;
        this.endereco = new Location(
            id,
            cep,
            rua,
            numero,
            bairro,
            cidade,
            this
            );
    } 
    public void setId(String id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDtAbertura(String dtAbertura){
        this.dtAbertura = dtAbertura;
    }
    public void setEndereco(Location endereco){
        this.endereco = endereco;
    }
    public String getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getDtAbertura(){
        return this.dtAbertura;
    }
    public Location getEndereco(){
        return endereco;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Estabelecimento)) {
            return false;
        }
        Estabelecimento estabelecimento = (Estabelecimento) obj;
        return Objects.equals(id, estabelecimento.id);
    }
    @Override
    public String toString(){
        return "ID: " + getId() +"\n"
        + "Nome: " + getNome() +"\n"
        + "Data de abertura: " + getDtAbertura() +"\n"
        ;
    }
    public String dadosEstabelecimento(){
        return "ID: " + getId() +"\n"
        + "Nome: " + getNome() +"\n"
        + "Data de abertura: " + getDtAbertura() +"\n";
    }
}
