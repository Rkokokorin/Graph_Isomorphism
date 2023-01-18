package study.tests;

import org.junit.Before;
import org.junit.Test;
import study.graphs.Tree;

import static org.junit.Assert.assertEquals;

public class OneCentreTreeCertificateTest {
    Tree tree;

    @Before
    public void setUp() {
        tree = new Tree();
        tree.addNode();
        tree.addNode();
        tree.addNodeWithConnection(0);
        tree.addConnection(2,1);
        tree.addNode();
        tree.addNodeWithConnection(3);
        tree.addConnection(4,1);
        tree.addNodeWithConnection(4);
        tree.addNodeWithConnection(5);
        tree.addNodeWithConnection(2);
        tree.addNodeWithConnection(3);
        tree.addNodeWithConnection(6);
        System.out.println(tree.isTree());
    }

    @Test
    public void calculateCertificate() {
        assertEquals("00001011100011100111", tree.calculateCertificate());
    }
}