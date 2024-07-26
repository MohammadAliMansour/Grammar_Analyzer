import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        chooseGrammar();
    }

    private static void chooseGrammar(){
        String grammar;
        CFG cfg = null;
        System.out.println("Choose a language A,B,C,D or E to exit");
        grammar = in.nextLine();

        if (grammar.equalsIgnoreCase("e"))
            return;

        if (!grammar.equalsIgnoreCase("a") && !grammar.equalsIgnoreCase("b") && !grammar.equalsIgnoreCase("c") && !grammar.equalsIgnoreCase("d")) {
            System.out.println("Language not found");
            chooseGrammar();
        } else if (!grammar.equalsIgnoreCase("E")){
            if (grammar.equalsIgnoreCase("A"))
                cfg = CFGFactory.getCFG("A.txt");
            else if (grammar.equalsIgnoreCase("B"))
                cfg = CFGFactory.getCFG("B.txt");
            else if (grammar.equalsIgnoreCase("C"))
                cfg = CFGFactory.getCFG("C.txt");
            else if (grammar.equalsIgnoreCase("D"))
                cfg = CFGFactory.getCFG("D.txt");
            cfg.printRule(cfg);
            readInput(cfg);
        }
    }

    private static void readInput(CFG cfg){
        String choice, inputString;
        System.out.println("Do you want to enter a string? y|n");
        choice = in.nextLine();
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")){
            System.out.println("Enter a string");
            inputString = in.nextLine();
            StringParser.parseString(inputString, cfg);
            readInput(cfg);
        } else {
            chooseGrammar();
        }
    }
}
