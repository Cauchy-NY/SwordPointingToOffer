package questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import questions.utils.TreeNode;

public class Question37 {

}

class Codec {

    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    private String serialize(TreeNode root, String data) {
        if (root == null) {
            data += "null,";
        } else {
            data += root.val + ",";
            data = serialize(root.left, data);
            data = serialize(root.right, data);
        }
        return data;
    }

    public TreeNode deserialize(String data) {
        String[] seq = data.split(",");
        return deserialize(new LinkedList<>(Arrays.asList(seq)));
    }

    private TreeNode deserialize(List<String> seqs) {
        if (seqs.get(0).equals("null")) {
            seqs.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(seqs.get(0)));

        root.left = deserialize(seqs);
        root.right = deserialize(seqs);
        return root;
    }

    public static void Main(String[] args) {

    }
}
