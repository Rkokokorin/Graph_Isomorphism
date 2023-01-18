package study.tests;

import org.junit.Before;
import org.junit.Test;
import study.graphs.Tree;


public class FakeTreeCertificateTest {
    Tree tree;

    @Before
    public void setUp() {
        tree = new Tree();
        tree.addNode();
        tree.addNodeWithConnection(0);
        tree.addNodeWithConnection(1);
        tree.addConnection(0,2);
    }

    @Test (expected = RuntimeException.class)
    public void calculateCertificate() {
        tree.calculateCertificate();
    }
}