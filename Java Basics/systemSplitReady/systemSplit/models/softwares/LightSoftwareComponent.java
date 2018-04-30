package systemSplit.models.softwares;

public class LightSoftwareComponent extends SoftwareComponent {
    private static final String SOFTWARE_TYPE = "Light";

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, SOFTWARE_TYPE, capacity, memory);
    }

    @Override
    public int getCapacity() {
        return this.calcCapacity(super.getCapacity());
    }

    @Override
    public int getMemory() {
        return this.calcMemory(super.getMemory());
    }

    private int calcCapacity(int capacity) {
        return capacity + (capacity / 2);
    }
    private int calcMemory(int memory) {
        return memory - (memory / 2);
    }
}
