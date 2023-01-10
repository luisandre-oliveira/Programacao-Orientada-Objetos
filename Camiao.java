import java.util.ArrayList;

public class Camiao {

    private String matricula;
    private int cubicagem;
    private Localizacao localizacao;
    private ArrayList<Servico> historico;
    private ArrayList<Servico> servico_atual;

    public Camiao(String m, int c,int lat,int lon) {
        this.matricula = m;
        this.cubicagem = c;
        this.localizacao = new Localizacao(lat,lon);
    }

    public String getMatricula()
    {   return this.matricula;}

    public void setMatricula(String m)
    {   this.matricula = m;}

    public int getCubicagem()
    {   return this.cubicagem;}

    public void setCubicagem(int c)
    {   this.cubicagem = c;}

    public int getSizeServicoAtual(){
        return this.servico_atual.size();
    }
    
    public Camiao clone()
    {   return new Camiao(this.getMatricula(), this.getCubicagem(),this.localizacao.lat,this.localizacao.lon);}

    public boolean equals(Camiao c)
    {
        if(c!=null)
            return(this.matricula == c.getMatricula());
        else
            return false;
    }
}
