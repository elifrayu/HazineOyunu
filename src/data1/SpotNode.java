/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data1;

/**
 *
 * @author elifuyar
 */
public class SpotNode {

    String type;        // "Treasure", "Trap", "Empty", "Forward", "Backward"
    int index;          // Butonun sırası (0, 1, 2, ..., 29)
    SpotNode next;      // Sonraki düğüm (ileri bağlantı)
    SpotNode prev;      // Önceki düğüm (geri bağlantı) — sadece 2. levelde kullandık
    SpotNode jump;      // Forward veya Backward tipindeyse ekstra zıplama bağlantısı

    public SpotNode(String type, int index) {
        this.type = type;
        this.index = index;
        this.next = null;
        this.prev = null;
        this.jump = null;
    }
}
