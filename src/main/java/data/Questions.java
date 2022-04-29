package data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="kysymykset")
public class Questions implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kysymys_id;
    private String kysymys;
    public Questions(String kysymys_id, String kysymys) {
        // TODO Auto-generated constructor stub
        setKysymys_id(kysymys_id);
        this.kysymys=kysymys;


    }
    public Questions() {
        // TODO Auto-generated constructor stub
    }
    public int getKysymys_id() {
        return kysymys_id;
    }
    public void setKysymys_id(int kysymys_id) {
        this.kysymys_id = kysymys_id;
    }
    public void setKysymys_id(String kysymys_id) {
        try {
            this.kysymys_id = Integer.parseInt(kysymys_id);
        }
        catch(NumberFormatException | NullPointerException e) {
            //Do nothing - the value of id won't be changed
        }
    }
    public String getKysymys() {
        return kysymys;
    }
    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

}