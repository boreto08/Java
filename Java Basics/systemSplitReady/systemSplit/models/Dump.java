package systemSplit.models;

import systemSplit.models.hardwares.HardwareComponent;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dump {
    private Map<String, HardwareComponent> dh;

    public Dump() {
        this.dh = new LinkedHashMap<>();
    }

    public void dump(HardwareComponent component) {
        if (component != null)
            this.dh.putIfAbsent(component.getName(), component);
    }

    public HardwareComponent restore(String name) {
        if (this.dh.containsKey(name)) {
            return this.dh.get(name);
        }
        return null;
    }

    public void destroy(String name) {
        if (this.dh.containsKey(name)) {
            this.dh.remove(name);
        }
    }

    public int getHardwareComponentsCount(String type) {
      return (int)this.dh.values().stream().filter(e -> e.getType().equals(type)).count();
    }

    public int getSoftwareComponentsCount(String express) {
        return this.dh.values().stream().mapToInt(e -> e.softCount(express)).sum();
    }

    public int getTotalMemory() {
        return this.dh.values().stream().mapToInt(HardwareComponent::getMemory).sum() - this.dh.values().stream().mapToInt(HardwareComponent::getAvailableMemory).sum();
    }

    public int getTotalCapacity() {

        return this.dh.values().stream().mapToInt(HardwareComponent::getCapacity).sum() - this.dh.values().stream().mapToInt(HardwareComponent::getAvailableCapacity).sum();
    }
}
