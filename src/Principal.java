import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner valorIngresado = new Scanner(System.in);
        int option = 0;

        ConsultaConversion request = new ConsultaConversion();

        Calculos calculos = new Calculos(request);
        generarArchivos generator = new generarArchivos();

        List<String> responses = new ArrayList<>();

        String menuOptions = """
                \n***************************************************
                *** Programa Conversor de Monedas ***
                1) Peso Colombiano ==>> Dólar Estadounidense
                2) Peso Colombiano ==>> Euro
                3) Peso Colombiano ==>> Libra Esterlina
                4) Dólar Estadounidense ==>> Peso Colombiano
                5) Euro ==>> Peso Colombiano
                6) Libra Esterlina ==>> Peso Colombiano
                9) Salir
                ***************************************************
                """;

        while (option != 9) {
            try {
                System.out.println(menuOptions);
                option = Integer.parseInt(valorIngresado.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (option) {
                    case 1:
                        calculos.storeValues("COP", "USD");
                        responses.add(formattedDate + " - " + calculos.messageResponse());
                        break;
                    case 2:
                        calculos.storeValues("COP", "EUR");
                        responses.add(formattedDate + " - " + calculos.messageResponse());
                        break;
                    case 3:
                        calculos.storeValues("COP", "GBP");
                        responses.add(formattedDate + " - " + calculos.messageResponse());
                        break;
                    case 4:
                        calculos.storeValues("USD", "COP");
                        responses.add(formattedDate + " - " + calculos.messageResponse());
                        break;
                    case 5:
                        calculos.storeValues("EUR", "COP");
                        responses.add(formattedDate + " - " + calculos.messageResponse());
                        break;
                    case 6:
                        calculos.storeValues("GBP", "COP");
                        responses.add(formattedDate + " - " + calculos.messageResponse());
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Debe ingresar una opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Solo se permiten códigos de moneda válidos.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Debe ingresar un valor numérico válido.");
            }
        }
        generator.saveJson(responses);

        System.out.println("Programa finalizado");
    }
}