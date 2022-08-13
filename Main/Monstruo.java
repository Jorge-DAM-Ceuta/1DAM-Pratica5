package Practica6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jorge.
 * Esta es la subclase Monstruo que hereda de Personaje e inicializa los atributos de un Personaje.
 * @version 1.0.
 */

public class Monstruo extends Personaje{

/**
 * Este es un constructor por defecto de un Monstruo. Inicializa todos sus atributos a su valor base excepto el Nombre y la Raza.
 */
    public Monstruo(){
        setNombre("");
        setRaza("");
        setNivel(1);
        setVida(100);
        setAtaque(10);
        setAgilidad(10);
        setArmadura(30);
        setResistenciaMagica(30);
        Estado=false;
    }
    
/**
 * Este es un constructor con parametros, los cuales, inicializan solo: El Nombre, Raza y Nivel. Ya que el resto de sus atributos siempre deben partir de su valor base.
 * @param no Recibe un atributo de tipo String que inicializara el Nombre si lo verifica el Setter disenado para ello.
 * @param ra Recibe un atributo de tipo String que inicializara la Raza si lo verifica el Setter disenado para ello.
 * @param ni Recibe un atributo de tipo int que inicializara el Nivel usando el Setter disenado para ello.
 */
    public Monstruo(String no, String ra, int ni){
        setNombre(no);
        setRaza(ra);
        setNivel(0);
        for(int i=0; i<ni; i++){
            subeNivel();
        }
        Estado=true;
    }
    
    public Monstruo(String ruta){
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
 * Este metodo comprueba que se cumpla la condicion para que la Raza del Monstruo sea valida.
 * @param ra Recibe un atributo de tipo String que contendra la Raza del Monstruo.
 */
    public void setRaza(String ra){
        switch(ra){
            
            case "Bestia":
                setAtaque((int)(10*1.2));
                setAgilidad((int)(10*1.2));
                setVida((int)(100*1.1));
                setArmadura((int)(30*0.9));
                setResistenciaMagica((int)(30*0.9));
                Raza=ra;
                Estado=true;
                break;
            
            case "No-Muerto":
                setResistenciaMagica((int)(30*1.3));
                setAtaque((int)(10*1.1));
                setVida((int)(100*0.8));
                setArmadura((int)(30*0.9));
                setAgilidad((10*1));
                Raza=ra;
                Estado=true;
                break;
                
            case "Gigante":
                setVida((int)(100*1.4));
                setAtaque((int)(10*1.4));
                setArmadura((int)(30*1.4));
                setAgilidad((int)(10/1.2));
                setResistenciaMagica((int)(30/1.2));
                Raza=ra;
                Estado=true;
                break;
        }
    }

/**
 * Este metodo implementado de la clase padre Persona, devuelve un atributo de tipo String.
 * @return Devuelve un String describiendo el estado del Monstruo.
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
        return "Monstruo";
    }
    
}

