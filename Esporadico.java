
/**
 * Escreva uma descrição da classe Esporadico aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Esporadico extends Cliente
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;

    /**
     * Construtor para objetos da classe Esporadico
     */
    public Esporadico(int nif, String n, String e)
    {
        // inicializa variáveis de instância
        super(nif,n,e);
    }

    public Esporadico clone()
    {   return new Esporadico(super.getNIF(), super.getNome(), super.getEndereco());
    }
}
