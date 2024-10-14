import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class generarArchivos {
    public void saveJson(List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter("historial.txt");
            for (String result : list) {
                fileWriter.write(result);
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Archivo historial de consultas guardado en 'historial.txt'");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo historial: " + e.getMessage());
        }
    }
}