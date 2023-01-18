package study.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class Tree {
    List<TreeNode> allNodes = new ArrayList<>();
    int edgesNum = 0;

    public void addNodeWithConnection(int previousNodeID) {
        try {
             TreeNode node = new TreeNode();
             node.id = allNodes.size();
            System.out.println("node id is " + node.id);
             TreeNode prevNode =  allNodes.get(previousNodeID);
             node.connections.add(prevNode);
             prevNode.connections.add(node);
             allNodes.add(node);
             System.out.println("node " + node.id + " connected to node " + prevNode.id);
             edgesNum ++;
        } catch (NullPointerException e) {
            System.out.println("Previous node is not found");
        }
    }

    public void addNode() {
        TreeNode node = new TreeNode();
        node.id = allNodes.size();
        allNodes.add(node);
        System.out.println("node id is " + node.id);
    }

    public void addConnection(int firstNodeId, int secondNodeId) {
        try {
            TreeNode fNode = allNodes.get(firstNodeId);
            TreeNode sNode = allNodes.get(secondNodeId);
            fNode.connections.add(sNode);
            sNode.connections.add(fNode);
            System.out.println("node " + fNode.id + " connected to node " + sNode.id);
            edgesNum++;
        } catch (NullPointerException e) {
            System.out.println("Node is not found");
        }
    }

   public boolean isIsomorphic(Tree secondTree) {
        return this.calculateCertificate().equals(secondTree.calculateCertificate());

    }
    public void checkTree() {
        if (!(this.isTree() )) {
            System.out.println("Graph is not a tree");
            throw new RuntimeException();
        }
    }

    public boolean isTree() {
        if (allNodes.stream().anyMatch(i->i.connections.isEmpty()))
            return false;
        return edgesNum == allNodes.size() - 1;
    }

    public String calculateCertificate() {
        checkTree();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        Map<TreeNode, ArrayList<TreeNode>> nodesToAdd = new HashMap<>();
        for (TreeNode node : allNodes) {
            nodes.add(node);
            node.cert = "01";
        }
        while (nodes.size() > 2) {
            for (TreeNode node: nodes) {
                if (node.connections.size() < 2) {
                    nodesToAdd.putIfAbsent(node.connections.get(0), new ArrayList<>());
                    nodesToAdd.get(node.connections.get(0)).add(node);
                    }
                }
            for (Map.Entry<TreeNode, ArrayList<TreeNode>> node: nodesToAdd.entrySet()) {
                TreeNode key = node.getKey();
                ArrayList<TreeNode> value = node.getValue();
                value.sort(Comparator.comparing(o -> o.cert));
                String sumNode = value.stream().map(i -> i.cert).collect(Collectors.joining());
                key.cert = "0" + sumNode + key.cert.substring(1);
                nodes.removeAll(value);
                key.connections.removeAll(value);
            }
            nodesToAdd.clear();
        }
        if (nodes.size() == 1)
            return nodes.get(0).cert;
        else
            if (nodes.get(0).cert.compareTo(nodes.get(1).cert) <= 0)
                return nodes.get(0).cert.concat(nodes.get(1).cert);
            else
                return nodes.get(1).cert.concat(nodes.get(0).cert);
    }
}
