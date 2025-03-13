import java.util.Iterator;
import java.util.Map;

class Mouse extends Animal {
    private static final Map<Class<? extends Animal>, Integer> diet = Map.of(Caterpillar.class, 90 );

    public Mouse() { super("Mouse", 1, 2, 0.5); }

    @Override
    public void eat(Location location) {
        Iterator<Animal> iterator = location.animals.iterator();
        boolean ate = false;

        while (iterator.hasNext()) {
            Animal neighbor = iterator.next();
            if (diet.containsKey(neighbor.getClass()) && Math.random() * 100 < diet.get(neighbor.getClass())) {
                iterator.remove();
                System.out.println(name + " съел " + neighbor.getName());
                ate = true;
                break;
            }
        }

        if (!ate && location.plantCount > 0) {
            location.plantCount--;
            System.out.println(name + " ест траву.");
        }
    }

    @Override public Animal reproduce() { return new Mouse(); }
}
