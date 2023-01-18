package study.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import study.graphs.Tree;

public class SimpleTreesIsomorphicTest {
    Tree tree;
    Tree tree2;

    @Before
    public void setUp() {
        tree = new Tree();
        tree.addNode();
        tree.addNodeWithConnection(0);
        tree.addNodeWithConnection(1);
        tree2 = new Tree();
        tree2.addNode();
        tree2.addNodeWithConnection(0);
        tree2.addNodeWithConnection(0);
    }

    @Test
    public void calculateCertificate() {
        Assert.assertTrue(tree.isIsomorphic(tree2));
    }
}