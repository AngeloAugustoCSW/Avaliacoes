import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Person {
    private String telefone;
    private ArrayList<Receita> receitaCliente = new ArrayList<>();;
    public Cliente(
        String id, 
        String nome, 
        String cpf, 
        String dtNasc, 
        String telefone
    ){
        super(id, nome, cpf, dtNasc);
        this.telefone = telefone;
    }
    public void setPhone(String telefone){
        this.telefone = telefone;
    }
    public String getPhone(){
        return this.telefone;
    }
    public void addReceita(Receita receita) {
        this.receitaCliente.add(receita);
    }

    public void setReceita(Receita receita) {
        this.receitaCliente.add(receita);
    }

    public ArrayList<Receita> getReceita() {
        return this.receitaCliente;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) obj;
        return Objects.equals(this.getCPF(), cliente.getCPF());
    }
    @Override
    public String toString(){
        return "ID: " + getId()+"\n"
        + "Nome do cliente: " + getNome()+"\n"
        + "CPF do cliente: " + getCPF()+"\n"
        + "Data de nascimento: " + getDtNasc() +"\n"
        + "Telefone do cliente: " + getPhone() + "\n";
    }
}
