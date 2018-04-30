package models.Hardware;

import models.Component;

public abstract class HardwareComponent extends Component{

    private int maxCapacity;
    private int maxMemory;

    protected HardwareComponent(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type);
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
    }

    private int getMaxCapacity() {
        return this.maxCapacity;
    }

    private void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    private int getMaxMemory() {
        return this.maxMemory;
    }

    private void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }
}
