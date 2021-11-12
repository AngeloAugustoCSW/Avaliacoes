import java.util.ArrayList;

public class Receita {
    private String id;
    private String nome;
    private String etapas;
    private String numEtapas;
    private Double valor;
    private Chef chef;
    private ArrayList<Padaria> padarias = new ArrayList<>();
    private ArrayList<Mercado> mercados = new ArrayList<>();
    
    public Receita(
        String id,
        String nome,
        String etapas,
        String numEtapas,
        Double valor,
        Chef chef
    ){
        this.id = id;
        this.nome = nome;
        this.etapas = etapas;
        this.numEtapas = numEtapas;
        this.valor = valor;
        this.chef = chef;

        chef.addReceitas(this);
    }

    public void addPadarias(Padaria padarias) {
        this.padarias.add(padarias);
    }
    public void addMercados(Mercado mercados) {
        this.mercados.add(mercados);
    }
    public void setId(String id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEtapas(String etapas){
        this.etapas = etapas;
    }
    public void setNumEtapas(String numEtapas){
        this.numEtapas = numEtapas;
    }
    public void setValor(Double valor){
        this.valor = valor;
    }
    public String getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEtapas(){
        return this.etapas;
    }
    public String getNumEtapas(){
        return this.numEtapas;
    }
    public Double getValor(){
        return this.valor;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Receita)) {
            return false;
        }
        Receita receita = (Receita) obj;
        return this.getId() == receita.getId();
    }
    @Override
    public String toString(){
        return "ID: " + getId() +"\n"
        + "Nome: " + getNome() +"\n"
        + "Descrição: " + getEtapas() +"\n"
        + "Numero de etapas: " + getNumEtapas() +"\n"
        + "Valor da receita: R$" + getValor() +"\n"
        + "Chef da receita: " + chef.getNome() +"\n";
        
    }
}
