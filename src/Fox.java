import java.util.Map;

class Fox extends Predator {
    private static final Map<Class<? extends Animal>, Integer> diet = Map.of(Rabbit.class, 70, Mouse.class, 90, Duck.class, 60, Caterpillar.class, 40);

    public Fox() { super("Fox", 2, 2, 8, diet); }

    @Override
    public void eat(Location location) {
        hunt(location);
    }

    @Override
    protected Animal createNew() {
        return new Fox();
    }

    @Override public Animal reproduce() { return new Fox(); }
}