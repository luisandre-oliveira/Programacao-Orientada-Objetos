import java.util.*; 

public class Menu
{
    private Scanner key;

    public Menu()
    {
        key = new Scanner(System.in);
    }
    
    public Empresa MenuPrincipal(Empresa casa)
    {
        int op = -1;
        
        while(op!=0)
        {
            System.out.println("\n-- Menu --");
            System.out.println("1 - Login "); // apenas para funcionalidades de clientes
            System.out.println("2 - Cliente ");
            System.out.println("3 - Camioes ");
            System.out.println("4 - Hubs ");
            System.out.println("0 - Quit ");
            
            System.out.print("\nMenu a visitar: ");
            op = key.nextInt();
        
            switch(op)
            {
                case 0:
                    break;
                    
                case 1: 
                    MenuLogin(casa);
                    break;
                    
                case 2:
                    MenuCliente(casa);
                    break;
                    
                case 3:
                    MenuCamioes(casa);
                    break;
                    
                case 4:
                    MenuHubs(casa);
                    break;
                
                default:
                    if(op != 0){
                        System.out.println("Erro... nao existe essa opcao.");
                        break;
                    }
            }
        }
       return casa;
    }
    
    public void MenuLogin(Empresa casa)
    {
        int op = -1;
        
        System.out.print("Introduza o seu NIF de utilizador: ");
        int nif = key.nextInt();
        
        if(casa.findCliente(nif) != null)
        {
            while(op!=0)
            {
                System.out.println("\n-- Menu --");
                System.out.println("1 - Emitir fatura de um servico");
                System.out.println("2 - Informacao de cliente");
                System.out.println("3 - Adicionar um servico");
                System.out.println("0 - Voltar ");
                
                System.out.print("\nMenu a visitar: ");
                op = key.nextInt();
                
                switch(op)
                {
                    case 0:
                        break;
                    case 1:
                        MenuLoginFatura(casa,nif);
                        break;
                    case 2:
                        MenuLoginInfo(casa,nif);
                        break;
                    case 3:
                        MenuLoginAddServico(casa,nif);
                        break;
                }
            }
        }
        else
        {
            System.out.println("NIF de cliente não existe");
        }
    }
    
    
    public void MenuLoginFatura(Empresa casa, int nif)
    {
        System.out.print("Introduza o codigo do servico: ");
        int codigo = key.nextInt();

        GregorianCalendar dataP = new GregorianCalendar();
        GregorianCalendar dataC = new GregorianCalendar();
        double preco = 0;
        int tipo = 0;

        for(Servico s:casa.findCliente(nif).getLista())
            if(s.getCodigo() == codigo)
            {
                preco = s.getPreco();
                tipo = s.getTipo();
                dataP = s.getData_pedido();
                dataC = s.getData_chegada();
            }

        System.out.println("Nome: " + casa.findCliente(nif).getNome());
        System.out.println("NIF: " + nif);
        
        int dia = dataP.get(Calendar.DATE);
        int mes = dataP.get(Calendar.MONTH) + 1;
        int ano = dataP.get(Calendar.YEAR);
        
        System.out.println("Data Pedido: " + dia + " " + mes + " " + ano);
        
        dia = dataC.get(Calendar.DATE);
        mes = dataC.get(Calendar.MONTH) + 1;
        ano = dataC.get(Calendar.YEAR);
        
        System.out.println("Data Chegada: " + dia + " " + mes + " " + ano);
        System.out.println("Valor: " + preco);

    }
    
    public void MenuLoginInfo(Empresa casa, int nif)
    {
        if(casa.findCliente(nif) != null)
        {
            System.out.println("NIF: " + nif);
            System.out.println("Nome: " + casa.findCliente(nif).getNome());
            System.out.println("Endereco: " + casa.findCliente(nif).getEndereco());
        }
        else{System.out.println("\nErro : o utilizador com o NIF " + nif + " nao existe");}
    }
    
