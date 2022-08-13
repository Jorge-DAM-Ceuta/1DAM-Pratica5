package Practica6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jorge.
 * Esta es la subclase Cazador que hereda de Personaje e inicializa los atributos de un Personaje.
 * @version 1.0.
 */

public class Cazador extends Personaje{
    
/**
    * @author Jorge.
    * Esta es la clase anidada Compa?eroAnimal de Cazador que hereda de Personaje e inicializa los atributos de un Personaje.
    * @version 1.0.
    */
    
    private CompaneroAnimal companero;
    
    public class CompaneroAnimal extends Personaje{
       
    /**
    * Este es un constructor por defecto de un Cazador. Inicializa todos sus atributos a sus valores predeterminados excepto el Nombre y la Raza.
    */    
        public CompaneroAnimal(){
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
        public CompaneroAnimal(String no, String ra, int ni){
            setNombre(no);
            setRaza(ra);
            setNivel(0);
            
            for(int i=0; i<ni; i++){
            subeNivel();
            }
            
            Estado=true;
        }
        
    /**
    * Este metodo comprueba que se cumpla la condicion para que la Raza del Companero Animal sea valida.
    * @param ra Recibe un atributo de tipo String que contendra la Raza del Companero Animal.
    */
        public void setRaza(String ra){
            switch(ra){
                case "Sabueso":
                    setVida((int)(100*1.25));
                    setAtaque((int)(10*1.25));
                    setAgilidad((int)(10*1.25));
                    setArmadura((int)(30*1.25));
                    setResistenciaMagica((int)(30*1.25));
                    Raza=ra;
                    Estado=true;
                break;
                
                case "Felino":
                    setVida((int)(100*1.15));
                    setAtaque((int)(10*1.3));
                    setAgilidad((int)(10*1.3));
                    setArmadura((int)(30*1.15));
                    setResistenciaMagica((int)(30*1.15));
                    Raza=ra;
                    Estado=true;
                break;
            
                case "Ave":
                    setVida((int)(100*1.05));
                    setAtaque((int)(10*1.15));
                    setAgilidad((int)(10*1.35));
                    setArmadura((int)(30*1.05));
                    setResistenciaMagica((int)(30*1.25));
                    Raza=ra;
                    Estado=true;
                break;
            }
        }

    /**
    * Este metodo implementado de la clase padre Persona, devuelve un atributo de tipo String.
    * @return Devuelve un String describiendo el estado del Companero Animal.
    */
        public String toString() {
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
            return "Compañero Animal";
        }
    }
            
/**
 * Este es un constructor por defecto de un Cazador. Inicializa todos sus atributos a su valores predeterminados excepto el Nombre y la Raza.
 */
    public Cazador(){
        setNombre("");
        setRaza("");
        setNivel(1);
        setVida(100);
        setAtaque(10);
        setAgilidad((int)(10*1.1));
        setArmadura(30);
        setResistenciaMagica(30);
        companero=new CompaneroAnimal();
        Estado=false;
    }
    
/**
 * Este es un constructor con parametros, los cuales, inicializan solo: El Nombre, Raza y Nivel. Ya que el resto de sus atributos siempre deben partir de su valor base.
 * @param no Recibe un atributo de tipo String que inicializara el Nombre si lo verifica el Setter disenado para ello.
 * @param ra Recibe un atributo de tipo String que inicializara la Raza si lo verifica el Setter disenado para ello.
 * @param ni Recibe un atributo de tipo int que inicializara el Nivel usando el Setter disenado para ello.
 */
    public Cazador(String no, String ra, int ni){
        setNombre(no);
        setRaza(ra);
        setNivel(ni);
        setNivel(0);
        setVida(100);
        setAtaque(10);
        setAgilidad((int)(10*1.1));
        setArmadura(30);
        setResistenciaMagica(30);
        for(int i=0; i<ni; i++){
            subeNivel();
        }
        companero=new CompaneroAnimal("Mascota", "Felino", ni);
        Estado=true;
    }
    
    public Cazador(String ruta){
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
                
                br.readLine();
                br.readLine();
                br.readLine();
                
                br.readLine();
                array=linea.split(":");
                companero.setNombre(array[1].trim());
                
                br.readLine();
                array=linea.split(":");
                if(array[1].trim().equals(companero.devuelveClase())){  
                    
                    br.readLine();
                    array=linea.split(":");
                    companero.setRaza(array[1].trim());
                    
                    br.readLine();
                   
                    br.readLine();
                    array=linea.split(":");
                    companero.setNivel(Integer.parseInt(array[1].trim()));
                    
                    br.readLine();
                    array=linea.split(":");
                    companero.setVida(Integer.parseInt(array[1].trim()));
                    
                    br.readLine();
                    array=linea.split(":");
                    companero.setAtaque(Integer.parseInt(array[1].trim()));
                    
                    br.readLine();
                    array=linea.split(":");
                    companero.setAgilidad(Integer.parseInt(array[1].trim()));
                    
                    br.readLine();
                    array=linea.split(":");
                    companero.setArmadura(Integer.parseInt(array[1].trim()));
                    
                    br.readLine();
                    array=linea.split(":");
                    companero.setResistenciaMagica(Integer.parseInt(array[1].trim()));
                    
                    br.readLine();
                    
                    if(br.readLine().contains("Vivo")){
                        companero.setEstado(true);
                    }else{
                        companero.setEstado(false);
                    }
                }              
            }
        }catch(IOException error){
            System.err.println(error);
        }
    }
    
/**
 * Este metodo imprime por pantalla un String que determina un Ataque usando los Getters de Nombre y Ataque del Cazador.
 * @return Devuelve un String con la informacion del ataque del Cazador y su companero animal.
 */
    public String luchar(){
        return "El Cazador " + getNombre() + " ataca con " + getAtaque() + " puntos de dano. \nSu companero animal " + companero.getNombre() + " ataca con " + companero.getAtaque() + " puntos de dano.";
    }

/**
 * Este metodo implementado de la clase padre Persona, devuelve un atributo de tipo String.
 * @return Devuelve un String describiendo el estado del Cazador.
 */
    public String toString(){  
        if(Estado==true){
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n\n Esta actualmente: Vivo" + "\n\n" + companero.toString();
        }else{
            return "Ficha del " + devuelveClase() + " " + getNombre() + "\n\n Nombre: " + getNombre() + "\n Clase: " + devuelveClase() + "\n Raza: " + getRaza() + "\n\n Nivel: " + getNivel() + "\n Vida: " + getVida() + "\n Ataque: " + getAtaque() + "\n Velocidad: " + getAgilidad() + "\n Proteccion: " + getArmadura() + "\n Resistencia Magica: " + getResistenciaMagica() + "\n\n Esta actualmente: Muerto" + "\n\n" + companero.toString();
        }    
    }
    
/**
 * Este metodo esta implementado para tener informacion de la clase.
 * @return Devuelve un String con el nombre de la clase.
 */
    public String devuelveClase(){
        return "Cazador";
    }
    
}
