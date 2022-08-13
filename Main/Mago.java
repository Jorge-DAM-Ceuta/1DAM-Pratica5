package Practica6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jorge.
 * Esta es la subclase Mago que hereda de Personaje e inicializa los atributos de un Personaje adem?s de su Magia.
 * @version 1.0.
 */

public class Mago extends Personaje{
    
    private int Magia;
   
/**
 * Este es un constructor por defecto de un Mago. Inicializa todos sus atributos a su valor base excepto el Nombre y la Raza.
 */
    public Mago(){
        setNombre("");
        setRaza("");
        setNivel(1);
        setVida((int)(100*0.9));
        setAtaque((int)(10*0.7));
        setAgilidad((int)(10*1.15));
        setArmadura((int)(30*0.9));
        setResistenciaMagica((int)(30*1.6));
        Magia=10;
        Estado=false;
    }
    
/**
 * Este es un constructor con parametros, los cuales, inicializan solo: El Nombre, Raza y Nivel. Ya que el resto de sus atributos siempre deben partir de su valor base.
 * @param no Recibe un atributo de tipo String que inicializara el Nombre si lo verifica el Setter diseñado para ello.
 * @param ra Recibe un atributo de tipo String que inicializara la Raza si lo verifica el Setter diseñado para ello.
 * @param ni Recibe un atributo de tipo int que inicializara el Nivel usando el Setter diseñado para ello.
 */
    public Mago(String no, String ra, int ni){
        setNombre(no);
        setRaza(ra);
        setNivel(0);
        setVida((int)(100*0.9));
        setAtaque((int)(10*0.7));
        setAgilidad((int)(10*1.15));
        setArmadura((int)(30*0.9));
        setResistenciaMagica((int)(30*1.6));
        setMagia(10);
        for(int i=0; i<ni; i++){
            subeNivel();
        }
        Estado=true;
    }
    
    public Mago(String ruta){
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
                setMagia(Integer.parseInt(array[1].trim()));
                
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
 * Este metodo es un Setter que inicializara la Magia del Mago.
 * @param ma Recibe un atributo de tipo int que contendra los puntos de Magia.
 */
    public void setMagia(int ma){
        Magia=ma;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo int.
 * @return Devuelve los puntos de Magia del Mago. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.
 */
    public final int getMagia(){
        return Magia;
    }
    
/**
 * Este metodo devuelve un String con el nombre de un conjuro a lanzar, dependiendo de cual se seleccione en el Switch.
 * @param con Recibe el atributo de tipo int con el que se selecciona el conjuro.
 * @return Devuelve un String con el nombre del conjuro seleccionado.
 */
    public String lanzarConjuro(int con){
        String conjuro="";
        
        switch(con){
            case 1:
                conjuro= "Bola de fuego";
            break;
            
            case 2:
                conjuro= "Lanza de hielo";
            break;
            
            case 3:
                conjuro= "Cefiro";
            break;
        }
        
        return conjuro;
    }
    
/**
 * Este metodo devuelve un String que determina un Ataque usando los Getters del Nombre y Ataque del Mago.
 * @return Devuelve un String con la informacion del ataque del Mago.
 */
    public String luchar(){
        return "El Mago " + getNombre() + " ataca con " + getAtaque() + " puntos de daño.";        
    }
    
/**
 * Esta version del metodo sobrecargado devuelve un String que determina un Ataque usando el Getter del Nombre del Mago junto con el conjuto que lanza.
 * @param con Recibe un atributo de tipo int que selecciona el hechizo a lanzar.
 * @return Devuelve un String con la informacion del ataque del Mago.
 */
    public String luchar(int con){
        return "El Mago " + getNombre() + " lanza el hechizo de " + lanzarConjuro(con);        
    }
    
/**
 * Este metodo implementado de la clase padre Persona, devuelve un atributo de tipo String.
 * @return Devuelve un String describiendo el estado del Mago.
 */
    public String toString(){
        if(Estado==true){
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n Magia: " + getMagia() + "\n\n Esta actualmente: Vivo";
        }else{
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n Magia: " + getMagia() + "\n\n Esta actualmente: Muerto";
        }  
    }
    
/**
 * Este metodo esta implementado para tener informacion de la clase.
 * @return Devuelve un String con el nombre de la clase.
 */
    public String devuelveClase(){
        return "Mago";
    }
    
}

