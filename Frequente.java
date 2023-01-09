
/**
 * Escreva uma descrição da classe Frequente aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Frequente extends Cliente
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu própri
    private int negocios;
    /**
     * Construtor para objetos da classe Frequente
     */
    public Frequente(int nif, String n, String e,int neg)
    {
        // inicializa variáveis de instância
        super(nif,n,e);
        this.negocios=neg;
    }
    public double desconto(){
        return this.negocios*Tabela.desconto(negocios/100);
    }
    public int getNegocios(){
        return this.negocios;
    }
    public Frequente clone()
    {   return new Frequente(super.getNIF(), super.getNome(), super.getEndereco(),this.negocios);
    }
}
