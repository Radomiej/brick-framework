package pl.radomiej.concept.brickframework.context;

import lombok.Data;
import pl.radomiej.concept.brickframework.brick.JobContext;
import pl.radomiej.concept.brickframework.model.Forge;
import pl.radomiej.concept.brickframework.model.Item;
import pl.radomiej.concept.brickframework.model.ItemRequest;
import pl.radomiej.concept.brickframework.model.Store;

@Data
public class JobItemForgeContext extends JobContext<ItemRequest, Item> {
    private Store nearestStore;
    private Forge nearestForge;
}
