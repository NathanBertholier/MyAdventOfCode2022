package Day2;

public class Scissors implements Shape {

    @Override
    public int getValue() {
        return 3;
    }

    @Override
    public int against(Rock rock) {
        return 0;
    }

    @Override
    public int against(Paper paper) {
        return 6;
    }

    @Override
    public int against(Scissors scissors) {
        return 3;
    }

    @Override
    public Shape winAgainst() {
        return new Paper();
    }

    @Override
    public Shape looseAgainst() {
        return new Rock();
    }
}
