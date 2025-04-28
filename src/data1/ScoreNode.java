/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data1;

/**
 *
 * @author rahimecalik
 */
// BST düğüm sınıfı
class ScoreNode {

    int score;
    String level;
    ScoreNode left, right;

    public ScoreNode(int score, String level) {
        this.score = score;
        this.level = level;
        left = right = null;
    }
}

// BST ağacı sınıfı
class ScoreBST {

    ScoreNode root;

    // Ekleme
    public void insert(int score, String level) {
        root = insertRec(root, score, level);
    }

    private ScoreNode insertRec(ScoreNode root, int score, String level) {
        if (root == null) {
            root = new ScoreNode(score, level);
            return root;
        }
        if (score < root.score) {
            root.left = insertRec(root.left, score, level);
        } else {
            root.right = insertRec(root.right, score, level);
        }
        return root;
    }

    // Ağacı inorder sırala (küçükten büyüğe sıralı gez)
    public void inorder(ScoreNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.score + " (" + root.level + ")");
            inorder(root.right);
        }
    }

    // Minimum skoru bul
    public ScoreNode findMin(ScoreNode root) {
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    // Maksimum skoru bul
    public ScoreNode findMax(ScoreNode root) {
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

}
