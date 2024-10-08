public class Produto {
    private int codigo;
    private String nome;
    private String tamanhoOuPeso;
    private String cor;
    private double valor;
    private int quantidadeEstoque;

    public Produto(int codigo, String nome, String tamanhoOuPeso, String cor, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoOuPeso = tamanhoOuPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean realizarVenda(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
            return true;
        } else {
            return false;
        }
    }

    public double aplicarDesconto(String metodoPagamento) {
        if (metodoPagamento.equalsIgnoreCase("Pix") ||
                metodoPagamento.equalsIgnoreCase("Espécie") ||
                metodoPagamento.equalsIgnoreCase("Transferência") ||
                metodoPagamento.equalsIgnoreCase("Débito")) {
            return valor * 0.95;
        } else if (metodoPagamento.equalsIgnoreCase("Crédito")) {
            return valor;
        } else {
            return valor;
        }
    }

    public String parcelamentoCredito() {
        return "Parcelamento disponível em até 3x sem juros";
    }
}
