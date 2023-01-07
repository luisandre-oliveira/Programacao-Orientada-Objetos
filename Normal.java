
/**
 * Escreva uma descrição da classe Normal aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Normal extends Carga
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private static final double consumo = 50.0;

    /**
     * Construtor para objetos da classe Normal
     */
    public Normal(int c,double p,int cub)
    {
        // inicializa variáveis de instância
        super(c,p,cub);
    }

    public double consumo(){
        return this.consumo;
    }
    public double preco(){
        return consumo()*super.getCub();
    }
    public Normal clone(){
        return new Normal(super.getCod(),super.getPeso(),super.getCub());    
    }
    public int tipo(){
        return 4;
    }
}
