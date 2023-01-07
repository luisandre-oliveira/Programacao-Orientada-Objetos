
/**
 * Escreva uma descrição da classe Camioes aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.*;
import java.util.HashMap;

public class Camioes
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private Map<String,Camiao> lista;

    /**
     * Construtor para objetos da classe Camioes
     */
    public Camioes()
    {
        // inicializa variáveis de instância
        this.lista = new HashMap<String,Camiao>();
    }

    public void addCamiao(Camiao c){
        this.lista.put(c.getMatricula(),c.clone());
    }
    
    public Camiao findCamiao(String matricula)
    {    
        if(this.lista.containsKey(matricula))
        {   return this.lista.get(matricula);}
        else
        {   return null;}
    }
}
