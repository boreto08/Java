package systemSplit.models.softwares;

import systemSplit.models.Component;

public abstract class SoftwareComponent extends Component {
    private int memoryConsumption;
    private int capacityConsumption;

    SoftwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.capacityConsumption = capacity;
        this.memoryConsumption = memory;
    }

    public int getMemory() {
        return this.memoryConsumption;
    }

    public int getCapacity() {
        return this.capacityConsumption;
    }
}
