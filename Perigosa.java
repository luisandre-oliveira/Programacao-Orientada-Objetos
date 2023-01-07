
/**
 * Escreva uma descrição da classe Perigosa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Perigosa extends Carga
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private static final int customedio = 120;
    
    /**
     * Construtor para objetos da classe Perigosa
     */
    public Perigosa(int c,double p,int cub)
    {
        // inicializa variáveis de instância
        super(c,p,cub);
    }

    public double consumo(){
        return 3.0 * super.getPeso();
    }
    public double preco(){
        return consumo()*customedio;
    }
    public Perigosa clone(){
        return new Perigosa(super.getCod(),super.getPeso(),super.getCub());    
    }
    public int tipo(){
        return 3;
    }
}
