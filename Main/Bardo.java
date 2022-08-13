package Practica6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jorge.
 * Esta es la subclase Bardo que hereda de Personaje e inicializa los atributos de un Personaje.
 * @version 1.0.
 */

public class Bardo extends Personaje{
    
/**
 * Este es un constructor por defecto de un Bardo. Inicializa todos sus atributos a sus valores predeterminados excepto el Nombre y la Raza.
 */
    public Bardo(){
        setNombre("");
        setRaza("");
        setNivel(1);
        setVida((int)(100*1.1));
        setAtaque((int)(10*0.9));
        setAgilidad((int)(10*1.5));
        setArmadura((int)(30*0.9));
        setResistenciaMagica((int)(30*0.9));
        Estado=false;
    }
    
/**
 * Este es un constructor con par?metros, los cuales, inicializan solo: El Nombre, Raza y Nivel. Ya que el resto de sus atributos siempre deben partir de sus valores predeterminados.
 * @param no Recibe un atributo de tipo String que inicializar? el Nombre si lo verifica el Setter dise?ado para ello.
 * @param ra Recibe un atributo de tipo String que inicializar? la Raza si lo verifica el Setter dise?ado para ello.
 * @param ni Recibe un atributo de tipo int que inicializar? el Nivel usando el Setter dise?ado para ello.
 */
    public Bardo(String no, String ra, int ni){
        setNombre(no);
        setRaza(ra);
        setNivel(0);
        setVida((int)(100*1.1));
        setAtaque((int)(10*0.9));
        setAgilidad((int)(10*1.5));
        setArmadura((int)(30*0.9));
        setResistenciaMagica((int)(30*0.9));
        for(int i=0; i<ni; i++){
            subeNivel();
        }
        Estado=true;
    }
    
    public Bardo(String ruta){
        try{
            FileReader fr=new FileReader(ruta);
            BufferedReader br=new BufferedReader(fr);
            String linea="";
            String [] array=new String [2];
            
            br.readLine();
            br.readLine();

            br.readLine();
            array=linea.split(":");
            setNombre(array[1].trim());
            
            br.readLine();
            array=linea.split(":");
            if(array[1].trim().equals(devuelveClase())){
                
                br.readLine();
                array=linea.split(":");
                setRaza(array[1].trim());


                br.readLine();
                
                br.readLine();
                array=linea.split(":");
                setNivel(Integer.parseInt(array[1].trim()));

                br.readLine();
                array=linea.split(":");
                setVida(Integer.parseInt(array[1].trim()));

                br.readLine();
                array=linea.split(":");
                setAtaque(Integer.parseInt(array[1].trim()));

                br.readLine();
                array=linea.split(":");
                setAgilidad(Integer.parseInt(array[1].trim()));

                br.readLine();
                array=linea.split(":");
                setArmadura(Integer.parseInt(array[1].trim()));
                
                br.readLine();
                array=linea.split(":");
                setResistenciaMagica(Integer.parseInt(array[1].trim()));
                
                br.readLine();
                
                if(br.readLine().contains("Vivo")){
                    setEstado(true);
                }else{
                    setEstado(false);
                }
            }
        }catch(IOException error){
            System.err.println(error);
        }
    }
    
/**
 * Este metodo imprime por pantalla el nombre de la M?sica que tocara, dependiendo de cual se seleccione en el Switch.
 * @param m Recibe el atributo int con el que se selecciona la Musica.
 * @return Devuelve un String con el nombre de la musica seleccionada.
 */
    private String tocarMusica(int m){
        String musica="";
        
        switch(m){
            case 1:
                musica= "Sinfonia Lugubre";
            break;
            
            case 2: 
                musica= "Arenga de combate";
            break;
             
            case 3:
                musica= "Flamenco";
            break;
        }
        
        return musica;
    }

/**
 * Este metodo imprime por pantalla un String que determina un Ataque usando los Getters de Nombre y Ataque del Bardo.
 * @return Devuelve un String con la información del Ataque del Bardo.
 */
    public String luchar(){
        return "El Bardo " + getNombre() + " ataca con " + getAtaque() + " puntos de daño";
    }
    
/**
 * Esta version del metodo sobrecargado imprime por pantalla un String que determina un Ataque con su habilidad musical, usando el Getter del Nombre del Bardo junto a la M?sica que toca.
 * @param mu Recibe un atributo de tipo int que selecciona la Musica a tocar.
 * @return Devuelve un String con la información del Ataque del Bardo.
 */
    public String luchar(int mu){
        return "El Bardo " + getNombre() + " toca su musica favorita: " + tocarMusica(mu);
    }
    
/**
 * Este metodo implementado de la clase padre Persona, devuelve un atributo de tipo String.
 * @return Devuelve un String describiendo el estado del Bardo.
 */
    public String toString(){       
        if(Estado==true){
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n\n Esta actualmente: Vivo";
        }else{
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n\n Esta actualmente: Muerto";
        }
    }
    
/**
 * Este metodo esta implementado para tener informacion de la clase.
 * @return Devuelve un String con el nombre de la clase.
 */
    public String devuelveClase(){
        return "Bardo";
    }
    
}
