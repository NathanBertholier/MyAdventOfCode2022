package Day2;

public class Paper implements Shape {

    @Override
    public int getValue() {
        return 2;
    }

    @Override
    public int against(Rock rock) {
        return 6;
    }

    @Override
    public int against(Paper paper) {
        return 3;
    }

    @Override
    public int against(Scissors scissors) {
        return 0;
    }

    @Override
    public Shape winAgainst() {
        return new Rock();
    }

    @Override
    public Shape looseAgainst() {
        return new Scissors();
    }
}
