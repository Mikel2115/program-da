package dambi.mainklaseak;

import java.util.Scanner;
import dambi.pojoak.Bideojokoa;
import dambi.pojoak.Bideojokoak;
import dambi.atzipenekoak.Csva;

public class Gogokoena {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Bideojokoak bideojokoak = new Bideojokoak();
        Csva csva = new Csva("data/Bideojokoak.csv");
        int total_bideojuego = 0;
        int rangoa = 0;
        
        System.out.print("Zein da zure bideojoko gogokoena? ");
        String titulo = sc.nextLine();
        sc.close();
        bideojokoak = csva.irakurri();
        if(bideojokoak != null){
            for(Bideojokoa b : bideojokoak.getBideojokoak()){
                if(b.getTitulo().equals(titulo)){
                    rangoa = b.getRango();
                    total_bideojuego++;
                }
            }
            if(total_bideojuego == 0){
                System.out.println("Ez da oso famatua bidejoko hori.");
            }else{
                System.out.println("Zure bideojokorik gogokoena "+rangoa+" salduena da.");
            }
        }
    }
}
