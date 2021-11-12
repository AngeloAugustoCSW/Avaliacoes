import java.util.Objects;
public class Person {
    private String id;
    private String nome;
    private String cpf;
    private String dtNasc;
    protected Person(String id, String nome, String cpf, String dtNasc){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    public void setDtNasc(String dtNasc){
        this.dtNasc = dtNasc;
    }
    public String getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCPF(){
        return this.cpf;
    }
    public String getDtNasc(){
        return this.dtNasc;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return Objects.equals(cpf, person.cpf);
    }
    @Override
    public String toString(){
        return "ID: " + getId() +"\n"
        + "Nome: " + getNome() +"\n"
        + "CPF: " + getCPF() +"\n"
        + "Data de nascimento: " + getDtNasc() +"\n";
    }
    public String dadosPerson(){
        return "ID: " + getId() +"\n"
        + "Nome: " + getNome() +"\n"
        + "CPF: " + getCPF() +"\n"
        + "Data de nascimento: " + getDtNasc() +"\n";
    }

}
