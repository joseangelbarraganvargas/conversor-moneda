import java.util.Scanner;


public class Calculos {
    private String currencyBase;
    private String targetCurrency;
    private double amount;

    Scanner valueEntered = new Scanner(System.in);
    ConsultaConversion conversion;

    public Calculos(ConsultaConversion conversion) {
        this.conversion = conversion;
    }

    public String getCurrencyBase() {
        return currencyBase;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void storeValues(String currencyBase, String targetCurrency){
        this.currencyBase = currencyBase;
        this.targetCurrency = targetCurrency;

        System.out.println("Ingrese el valor a convertir");

        this.amount = Double.parseDouble(valueEntered.nextLine());
    }


    public String messageResponse() {
        String mensaje = getAmount()+ " ["+getCurrencyBase().toUpperCase() + "] equivalen a: " + conversion.buscaConversion(getCurrencyBase(), getTargetCurrency(), getAmount())+ " ["+getTargetCurrency().toUpperCase() + "] " ;
        System.out.println(mensaje);
        return mensaje;
    }
}