    public Empresa MenuLoginAddServico(Empresa casa,int nif)
    {
        int size = casa.findCliente(nif).numero_servicos();

        int codigo = Integer.valueOf(String.valueOf(nif) + String.valueOf(size));

        System.out.print("Introduza a cubicagem minima: ");
        int cub = key.nextInt();

        System.out.print("Introduza o dia de hoje: ");
        int dia = key.nextInt();

        System.out.print("Introduza o mês: ");
        int mes = key.nextInt();

        System.out.print("Introduza o ano: ");
        int ano = key.nextInt();

        ArrayList <Camiao> lista = MenuCamioesDisponibilidade(casa);

        for(Camiao cam:lista)
        {
            if(cam.getCubicagem() > cub)
            {
                 Servico s = new Servico(codigo,nif,ano,mes,dia);
            }
        }

        return casa;
    }
    
    
    public Empresa MenuCliente(Empresa casa)
    {
        int op = -1;
        
        while(op!=0)
        {
            System.out.println("\n-- Menu --");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Informacao de cliente");
            System.out.println("0 - Voltar ");
            
            System.out.print("\nMenu a visitar: ");
            op = key.nextInt();
            
            switch(op)
            {
                case 0:
                    break;
                case 1:
                    MenuClienteAddCliente(casa);
                    break;
                case 2:
                    MenuClienteInfo(casa);
                    break;
            }
        }
       return casa;
    }
    
    public Empresa MenuClienteAddCliente(Empresa casa)
    {
        System.out.print("Indique o nome do novo cliente: ");
        String nome = key.next();
        System.out.print("Indique o NIF: ");
        int nif = key.nextInt();
        System.out.print("Indique o endereco: ");
        String endereco = key.next();
        
        if(casa.findCliente(nif) == null)
        {
            Esporadico temp = new Esporadico(nif,nome,endereco);
            casa.addCliente(temp);
        }
        else
        {   System.out.println("Cliente já existe, tente novamente"); }
        
        return casa;
    }
    
    public void MenuClienteInfo(Empresa casa)
    {
        System.out.print("Indique o NIF a procurar: ");
        int nif = key.nextInt();
        
        if(casa.findCliente(nif) != null)
        {
            System.out.println("NIF: " + nif);
            System.out.println("Nome: " + casa.findCliente(nif).getNome());
            System.out.println("Endereco: " + casa.findCliente(nif).getEndereco());
        }
        else{System.out.println("\nErro : o utilizador com o NIF " + nif + " nao existe");}
    }
    
    public int MenuCamioes(Empresa casa)
    {
        int op = -1;
        
        while(op!=0)
        {
            
            System.out.println("\n-- Menu --");
            System.out.println("1 - Adicionar camiao");
            System.out.println("2 - Informacao de camiao");
            System.out.println("3 - Verificar disponibilidade");
            System.out.println("0 - Voltar ");
            
            System.out.print("\nMenu a visitar: ");
            op = key.nextInt();
            
            switch(op)
            {
                case 0:
                    break;
                case 1:
                    MenuCamioesAddCamiao(casa);
                    break;
                case 2:
                    MenuCamioesInfo(casa);
                    break;
                case 3:
                    ArrayList<Camiao> temp = new ArrayList<Camiao>();
                    temp = MenuCamioesDisponibilidade(casa);
                    
                    for(Camiao c:temp){
                        System.out.println(c.getMatricula());
                    }
                    break;
            }
        }
       return op;
    }
    
    public Empresa MenuCamioesAddCamiao(Empresa casa)
    {
        System.out.print("Indique a matricula do camiao novo: ");
        String mat = key.next();
        System.out.print("Indique a cubicagem: ");
        int cub = key.nextInt();
        System.out.print("\nLatitude do Hub:");
        int lat = key.nextInt();
        System.out.print("\nLongitude do Hub:");
        int lon = key.nextInt();
        
        if(casa.findCamiao(mat) == null)
        {
            Camiao temp = new Camiao(mat,cub,lat,lon);
            casa.addCamiao(temp);
        }
        else
        {   System.out.println("Matricula já existe, tente novamente"); }
        
        return casa;
    }
    
