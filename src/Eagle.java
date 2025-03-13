import java.util.Map;

class Eagle extends Predator {
    private static final Map<Class<? extends Animal>, Integer> diet = Map.of(Fox.class, 10,Rabbit.class, 90, Mouse.class, 90, Duck.class, 80);

    public Eagle() { super("Eagle", 4, 3, 6.0, diet); }

    @Override
    public void eat(Location location) {
        hunt(location);
    }

    @Override
    protected Animal createNew() {
        return new Eagle();
    }



    @Override public Animal reproduce() { return new Eagle(); }
}
