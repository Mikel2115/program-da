package dambi.atzipenekoak;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Bideojokoa;
import dambi.pojoak.Bideojokoak;

public class Jsona {
    public String strFileIn;
    public String strFileOut;

    public Jsona(String strFile){
        strFileIn = strFile;
    }

    public Jsona(String strFileIn, String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Bideojokoak irakurri(){
        Bideojokoak bideojokoak = null;
        try{
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            bideojokoak = new Bideojokoak();
            for(int i = 0; i < jsonarray.size(); i++  ){
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Bideojokoa bideojokoa = new Bideojokoa();
                bideojokoa.setId(jsonobj.getInt("id"));
                bideojokoa.setRango(jsonobj.getInt("Rango"));
                bideojokoa.setTitulo(jsonobj.getString("titulo"));
                bideojokoa.setVenta(jsonobj.getInt("Ventas"));
                bideojokoa.setSeries(jsonobj.getString("Series"));
                bideojokoa.setPlat(jsonobj.getString("Plataforma"));
                bideojokoa.setFechaSalida(jsonobj.getString("Fecha de salida"));
                bideojokoa.setDesarrollador(jsonobj.getString("Desarrollador"));
                bideojokoa.setPublicador(jsonobj.getString("Publicador"));
                bideojokoak.add(bideojokoa);
            }
        }catch(Exception e){
            System.out.println("Arazoak "+strFileIn+" fitxategiakin irakurtzeko");
        }
        return bideojokoak;
    }

    public int idatzi(Bideojokoak bideojokoak){
        int bideojokoKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Bideojokoa b : bideojokoak.getBideojokoak()){
            jab.add(Json.createObjectBuilder()
                    .add("id", b.getId())
                    .add("Rango", b.getRango())
                    .add("Titulo", b.getTitulo())
                    .add("Venta", b.getVenta())
                    .add("Serie", b.getSeries())
                    .add("Plataforma", b.getPlat())
                    .add("Fecha de salida", b.getFechaSalida())
                    .add("Desarrollador", b.getDesarrollador())
                    .add("Publicador", b.getPublicador())
                    .build());
            bideojokoKopurua++;
        }
        model = jab.build();
        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }

        return bideojokoKopurua;
    }
}
