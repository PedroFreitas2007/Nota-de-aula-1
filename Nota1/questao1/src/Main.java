import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        Aluno aluno = new Aluno(nomeAluno, nota1, nota2);

        double media = aluno.calcularMedia();
        System.out.println("Média do aluno " + aluno.getNome() + ": " + media);
        System.out.println("Situação: " + aluno.getSituacao());

        scanner.close();
    }
}
