import java.util.Scanner;

public class SegundaQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler as idades dos homens
        System.out.print("Digite a idade do primeiro homem: ");
        int idadeHomem1 = scanner.nextInt();

        System.out.print("Digite a idade do segundo homem: ");
        int idadeHomem2 = scanner.nextInt();

        // Ler as idades das mulheres
        System.out.print("Digite a idade da primeira mulher: ");
        int idadeMulher1 = scanner.nextInt();

        System.out.print("Digite a idade da segunda mulher: ");
        int idadeMulher2 = scanner.nextInt();

        // Encontrar o homem mais velho e o mais novo
        int homemMaisVelho = Math.max(idadeHomem1, idadeHomem2);
        int homemMaisNovo = Math.min(idadeHomem1, idadeHomem2);

        // Encontrar a mulher mais velha e a mais nova
        int mulherMaisVelha = Math.max(idadeMulher1, idadeMulher2);
        int mulherMaisNova = Math.min(idadeMulher1, idadeMulher2);

        // Calcular a soma das idades do homem mais velho com a mulher mais nova
        int somaIdades = homemMaisVelho + mulherMaisNova;

        // Calcular o produto das idades do homem mais novo com a mulher mais velha
        int produtoIdades = homemMaisNovo * mulherMaisVelha;

        // Exibir os resultados
        System.out.println("A soma das idades do homem mais velho com a mulher mais nova é: " + somaIdades);
        System.out.println("O produto das idades do homem mais novo com a mulher mais velha é: " + produtoIdades);

        scanner.close();
    }
}
