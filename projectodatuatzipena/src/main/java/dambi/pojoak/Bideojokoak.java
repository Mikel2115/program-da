package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bideojokoak")
public class Bideojokoak {
    
    List<Bideojokoa> bideojokoak;

    public List<Bideojokoa> getBideojokoak(){
        return bideojokoak;
    }
    @XmlElement(name ="Bideojokoa")
    public void setBideojokoak(List<Bideojokoa> bideojokoak){
        this.bideojokoak = bideojokoak;
    }

    public void add(Bideojokoa bideojokoa){
        if(this.bideojokoak == null){
            this.bideojokoak = new ArrayList<Bideojokoa>();
        }
        this.bideojokoak.add(bideojokoa);
    }

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        for(Bideojokoa b : this.bideojokoak){
            str.append(b.toString());
            str.append("\n");
        }
        return str.toString();
    }
}
