import java.util.Arrays;

public class QuartaQuestao {

    public static void main(String[] args) {
        int[] array1 = { 1, 3, 5, 7, 9 };
        int[] array2 = { 2, 4, 6, 8, 10 };

        int[] resultado = unirArraysOrdenados(array1, array2);

        System.out.println("Array Resultante: " + Arrays.toString(resultado));
    }

    public static int[] unirArraysOrdenados(int[] array1, int[] array2) {
        int tamanhoArray1 = array1.length;
        int tamanhoArray2 = array2.length;
        int[] resultado = new int[tamanhoArray1 + tamanhoArray2];

        int i = 0, j = 0, k = 0;

        while (i < tamanhoArray1 && j < tamanhoArray2) {
            if (array1[i] < array2[j]) {
                resultado[k] = array1[i];
                i++;
            } else {
                resultado[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i < tamanhoArray1) {
            resultado[k] = array1[i];
            i++;
            k++;
        }

        while (j < tamanhoArray2) {
            resultado[k] = array2[j];
            j++;
            k++;
        }

        return resultado;
    }
}
