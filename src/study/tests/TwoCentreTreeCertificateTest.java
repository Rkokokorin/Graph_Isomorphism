package study.tests;

import org.junit.Before;
import org.junit.Test;
import study.graphs.Tree;

import static org.junit.Assert.assertEquals;

public class TwoCentreTreeCertificateTest {
    Tree tree;

    @Before
    public void setUp() {
        tree = new Tree();
        tree.addNode();
        tree.addNodeWithConnection(0);
        tree.addNodeWithConnection(1);
        tree.addNode();
        tree.addNodeWithConnection(3);
        tree.addNodeWithConnection(4);
        tree.addNodeWithConnection(5);
        tree.addConnection(4,1);
        tree.addNodeWithConnection(0);
        tree.addNodeWithConnection(2);
        tree.addNodeWithConnection(1);
        System.out.println(tree.isTree());
    }

    @Test
    public void calculateCertificate() {
        assertEquals("00011001101100011011", tree.calculateCertificate());
    }
}