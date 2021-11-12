import java.util.ArrayList;
import java.util.Objects;

public class Padaria extends Estabelecimento{

    private String horario;
    private ArrayList<Receita> receitas = new ArrayList<>();
    public Padaria(String id, String nome, String dtAbertura, 
                   String horario, String cep, String rua, String numero, String bairro, String cidade){
        super(id, nome, dtAbertura, cep, rua, numero, bairro, cidade);
        this.horario = horario;
    }

    public void addReceita(Receita receita) {
        this.receitas.add(receita);
        receita.addPadarias(this);
    }
    public void setReceita(Receita receita) {
        this.receitas.add(receita);
    }
    public ArrayList<Receita> getReceitas() {
        return this.receitas;
    }
    public void setHorario (String horario){
        this.horario = horario;
    }
    
    public String getHorario (){
        return this.horario;
    }
    public ArrayList<Receita> getReceita() {
        return this.receitas;
    }
  

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Padaria)) {
            return false;
        }
        Estabelecimento padaria = (Estabelecimento) obj;
        return Objects.equals(this.getId(), padaria.getId());
    }
    @Override
    public String toString(){
        return "ID: " + getId() +"\n"
        + "Nome: " + getNome() +"\n"
        + "Data de abertura: " + getDtAbertura() +"\n"
        + "Horario: " + getHorario() + "\n"
        + "Endereço: " + getEndereco()
        + "---------Receitas da Padaria---------" +"\n"
        + getReceita();
    }
    public String dadosPadaria(){
        String ret = super.dadosEstabelecimento()
        + "---------Receitas da Padaria---------" +"\n"
        + getReceita();
        return ret;
    }
}
