package pl.radomiej.concept.brickframework.service;

import org.springframework.stereotype.Component;
import pl.radomiej.concept.brickframework.brick.Job;
import pl.radomiej.concept.brickframework.brick.JobLauncher;
import pl.radomiej.concept.brickframework.context.JobItemForgeContext;
import pl.radomiej.concept.brickframework.model.Forge;
import pl.radomiej.concept.brickframework.model.Item;
import pl.radomiej.concept.brickframework.model.ItemRequest;
import pl.radomiej.concept.brickframework.model.Store;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class BrickFactory {

    private JobLauncher jobLuncher = new JobLauncher();
    private Job<JobItemForgeContext> firstJob;

    @PostConstruct
    private void init() {
        firstJob = createFirstJob();
    }

    private Job<JobItemForgeContext> createFirstJob() {
        Job<JobItemForgeContext> job = new Job<JobItemForgeContext>();
        job.step(this::findStore);
        job.step(this::findForge);
        job.step(this::processItemRequest);
        return job;
    }

    private void findStore(JobItemForgeContext jobItemForgeContext) {
        Store store = new Store();
        jobItemForgeContext.setNearestStore(store);
    }

    private void findForge(JobItemForgeContext jobItemForgeContext) {
        Forge forge = new Forge();
        jobItemForgeContext.setNearestForge(forge);
    }

    private void processItemRequest(JobItemForgeContext jobItemForgeContext) {
        List<Item> results = jobItemForgeContext.getInputs().stream().flatMap(r -> forgeItems(r).stream()).collect(Collectors.toList());
        jobItemForgeContext.setOutputs(results);
    }

    private List<Item> forgeItems(ItemRequest itemRequest) {
        return IntStream.range(1, itemRequest.getCount()).mapToObj(i -> forgeItem(i, itemRequest)).collect(Collectors.toList());
    }

    private Item forgeItem(int i, ItemRequest itemRequest) {
        Item item = new Item();
        item.setId(i);
        item.setName(itemRequest.getName());
        return item;
    }


}
