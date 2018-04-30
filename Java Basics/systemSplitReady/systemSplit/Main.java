package systemSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        TheSystem sys = new TheSystem();
        while (!"System Split".equals(line)) {
            int braceIndex = line.indexOf('(');
            String command = line.substring(0, braceIndex);
            String[] tokens = line.substring(braceIndex + 1, line.length() - 1).split(", ");
            switch (command) {
                case "RegisterPowerHardware":
                    sys.registerPowerHardware(tokens[0], Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
                    break;
                case "RegisterHeavyHardware":
                    sys.registerHeavyHardware(tokens[0], Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
                    break;
                case "Analyze":
                    System.out.println(sys.analyze());
                    break;
                case "RegisterLightSoftware":
                    sys.registerLightSoftware(tokens[0], tokens[1], Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]));
                    break;
                case "RegisterExpressSoftware":
                    sys.registerExpressSoftware(tokens[0], tokens[1], Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]));
                    break;
                case "ReleaseSoftwareComponent":
                    sys.releaseSoftwareComponent(tokens[0], tokens[1]);
                    break;
                case "Dump":
                    sys.dump(tokens[0]);
                    break;
                case "DumpAnalyze":
                    System.out.println(sys.dumpAnalyze());
                    break;
                case "Restore":
                    sys.restore(tokens[0]);
                    break;
                case "Destroy":
                    sys.destroy(tokens[0]);
                    break;
            }

            line = reader.readLine();
        }
        System.out.println(sys.split());

    }
}
