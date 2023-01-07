
/**
 * Escreva uma descrição da classe Localizacao aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Localizacao
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int lat;
    private int lon;

    /**
     * Construtor para objetos da classe Localizacao
     */
    public Localizacao()
    {
        // inicializa variáveis de instância
        lat = 0;
        lon = 0;
    }

    public int getLatitude()
    {   return this.lat;}
    
    public void setLatitude(int lat)
    {   this.lat = lat;}
    
    public int getLongitude()
    {   return this.lon;}
    
    public void setLongitude(int lon)
    {   this.lon = lon;}
}
