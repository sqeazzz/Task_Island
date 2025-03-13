class Rabbit extends Animal {
    public Rabbit() { super("Rabbit", 2, 4, 2.5); }
    @Override
    public void eat(Location location) {
        if (location.plantCount > 0) {
            location.plantCount--;
            System.out.println(name + " ест траву.");
        }
    }
    @Override public Animal reproduce() { return new Rabbit(); }
}
