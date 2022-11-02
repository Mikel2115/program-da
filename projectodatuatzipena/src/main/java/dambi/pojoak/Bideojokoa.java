package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre", "compañia", "plataforma"})
@XmlRootElment(name = "Bideojokoa")
public class Bideojokoa {
    
    int id = 0;
    String nombre;
    String plataforma;
    String compañia;

    
    public int getId(){
        return id;
    }

    @XmlAttribute(name = "Id")
    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    @XmlElement(name = "Nombre")
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPlat(){
        return plataforma;
    }

    @XmlElement(name = "Plataforma")
    public void setPlat(String plat){
        this.plataforma = plat;
    }

    public String getComp(){
        return compañia;
    }

    @XmlElement(name = "Compañia")
    public void setComp(String comp){
        this.compañia = comp;
    }

    @Override
    public String toString(){
        return "Bideojokoa["+ id +", "+ nombre +", "+ plataforma +", "+ compañia +"]";
    }
}
