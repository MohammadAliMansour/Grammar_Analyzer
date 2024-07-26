import java.util.ArrayList;
import java.util.List;

public class CFG {
    private List<ProductionRule> rules;
    public CFG() {
        rules = new ArrayList<>();
    }

    public void addRule(ProductionRule rule) {
        rules.add(rule);
    }

    public void printRule(CFG cfg){
        for (int i = 0; i < getRules().size(); i++) {
            System.out.println("\nrule " + i + cfg.getRules().get(i));
        }
        System.out.println();
    }

    public List<ProductionRule> getRules() {
        return rules;
    }
}
