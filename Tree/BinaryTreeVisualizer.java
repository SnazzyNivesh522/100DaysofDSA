import javax.swing.*;
import java.awt.*;

public class BinaryTreeVisualizer extends JFrame {

    public BinaryTreeVisualizer(TreeNode root) {
        setTitle("Binary Tree Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel treePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(g, root, getWidth() / 2, 50, getWidth() / 4);
            }
        };
        treePanel.setBackground(Color.WHITE);
        add(treePanel, BorderLayout.CENTER);
    }

    private void drawTree(Graphics g, TreeNode node, int x, int y, int hGap) {
        if (node == null) {
            return;
        }

        g.drawString(String.valueOf(node.val), x, y);

        if (node.left != null) {
            int leftX = x - hGap;
            int leftY = y + 50;
            g.drawLine(x, y + 20, leftX, leftY - 20);
            drawTree(g, node.left, leftX, leftY, hGap / 2);
        }

        if (node.right != null) {
            int rightX = x + hGap;
            int rightY = y + 50;
            g.drawLine(x, y + 20, rightX, rightY - 20);
            drawTree(g, node.right, rightX, rightY, hGap / 2);
        }
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        BinaryTreeVisualizer visualizer = new BinaryTreeVisualizer(root);
        visualizer.setVisible(true);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}