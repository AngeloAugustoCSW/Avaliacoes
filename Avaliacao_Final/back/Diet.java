package back;
import java.sql.Date;
public class Diet{
    private int idDiet;
    private Date date;
    private String details;
    private Leao leao;
    public Diet(int idDiet, Date date, String details, Leao leao) {
        this.idDiet = idDiet;
        this.date = date;
        this.details = details;
        this.leao = leao;
        leao.addDietList(this);
    }
    public int getIdDiet() {
        return idDiet;
    }
    public void setIdDiet(int idDiet) {
        this.idDiet = idDiet;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((details == null) ? 0 : details.hashCode());
        result = prime * result + idDiet;
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
        Diet other = (Diet) obj;
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
        if (idDiet != other.idDiet)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Ultimo dia da alimentação= " + date +"\n"+ 
               "Detalhes da alimentação= " + details +"\n"+ 
               "Leão= " + leao.getNome() +"\n"+
               "ID da alimentação= " + idDiet +"\n";
    }
    
}
