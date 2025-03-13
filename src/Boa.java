import java.util.Map;

class Boa extends Predator {
    private static final Map<Class<? extends Animal>, Integer> diet = Map.of(Fox.class,15,Rabbit.class, 20, Mouse.class, 40, Duck.class, 10);

    public Boa() { super("Boa", 1, 3, 15, diet); }

    @Override
    public void eat(Location location) {
        hunt(location);
    }

    @Override
    protected Animal createNew() {
        return new Boa();
    }

    @Override public Animal reproduce() { return new Boa(); }
}