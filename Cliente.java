import java.util.*;
import java.util.List;

public abstract class Cliente
{
    private int nif;
    private String nome;
    private String endereco;

    private List<Servico>lista;
    
    public Cliente(int nif, String n, String e)
    {
        this.nif = nif;
        this.nome = n;
        this.endereco = e;
        this.lista=new ArrayList<Servico>();
    }

    public int getNIF()
    {   return this.nif;}
    
    public void setNIF(int n)
    {   this.nif = n;}
    
    public String getNome()
    {   return this.nome;}
    
    public void setNome(String n)
    {   this.nome = n;}
    
    public String getEndereco()
    {   return this.endereco;}
    
    public void setEndereco(String e)
    {   this.endereco = e;}
    
    //adicionar novo servico
    public void add(Servico s){
        this.lista.add(s);
    }
    
    //listar servicos
    public List<Servico> getLista(){
        ArrayList<Servico>temp = new ArrayList <Servico>();
        
        for(Servico s:this.lista)
            temp.add(s);
            
        return temp;
    }
    
    public boolean equals(Cliente c)
    {
        if(c!=null)
            return(this.nif == c.getNIF());
        else
            return false;
    }
    
    public abstract Cliente clone();
}
