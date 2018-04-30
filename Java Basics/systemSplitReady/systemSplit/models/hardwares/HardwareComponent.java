package systemSplit.models.hardwares;

import systemSplit.models.Component;
import systemSplit.models.softwares.SoftwareComponent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class HardwareComponent extends Component {

    private Map<String, SoftwareComponent> registeredComponents;
    private int capacity;
    private int memory;

    public HardwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.capacity = capacity;
        this.memory = memory;
        this.registeredComponents = new LinkedHashMap<>();
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent) {

        if (this.hasCapacity(softwareComponent)) {
            this.registeredComponents
                    .putIfAbsent(softwareComponent.getName(), softwareComponent);
        }
    }

    public void releaseSoftwareComponent(String softName) {
        if (this.registeredComponents.containsKey(softName)) {
            this.registeredComponents.remove(softName);
        }
    }

    public int softCount() {
      return this.registeredComponents.values().size();
    }

    public int softCount(String type) {
        return (int)this.registeredComponents.values().stream().filter(e -> e.getType().equals(type)).count();
    }

    /**
     * Hardware Component - {componentName}
     Express Software Components: {countOfExpressSoftwareComponents}
     Light Software Components: {countOfLightSoftwareComponents}
     Memory Usage: {memoryUsed} / {maximumMemory}
     Capacity Usage: {capacityUsed} / {maximumCapacity}
     Type: {Power/Heavy}
     Software Components: {softwareComponent1, softwareComponent2…}”

     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Hardware Component - %s",super.getName())).append(System.lineSeparator());
        sb.append(String.format("Express Software Components - %d",
                this.registeredComponents.values().stream()
                        .filter(e -> e.getType().equals("Express")).count())).append(System.lineSeparator());
        sb.append(String.format("Light Software Components - %d",
                this.registeredComponents.values().stream()
                        .filter(e -> e.getType().equals("Light")).count())).append(System.lineSeparator());
        sb.append(String.format("Memory Usage: %d / %d",this.getMemory() - this.getAvailableMemory(),this.getMemory())).append(System.lineSeparator());
        sb.append(String.format("Capacity Usage: %d / %d",this.getCapacity() - this.getAvailableCapacity(),this.getCapacity())).append(System.lineSeparator());
        sb.append(String.format("Type: %s",super.getType())).append(System.lineSeparator());
        List<String> softComp = this.registeredComponents.values()
                .stream().map(Component::getName)
                .collect(Collectors.toList());
        sb.append(String.format("Software Components: %s",softComp.size() > 0 ? softComp.toString()
                .replaceAll("\\[|\\]","") : "None"));
        return sb.toString();
    }

    private boolean hasCapacity(SoftwareComponent softwareComponent) {
        return softwareComponent.getCapacity() <= this.getAvailableCapacity() &&
                softwareComponent.getMemory() <= this.getAvailableMemory();
    }

    public int getAvailableCapacity() {
        return this.getCapacity() - this.registeredComponents.values().stream().mapToInt(SoftwareComponent::getCapacity).sum();
    }

    public int getAvailableMemory() {
        return this.getMemory() - this.registeredComponents.values().stream().mapToInt(SoftwareComponent::getMemory).sum();
    }
}
