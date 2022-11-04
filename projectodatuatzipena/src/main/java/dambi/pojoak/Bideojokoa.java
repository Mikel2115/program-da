package dambi.pojoak;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"rango", "titulo", "venta", "series", "plataforma", "fecha_salida", "desarrollador", "publicador"})
@XmlRootElement(name = "Bideojokoa")
public class Bideojokoa {
    
    int id;
    int rango;
    String titulo;
    int venta;
    String series;
    String plataforma;
    LocalDate fecha_salida;
    String desarrollador;
    String publicador;

    
    public int getId(){
        return id;
    }

    @XmlAttribute(name = "Id")
    public void setId(int id){
        this.id = id;
    }
    
    public int getRango(){
        return rango;
    }

    @XmlElement(name = "Rango")
    public void setRango(int rango){
        this.rango = rango;
    }

    public String getTitulo(){
        return titulo;
    }

    @XmlElement(name = "Titulo")
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getVenta(){
        return venta;
    }

    @XmlElement(name = "Venta")
    public void setVenta(int venta){
        this.venta = venta;
    }

    public String getSeries(){
        return series;
    }

    @XmlElement(name = "series")
    public void setSeries(String series){
        this.series = series;
    }

    public String getPlat(){
        return plataforma;
    }

    @XmlElement(name = "Plataforma")
    public void setPlat(String plat){
        this.plataforma = plat;
    }

    public String getFechaSalida(){
        return fecha_salida.toString();
    }

    @XmlElement(name = "Fecha de Salida")
    public void setFechaSalida(String fecha){
        this.fecha_salida = LocalDate.parse(fecha);
    }

    public String getDesarrollador(){
        return desarrollador;
    }

    @XmlElement(name = "Desarrollador")
    public void setDesarrollador(String desarrollador){
        this.desarrollador = desarrollador;
    }

    public String getPublicador(){
        return publicador;
    }

    @XmlElement(name = "Publicador")
    public void setPublicador(String publicador){
        this.publicador = publicador;
    }

    @Override
    public String toString(){
        return "Bideojokoa["+ id +", "+ titulo +", "+ venta +", "+ plataforma +", "+fecha_salida +", "+ desarrollador +", "+publicador+"]";
    }
}
