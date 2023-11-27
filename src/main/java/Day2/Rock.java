package Day2;

public class Rock implements Shape {

    @Override
    public int getValue() {
        return 1;
    }

    @Override
    public int against(Rock rock) {
        return 3;
    }

    @Override
    public int against(Paper paper) {
        return 0;
    }

    @Override
    public int against(Scissors scissors) {
        return 6;
    }

    @Override
    public Shape winAgainst() {
        return new Scissors();
    }

    @Override
    public Shape looseAgainst() {
        return new Paper();
    }
}
