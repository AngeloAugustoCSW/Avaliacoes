package back;
import java.util.ArrayList;
public class Golfinho extends Animal{
    private int qtdTraining;
    private Cage cage;
    ArrayList<Training> TrainList = new ArrayList<>();
    public Golfinho(int id, String nome, int qtdTraining, String desc) {
        super(id, nome);
        this.qtdTraining = qtdTraining;
        this.cage = new Cage(
            id,
            desc
        );
    }
    public int getQtdTraining() {
        return qtdTraining;
    }
    public void setQtdTrainingg(int qtdTraining) {
        this.qtdTraining = qtdTraining;
    }
    public Cage getCage() {
        return cage;
    }
    public void setCage(Cage cage) {
        this.cage = cage;
    }
    public void addTrainList(Training training){
        this.TrainList.add(training);
    }
    public void setTrainList(Training training){
        this.TrainList.add(training);
    }
    public ArrayList<Training> getTrainList(Training training){
        return this.TrainList;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cage == null) ? 0 : cage.hashCode());
        result = prime * result + qtdTraining;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Golfinho other = (Golfinho) obj;
        if (cage == null) {
            if (other.cage != null)
                return false;
        } else if (!cage.equals(other.cage))
            return false;
        if (qtdTraining != other.qtdTraining)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Nome= " + super.getNome() +"/n" +
               "ID= " + super.getId() +"/n" +
               "Descrição da jaula= " + cage.getDesc() +"/n" +
               "Lista de treinamento= " + TrainList +"/n";
    }

}


// return "Golfinho [Nome=" + super.getNome() + ", cage=" + cage.getDesc() + ", training=" + TrainList + ", id=" + super.getId() + "]";
