class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int size = Q.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node node = Q.poll();
                if (prev != null)   prev.next = node;
                prev = node;

                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
            }
        }

        return root;
    }
}
