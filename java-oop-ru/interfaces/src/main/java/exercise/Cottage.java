package exercise;

// BEGIN
public  class Cottage implements Home{
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home estateItem) {
        if(this.getArea() >= estateItem.getArea()) {
            return 1;
        } else if (this.getArea() <= estateItem.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d этажный коттедж площадью %s метров", floorCount, getArea());
    }
}
// END
