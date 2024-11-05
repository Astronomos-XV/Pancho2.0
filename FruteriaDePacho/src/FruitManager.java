import java.util.List;
import java.util.stream.Collectors;

public class FruitManager extends BaseManager<Fruit> {

    public FruitManager(String filepath) {
        super(filepath);
    }

    @Override
    protected void addItemFromLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length == 4) {
            int id = Integer.parseInt(parts[0].split(": ")[1]);
            String name = parts[1].split(": ")[1];
            double weight = Double.parseDouble(parts[2].split(": ")[1].replace(" kg", ""));
            double price = Double.parseDouble(parts[3].split(": ")[1].replace("$", ""));
            items.add(new Fruit(id, name, weight, price));
        }
    }

    public void create(Fruit fruit) {
        items.add(fruit);
        save();
    }

    public Fruit read(int id) {
        return items.stream().filter(fruit -> fruit.getId() == id).findFirst().orElse(null);
    }

    public void update(Fruit fruit) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == fruit.getId()) {
                items.set(i, fruit);
                save();
                break;
            }
        }
    }

    public void delete(int id) {
        items.removeIf(fruit -> fruit.getId() == id);
        save();
    }

    // Método para generar un reporte  
    public void generateReport(double minWeight) {
        List<Fruit> filteredFruits = items.stream()
                .filter(fruit -> fruit.getWeight() > minWeight) // Filtro por peso  
                .collect(Collectors.toList());

        double totalWeight = filteredFruits.stream()
                .mapToDouble(Fruit::getWeight) // Mapeo a pesos  
                .sum(); // Sumar pesos  

        double totalPrice = filteredFruits.stream()
                .mapToDouble(Fruit::getPrice) // Mapeo a precios  
                .sum(); // Sumar precios  

        long count = filteredFruits.stream()
                .count(); // Contar frutas filtradas  

        // Mostrar resultados  
        System.out.println("Reporte de Frutas con peso mayor a " + minWeight + " kg:");
        filteredFruits.forEach(System.out::println);
        System.out.println("Total de frutas: " + count);
        System.out.println("Peso total: " + totalWeight + " kg");
        System.out.println("Precio total: $" + totalPrice);
    }
}  
