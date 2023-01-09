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
                    //MenuHubs(casa);
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
                }
            }
        }
    }
    
    public void MenuLoginFatura(Empresa casa, int nif)
    {
        System.out.print("Introduza o codigo do servico: ");
        int codigo = key.nextInt();
        
        String nome = casa.findCliente(nif).getNome();
        
        /*for(Servico s:casa.findCliente(nif).getLista())
            if(s.getCodigo() == codigo)
                Carga c = s.get */
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
                    //MenuCamioesDisponibilidade(casa);
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
        
        if(casa.findCamiao(mat) == null)
        {
            Camiao temp = new Camiao(mat,cub);
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
    
    /*
    public ArrayList<Camiao> MenuCamioesDisponibilidade(Empresa casa)
    {
        
    } 
    */
    
    public int MenuHubs(Empresa casa)
    {
        int op = -1;
        
        while(op!=0)
        {
            System.out.println("\n-- Menu --");
            System.out.println("1 - Verificar disponibilidade");
            System.out.println("0 - Voltar ");
            
            System.out.print("\nMenu a visitar: ");
            op = key.nextInt();
            
            switch(op)
            {
                case 0:
                    break;
                case 1:
                    //MenuCamioesDisponibilidade(casa);
                    break;
                case 2:
                    //MenuCamioesAddCamiao(casa);
                    break;
                case 3:
                    //MenuCamioesInfo(casa);
                    break;
            }
        }
       return op;
    }
}
