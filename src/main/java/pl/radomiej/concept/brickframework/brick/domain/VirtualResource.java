package pl.radomiej.concept.brickframework.brick.domain;

public interface VirtualResource {
    public boolean open();
    public boolean append(byte[] data);
    public boolean close();
}
