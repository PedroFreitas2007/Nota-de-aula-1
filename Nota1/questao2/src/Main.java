import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o tamanho ou peso do produto: ");
        String tamanhoOuPeso = scanner.nextLine();

        System.out.print("Digite a cor do produto: ");
        String cor = scanner.nextLine();

        System.out.print("Digite o valor do produto: ");
        double valor = scanner.nextDouble();

        System.out.print("Digite a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(codigo, nome, tamanhoOuPeso, cor, valor, quantidadeEstoque);

        System.out.print("Digite a quantidade a ser vendida: ");
        int quantidadeVenda = scanner.nextInt();

        if (produto.realizarVenda(quantidadeVenda)) {
            System.out.print("Informe o método de pagamento (Pix, Espécie, Transferência, Débito, Crédito): ");
            scanner.nextLine(); // Limpar buffer
            String metodoPagamento = scanner.nextLine();

            double valorComDesconto = produto.aplicarDesconto(metodoPagamento);
            System.out.println("Valor do produto com desconto: R$" + valorComDesconto);

            if (metodoPagamento.equalsIgnoreCase("Espécie")) {
                System.out.print("Informe o valor pago: ");
                double valorPago = scanner.nextDouble();
                if (valorPago > valorComDesconto) {
                    double troco = valorPago - valorComDesconto;
                    System.out.println("Troco: R$" + troco);
                } else if (valorPago == valorComDesconto) {
                    System.out.println("Pagamento realizado sem troco.");
                } else {
                    System.out.println("Valor insuficiente para a compra.");
                }
            }

            if (metodoPagamento.equalsIgnoreCase("Crédito")) {
                System.out.println(produto.parcelamentoCredito());
            }

            System.out.println("Venda realizada com sucesso.");
            System.out.println("Estoque atual: " + produto.getQuantidadeEstoque());
        } else {
            System.out.println("Estoque insuficiente para a venda.");
        }

        scanner.close();
    }
}
