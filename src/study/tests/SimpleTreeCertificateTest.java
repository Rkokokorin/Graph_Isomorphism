package study.tests;

import org.junit.Before;
import org.junit.Test;
import study.graphs.Tree;

import static org.junit.Assert.*;

public class SimpleTreeCertificateTest {
    Tree tree;

    @Before
    public void setUp() {
        tree = new Tree();
        tree.addNode();
        tree.addNodeWithConnection(0);
        tree.addNodeWithConnection(0);
        tree.addNodeWithConnection(1);
        tree.addNodeWithConnection(2);
        System.out.println(tree.isTree());
    }

    @Test
    public void calculateCertificate() {
        assertEquals("0001100111", tree.calculateCertificate());
    }
}