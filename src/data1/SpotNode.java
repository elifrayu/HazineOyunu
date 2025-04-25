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
    
    String type;        // "Treasure", "Trap", "Empty"
    int index;          // buton sırası
    SpotNode next;

    public SpotNode(String type, int index) {
        this.type = type;
        this.index = index;
        this.next = null;
    }

}
