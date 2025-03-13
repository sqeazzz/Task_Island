import java.util.Map;

class Wolf extends Predator {
    private static final Map<Class<? extends Animal>, Integer> diet = Map.of(Rabbit.class, 60, Deer.class, 40, Mouse.class, 80, Horse.class, 10, Goat.class, 60, Sheep.class, 70, Hog.class,15, Buffalo.class, 10, Duck.class, 40);

    public Wolf() { super("Wolf", 3, 8, 50.0, diet); }

    @Override
    public void eat(Location location) {
        hunt(location);
    }

    @Override
    protected Animal createNew() {
        return new Wolf();
    }

    @Override public Animal reproduce() { return new Wolf(); }
}