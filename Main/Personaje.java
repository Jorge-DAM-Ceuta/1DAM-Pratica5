package Practica6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jorge.
 * Esta es la clase padre Personaje, que inicializa y permite modificar los atributos de un Personaje.
 * @version 1.0.
 */

public abstract class Personaje {
    
    protected String Nombre, Raza; 
    protected boolean Estado;
    private int Nivel, Vida, Ataque, Agilidad, Armadura, ResistenciaMagica;
    
/**
 * Este es un constructor por defecto de un Personaje. Inicializa todos sus atributos a su valor base excepto el Nombre y la Raza.
 */
    public Personaje(){
        Nombre="";
        Raza="";
        Nivel=1;
        Vida=100;
        Ataque=10;
        Agilidad=10;
        Armadura=30;
        ResistenciaMagica=30;
        Estado=false;
    }
    
/**
 * Este es un constructor con par?metros, los cuales, inicializan solo: El Nombre, Raza y Nivel. Ya que el resto de sus atributos siempre deben partir de su valor base.
 * @param no Recibe un atributo de tipo String que inicializar? el Nombre si lo verifica el Setter dise?ado para ello.
 * @param ra Recibe un atributo de tipo String que inicializar? la Raza si lo verifica el Setter dise?ado para ello.
 * @param ni Recibe un atributo de tipo int que inicializar? el Nivel usando el Setter dise?ado para ello.
 */
    public Personaje(String no, String ra, int ni){
        setNombre(no);
        setRaza(ra);
        setNivel(ni);
        Vida=100;
        Ataque=10;
        Agilidad=10;
        Armadura=30;
        ResistenciaMagica=30;
        Estado=true;
    }
    
