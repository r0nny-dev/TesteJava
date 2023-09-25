public class TerceiraQuestao {
    public static void main(String[] args) {
        int limite = 10; // O limite comum para todas as sequências
        int primeiroNumero = 1; // O primeiro número (sempre ímpar)

        while (primeiroNumero <= limite) {
            System.out.print("(" + primeiroNumero + ", ");

            for (int i = 1; i <= limite; i++) {
                System.out.print(i);

                if (i < limite) {
                    System.out.print(" ");
                }
            }

            System.out.print(")\n");
            primeiroNumero += 2; // Avança para o próximo número ímpar
        }
    }
}
