package back;

public class Cage {
    private int id;
    private String desc;
    protected Cage(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((desc == null) ? 0 : desc.hashCode());
        result = prime * result + id;
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
        Cage other = (Cage) obj;
        if (desc == null) {
            if (other.desc != null)
                return false;
        } else if (!desc.equals(other.desc))
            return false;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Descrição da jaula= " + desc + "\n" +
               "ID= " + id;
    }
    
}
