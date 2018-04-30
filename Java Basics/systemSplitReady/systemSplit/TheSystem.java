package systemSplit;

import systemSplit.models.Dump;
import systemSplit.models.hardwares.HardwareComponent;
import systemSplit.models.hardwares.HeavyHardwareComponent;
import systemSplit.models.hardwares.PowerHardwareComponent;
import systemSplit.models.softwares.ExpressSoftwareComponent;
import systemSplit.models.softwares.LightSoftwareComponent;
import systemSplit.models.softwares.SoftwareComponent;

import java.util.LinkedHashMap;
import java.util.Map;

public class TheSystem {
    private Map<String, HardwareComponent> hardwares;
    private Dump dump;

    public TheSystem() {
        this.hardwares = new LinkedHashMap<>();
        this.dump = new Dump();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        HardwareComponent hc = new PowerHardwareComponent(name, capacity, memory);
        this.hardwares.put(name, hc);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HardwareComponent hc = new HeavyHardwareComponent(name, capacity, memory);
        this.hardwares.put(name, hc);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwares.containsKey(hardwareComponentName)) {
            SoftwareComponent sc = new ExpressSoftwareComponent(name, capacity, memory);
            this.hardwares.get(hardwareComponentName).registerSoftwareComponent(sc);
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwares.containsKey(hardwareComponentName)) {
            SoftwareComponent sc = new LightSoftwareComponent(name, capacity, memory);
            this.hardwares.get(hardwareComponentName).registerSoftwareComponent(sc);
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (this.hardwares.containsKey(hardwareComponentName)) {
            this.hardwares.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);
        }
    }

    /**
     * “System Analysis
     * Hardware Components: {countOfHardwareComponents}
     * Software Components: {countOfSoftwareComponents}
     * Total Operational Memory: {totalOperationalMemoryInUse} / {maximumMemory}
     * Total Capacity Taken: {totalCapacityTaken} / {maximumCapacity}”
     */

    public String analyze() {
        return "System Analysis\n" +
                String.format("Hardware Components: %d\n", this.hardwares.size()) +
                String.format("Software Components: %d\n", this.softCount()) +
                String.format("Total Operational Memory: %d / %d\n", this.getTotalOperationalMemoryInUse(), this.getMaximumMemory()) +
                String.format("Total Capacity Taken: %d / %d", this.getTotalCapacityTaken(), this.getMaximumCapacity());
    }

    public String split() {
        StringBuilder sb = new StringBuilder();
        this.hardwares.values()
                .stream().sorted((e1, e2) -> e2.getType().compareTo(e1.getType()))
                .forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        return sb.toString();
    }

    public void dump(String name) {
        this.dump.dump(this.removeFromSystem(name));
    }

    public void restore(String name) {
        HardwareComponent hc = this.dump.restore(name);
        if (hc != null) {
            this.hardwares.putIfAbsent(hc.getName(), hc);
        }
    }

    public String dumpAnalyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dump Analysis").append(System.lineSeparator());
        sb.append(String.format("Power Hardware Components: %d", this.dump.getHardwareComponentsCount("Power"))).append(System.lineSeparator());
        sb.append(String.format("Heavy Hardware Components: %d", this.dump.getHardwareComponentsCount("Heavy"))).append(System.lineSeparator());
        sb.append(String.format("Express Software Components: %d", this.dump.getSoftwareComponentsCount("Express"))).append(System.lineSeparator());
        sb.append(String.format("Light Software Components: %d", this.dump.getSoftwareComponentsCount("Light"))).append(System.lineSeparator());
        sb.append(String.format("Total Dumped Memory: %d", this.dump.getTotalMemory())).append(System.lineSeparator());
        sb.append(String.format("Total Dumped Capacity: %d", this.dump.getTotalCapacity()));
        return sb.toString();
    }

    public void destroy(String name) {
        this.dump.destroy(name);
    }

    private int softCount() {
        return this.hardwares.values().stream().mapToInt(HardwareComponent::softCount).sum();
    }

    private int getTotalOperationalMemoryInUse() {
        return this.getMaximumMemory() - this.getTotalAvailableMemory();
    }

    private int getTotalAvailableMemory() {
        return this.hardwares.values().stream().mapToInt(HardwareComponent::getAvailableMemory).sum();
    }

    private int getMaximumMemory() {
        return this.hardwares.values().stream().mapToInt(HardwareComponent::getMemory).sum();
    }

    private int getTotalCapacityTaken() {
        return this.getMaximumCapacity() - this.getTotalAvailableCapacity();
    }

    private int getTotalAvailableCapacity() {
        return this.hardwares.values().stream().mapToInt(HardwareComponent::getAvailableCapacity).sum();
    }

    private int getMaximumCapacity() {
        return this.hardwares.values().stream().mapToInt(HardwareComponent::getCapacity).sum();
    }

    private HardwareComponent removeFromSystem(String comName) {
        if (this.hardwares.containsKey(comName))
            return this.hardwares.remove(comName);
        return null;
    }
}
