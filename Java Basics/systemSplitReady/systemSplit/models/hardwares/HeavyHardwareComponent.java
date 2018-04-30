package systemSplit.models.hardwares;

public class HeavyHardwareComponent extends HardwareComponent {
    private static final String HARDWARE_TYPE = "Heavy";
    private static final int DELIMITER = 4;
    private static final int INCREMENTER = 2;

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, HARDWARE_TYPE, capacity, memory);
    }

    @Override
    public int getCapacity() {
        return this.calcCapacity(super.getCapacity());
    }

    @Override
    public int getMemory() {
        return this.calcMemory(super.getMemory());
    }

    private int calcMemory(int memory) {
        return memory - (memory / DELIMITER);
    }

    private int calcCapacity(int capacity) {
        return capacity * INCREMENTER;
    }
}
