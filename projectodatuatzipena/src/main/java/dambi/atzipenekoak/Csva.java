package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dambi.pojoak.Bideojokoa;
import dambi.pojoak.Bideojokoak;

public class Csva {

    public String strFileIn;
    public String strFileOut;

    public Csva(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Csva(String strFileIn, String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Bideojokoak irakurri(){
        Bideojokoak bideojokoak = null;

        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))){
            String bantzailea = ",";
            String l;
            bideojokoak = new Bideojokoak();
            while((l = inputStream.readLine()) != null){
                String[] eremuak = l.split(bantzailea);
                if (!eremuak[0].equals("ID")){
                    Bideojokoa bideojokoa = new Bideojokoa();
                    bideojokoa.setId(Integer.parseInt(eremuak[0]));
                    bideojokoa.setRango(Integer.parseInt(eremuak[1]));
                    bideojokoa.setTitulo(eremuak[2]);
                    bideojokoa.setVenta(Integer.parseInt(eremuak[3]));
                    bideojokoa.setSeries(eremuak[4]);
                    bideojokoa.setPlat(eremuak[5]);
                    bideojokoa.setFechaSalida(eremuak[6]);
                    bideojokoa.setDesarrollador(eremuak[7]);
                    bideojokoa.setPublicador(eremuak[8]);
                    bideojokoak.add(bideojokoa);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Ez da "+ strFileIn + " fitxategia aurkitu.");
        } catch (IOException e){
            System.out.println("IOsalbuespena gertatu da");
        }
        return bideojokoak;
    }

    public int idatzi(Bideojokoak bideojokoak){
        int bideojokoKopurua = 0;

        try(PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut))){
            for(Bideojokoa b : bideojokoak.getBideojokoak()){
                if (bideojokoKopurua == 0){
                    outputStream.println("ID,RANGO,TITULO,VENTAS,PLATAFORMA, FECHA DE SALIDA, DESARROLLADOR, PUBLICADOR");
                }
                bideojokoKopurua++;

                outputStream.println(b.getId()+","+b.getRango()+","+b.getTitulo()+","+b.getVenta()+","+b.getSeries()+","+b.getPlat()+","+b.getFechaSalida()+","+ b.getDesarrollador()+","+b.getPublicador());
            }
        }catch (IOException e){
            System.out.println(strFileOut + " fitxategiarekin arazoren bat egon da");
        }
        return bideojokoKopurua;
    }
}