    public void MenuCamioesInfo(Empresa casa)
    {
        System.out.println("Indique a matricula do camiao: ");
        String mat = key.next();
        
        Camiao c = casa.findCamiao(mat);
        
        if(c != null)
        {   System.out.println("Matricula: " + c.getMatricula() + " e Cubicagem: " + c.getCubicagem()); }
        else
        {   System.out.println("Camiao "); }
    }
    
    
    public ArrayList<Camiao> MenuCamioesDisponibilidade(Empresa casa)
    {
        ArrayList<Camiao> temp = new ArrayList<Camiao>();
        
        
        for(Camiao c:casa.getListaCamiao()){
            if(c.getSizeServicoAtual()==0){
                temp.add(c);
            }
        }  
        
        return temp;
    } 
    
    
    public int MenuHubs(Empresa casa)
    {
        int op = -1;
        
        while(op!=0)
        {
            System.out.println("\n-- Menu --");
            System.out.println("1 -Adicionar Hub");
            System.out.println("2 -Ver Hub");
            System.out.println("3 -Adicionar Ligação");
            System.out.println("0 - Voltar ");
            
            System.out.print("\nMenu a visitar: ");
            op = key.nextInt();
            
            switch(op)
            {
                case 0:
                    break;
                case 1:
                    MenuHubsAddHub(casa);
                    break;
                case 2:
                    MenuHubsInfoHub(casa);
                    break;
                case 3:
                    MenuHubsAddLigacao(casa);
                    break;
            }
        }
       return op;
    }
    
    public void MenuHubsAddHub(Empresa casa)
    {
        System.out.print("\nIndique a cidade do Hub: ");
        String nome = key.next();
        int lat,lon;
        Boolean ref = true;
        if(casa.findHub(nome)==null){
            int op = -1;
            
            while(op != 0 && op != 1){
                System.out.print("\nRefrigeração(y/n): ");
                op = key.nextInt();
                    switch(op)
                    {
                        case 1:
                            ref = true;
                            break;
                        case 0:
                            ref = false;
                            break;
                        default:
                            break;
                        
                    }
            }
            
            System.out.print("\nLatitude do Hub:");
            lat = key.nextInt();
            System.out.print("\nLongitude do Hub:");
            lon = key.nextInt();
            
            Hub temp = new Hub(nome,ref,lat,lon);
            
            System.out.print("\nAdicionar Ligações?(0 para não): ");
            op = key.nextInt();
            while(op != 0){
                System.out.print("\nIndique uma ligação do Hub (termine com \"Termina\"): ");
                nome = key.next();
                
                Hub liga = casa.findHub(nome);
                if(liga != null){
                    Localizacao local2 = liga.getLocal();
                    double d = Math.sqrt(Math.pow(local2.lat - lat, 2) + Math.pow(local2.lon - lon, 2));
                    temp.add(nome,(int)d);
                }
                System.out.print("\nAdicionar Ligações?(0 para não): ");
                op = key.nextInt();
            }
            
            
            casa.addHub(temp);
        }else{
            System.out.println("\nJá existe um Hub nesta cidade.");
        }
        
    }
    
    public void MenuHubsInfoHub(Empresa casa){
        System.out.print("\nIndique a cidade do Hub: ");
        String nome = key.next();
        Hub temp = casa.findHub(nome);
        if(temp != null){
            System.out.print("\nCidade do Hub: ");
            System.out.println(temp.getNome());
            if(temp.getRefrig()){
                System.out.println("Refrigeração");
            }
            Localizacao local = temp.getLocal();
            System.out.print("Latitude: ");
            System.out.println(local.lat);
            System.out.print("Longitude: ");
            System.out.println(local.lon);
        }else{
            System.out.println("Não existe um Hub nesta cidade");
        }
    }
    
    public void MenuHubsAddLigacao(Empresa casa){
        System.out.print("\nIndique a cidade do Hub: ");
        String nome = key.next();
        Hub temp = casa.findHub(nome);
        if(temp != null){
            System.out.print("\nIndique a cidade da Ligação: ");
            String nome2 = key.next();
            Hub lig = casa.findHub(nome2);
            if(lig != null){
                Localizacao local1 = temp.getLocal();
                Localizacao local2 = lig.getLocal();
                double d = Math.sqrt(Math.pow(local2.lat - local1.lat, 2) + Math.pow(local2.lon - local1.lon, 2));
                temp.add(nome2,(int)d);
            }else{
                System.out.println("Não existe um Hub nesta cidade");
            }
        }else{
            System.out.println("Não existe um Hub nesta cidade");
        }
    }
}