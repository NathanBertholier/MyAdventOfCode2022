package Day2;

public interface Shape {
    public static Shape createShape(String symbol) {
        switch (symbol) {
            case "A", "X":
                return new Rock();
            case "B", "Y":
                return new Paper();
            case "C", "Z":
                return new Scissors();
        }
        throw new IllegalStateException();
    }

    static int computeWin(Shape shape1, Shape shape2) {
        return shape1.against(shape2);
    }

    default int against(Shape shape) {
        return switch (shape) {
            case Rock rock -> against(rock);
            case Paper paper -> against(paper);
            case Scissors scissors -> against(scissors);
            default -> throw new IllegalStateException("Unexpected value: " + shape);
        };
    }

    default Shape findShape(String symbol){
        return switch (symbol){
            case "X" -> winAgainst();
            case "Y" -> drawAgainst();
            case "Z" -> looseAgainst();
            default -> throw new IllegalStateException("Unexpected value: " + symbol);
        };
    }

    int getValue();

    int against(Rock rock);

    int against(Paper paper);

    int against(Scissors scissors);

    Shape winAgainst();

    Shape looseAgainst();

    default Shape drawAgainst(){
        return this;
    }


}
