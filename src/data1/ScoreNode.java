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
    String username;
    String level;
    ScoreNode left, right;// Sol ve sağ çocuk düğümleri (BST yapısı için)


    public ScoreNode(int score, String username, String level) {
        this.username = username;
        this.score = score;
        this.level = level;
        left = right = null;// Başlangıçta çocuğu yok
    }
}

// BST ağacı sınıfı
class ScoreBST {

    ScoreNode root;

    // Yeni bir skor eklemek için dışarıdan çağrılan fonksiyon
    public void insert(int score, String username, String level) {
        root = insertRec(root, score, username, level);
    }
// Skoru ağaca rekürsif olarak yerleştiren yardımcı fonksiyon
    private ScoreNode insertRec(ScoreNode root, int score, String username, String level) {
         // Eğer kök düğüm null ise, buraya yeni düğüm eklenebilir
        if (root == null) {
        return new ScoreNode(score, username, level);
    }
        // Skor küçükse sola eklenir,Skor büyük veya eşitse sağa eklenir
        if (score < root.score) {
            root.left = insertRec(root.left, score, username, level);
        } else {
            root.right = insertRec(root.right, score, username, level);
        }
        return root;
    }

     // Ağacı küçükten büyüğe sırayla gezip skorları yazdırır
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
