package Practica6;

public class Combate extends Personaje{
    
    public String combatir(Personaje a, Personaje b){
        String Resultado="";
        
        if(a.getAgilidad()>b.getAgilidad()){
                do{
                    System.out.println(a.defender());
                    System.out.println(b.defender());
                    System.out.println(a.luchar());
                    
                    if(a.getAgilidad()>(b.getAgilidad()*2)){
                        b.setVida(b.getVida()-a.getAtaque()*2);                        
                    }else{
                        b.setVida(b.getVida()-a.getAtaque());
                    }
                    
                    System.out.println(a.getNombre() + " le quita " + a.getAtaque() + " de Vida a " + b.getNombre() + "\n");
                    System.out.println(b.defender());
                    System.out.println(b.luchar());
                    
                    if(b.getAgilidad()>(a.getAgilidad()*2)){
                        a.setVida(a.getVida()-b.getAtaque()*2);                        
                    }else{
                        a.setVida(a.getVida()-b.getAtaque());
                    }
                    
                    System.out.println(b.getNombre() + " le quita " + b.getAtaque() + " de Vida a " + a.getNombre() + "\n");
                    a.setVida(a.getVida()-b.getAtaque());
                    
                    if(a.getVida()<=0 && b.getVida()>0){
                        Resultado=b.getNombre() + " ha ganado el combate!";
                    }if(b.getVida()<=0 && a.getVida()>0){
                        Resultado=a.getNombre() + " ha ganado el combate!";
                    }
            
                }while(a.getVida()<=0 || b.getVida()<=0);
        }
        
        if(b.getAgilidad()>a.getAgilidad()){
                do{
                    System.out.println(b.defender());
                    System.out.println(a.defender());
                    System.out.println(b.luchar());
                    
                    if(b.getAgilidad()>(a.getAgilidad()*2)){
                        a.setVida(a.getVida()-b.getAtaque()*2);                        
                    }else{
                        a.setVida(a.getVida()-b.getAtaque());
                    }
                    
                    System.out.println(b.getNombre() + " le quita " + b.getAtaque() + " de Vida a " + a.getNombre() + "\n");
                    a.setVida(a.getVida()-b.getAtaque());
                    System.out.println(a.defender());
                    System.out.println(a.luchar());
                    
                    if(a.getAgilidad()>(b.getAgilidad()*2)){
                        b.setVida(b.getVida()-a.getAtaque()*2);                        
                    }else{
                        b.setVida(b.getVida()-a.getAtaque());
                    }
                    
                    System.out.println(a.getNombre() + " le quita " + a.getAtaque() + " de Vida a " + b.getNombre() + "\n");
                    b.setVida(b.getVida()-a.getAtaque());
                    
                    if(a.getVida()<=0 && b.getVida()>0){
                        Resultado=b.getNombre() + " ha ganado el combate!";
                    }if(b.getVida()<=0 && a.getVida()>0){
                        Resultado=a.getNombre() + " ha ganado el combate!";
                    }
                    
                }while(a.getVida()<=0 || b.getVida()<=0);
        }
        
        return Resultado;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
