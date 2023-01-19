package study.graphs;

import java.util.Scanner;

public class ConsoleRunner {
    public static final String REGEX = "(add\\s*\\d*)|connect(\\s\\d){2}|next|check";
    public static final String START_MESSAGE = "choose command:\n add <connect to node id, optional>,\n connect" +
            " <node 1, node2> - connect 2 nodes , \n next - go to second tree, \n check - check graphs isomorphism";
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        Tree curTree = tree1;
        System.out.println(START_MESSAGE);
        try {

            while (true) {
                String command = scanner.nextLine().trim().toLowerCase();
                if (!command.matches(REGEX)) {
                    System.out.println("Wrong command");
                    continue;
                }
                if (command.contains("add")) {
                    if (command.length() > 3)
                        curTree.addNodeWithConnection(Integer.parseInt(command.substring(4)));
                    else
                        curTree.addNode();
                    continue;
                }
                if (command.equals("next")) {
                    curTree = tree2;
                    System.out.println("tree switched to second");
                }
                if (command.equals("check")) {
                    if (curTree != tree2) {
                        System.out.println("Enter second tree!");
                        continue;
                    }
                    System.out.println(tree1.isIsomorphic(tree2) ? "YES" : "NO");
                    break;
                }
                if (command.contains("connect")) {
                    String[] parts = command.split(" ");
                    curTree.addConnection(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                }
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Node with this id does not exist");
        }
    }
}
