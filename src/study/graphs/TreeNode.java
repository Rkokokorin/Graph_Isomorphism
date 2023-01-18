package study.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TreeNode {
        int id;
        List<TreeNode> connections = new ArrayList<>();
        String cert;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return id == treeNode.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

}