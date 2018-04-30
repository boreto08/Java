package systemSplit.models.hardwares;

public class PowerHardwareComponent extends HardwareComponent {
    private static final String HARDWARE_TYPE = "Power";
    private static final int DIVIDENT = 3;
    private static final int DIVISOR = 4;


    public PowerHardwareComponent(String name, int capacity, int memory) {
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
        return memory + ((memory * DIVIDENT) / DIVISOR);
    }

    private int calcCapacity(int capacity) {
        return capacity - ((capacity * DIVIDENT) / DIVISOR);
    }
}
