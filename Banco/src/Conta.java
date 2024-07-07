import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Conta implements IConta {

    private static int AGENCIA_PADRAO = 0001;

    private static int SEQUENCIAL = 1;

    protected int agencia;

    protected int numero;

    protected double saldo;

    private Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta conta) {
       sacar(valor);
       conta.depositar(valor); 
    }

    protected void imprimirInfoComuns(){
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Número: %d", numero));
        System.out.println(String.format("saldo: %.2f", saldo));
     }
        
}
