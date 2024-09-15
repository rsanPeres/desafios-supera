import java.util.Objects;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

public class SequenciadorCoresResistor {

    public static String[] separaStrings(String valorOhms) {
        String[] valor = valorOhms.split(" ");

        String[] numerosXletra = new String[2];

        numerosXletra[0] = valor[0].replaceAll("[^0-9]", "");
        numerosXletra[1] = valor[0].replaceAll("[^a-zA-Z]", "");

        return numerosXletra;
    }

    public static String pegaCor(Integer numero) throws NameNotFoundException {
        switch (numero) {
            case 0 -> {
                return "preto";
            }
            case 1 -> {
                return "marrom";
            }
            case 2 -> {
                return "vermelho";
            }
            case 3 -> {
                return "laranja";
            }
            case 4 -> {
                return "amarelo";
            }
            case 5 -> {
                return " verde";
            }
            case 6 -> {
                return " azul";
            }
            case 7 -> {
                return " violeta";
            }
            case 8 -> {
                return " cinza";
            }
            case 9 -> {
                return " branco";
            }
        }
        throw new NameNotFoundException(
                "O valor enviado: " + numero + " não está dentro do escopo dos resistores, faça uma nova tentativa!");
    }

    public static String[] encontraCorDigitos(Integer numero, String zeros) {
        try {
            String[] cores = new String[3];
            int contador = 2;

            if (Objects.nonNull(zeros)) {
                switch (zeros) {
                    case "k" -> cores[2] = "vermelho";
                    case "M" -> cores[2] = "verde";
                }
            }

            if (numero <= 10) {
                cores[1] = "preto";
                cores[2] = (Objects.isNull(cores[2])) ? "preto" : cores[2];
                contador = 0;
            } 
            else if (numero >= 10 && numero < 100) {
                cores[2] = (Objects.isNull(cores[2])) ? "preto" : cores[2];
                contador = 1;
            } 
            else if (numero >= 100 && numero < 1000) {
                cores[2] = (Objects.isNull(cores[2])) ? "marrom" : cores[2];
            }

            while (numero > 0 && contador >= 0) {
                int digito = numero % 10;
                
                if (contador != 2 || digito != 0){
                    cores[contador] = pegaCor(digito);
                }
                
                numero /= 10;
                contador--;
            }

            return cores;

        } catch (Exception e) {
            e.getMessage();
        }
        return new String[3];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String valorOhms = scanner.nextLine();
        scanner.close();

        String[] ohms = separaStrings(valorOhms);

        Integer numeros = Integer.parseInt(ohms[0]);

        String[] cores = encontraCorDigitos(numeros, ohms[1]);

        System.out.println(cores[0] + " " + cores[1] + " " + cores[2] + " dourado");

    }

}
