class Horse extends Animal {
    public Horse() { super("Horse", 4, 10, 120.0); }
    @Override
    public void eat(Location location) {
        if (location.plantCount > 0) {
            location.plantCount--;
            System.out.println(name + " ест траву.");
        }
    }
    @Override public Animal reproduce() { return new Horse(); }
}