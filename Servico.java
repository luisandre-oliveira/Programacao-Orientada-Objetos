import java.util.GregorianCalendar;

public class Servico {
    private int codigo;
    private int nif_cliente;
    private GregorianCalendar data_pedido;

    private Localizacao origem;
    private Localizacao destino;

    public Servico(int c, int nc, int y, int m, int d)
    {
        this.codigo = c;
        this.nif_cliente = nc;
        this.data_pedido = new GregorianCalendar(y,m+1,d);
    }

    public int getCodigo()
    {   return this.codigo;}

    public void setCodigo(int c)
    {   this.codigo = c;}

    public int getNif_cliente()
    {   return this.nif_cliente;}

    public void setNif_cliente(int nc)
    {   this.nif_cliente = nc;}

    public GregorianCalendar getData_pedido()
    {   return this.data_pedido;}

    public void setData_pedido(int y, int m, int d)
    {   this.data_pedido = new GregorianCalendar(y,m+1,d);}
}