    public Personaje(String ruta){
        try{
            FileReader fr=new FileReader(ruta);
            BufferedReader br=new BufferedReader(fr);
            String linea="";
            String [] array=new String [2];
            
            br.readLine();
            br.readLine();
//Linea 3     
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
                
                if(br.readLine().contains("vivo")){
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
 * Este metodo comprueba que se cumpla la condicion para que un Nombre sea valido.
 * @param no Recibe un atributo de tipo String que contendra el Nombre del Personaje.
 * @return Devuelve verdadero si se cumple su condicion, para despu?s ser usado en un Setter.
 */
    protected boolean checkNombre(String no){
        boolean comp=false;
        
        if(no.length()>=4){
            comp=true;
        }
        
        return comp;
    }
    
/**
 * Este metodo comprueba que se cumpla la condicion para que una Raza sea v?lida.
 * @param ra Recibe un atributo de tipo String que contendra la Raza del Personaje.
 * @return Devuelve verdadero si se cumple su condicion, para despu?s ser usado en un Setter.
 */ 
    protected boolean checkRaza(String ra){
        boolean comp=false;
        
        if(!ra.equals("Angel") || !ra.equals("Demonio")){
            comp=true;
        }
        
        return comp;
    }
    
/**
 * Este metodo hace que se aumente el atributo Nivel en 1, aplicando a todos sus atributos una bonificaci?n extra mediante sus Setters.
 */
    protected final void subeNivel(){
        Nivel++;
        setVida((int)(getVida()*1.1));
        setAtaque((int)(getAtaque()*1.1));
        setAgilidad((int)(getAgilidad()*1.1));
        setArmadura((int)(getArmadura()*1.1));
        setResistenciaMagica((int)(getResistenciaMagica()*1.1));
    }
   
/**
 * Este metodo es un Setter que inicializara el Nombre del Personaje.
 * @param no Recibe un atributo de tipo String que contendr? el Nombre.
 */
    public void setNombre(String no){
        if(checkNombre(no)){
            Nombre=no;
        }
    }
    
/**
 * Este metodo es un Setter que inicializara la Raza del Personaje.
 * @param ra Recibe un atributo de tipo String que contendra la Raza.
 */
    public void setRaza(String ra){
        if(checkRaza(ra)){
            Raza=ra;
        }
    }
    
/**
 * Este metodo es un Setter que inicializara la Vida del Personaje.
 * @param vi Recibe un atributo de tipo int que contendra los puntos de Vida.
 */
    public void setVida(int vi){
        Vida=vi;
    }
    
/**
 * Este metodo es un Setter que inicializara el Nivel del Personaje.
 * @param ni Recibe un atributo de tipo int que contendra el Nivel.
 */
    public void setNivel(int ni){
        Nivel=ni;
    }
    
/**
 * Este metodo es un Setter que inicializara el Ataque del Personaje.
 * @param at Recibe un atributo de tipo int que contendra los puntos de Ataque.
 */
    public void setAtaque(int at){
        Ataque=at;
    }
    
/**
 * Este metodo es un Setter que inicializara la Agilidad del Personaje.
 * @param ag Recibe un atributo de tipo int que contendra los puntos de Agilidad.
 */
    public void setAgilidad(int ag){
        Agilidad=ag;
    }
    
/**
 * Este metodo es un Setter que inicializara la Armadura del Personaje.
 * @param ar Recibe un atributo de tipo int que contendra los puntos de Armadura.
 */
    public void setArmadura(int ar){
        Armadura=ar;
    }
    
/**
 * Este metodo es un Setter que inicializara la Resistencia Magica del Personaje.
 * @param rm Recibe un atributo de tipo int que contendra los puntos de Resistencia Magica.
 */
    public void setResistenciaMagica(int rm){
        ResistenciaMagica=rm;
    }
    
    public void setEstado(boolean es){
        Estado=es;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo String.
 * @return Devuelve el Nombre del Personaje. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.
 */
    public final String getNombre(){
        return Nombre;
    }
   
/**
 * Este metodo es un Getter que devuelve un atributo de tipo String.
 * @return Devuelve la Raza del Personaje. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.
 */
    public final String getRaza(){
        return Raza;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo int.
 * @return Devuelve la Vida del Personaje. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.
 */
    public final int getVida(){
        return Vida;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo int.
 * @return Devuelve los puntos de Ataque del Personaje. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.
 */
    public final int getAtaque(){
        return Ataque;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo int.
 * @return Devuelve los puntos de Agilidad del Personaje. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.
 */
    public final int getAgilidad(){
        return Agilidad;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo int.
 * @return Devuelve los puntos de Armadura del Personaje. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.
 */
    public final int getArmadura(){
        return Armadura;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo int.
 * @return Devuelve los puntos de Resistencia Magica del Personaje. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.  
 */
    public final int getResistenciaMagica(){
        return ResistenciaMagica;
    }
    
/**
 * Este metodo es un Getter que devuelve un atributo de tipo int. Al ser Final nunca podra ser usado en otra clase si ha sido modificado.
 * @return Devuelve el Nivel del Personaje.  
 */
    public final int getNivel(){
        return Nivel;
    }
    
    public boolean getEstado(){
        return Estado;
    }
    
/**
 * Este metodo imprime por pantalla un String que determina un Ataque usando los Getters del Nombre y Ataque del Personaje.
 * @return Devuelve un String con la informacion del ataque.
 */
    public String luchar(){
        return "El " + devuelveClase() + " " + getNombre() + " ataca con " + getAtaque() + " puntos de dano.\n";
    }
    
/**
 * Este metodo imprime por pantalla un String que determina una Defensa usando los Getters del Nombre, Armadura y Resistencia Magica del Personaje.
 * @return Devuelve un String con el estado del Personaje.
 */
    public String defender(){
        return getNombre() + " tiene " + getVida() + " puntos de Vida, " + getArmadura() + " puntos de Armadura y " + getResistenciaMagica() + " puntos de Resistencia Magica\n";
    }
    
/**
 * Este metodo Abstact esta destinado a usarse en subclases de Personaje.
 * @return Devolvera un String describiendo el estado del Personaje en cuestion.
 */
    public abstract String toString();
    
/**
 * Este metodo esta implementado para tener informacion de la clase.
 * @return Devuelve un String con el nombre de la clase.
 */
    public String devuelveClase(){
        return "Personaje";
    }
}


