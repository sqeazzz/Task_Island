class Deer extends Animal {
    public Deer() { super("Deer", 3, 6, 80.0); }
    @Override
    public void eat(Location location) {
        if (location.plantCount > 0) {
            location.plantCount--;
            System.out.println(name + " ест траву.");
        }
    }
    @Override public Animal reproduce() { return new Deer(); }
}