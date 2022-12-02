public class Cliente
{
    private int nif;
    private String nome;
    private String endereco;

    public Cliente(int nif, String n, String e)
    {
        this.nif = nif;
        this.nome = n;
        this.endereco = e;
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
    
    public Cliente clone()
    {   return new Cliente(this.getNIF(), this.getNome(), this.getEndereco());}
    
    public boolean equals(Cliente c)
    {
        if(c!=null)
            return(this.nif == c.getNIF());
        else
            return false;
    }
}
