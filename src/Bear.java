import java.util.Map;

class Bear extends Predator {
    private static final Map<Class<? extends Animal>, Integer> diet = Map.of(Boa.class, 80, Horse.class, 40, Deer.class, 80, Rabbit.class, 80, Mouse.class,90, Goat.class, 70, Sheep.class, 70, Hog.class, 50, Buffalo.class,20, Duck.class,10);

    public Bear() { super("Bear", 2, 15, 200.0, diet); }

    @Override
    public void eat(Location location) {
        hunt(location);
    }

    @Override
    protected Animal createNew() {
        return new Bear();
    }

    @Override public Animal reproduce() { return new Bear(); }
}