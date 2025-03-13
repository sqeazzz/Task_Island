class Caterpillar extends Animal {
    public Caterpillar() { super("Caterpillar", 0, 0, 0.01); }
    @Override
    public void eat(Location location) {
        if (location.plantCount > 0) {
            location.plantCount--;
            System.out.println(name + " ест траву.");
        }
    }
    @Override public Animal reproduce() { return new Rabbit(); }
}