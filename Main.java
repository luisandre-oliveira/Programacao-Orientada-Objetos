import java.util.*;

public class Main
{    
    public static void main(String [] args) 
    {
        Menu menu = new Menu();
        Empresa casa = new Empresa();
        
        Frequente c1 = new Frequente(123,"Luis","Lisboa",100);
        Esporadico c2 = new Esporadico(456,"Goncalo","Porto");
        Frequente c3 = new Frequente(789,"Jorge","Guimaraes",500);
        
        Camiao cam1 = new Camiao("AA-AA-00",500,100,100);
        Camiao cam2 = new Camiao("BB-BB-00",1000,500,100);
        Camiao cam3 = new Camiao("CC-CC-00",600,400,800);
        
        Hub h1 = new Hub("Lisboa",true,100,100);
        Hub h2 = new Hub("Porto",false,500,100);
        Hub h3 = new Hub("Guimaraes",true,400,800);
        
        casa.addCliente(c1);
        casa.addCliente(c2);
        casa.addCliente(c3);
        
        casa.addCamiao(cam1);
        casa.addCamiao(cam2);
        casa.addCamiao(cam3);
        
        casa.addHub(h1);
        casa.addHub(h2);
        casa.addHub(h3);
        
        menu.MenuPrincipal(casa);
    }
}