
/**
 * Escreva uma descrição da classe Carga aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public abstract class Carga
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int cod;
    private double peso;
    private int cubicagem;

    /**
     * Construtor para objetos da classe Carga
     */
    public Carga(int c,double p,int cub)
    {
        // inicializa variáveis de instância
        this.cod = c;
        this.peso = p;
        this.cubicagem = cub;
    }
    
    public int getCod(){
        return this.cod;
    }
    public double getPeso(){
        return this.peso;
    }
    public int getCub(){
        return this.cubicagem;
    }
    public boolean equals(Carga c)
    {
        if(c!=null)
            return(this.cod == c.getCod());
        else
            return false;
    }
    public abstract double consumo();
    public abstract double preco();
    public abstract Carga clone();
}
