package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Sqlite;
import dambi.pojoak.Bideojokoa;
import dambi.pojoak.Bideojokoak;

public class CsvtikSqlitera {
    public static void main(String[]args){

        Bideojokoak bideojokoak = new Bideojokoak();
        Csva csva = new Csva("data/Bideojokoak.csv");
        Sqlite sql = new Sqlite();

        bideojokoak = csva.irakurri();
        if(bideojokoak != null){
            for(Bideojokoa b : bideojokoak.getBideojokoak()){
                sql.insert(b.getId(), b.getRango(), b.getTitulo(), b.getVenta(), b.getSeries(), b.getPlat(), b.getFechaSalida(), b.getDesarrollador(), b.getPublicador());
            }
        }        
    }
}
