import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "frutas.txt"; // Ruta del archivo donde se guardarán las frutas
    private static FruitManager fruitManager; // Objeto para manejar las frutas

    public static void main(String[] args) {
        fruitManager = new FruitManager(FILE_PATH); // Inicializa el gestor de frutas
        Scanner scanner = new Scanner(System.in); // Scanner para entrada de usuario

        while (true) {
            System.out.println("\nGestión de Frutas");
            System.out.println("1. Crear Fruta");
            System.out.println("2. Leer Fruta");
            System.out.println("3. Actualizar Fruta");
            System.out.println("4. Borrar Fruta");
            System.out.println("5. Listar Frutas");
            System.out.println("6. Reporte de Frutas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt(); // Leer la opción elegida

            switch (choice) {
                case 1: // Crear Fruta
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Peso (en kg): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Precio: ");
                    double price = scanner.nextDouble();
                    fruitManager.create(new Fruit(id, name, weight, price)); // Crear nueva fruta
                    System.out.println("Fruta creada.");
                    break;
                case 2: // Leer Fruta
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    Fruit fruit = fruitManager.read(id); // Leer fruta por ID
                    System.out.println(fruit != null ? fruit : "Fruta no encontrada.");
                    break;
                case 3: // Actualizar Fruta
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nuevo Nombre: ");
                    name = scanner.nextLine();
                    System.out.print("Nuevo Peso (en kg): ");
                    weight = scanner.nextDouble();
                    System.out.print("Nuevo Precio: ");
                    price = scanner.nextDouble();
                    fruitManager.update(new Fruit(id, name, weight, price)); // Actualizar fruta
                    System.out.println("Fruta actualizada.");
                    break;
                case 4: // Borrar Fruta
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    fruitManager.delete(id); // Borrar fruta por ID
                    System.out.println("Fruta borrada.");
                    break;
                case 5: // Listar Frutas
                    System.out.println("Lista de Frutas:");
                    for (Fruit fruitInList : fruitManager.items) {
                        System.out.println(fruitInList); // Mostrar lista de frutas
                    }
                    break;
                case 6: // Generar Reporte
                    System.out.print("Peso mínimo para el reporte: ");
                    double minWeight = scanner.nextDouble(); // Leer peso mínimo para filtrado
                    fruitManager.generateReport(minWeight); // Generar reporte de frutas
                    break;
                case 0: // Salir
                    scanner.close(); // Cerrar el scanner
                    return; // Terminar el programa
                default:
                    System.out.println("Opción no válida."); // Manejo de opción no válida
                    break;
            }
        }
    }
}