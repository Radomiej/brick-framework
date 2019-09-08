package pl.radomiej.concept.brickframework.brick;

import java.util.ArrayList;
import java.util.List;

public class Job<C extends JobContext> {
    private static class SomeContainer<C> {
        public C createContents(Class<C> clazz) throws IllegalAccessException, InstantiationException {
            return clazz.newInstance();
        }
    }

    private List<Step> steps = new ArrayList<>();

    public Job<C> step(Step<C> step){
        steps.add(step);
        return this;
    }
}
