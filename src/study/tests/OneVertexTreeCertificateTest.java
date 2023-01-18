package study.tests;

import org.junit.Before;
import org.junit.Test;
import study.graphs.Tree;

import static org.junit.Assert.assertEquals;

public class OneVertexTreeCertificateTest {
    Tree tree;

    @Before
    public void setUp() {
        tree = new Tree();
        tree.addNode();
        tree.addNodeWithConnection(0);
    }

    @Test
    public void calculateCertificate() {
        assertEquals("0101", tree.calculateCertificate());
    }
}