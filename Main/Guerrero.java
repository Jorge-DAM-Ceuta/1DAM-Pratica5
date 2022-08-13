package Practica6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jorge.
 * Esta es la subclase Guerrero que hereda de Personaje e inicializa los atributos de un Personaje adem?s de su Furia.
 * @version 1.0.
 */

public class Guerrero extends Personaje{
    
    private boolean Furia;
    
/**
 * Este es un constructor por defecto de un Guerrero. Inicializa todos sus atributos a su valor base excepto el Nombre y la Raza.
 */
    public Guerrero(){
        setNombre("");
        setRaza("");
        setNivel(1);
        setVida((int)(100*1.15));
        setAtaque((int)(10*1.2));
        setAgilidad(10);
        setArmadura((int)(30*1.15));
        setResistenciaMagica((int)(30*0.8));
        Furia=false;
        Estado=false;
    }
    
/**
 * Este es un constructor con par?metros, los cuales, inicializan solo: El Nombre, Raza y Nivel. Ya que el resto de sus atributos siempre deben partir de su valor base.
 * @param no Recibe un atributo de tipo String que inicializara el Nombre si lo verifica el Setter disenado para ello.
 * @param ra Recibe un atributo de tipo String que inicializara la Raza si lo verifica el Setter disenado para ello.
 * @param ni Recibe un atributo de tipo int que inicializara el Nivel usando el Setter disenado para ello.
 */
    public Guerrero(String no, String ra, int ni){
        setNombre(no);
        setRaza(ra);
        setNivel(0);
        setVida((int)(100*1.15));
        setAtaque((int)(10*1.2));
        setAgilidad(10);
        setArmadura((int)(30*1.15));
        setResistenciaMagica((int)(30*0.8));
        Furia=false;
        for(int i=0; i<ni; i++){
            subeNivel();
        }
        Estado=true;
    }
    
    public Guerrero(String ruta){
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
                
                if(br.readLine().contains("true")){
                    setFuria(true);
                }else{
                    setFuria(false);
                }
                
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
 * Este metodo es un Setter que inicializara la Furia del Guerrero.
 * @param fu Recibe un atributo de tipo boolean para activar la Furia si es verdadero.
 */
    public void setFuria(boolean fu){
        Furia=fu;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo Boolean.
 * @return Devuelve la Furia del Guerrero. Al ser Final nunca podr? ser usado en otra clase si ha sido modificado.
 */
    public final boolean getFuria(){
        return Furia;
    }
    
/**
 * Este metodo devuelve un String que determina un Ataque usando los Getters del Nombre y Ataque del Guerrero.
 */
    public String luchar(){
        if(Furia==true){
            setAtaque(this.getAtaque()*2);
            System.out.println(getNombre() + " esta furioso! Aumenta x2 los puntos de Ataque.");
            System.out.println("El Guerrero " + getNombre() + " ataca con " + getAtaque() + " puntos de daño");
        
            setAtaque(getAtaque()/2);
            
            return getNombre() + " esta furioso! Aumenta x2 los puntos de Ataque." + "\nEl Guerrero " + getNombre() + " ataca con " + getAtaque() + " puntos de daño";
        }else{
            return "El Guerrero " + getNombre() + " ataca con " + getAtaque() + " puntos de daño";
        }
    }
    
/**
 * Este metodo devuelve un String que determina una Defensa usando los Getters del Nombre, Armadura y Resistencia M?gica del Guerrero.
 */
    public String defender(){
        if(Furia==true){
            setArmadura(getArmadura()/2);
            setResistenciaMagica(getResistenciaMagica()/2);
            System.out.println(getNombre() + " esta furioso! Tiene la mitad de puntos de Armadura y Resistencia Magica");
            System.out.println("El Guerrero " + getNombre() + " tiene " + getVida() + " puntos de Vida, " + getArmadura() + " puntos de Armadura" + " y " + getResistenciaMagica() + " puntos de Resistencia Magica");        
            
            setArmadura(getArmadura()*2);
            setResistenciaMagica(getResistenciaMagica()*2);
            
            return getNombre() + " esta furioso! Tiene la mitad de puntos de Armadura y Resistencia Magica" + "\nEl Guerrero " + getNombre() + " tiene " + getArmadura() + " puntos de Armadura" + " y " + getResistenciaMagica() + " puntos de Resistencia Magica";        

        }else{
            return "El Guerrero " + getNombre() + " tiene " + getVida() + " puntos de Vida, " + getArmadura() + " puntos de Armadura" + " y " + getResistenciaMagica() + " puntos de Resistencia Magica";       
        }
    }
    
/**
 * Este metodo implementado de la clase padre Persona, devuelve un atributo de tipo String.
 * @return Devuelve un String describiendo el estado del Guerrero.
 */
    public String toString(){
        if(Estado==true){
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n Furia: " + getFuria() + "\n\n Esta actualmente: Vivo";
        }else{
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n Furia: " + getFuria() + "\n\n Esta actualmente: Muerto";
        }    
    }
    
/**
 * Este metodo esta implementado para tener informacion de la clase.
 * @return Devuelve un String con el nombre de la clase.
 */
    public String devuelveClase(){
        return "Guerrero";
    }
    
}

