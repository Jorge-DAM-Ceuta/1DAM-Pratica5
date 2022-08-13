/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Propietario
 */
public class GameLogger {
    
    
    public static void ejercicio2 (String ruta, Personaje n) {
        if (ruta.charAt(0) == '/' && ruta.endsWith(".txt")) {
            try {
                FileWriter fw = new FileWriter(ruta);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(n.toString());
                bw.close();
                fw.close();
            } catch (IOException error) {
                System.err.println(error.toString());
            }
        }
    }
    
    
    public static void ejercicio3 (String ruta, Personaje [] array){
        
        File f=new File(ruta);
        
        if (f.canRead() && f.canWrite()) {
            try {
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                
                for(int i=0; i<array.length; i++){
                    
                    bw.write("Ficha del personaje " + i+1 + "\n");
                    bw.write(array[i].toString());
                }
                
                bw.close();
                fw.close();
            } catch (IOException error) {
                System.err.println(error.toString());
            }
        }
    }

    public void bubble(Personaje [] array){
        boolean ordenado=false;
        while(!ordenado){
            ordenado=true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i].getAgilidad() > array[i+1].getAgilidad()) {
                    permuta(array,i,i+1);
                    ordenado=false;
                }
            }
        }
    }

    private void permuta(Personaje [] array, int i, int j) {
        Personaje backup;
        backup=array[j];
        array[j]=array[i];
        array[i]=backup;
    }
    
    
    public void ejercicio5 (File f, Personaje p){
        String linea1, linea2, linea3, linea4, linea5, linea6, linea7, linea8, linea9, linea10;
        String [] seccion = new String[2];
        String nombre, raza;
        int nivel, vida, ataque, agilidad, armadura, rm;
        boolean estado;
        boolean comp=true;
        
        try{
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            
            br.readLine();
            br.readLine();
            
            linea1 = br.readLine();
            seccion=linea1.split(":");
            nombre=seccion[1];
            if(!seccion[1].trim().equals(p.getNombre())){
                comp=false;
            }
            
            linea2 = br.readLine();
            seccion=linea2.split(":");
            if(!seccion[1].trim().equals(p.devuelveClase())){
                comp=false;
            }
            
            linea3 = br.readLine();
            seccion=linea3.split(":");
            raza=seccion[1];
            if(!seccion[1].trim().equals(p.getRaza())){
                comp=false;
            }
            
            br.readLine();
            
            linea4 = br.readLine();
            seccion=linea4.split(":");
            nivel = Integer.parseInt(seccion[1]);
            if(!seccion[1].trim().equals(p.getNivel())){
                comp=false;
            }
            
            linea5 = br.readLine();
            seccion=linea5.split(":");
            vida = Integer.parseInt(seccion[1]);
            if(!seccion[1].trim().equals(p.getVida())){
                comp=false;
            }
            
            linea6 = br.readLine();
            seccion=linea6.split(":");
            ataque = Integer.parseInt(seccion[1]);
            if(!seccion[1].trim().equals(p.getAtaque())){
                comp=false;
            }
            
            linea7 = br.readLine();
            seccion=linea7.split(":");
            agilidad = Integer.parseInt(seccion[1]);
            if(!seccion[1].trim().equals(p.getAgilidad())){
                comp=false;
            }
            
            linea8 = br.readLine();
            seccion=linea8.split(":");
            armadura = Integer.parseInt(seccion[1]);
            if(!seccion[1].trim().equals(p.getArmadura())){
                comp=false;
            }
            
            linea9 = br.readLine();
            seccion=linea9.split(":");
            rm = Integer.parseInt(seccion[1]);
            if(!seccion[1].trim().equals(p.getResistenciaMagica())){
                comp=false;
            }
            
            br.readLine();
            
            linea10 = br.readLine();
            seccion=linea10.split(":");
            if(!seccion[1].trim().equals("Vivo")){
                comp=false;
            }
            
            if(comp=false){
                p.setNombre(nombre);
                p.setRaza(raza);
                p.setNivel(nivel);
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setAgilidad(agilidad);
                p.setArmadura(armadura);
                p.setResistenciaMagica(rm);
                p.setEstado(true);
            }
            
        }catch(IOException error){
            System.out.println(error);
        }
    }
    
    
    public boolean ejercicio6(String [] array, String personaje){
    
        boolean comp=false;
        
        try{
            for(int i=0; i<array.length; i++){
                File fichero = new File(array[i]);
                FileReader fr=new FileReader(fichero);
                BufferedReader br=new BufferedReader(fr);
                String linea;
                String [] datos=new String [2];
                
                br.readLine();
                br.readLine();
                linea=br.readLine();
                datos=linea.split(":");
                if(datos[1].trim().equals(personaje)){
                    comp=true;
                    return comp;
                }else{
                    comp=false;
                }
            }
        }catch(IOException error){
            System.err.println(error);
        }
            return comp;
    }
    
    
    public boolean ejercicio7(String [] array){
        
        try{
        
            for(int i=0; i<array.length; i++){
                File fichero = new File(array[i]);
                FileReader fr=new FileReader(fichero);
                BufferedReader br=new BufferedReader(fr);
                br.readLine();
                br.readLine();
                br.readLine();
                String linea=br.readLine();
                String [] content=new String [2];
                content=linea.split(":");
                
                for(int j=0; j<i; j++){
                    File fichero2 = new File(array[j]);
                    FileReader fr2=new FileReader(fichero2);
                    BufferedReader br2=new BufferedReader(fr2);
                    br2.readLine();
                    br2.readLine();
                    br2.readLine();
                    String linea2=br2.readLine();
                    String [] content2=new String [2];
                    content2=linea2.split(":");
                    if(content2[1].trim().equals(content[1].trim())){
                        return true;
                    }
                }
            }
        }catch(IOException error){
                System.err.println(error);
        }
        return false;
    }
    
    
    public static String ejercicio8(File f, Personaje a, Personaje b){
        String Resultado="";
        
        try{
            FileWriter fw=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fw);
            
//ATAQUE DEL PERSONAJE A
            if(a.getAgilidad()>b.getAgilidad()){
                    
//ARMADURA
                if(a.getArmadura()>=0 || b.getArmadura()>=0){
                    do{
                        bw.write(a.defender() + "\n");
                        bw.write(b.defender()+ "\n");
                        bw.write(a.luchar()+ "\n");

                        if(a.getAgilidad()>(b.getAgilidad()*2)){
                            b.setArmadura(b.getArmadura()-a.getAtaque()*2);                        
                        }else{
                            b.setArmadura(b.getArmadura()-a.getAtaque());
                        }

                        bw.write(a.getNombre() + " le quita " + a.getAtaque() + " puntos de Armadura al " + b.devuelveClase() + " " + b.getNombre() + "\n");
                        bw.write(b.defender()+ "\n");
                        bw.write(b.luchar()+ "\n");

                        if(b.getAgilidad()>(a.getAgilidad()*2)){
                            a.setArmadura(a.getArmadura()-b.getAtaque()*2);                        
                        }else{
                            a.setArmadura(a.getArmadura()-b.getAtaque());
                        }

                        bw.write(b.getNombre() + " le quita " + b.getAtaque() + " puntos de Armadura al " + a.devuelveClase() + " " + a.getNombre() + "\n");
                        a.setArmadura(a.getArmadura()-b.getAtaque());
                    }while(a.getArmadura()<=0 || b.getArmadura()<=0);
                }
//VIDA
                if(a.getArmadura()<=0 || b.getArmadura()<=0){    
                    do{
                        bw.write(a.defender()+ "\n");
                        bw.write(b.defender()+ "\n");
                        bw.write(a.luchar()+ "\n");

                        if(a.getAgilidad()>(b.getAgilidad()*2)){
                            b.setVida(b.getVida()-a.getAtaque()*2);                        
                        }else{
                            b.setVida(b.getVida()-a.getAtaque());
                        }

                        bw.write(a.getNombre() + " le quita " + a.getAtaque() + " puntos de Vida al " + b.devuelveClase() + " " + b.getNombre() + "\n");
                        bw.write(b.defender()+ "\n");
                        bw.write(b.luchar()+ "\n");

                        if(b.getAgilidad()>(a.getAgilidad()*2)){
                            a.setVida(a.getVida()-b.getAtaque()*2);                        
                        }else{
                            a.setVida(a.getVida()-b.getAtaque());
                        }

                        bw.write(b.getNombre() + " le quita " + b.getAtaque() + " puntos de Vida al " + a.devuelveClase() + " " + a.getNombre() + "\n");
                        a.setVida(a.getVida()-b.getAtaque());

                        if(a.getVida()<=0 && b.getVida()>0){
                            Resultado=b.getNombre() + " ha ganado el combate!";
                            bw.write(Resultado);
                        }if(b.getVida()<=0 && a.getVida()>0){
                            Resultado=a.getNombre() + " ha ganado el combate!";
                            bw.write(Resultado);
                        }
                        
                        bw.write(Resultado);
                        
                    }while(a.getVida()<=0 || b.getVida()<=0);
                }
            }
            
//ATAQUE DEL PERSONAJE B

            if(b.getAgilidad()>a.getAgilidad()){
                    
//ARMADURA  
                if(a.getArmadura()>=0 || b.getArmadura()>=0){
                    do{
                        bw.write(b.defender()+ "\n");
                        bw.write(a.defender()+ "\n");
                        bw.write(b.luchar()+ "\n");

                        if(b.getAgilidad()>(a.getAgilidad()*2)){
                            a.setArmadura(a.getArmadura()-b.getAtaque()*2);                        
                        }else{
                            a.setArmadura(a.getArmadura()-b.getAtaque());
                        }

                        bw.write(b.getNombre() + " le quita " + b.getAtaque() + " puntos de Armadura al " + a.devuelveClase() + " " + a.getNombre() + "\n");
                        bw.write(a.defender()+ "\n");
                        bw.write(a.luchar()+ "\n");

                        if(a.getAgilidad()>(b.getAgilidad()*2)){
                            b.setArmadura(b.getArmadura()-a.getAtaque()*2);                        
                        }else{
                            b.setArmadura(b.getArmadura()-a.getAtaque());
                        }

                        bw.write(a.getNombre() + " le quita " + a.getAtaque() + " puntos de Armadura al " + b.devuelveClase() + " " + b.getNombre() + "\n");
                        b.setArmadura(b.getArmadura()-a.getAtaque());

                    }while(b.getArmadura()<=0 || a.getArmadura()<=0);
                }    
                    
//VIDA
                if(a.getArmadura()<=0 || b.getArmadura()<=0){
                    do{
                        bw.write(b.defender()+ "\n");
                        bw.write(a.defender()+ "\n");
                        bw.write(b.luchar()+ "\n");

                        if(b.getAgilidad()>(a.getAgilidad()*2)){
                            a.setVida(a.getVida()-b.getAtaque()*2);                        
                        }else{
                            a.setVida(a.getVida()-b.getAtaque());
                        }

                        bw.write(b.getNombre() + " le quita " + b.getAtaque() + " puntos de Vida al " + a.devuelveClase() + " " + a.getNombre() + "\n");
                        bw.write(a.defender()+ "\n");
                        bw.write(a.luchar()+ "\n");

                        if(a.getAgilidad()>(b.getAgilidad()*2)){
                            b.setVida(b.getVida()-a.getAtaque()*2);                        
                        }else{
                            b.setVida(b.getVida()-a.getAtaque());
                        }

                        bw.write(a.getNombre() + " le quita " + a.getAtaque() + " puntos de Vida al " + b.devuelveClase() + " " + b.getNombre() + "\n");
                        b.setVida(b.getVida()-a.getAtaque());

                        if(b.getVida()<=0 && a.getVida()>0){
                            Resultado=a.getNombre() + " ha ganado el combate!";
                            bw.write(Resultado);
                        }if(a.getVida()<=0 && b.getVida()>0){
                            Resultado=b.getNombre() + " ha ganado el combate!";
                            bw.write(Resultado);
                        }
                        
                        bw.write(Resultado);
                        
                    }while(a.getVida()<=0 || b.getVida()<=0);
                }
            }
            
            bw.write(Resultado);
            bw.close();
            fw.close();
        }catch(IOException error){
            System.err.println(error);
        }
        return Resultado;
    }
    
    public static void ejercicio9(File f, Personaje [] array){
       
        try{
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String linea="";
            String [] resultado= new String [2];
            
            for(int i=0; i<array.length; i++){
                while((linea=br.readLine())!=null){
                    resultado=linea.split(" ha ganado el combate!");
                    
                    if(resultado[0].contains(array[i].getNombre())){
                        array[i].subeNivel();
                    }
                }
            }
            
        }catch(IOException error){
            System.err.println(error);    
        }
    }
    
}
