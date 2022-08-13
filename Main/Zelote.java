package Practica6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jorge.
 * Esta es la subclase Zelote que hereda de Personaje e inicializa los atributos de un Personaje.
 * @version 1.0.
 */

public abstract class Zelote extends Personaje{
    
    private int Fe;
    
/**
 * Este es un constructor por defecto de un Zelote. Inicializa todos sus atributos a su valor base excepto el Nombre y la Raza.
 */
    public Zelote(){
        setNombre("");
        setRaza("");
        setNivel(1);
        setVida(100);
        setAtaque(10);
        setAgilidad(10);
        setArmadura(30);
        setResistenciaMagica(30);
        setFe(10);
        Estado=false;
    }
    
/**
 * Este es un constructor con parametros, los cuales, inicializan solo: El Nombre, Raza y Nivel. Ya que el resto de sus atributos siempre deben partir de su valor base.
 * @param no Recibe un atributo de tipo String que inicializara el Nombre si lo verifica el Setter diseñado para ello.
 * @param ra Recibe un atributo de tipo String que inicializara la Raza si lo verifica el Setter diseñado para ello.
 * @param ni Recibe un atributo de tipo int que inicializara el Nivel usando el Setter diseñado para ello.
 */
    public Zelote(String no, String ra, int ni){
        setNombre(no);
        setRaza(ra);
        setNivel(0);
        setVida(100);
        setAtaque(10);
        setAgilidad(10);
        setArmadura(30);
        setResistenciaMagica(30);
        setFe(10);
        for(int i=0; i<ni; i++){
            subeNivel();
        }
        Estado=true;
    }
    
    public Zelote(String ruta){
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
 * Este metodo es un Setter que inicializara la Fe del Zelote.
 * @param f Recibe un atributo de tipo int que contendra los puntos de Fe.
 */
    public void setFe(int f){
        Fe=f;
    }
    
/**
 * Este m?todo es un Getter que devuelve un atributo de tipo int.
 * @return Devuelve los puntos de Fe del Zelote. Al ser Final nunca podr? ser usado en otra clase si ha sido modificado.
 */
    public int getFe(){
        return Fe;
    }
    
/**
 * Este metodo Abstract esta destinado a usarse en subclases de Zelote.
 * @param mi Recibira el atributo de tipo int con el que se seleccionar? el Milagro.
 * @return Devuelve un String con el nombre del milagro seleccionado.
 */
    public abstract String rezarMilagro(int mi);
    
/**
 * Este metodo implementado de la clase padre Persona, devuelve un atributo de tipo String.
 * @return Devuelve un String describiendo el estado del Zelote.
 */
    public String toString(){
        if(Estado==true){
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n Fe de Zelote: " + getFe() + "\n Esta actualmente: Vivo";
        }else{
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n Fe de Zelote: " + getFe() + "\n Esta actualmente: Muerto";
        }    
    }
 
/**
 * Este metodo esta implementado para tener informacion de la clase.
 * @return Devuelve un String con el nombre de la clase.
 */
    public String devuelveClase(){
        return "Zelote";
    }
    
}

