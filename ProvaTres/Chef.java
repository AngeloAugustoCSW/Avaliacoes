import java.util.ArrayList;
import java.util.Objects;

public class Chef extends Person {
    /*
    id
    nome
    cpf
    dtNasc
    */
    private String speciality;
    ArrayList<Receita> receitas = new ArrayList<>();
    public Chef(
        String id,
        String nome,
        String cpf,
        String dtNasc,
        String speciality
    ){
        super(id,nome,cpf,dtNasc);
        this.speciality = speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void addReceitas(Receita receita) {
        this.receitas.add(receita);
    }
    public void setReceita(Receita receita) {
        this.receitas.add(receita);
    }

    public ArrayList<Receita> getReceita() {
        return this.receitas;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Chef)) {
            return false;
        }
        Chef chef = (Chef) obj;
        return Objects.equals(this.getCPF(), chef.getCPF());
    }
    @Override
    public String toString(){
        return "ID: " + getId() +"\n"
        + "Nome: " + getNome() +"\n"
        + "CPF: " + getCPF() +"\n"
        + "Data de nascimento: " + getDtNasc() +"\n"
        + "Especialidade: " + getSpeciality() +"\n"
        + "---------Receitas do Chef---------" +"\n"
        + getReceita()+"\n";
    }

}
