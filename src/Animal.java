import java.util.Random;

public abstract class Animal {
    protected String name;
    protected int speed;
    protected double maxFood;
    protected double weight;
    protected boolean isAlive = true;

    public Animal(String name, int speed, double maxFood, double weight) {
        this.name = name;
        this.speed = speed;
        this.maxFood = maxFood;
        this.weight = weight;
    }

    public String getName() { return name; }
    public abstract void eat(Location location);
    public void move(Island island, int x, int y) {
        Random random = new Random();
        int newX = Math.max(0, Math.min(island.getWidth() - 1, x + random.nextInt(3) - 1));
        int newY = Math.max(0, Math.min(island.getHeight() - 1, y + random.nextInt(3) - 1));
        island.moveAnimal(this, x, y, newX, newY);
    }
    public abstract Animal reproduce();
}
