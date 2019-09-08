package pl.radomiej.concept.brickframework.brick;

import lombok.Data;

import java.util.List;

@Data
public class JobContext<I, O> {
    private List<I> inputs;
    private I input;

    private List<O> outputs;
    private O output;
}
