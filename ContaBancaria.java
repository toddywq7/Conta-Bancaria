public class ContaBancaria {
    private String titular;
    private double saldo;
    private double limite;

    public ContaBancaria(String titular, double limite) {
        this.titular = titular;
        this.saldo = 0.0;
        this.limite = limite;
    }


    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }


    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }


    public boolean sacar(double valor) {
        if (valor > 0 && (this.saldo + this.limite) >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }
}