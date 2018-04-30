package models.Software;

import models.Component;

public abstract class SoftwareComponent extends Component {

    protected int capacityConsumption;
    protected int memoryConsumption;



    protected SoftwareComponent(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    private int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    private int getMemoryConsumption() {
        return this.memoryConsumption;
    }

    private void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    private void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}
