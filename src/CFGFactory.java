import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class CFGFactory {
    private static final Map<String, CFG> grammars = new HashMap<>();

    public static CFG getCFG(String filePath) {
        if (!grammars.containsKey(filePath)) {
            grammars.put(filePath, readGrammar(filePath));
        }
        return grammars.get(filePath);
    }

    private static CFG readGrammar(String filePath) {
        CFG cfg = new CFG();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" -> ");
                if (parts.length == 2) {
                    ProductionRule rule = new ProductionRule(parts[0], parts[1]);
                    cfg.addRule(rule);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return cfg;
    }
}