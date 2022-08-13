package Practica6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jorge.
 * Esta es la subclase Paladin que hereda de Zelote e inicializa los atributos de un Zelote.
 * @version 1.0.
 */

public class Paladin extends Zelote{

/**
 * Este es un constructor por defecto de un Paladin. Inicializa todos sus atributos a su valor base excepto el Nombre y la Raza.
 */
    public Paladin(){
        setNombre("");
        setRaza("");
        setNivel(1);
        setVida((int)(100*1.3));
        setAtaque((int)(10*1.1));
        setAgilidad((int)(10*0.6));
        setArmadura((int)(30*1.3));
        setResistenciaMagica(30);
        setFe((int)(10*1.1));
        Estado=false;
    }
    
/**
 * Este es un constructor con parametros, los cuales, inicializan solo: El Nombre, Raza y Nivel. Ya que el resto de sus atributos siempre deben partir de su valor base.
 * @param no Recibe un atributo de tipo String que inicializara el Nombre si lo verifica el Setter disenado para ello.
 * @param ra Recibe un atributo de tipo String que inicializara la Raza si lo verifica el Setter disenado para ello.
 * @param ni Recibe un atributo de tipo int que inicializara el Nivel usando el Setter disenado para ello.
 */
    public Paladin(String no, String ra, int ni){
        setNombre("");
        setRaza("");
        setNivel(0);
        setVida((int)(100*1.3));
        setAtaque((int)(10*1.1));
        setAgilidad((int)(10*0.6));
        setArmadura((int)(30*1.3));
        setResistenciaMagica(30);
        setFe((int)(10*1.1));
        for(int i=0; i<ni; i++){
            subeNivel();
        }
        Estado=true;
    }
    
    public Paladin(String ruta){
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
                array=linea.split(":");
                setFe(Integer.parseInt(array[1].trim()));
                
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
 * Este metodo devuelve un String el nombre de un Milagro a rezar, dependiendo de cual se seleccione en el Switch.
 * @param mi Recibira el atributo de tipo int con el que se seleccionara el Milagro.
 * @return Devuelve un String con el nombre del milagro seleccionado.
 */
    public String rezarMilagro(int mi) {
        String milagro="";
        
        switch(mi){
            case 1:
                milagro= "Imbuir arma";
            break;
                
            case 2:
                milagro= "Purificar no-muerto";
            break;
        }
        
        return milagro;
    }
    
/**
 * Este metodo devuelve un String que determina un Ataque usando los Getters del Nombre y Ataque del Paladin.
 * @return Devuelve un String con la informacion del ataque del Paladin.
 */
    public String luchar(){
        return "El Paladin " + getNombre() + " ataca con " + getAtaque() + " puntos de dano.";        
    }
    
/**
 * Esta version del metodo sobrecargado devuelve un String que determina un Ataque con su habilidad especial usando el Getter del Nombre del Paladin.
 * @param mi Recibe un atributo de tipo int con el que se seleccionara el Milagro a rezar.
 * @return Devuelve un String con la informacion del ataque del Paladin.
 */
    public String luchar(int mi){
        return "El Paladin " + getNombre() + " usa el milagro de " + rezarMilagro(mi);        
    }
    
/**
 * Este metodo implementado de la clase padre Persona, devuelve un atributo de tipo String.
 * @return Devuelve un String describiendo el estado del Paladin.
 */
    public String toString(){
        if(Estado==true){
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n Fe de Paladin: " + getFe() + "\n\n Esta actualmente: Vivo";
        }else{
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n Fe de Paladin: " + getFe() + "\n\n Esta actualmente: Muerto";
        }
    }
    
/**
 * Este metodo esta implementado para tener informacion de la clase.
 * @return Devuelve un String con el nombre de la clase.
 */
    public String devuelveClase(){
        return "Paladin";
    }
    
}

