package pl.radomiej.concept.brickframework.brick;

public interface Step<C extends JobContext> {
    void run(C jobContext);
}
