package back;

import java.util.ArrayList;

public class Leao extends Animal{
    private int qtdDiet;
    private int guest;
    private Cage cage;
    ArrayList<Diet> DietList = new ArrayList<>();
    public Leao(int id, String nome, int qtdDiet, int guest, String desc) {
        super(id, nome);
        this.qtdDiet = qtdDiet;
        this.guest = guest;
        this.cage = new Cage(
            id,
            desc
        );
    }
    
    public int getDiet() {
        return qtdDiet;
    }
    public void setDiet(int qtdDiet) {
        this.qtdDiet = qtdDiet;
    }
    public int getGuest() {
        return guest;
    }
    public void setGuest(int guest) {
        this.guest = guest;
    }
    public void addDietList(Diet  Diet){
        this.DietList.add(Diet);
    }
    public void setDietList(Diet Diet){
        this.DietList.add(Diet);
    }
    public ArrayList<Diet> getDietList(Diet Diet){
        return this.DietList;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + qtdDiet;
        result = prime * result + guest;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Leao other = (Leao) obj;
        if (qtdDiet != other.qtdDiet)
            return false;
        if (guest != other.guest)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Nome= " + super.getNome() +"\n" +
               "ID= " + super.getId() +
               "Descrição da jaula= " + cage.getDesc() +"\n" +  
               "Horario de alimentação= " + getDiet() +"\n" +  
               "Quantidade de visitantes= " + getGuest() +"\n" +   
               "Lista de alimentação=" + DietList +"\n";
    }
    
}
