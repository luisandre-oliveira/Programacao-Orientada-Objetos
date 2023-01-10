import java.util.*;

/**
 * Escreva uma descrição da classe Hub aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Hub
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private boolean refrig;
    
    private Map<String,Integer> ligacoes;
    private Localizacao local;
    
    /**
     * Construtor para objetos da classe Hub
     */
    public Hub(String n,boolean r,int lat,int lon)
    {
        // inicializa variáveis de instância
        this.nome = n;
        this.refrig = r;
        this.ligacoes = new HashMap<String,Integer>();
        this.local = new Localizacao(lat,lon);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public boolean getRefrig(){
        return this.refrig;
    }
    
    public Map<String,Integer> getLigacoes(){
        HashMap<String,Integer>temp = new HashMap<String,Integer>();
        
        for(String l:this.ligacoes.keySet())
            temp.put(l,this.ligacoes.get(l));
            
        return temp;
    }
    
    public Localizacao getLocal(){
        return this.local;
    }
    
    public void setNome(String s){
        this.nome = s;
    }
    
    public void setRefrig(boolean r){
        this.refrig = r;
    }
    
    //Adicionar nova ligacao
    public void add(String l,int d){
        this.ligacoes.put(l,d);
    }
    
    public int numero_servicos(){
        return this.ligacoes.size();
    }
    
    public boolean equals(Hub o){
        if(o!=null){
            return (this.nome==o.getNome());
        }else
            return false;
    }
    
    public Hub clone(){
        Hub h = new Hub(this.nome,this.refrig,this.local.lat,this.local.lon);
        for(String l:this.ligacoes.keySet())
            h.add(l,this.ligacoes.get(l));
        return h;
    }
}