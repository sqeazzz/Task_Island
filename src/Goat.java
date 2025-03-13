class Goat extends Animal {
    public Goat() { super("Goat", 3, 10, 60); }
    @Override
    public void eat(Location location) {
        if (location.plantCount > 0) {
            location.plantCount--;
            System.out.println(name + " ест траву.");
        }
    }
    @Override public Animal reproduce() { return new Rabbit(); }
}
