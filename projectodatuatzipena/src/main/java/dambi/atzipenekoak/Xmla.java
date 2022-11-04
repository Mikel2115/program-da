package dambi.atzipenekoak;

import java.io.File;

import dambi.pojoak.Bideojokoak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {
    public String strFileIn;
    public String strFileOut;

    public Xmla(String strFile){
        strFileIn = strFile;
    }

    public Xmla(String strFileIn, String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Bideojokoak irakurri(){
        Bideojokoak bideojokoak = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Bideojokoak.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            bideojokoak = (Bideojokoak) jaxbUnmarshaller.unmarshal(new File(strFileIn));
        }catch (Exception ex){
            System.out.println("Arazoren bat "+ strFileIn +" irakurtzerakoan");
        }
        return bideojokoak;
    }

    public int idatzi(Bideojokoak bideojokoak){
        int bideojokoKopurua = 0;
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Bideojokoak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(bideojokoak, new File(strFileOut));

            bideojokoKopurua = bideojokoak.getBideojokoak().size();
        }catch(JAXBException e){
            e.printStackTrace();
        }
        return bideojokoKopurua;
    }
}
