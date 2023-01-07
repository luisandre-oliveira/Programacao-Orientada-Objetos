
/**
 * Escreva uma descrição da classe Perecivel aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Perecivel extends Carga
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int kms;
    private static final int customedio = 40;
    
    /**
     * Construtor para objetos da classe Perecivel
     */
    public Perecivel(int c,double p,int cub,int k)
    {
        // inicializa variáveis de instância
        super(c,p,cub);
        this.kms=k;
    }

    public int getKms(){
        return this.kms;
    }
    public double consumo(){
        return this.kms * super.getPeso();
    }
    public double preco(){
        return consumo()*customedio;
    }
    public Perecivel clone(){
        return new Perecivel(super.getCod(),super.getPeso(),super.getCub(),this.kms);    
    }
    public int tipo(){
        return 2;
    }
}
