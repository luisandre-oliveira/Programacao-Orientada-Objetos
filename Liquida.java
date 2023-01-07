
/**
 * Escreva uma descrição da classe Liquida aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Liquida extends Carga
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio

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
    public abstract double consumo();
    public abstract double preco();
}
