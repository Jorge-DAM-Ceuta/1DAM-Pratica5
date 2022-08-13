package Practica6;

import static Practica6.GameLogger.ejercicio8;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        //Combate a=new Combate();
        Personaje jorge, ismael;
        jorge=new Monstruo("ElPiezass", "Americana", 12);
        ismael=new Mago("Bravis", "Arabica", 15);
        
        //System.out.println(a.combatir(jorge, ismael));
        

        /*Mago a=new Mago("Beavis", "Judio", 1);
        GameLogger.emiteFicheroPersonaje("/home/jorge/Ficha1.txt", a);*/

        //GameLogger g=new GameLogger();
        File f=new File("C:\\Users\\Propietario\\Desktop\\combate.txt");
        
        ejercicio8(f, ismael, jorge);
        
    
    }
}
    

