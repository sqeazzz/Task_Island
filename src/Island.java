import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Island {
    private final int width;
    private final int height;
    private final Location[][] locations;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                locations[i][j] = new Location();
            }
        }
        populateIsland();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    private void populateIsland() {
        Random random = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (random.nextDouble() < 0.4) locations[i][j].animals.add(new Wolf());
                if (random.nextDouble() < 0.4) locations[i][j].animals.add(new Bear());
                if (random.nextDouble() < 0.4) locations[i][j].animals.add(new Boa());
                if (random.nextDouble() < 0.4) locations[i][j].animals.add(new Fox());
                if (random.nextDouble() < 0.4) locations[i][j].animals.add(new Eagle());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Deer());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Horse());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Rabbit());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Mouse());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Buffalo());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Duck());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Caterpillar());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Sheep());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Goat());
                if (random.nextDouble() < 0.6) locations[i][j].animals.add(new Hog());
            }
        }
    }

    public void moveAnimal(Animal animal, int oldX, int oldY, int newX, int newY) {
        if (locations[oldX][oldY].animals.remove(animal)) {
            locations[newX][newY].animals.add(animal);
        }
    }

    public void simulate() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        scheduler.scheduleAtFixedRate(this::updateAnimals, 0, 2, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::printStatistics, 0, 3, TimeUnit.SECONDS);
    }
    //Обновление животных
    private void updateAnimals() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                locations[i][j].plantCount = Math.min(10, locations[i][j].plantCount + 1);

                List<Animal> animalsCopy = new ArrayList<>(locations[i][j].animals);
                for (Animal animal : animalsCopy) {
                    animal.eat(locations[i][j]);
                    animal.move(this, i, j);
                    if (Math.random() < 0.1) {
                        locations[i][j].animals.add(animal.reproduce());
                    }
                }
            }
        }
    }
    //Статистика
    private void printStatistics() {
        try {
            System.out.println("=== Статистика по острову ===");
            boolean hasAnimals = false;

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    List<Animal> animalsCopy = new ArrayList<>(locations[i][j].animals);

                    if (!animalsCopy.isEmpty()) hasAnimals = true;

                    Map<String, Integer> speciesCount = new HashMap<>();
                    for (Animal animal : animalsCopy) {
                        if (animal != null) {
                            speciesCount.put(animal.getName(), speciesCount.getOrDefault(animal.getName(), 0) + 1);
                        }
                    }
                    System.out.println("Локация [" + i + ", " + j + "]: " + speciesCount + ", Растений: " + locations[i][j].plantCount);
                }
            }

            if (!hasAnimals) {
                System.out.println("Все животные вымерли. Завершаем симуляцию.");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}