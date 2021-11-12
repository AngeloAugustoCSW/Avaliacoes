/*
    ADD 
     3 
    PROMOS
*/
import java.util.ArrayList;
import java.util.Objects;

public class Mercado extends Estabelecimento{
    private String promo;
    private ArrayList<Receita> receitas = new ArrayList<>();
    public Mercado(String id, String nome, String dtAbertura, 
                   String promo, String cep, String rua, String numero, 
                   String bairro, String cidade){
        super(id, nome, dtAbertura, cep, rua, numero, bairro, cidade);
        this.promo = promo;
    }
    public void addReceita(Receita receita) {
        this.receitas.add(receita);
        receita.addMercados(this);
    }
    public void setReceita(Receita receita) {
        this.receitas.add(receita);
    }

    public ArrayList<Receita> getReceitas() {
        return this.receitas;
    }
    public void setPromo (String promo) {
        this.promo = promo;
    }

    public String getPromo(){
        return this.promo;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Mercado)) {
            return false;
        }
        Mercado mercado = (Mercado) obj;
        return Objects.equals(this.getId(), mercado.getId());
    }

    @Override
    public String toString(){
        return "ID: " + getId() +"\n"
        + "Nome: " + getNome() +"\n"
        + "Data de abertura: " + getDtAbertura() +"\n"
        + "Endereço: " + getEndereco()+"\n"
        + "Promoção: " + getPromo() 
        ;
    }
    public String dadosMercado(){
        String ret = super.dadosEstabelecimento() +"\n"
        + "Promoção: " + getPromo() +"\n";
        return ret;
    }
}
