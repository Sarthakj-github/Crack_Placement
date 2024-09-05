public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        
        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            if (node != null) {
                ans.append(node.val).append(" ");
                Q.add(node.left);
                Q.add(node.right);
            } else {
                ans.append("null ");
            }
        }
        return ans.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        
        for (int i = 1; i < values.length; i++) {
            TreeNode node = Q.poll();
            if (!values[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                Q.add(node.left);
            }
            if (!values[++i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                Q.add(node.right);
            }
        }
        return root;
    }
}
