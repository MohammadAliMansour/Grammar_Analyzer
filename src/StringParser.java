import java.util.List;
import java.util.Stack;

public class StringParser {

    public static void parseString(String input, CFG cfg) {

        List<ProductionRule> rules = cfg.getRules();

        Stack<String> stack = new Stack<>();
        stack.push(rules.get(0).left()); // Push the start symbol onto the stack
        System.out.println("\nstack: " + stack);

        int index = 0; // Index to traverse the input string
        String nextChar = "";
        while (!stack.isEmpty()) {
            if (index >= input.length()){
                System.out.println("Rejected: input has been consumed but stack is still not empty");
                return;
            }
            String popped = stack.pop();
            System.out.println("\nstack after pop: " + stack);

            if (isVariable(popped)) {
                try {
                    nextChar = input.substring(index, index + 1);
                } catch (Exception e){
                    System.out.println("\nRejected: Input String has been consumed");
                    return;
                }

                for (ProductionRule rule : rules) {
                    if (rule.left().equals(popped) && rule.right().startsWith(nextChar)) {
                        // Push the right-hand side of the rule onto the stack in reverse order
                        String rhs = rule.right();
                        for (int i = rhs.length() - 1; i >= 0; i--) {
                            stack.push(rhs.substring(i, i + 1));
                        }
                        break;
                    }
                }
                System.out.println("\n" + nextChar);
                System.out.println("stack: " + stack);
            } else if (isTerminal(popped)) {
                 nextChar = input.substring(index, index + 1);
                if (popped.equals(nextChar)) {
                    index++; // Move to the next character in the input
                } else {
                    System.out.println("\nRejected: Mismatched terminal");
                    return;
                }
            }
        }

        if (index == input.length()) {
            System.out.println("\nAccepted");
        } else {
            System.out.println("\nRejected: Unconsumed input");
        }
    }

    private static boolean isVariable(String symbol) {
        return symbol.equals("S") || symbol.equals("X") || symbol.equals("A") || symbol.equals("Y") || symbol.equals("Z");
    }

    private static boolean isTerminal(String symbol) {
        return symbol.equals("a") || symbol.equals("b") || symbol.equals("c") || symbol.equals("d") || symbol.equals("#") || symbol.equals("0") || symbol.equals("1");
    }

}
