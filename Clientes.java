import java.util.Map;
import java.util.HashMap;

public class Clientes
{
    private Map<String,Cliente> lista;

    public Clientes()
    {
        this.lista = new HashMap<String,Cliente>();
    }

    public void addCliente(Cliente c)
    {
        this.lista.put(String.valueOf(c.getNIF()),c.clone());
    }
    
    public Cliente findCliente(int nif)
    {    
        if(this.lista.containsKey(nif))
        {   return this.lista.get(nif);}
        
        else
        {   return null;}
    }
    
    public Map<Cliente,Integer> clienteMaxViagens()
    {
        int max = 0;
        HashMap<Cliente,Integer> temp = new HashMap<Cliente,Integer>();
        
        for(Cliente c:this.lista.values())
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
    {   return this.lista.size();}
}