public class Cube {
    private double sideLength;
    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    public double surfaceArea() {
        return 6 * sideLength * sideLength;
    }

    public double volume() {
        return sideLength * sideLength * sideLength;
    }

    public double diagonal() {
        return Math.sqrt(3) * sideLength;
    }
    public void print() {
        System.out.println("Cube with side " + sideLength + " :");
        System.out.println("S = " + surfaceArea());
        System.out.println("V = " + volume());
        System.out.println("d = " + diagonal());
    }

    public static void main(String[] args) {
        Cube cube = new Cube(10);
        cube.print();
    }
}
