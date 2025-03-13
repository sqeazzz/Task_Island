class Buffalo extends Animal {
    public Buffalo() { super("Buffalo", 3, 100, 700); }
    @Override
    public void eat(Location location) {
        if (location.plantCount > 0) {
            location.plantCount--;
            System.out.println(name + " ест траву.");
        }
    }
    @Override public Animal reproduce() { return new Rabbit(); }
}