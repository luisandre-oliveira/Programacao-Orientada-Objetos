
/**
 * Escreva uma descrição da classe Liquida aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Liquida extends Carga
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private static final double estimativa = 10.0;
    private static final int customedio = 22;
    /**
     * Construtor para objetos da classe Liquida
     */
    public Liquida(int c,double p,int cub)
    {
        // inicializa variáveis de instância
        super(c,p,cub);
    }

    public Liquida clone(){
        return new Liquida(super.getCod(),super.getPeso(),super.getCub());
    }
    public double consumo(){
        return this.estimativa*super.getCub();
    }
    public double preco(){
        return consumo()*customedio;
    }
    public int tipo(){
        return 1;
    }
}
