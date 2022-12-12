package exercise;

// BEGIN
public class Flat implements Home{
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }


    @Override
    public double getArea() {
        return area + balconyArea;
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
        return String.format("Квартира площадью %s метров на %d этаже", getArea(), floor);
    }
}
// END
