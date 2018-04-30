package systemSplit.models.softwares;

public class ExpressSoftwareComponent extends SoftwareComponent {
    private static final String SOFTWARE_TYPE = "Express";

    public ExpressSoftwareComponent(String name, int capacity, int memory) {
        super(name, SOFTWARE_TYPE, capacity, memory);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public int getMemory() {
        return this.calcMemory(super.getMemory());
    }

    private int calcMemory(int memory) {
        return memory * 2;
    }
}
