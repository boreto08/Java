package models.Hardware;

/**
 * Created by boreto on 3/10/2017.
 */
public class PowerHardwareComponent extends HardwareComponent {

    private PowerHardwareComponent(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type, maxCapacity, maxMemory);
    }
}
