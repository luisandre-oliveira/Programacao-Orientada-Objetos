
/**
 * Escreva uma descrição da classe Empresa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

import java.util.*;
import java.util.HashMap;

public class Empresa
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private Map<Integer,Cliente> listaCliente;
    private Map<String,Camiao> listaCamiao;
    private Map<String,Hub> listaHub;

    /**
     * Construtor para objetos da classe Empresa
     */
    public Empresa()
    {
        // inicializa variáveis de instância
        this.listaCliente = new HashMap<Integer,Cliente>();
        this.listaCamiao = new HashMap<String,Camiao>();
        this.listaHub = new HashMap<String,Hub>();
    }
    
    //CLIENTE
    
    public void addCliente(Cliente c)
    {
        this.listaCliente.put(c.getNIF(),c.clone());
    }
    
    public Cliente findCliente(int nif)
    {    
        if(this.listaCliente.containsKey(nif))
        {   return this.listaCliente.get(nif);}
        
        else
        {   return null;}
    }
    
    public Map<Cliente,Integer> clienteMaxViagens()
    {
        int max = 0;
        HashMap<Cliente,Integer> temp = new HashMap<Cliente,Integer>();
        
        for(Cliente c:this.listaCliente.values())
        {
            int val = c.getLista().size();
            
            if(val == max)
            {   temp.put(c,max);}
                
            else if(val > max)
            {    
                max = val; 
                temp.clear();
                temp.put(c,max);
            }
        }
        
        return temp;
    }
    
    public int getNumClientes()
    {   return this.listaCliente.size();}
    
    //CAMIAO
    
    public void addCamiao(Camiao c){
        this.listaCamiao.put(c.getMatricula(),c.clone());
    }
    
    public Camiao findCamiao(String matricula)
    {    
        if(this.listaCamiao.containsKey(matricula))
        {   return this.listaCamiao.get(matricula);}
        else
        {   return null;}
    }
    
    //HUB
    
    public void addHub(Hub h){
        this.listaHub.put(h.getNome(),h.clone());
    }
    
    public Hub findHub(String nome)
    {    
        if(this.listaHub.containsKey(nome))
        {   return this.listaHub.get(nome);}
        else
        {   return null;}
    }
}
