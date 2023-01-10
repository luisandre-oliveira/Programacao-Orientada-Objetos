
/**
 * Escreva uma descrição da classe Localizacao aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Localizacao
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    public int lat;
    public int lon;

    /**
     * Construtor para objetos da classe Localizacao
     */
    public Localizacao(int lat, int lon)
    {
        // inicializa variáveis de instância
        this.lat = lat;
        this.lon = lon;
    }

    public int getLatitude()
    {   return this.lat;}
    
    public void setLatitude(int lat)
    {   this.lat = lat;}
    
    public int getLongitude()
    {   return this.lon;}
    
    public void setLongitude(int lon)
    {   this.lon = lon;}
    
    public double getDistancia(Localizacao a,Localizacao b){   
        return Math.sqrt(Math.pow(b.lat - a.lat, 2) + Math.pow(b.lon - a.lon, 2));
    }
}
