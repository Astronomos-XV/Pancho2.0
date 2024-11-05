

public class Fruit {
    private int id;           // ID único de la fruta
    private String name;      // Nombre de la fruta
    private double weight;    // Peso en kilogramos
    private double price;     // Precio en formato decimal

    public Fruit(int id, String name, double weight, double price) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    // Método toString para representaciones
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Peso: " + weight + " kg, Precio: $" + price;
    }
}