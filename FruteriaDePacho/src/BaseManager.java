import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseManager<T> {
    protected List<T> items; // Lista de elementos
    protected String filepath;

    public BaseManager(String filepath) {
        this.filepath = filepath;
        this.items = new ArrayList<>();
        load();
    }

    // Cargar los elementos desde el archivo
    private void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                addItemFromLine(line);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

    // Método abstracto para agregar elementos desde una línea
    protected abstract void addItemFromLine(String line);

    // Guardar los elementos en el archivo
    protected void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (T item : items) {
                bw.write(item.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}