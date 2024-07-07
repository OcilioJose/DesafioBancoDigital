import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banco {

    private String nome;
    
    private List<Conta> contas;

    public Set<Cliente> clientes;

    
    public void listarClientes(){
        if (clientes == null){
           clientes = new HashSet<Cliente>(); 
          
           contas.forEach(c -> {clientes.add(c.getCliente());});
        }
    }

    public void imprimirListaDeClientes(){
        listarClientes();
        clientes.forEach(c -> {
            System.out.println("-----Lista de Clientes-----");
            System.out.println(c);
        });
    }

    public void imprimirExtrato(IConta conta){
        conta.imprimirExtrato();
    }

    public void imprimirExtrato(){
        System.out.println("-----Extrato Completo-----");
        System.out.println();
        contas.forEach(c -> {c.imprimirExtrato();});
    }

    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();
        
        Cliente ocilio = new Cliente();
        ocilio.setNome("Ocilio");
        ocilio.setCpf(1234567890);
        ocilio.setDataNascimento(new Date());

        Conta cc = new ContaCorrente(ocilio);
        Conta cp = new ContaPoupanca(ocilio);


        cc.depositar(500);
        cc.transferir(100, cp);

        List<Conta> contas = new ArrayList<Conta>();
        contas.add(cc);
        contas.add(cp);
       
        banco.setContas(contas);
        banco.imprimirExtrato();

        banco.imprimirListaDeClientes();
    }
}
