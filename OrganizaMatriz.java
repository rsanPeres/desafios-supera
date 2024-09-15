import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrganizaMatriz {

    public static void dumpMatriz(Integer[][] matriz, Integer linha, Integer coluna){
        Integer contadorI = 0;
        Integer contadorJ = 0;

        System.out.print("\n");
        System.out.print("\n");

        while (contadorI < linha) {
            System.out.print("| ");
            while (contadorJ < coluna) {
                System.out.print(matriz[contadorI][contadorJ] + " | ");
                contadorJ ++;
            }
            contadorJ = 0;
            contadorI ++;
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");
    }

    public static void dumpSentidoHorário(Integer[][] matriz, Integer linha, Integer coluna){
        List<Integer> resultado = new ArrayList<>();

        Integer contadorI = 0;
        Integer contadorJ = 0;
        Integer contadorX = linha - 1;
        Integer contadorY = coluna - 1;

        while (contadorI <= contadorX && contadorJ <= contadorY) {
            for (int j = contadorJ; j <= contadorY; j++) {
                resultado.add(matriz[contadorI][j]);
            }
            contadorI++;

            for (int i = contadorI; i <= contadorX; i++) {
                resultado.add(matriz[i][contadorY]);
            }
            contadorY--;

            if (contadorI <= contadorX) {
                for (int j = contadorY; j >= contadorJ; j--) {
                    resultado.add(matriz[contadorX][j]);
                }
                contadorX--;
            }

            if (contadorJ <= contadorY) {
                for (int i = contadorX; i >= contadorI; i--) {
                    resultado.add(matriz[i][contadorJ]);
                }
                contadorJ++;
            }
        }

        resultado.forEach(numero -> System.out.println(numero));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Digite o tamanho da matriz, um valor seguido de enter e o próximo valor. \n Exmplo: para uma matriz 2x3, digite: 2 enter 3)");
        
        Integer i = scanner.nextInt();
        Integer j = scanner.nextInt();         
        Integer[][] matriz = new Integer[i][j];

        scanner.nextLine();

        System.out.println(
            "Digite cada valor seguido de enter. \n Se desejar parar de inserir valores, digite 'fim': ");

        Integer contadorI = 0;
        Integer contadorJ = 0;

        while (contadorI < i) {
            while (contadorJ < j) {    
                String entradaI = scanner.nextLine();
                
                if (entradaI.equalsIgnoreCase("fim")) {
                    break;
                }
                matriz[contadorI][contadorJ] = Integer.parseInt(entradaI);
                contadorJ ++;
            }
            contadorJ = 0;
            contadorI ++;
        }

        scanner.close();

        dumpMatriz(matriz, i, j);

        dumpSentidoHorário(matriz, i, j);
    }
}
