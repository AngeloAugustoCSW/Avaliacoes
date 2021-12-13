package back;
import java.sql.Date;
public class Training{
    private int idTrain;
    private String details;
    private Date date;
    private Golfinho golfinho;
    public Training(int idTrain, String details, Date date, Golfinho golfinho){
        this.idTrain = idTrain;
        this.details = details;
        this.date = date;
        this.golfinho = golfinho;
        golfinho.addTrainList(this);
    }
    public int getIdTrain() {
        return idTrain;
    }
    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((details == null) ? 0 : details.hashCode());
        result = prime * result + idTrain;
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
        Training other = (Training) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (details == null) {
            if (other.details != null)
                return false;
        } else if (!details.equals(other.details))
            return false;
        if (idTrain != other.idTrain)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Dia do treinamento= " + date +"\n" + 
               "Detalhes do treinamento= " + details +"\n" + 
               "Golfinho= " + golfinho.getNome() +"\n" + 
               "ID do treinamento= " + idTrain +"\n";
    }
}