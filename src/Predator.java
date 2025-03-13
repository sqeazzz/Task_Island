import java.util.Iterator;
import java.util.Map;

abstract class Predator extends Animal {
    protected final Map<Class<? extends Animal>, Integer> diet;
    private boolean isHungry = false;
    private int hungerLevel = 5;

    public Predator(String name, int speed, int maxFood, double weight, Map<Class<? extends Animal>, Integer> diet) {
        super(name, speed, maxFood, weight);
        this.diet = diet;
    }

    protected void hunt(Location location) {
        Iterator<Animal> iterator = location.animals.iterator();
        boolean ate = false;

        while (iterator.hasNext()) {
            Animal neighbor = iterator.next();
            if (diet.containsKey(neighbor.getClass()) && Math.random() * 100 < diet.get(neighbor.getClass())) {
                iterator.remove();
                isHungry = true;
                hungerLevel = 5;
                System.out.println(name + " съел " + neighbor.name);
                ate = true;
                break;
            }
        }

        if (!ate) {
            hungerLevel--;
            if (hungerLevel <= 0) {
                System.out.println(name + " умер от голода.");
                location.animals.remove(this);
            }
        }
    }

    @Override
    public Animal reproduce() {
        if (isHungry && hungerLevel > 2) {
            isHungry = false;
            System.out.println(name + " размножился.");
            return createNew();
        }
        return null;
    }

    protected abstract Animal createNew();
}