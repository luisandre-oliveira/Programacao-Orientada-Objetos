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
    
    private List<Localizacao> ligacoes;
    private Localizacao local;
    
    /**
     * Construtor para objetos da classe Hub
     */
    public Hub(String n,boolean r)
    {
        // inicializa variáveis de instância
        this.nome = n;
        this.refrig = r;
        this.ligacoes = new ArrayList<Localizacao>();
        this.local = new Localizacao();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public boolean getRefrig(){
        return this.refrig;
    }
    
    public List<Localizacao> getLigacoes(){
        ArrayList<Localizacao>temp = new ArrayList <Localizacao>();
        
        for(Localizacao l:this.ligacoes)
            temp.add(l);
            
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
    public void add(Localizacao l){
        this.ligacoes.add(l);
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
        Hub h = new Hub(this.nome,this.refrig);
        for(Localizacao l:this.ligacoes)
            h.add(l);
        return h;
    }
}
