/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package data1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author elifuyar
 */
public class GamePage extends javax.swing.JFrame {

    /**
     * Creates new form GamePage
     */
    private ImageIcon playerIcon;

    public void playDiceSound() {
        try {
            File soundFile = new File("sounds/dice_roll.wav"); // yolumuz burası
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void playSound(String soundFileName) {
        try {
            File soundFile = new File("sounds/" + soundFileName);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SpotNode head;
    private SpotNode currentNode;

    private JButton[] buttons;

    String username;

    private int score = 0;
    private int currentIndex = 0;

    public GamePage(String username) {
        this.username = username;
        initComponents();
        setupButtonLinkedList();
        btnRollDice.setIcon(resizeIcon("/images/dice.png", 40, 40));
        lblUsername.setText("User: " + username);
        lblScore.setText("Score: 0");
    }

    private void setupButtonLinkedList() {
        // Tüm butonları bir dizi (array) içine alıyoruz. Böylece tek tek değil, döngü ile işlem yapabiliriz.
        buttons = new JButton[]{
            jButton1, jButton2, jButton3, jButton4, jButton5,
            jButton6, jButton7, jButton8, jButton9, jButton10,
            jButton11, jButton12, jButton13, jButton14, jButton15,
            jButton16, jButton17, jButton18, jButton19, jButton20,
            jButton21, jButton22, jButton23, jButton24, jButton25,
            jButton26, jButton27, jButton28, jButton29, jButton30
        };

        playerIcon = resizeIcon("/images/player_icon.png", 60, 60);

        String[] types = {"Treasure", "Trap", "Empty"};
        //ilk eleman head sonrakiler prev.next olacak
        SpotNode prev = null;
        mapPanel.setLayout(new GridLayout(5, 6, 15, 15));
        for (int i = 0; i < buttons.length; i++) {
            String type = types[(int) (Math.random() * types.length)];

            if (i == 0) {
                type = "Start"; // 1. butonun tipi Start olacak
            }

            if (i == 29) {
                type = "Finish"; // 30. butonun tipi Finish olacak
            }

            SpotNode node = new SpotNode(type, i);

            if (head == null) {
                head = node;
                currentNode = head; // oyuncu başlangıçta head’te
            } else {
                //önceki düğümle şimdikini bağlar
                prev.next = node;
            }
            //şimdiki düğüm bir sonrakinde prev olur
            prev = node;

            buttons[i].setText(""); // Yazıyı kaldır

            buttons[i].setPreferredSize(new Dimension(100, 60));

// Type'a göre ikonu ayarla
            switch (type) {
                case "Treasure" ->
                    buttons[i].setIcon(resizeIcon("/images/treasure.png", 60, 60));
                case "Trap" ->
                    buttons[i].setIcon(resizeIcon("/images/trap.png", 60, 60));
                case "Finish" ->
                    buttons[i].setIcon(resizeIcon("/images/finish.png", 60, 60));
                case "Start" ->
                    buttons[i].setIcon(resizeIcon("/images/start.png", 60, 60));
                default ->
                    buttons[i].setIcon(resizeIcon("/images/empty.png", 60, 60));
            }

            buttons[i].setOpaque(false); // Arkaplanı saydam yap
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setFocusPainted(false);
        }
        buttons[0].setIcon(playerIcon);
 
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnRollDice = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblDice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mapPanel.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("jButton1");
        mapPanel.add(jButton1);

        jButton2.setText("jButton1");
        mapPanel.add(jButton2);

        jButton3.setText("jButton1");
        mapPanel.add(jButton3);

        jButton4.setText("jButton1");
        mapPanel.add(jButton4);

        jButton5.setText("jButton1");
        mapPanel.add(jButton5);

        jButton6.setText("jButton1");
        mapPanel.add(jButton6);

        jButton7.setText("jButton1");
        mapPanel.add(jButton7);

        jButton8.setText("jButton1");
        mapPanel.add(jButton8);

        jButton9.setText("jButton1");
        mapPanel.add(jButton9);

        jButton10.setText("jButton1");
        mapPanel.add(jButton10);

        jButton11.setText("jButton1");
        mapPanel.add(jButton11);

        jButton12.setText("jButton1");
        mapPanel.add(jButton12);

        jButton13.setText("jButton1");
        mapPanel.add(jButton13);

        jButton14.setText("jButton1");
        mapPanel.add(jButton14);

        jButton15.setText("jButton1");
        mapPanel.add(jButton15);

        jButton16.setText("jButton1");
        mapPanel.add(jButton16);

        jButton17.setText("jButton1");
        mapPanel.add(jButton17);

        jButton18.setText("jButton1");
        mapPanel.add(jButton18);

        jButton19.setText("jButton1");
        mapPanel.add(jButton19);

        jButton20.setText("jButton1");
        mapPanel.add(jButton20);

        jButton21.setText("jButton1");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        mapPanel.add(jButton21);

        jButton22.setText("jButton1");
        mapPanel.add(jButton22);

        jButton23.setText("jButton1");
        mapPanel.add(jButton23);

        jButton24.setText("jButton1");
        mapPanel.add(jButton24);

        jButton25.setText("jButton1");
        mapPanel.add(jButton25);

        jButton26.setText("jButton1");
        mapPanel.add(jButton26);

        jButton27.setText("jButton1");
        mapPanel.add(jButton27);

        jButton28.setText("jButton1");
        mapPanel.add(jButton28);

        jButton29.setText("jButton1");
        mapPanel.add(jButton29);

        jButton30.setText("jButton1");
        mapPanel.add(jButton30);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRollDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollDiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnRollDice, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblDice, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(142, Short.MAX_VALUE)
                    .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(86, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRollDice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDice, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(326, Short.MAX_VALUE)
                    .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRollDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollDiceActionPerformed

//        playDiceSound();
//
//        int dice = (int) (Math.random() * 6) + 1;
//        lblDice.setText("Rolled: " + dice);
//        //dice kadar gidiyor
//        for (int i = 0; i < dice && currentNode.next != null; i++) {
//            currentNode = currentNode.next;
//        }
//
//        String cellType = currentNode.type;
//        switch (cellType) {
//            case "Treasure" -> {
//                score += 10;
//                playSound("treasure.wav"); // 🎵 Treasure sesi çal
//            }
//
//            case "Trap" -> {
//                score -= 5;
//                playSound("trap.wav"); // 🎵 Trap sesi çal
//            }
//        }
//
//        lblScore.setText("Score: " + score);
//
//        for (int i = 0; i < buttons.length; i++) {
//            if (i == currentNode.index) {
//                buttons[i].setIcon(playerIcon);
//            } else {
//                //buttons[i].setIcon(null); // diğerlerinde ikon olmasın
//                switch (buttons[i].getText()) {
//                    case "Treasure" ->
//                        buttons[i].setBackground(Color.YELLOW);
//                    case "Trap" ->
//                        buttons[i].setBackground(Color.RED);
//                    case "Empty" ->
//                        buttons[i].setBackground(Color.LIGHT_GRAY);
//                }
//            }
//        }
//
//        if (currentNode.type.equals("Finish")) {
//            JOptionPane.showMessageDialog(this, "Level 1 completed! Your score: " + score);
//            saveScoreToFile();
//
//            // 🎯 Burada this yerine null verdik!
//            int choice = JOptionPane.showConfirmDialog(
//                    null, "Do you want to continue to Level 2?",
//                    "Continue?",
//                    JOptionPane.YES_NO_OPTION
//            );
//
//            if (choice == JOptionPane.YES_OPTION) {
//                this.dispose();
//                new GamePageLevel2(username).setVisible(true);
//            } else {
//                this.dispose();
//                new MainMenu().setVisible(true);
//            }
//        }
//        
playDiceSound();
        
        int dice = (int) (Math.random() * 6) + 1;
        btnRollDice.setIcon(resizeIcon("/images/dice.png", 40, 40));
        
        lblDice.setText("Rolled: " + dice);
        
        // Şu anki hücreyi kaydet (başlangıçta nereden hareket ettiğimizi biliyoruz)
        SpotNode previousNode = currentNode;

        // Zar kadar ilerle
        for (int i = 0; i < dice && currentNode.next != null; i++) {
            currentNode = currentNode.next;
        }

        // Hücrenin tipine göre skor güncelle
        String cellType = currentNode.type;
        switch (cellType) {
            case "Treasure" -> {
                score += 10;
                playSound("treasure.wav");
            }
            case "Trap" -> {
                score -= 5;
                playSound("trap.wav");
            }
        }

        lblScore.setText("Score: " + score);
        
        // Bilgilendirme paneli: Nereden nereye gidildiğini ve bonusları göster
    String message = "You rolled a " + dice + "!\n";
    message += "You moved from position " + previousNode.index + " to position " + currentNode.index + ".\n";
    message += "You landed on a " + cellType + "!\n";

    if (cellType.equals("Treasure")) {
        message += "You gained 10 points!\n";
    } else if (cellType.equals("Trap")) {
        message += "You lost 5 points!\n";
    }

    // Bilgilendirme penceresini göster
    JOptionPane.showMessageDialog(this, message, "Move Information", JOptionPane.INFORMATION_MESSAGE);

        // BÜTÜN butonları güncelle
        SpotNode temp = head;
        while (temp != null) {
            JButton button = buttons[temp.index];
            if (temp.index == currentNode.index) {
                // Oyuncunun olduğu yere player ikonu koy
                button.setIcon(playerIcon);
            } else {
                // Diğer butonlara kendi ikonlarını geri koy
                switch (temp.type) {
                    case "Treasure" ->
                        button.setIcon(resizeIcon("/images/treasure.png", 60, 60));
                    case "Trap" ->
                        button.setIcon(resizeIcon("/images/trap.png", 60, 60));
                    case "Finish" ->
                        button.setIcon(resizeIcon("/images/finish.png", 60, 60));
                    case "Start" ->
                        button.setIcon(resizeIcon("/images/start.png", 60, 60));
                    default ->
                        button.setIcon(resizeIcon("/images/empty.png", 60, 60));
                }
            }
            temp = temp.next;
        }

        // Eğer varış noktası bitiş ise
        if (currentNode.type.equals("Finish")) {
            JOptionPane.showMessageDialog(this, "Level 1 completed! Your score: " + score);
            saveScoreToFile();

            int choice = JOptionPane.showConfirmDialog(
                    null, "Do you want to continue to Level 2?",
                    "Continue?",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                this.dispose();
                new GamePageLevel2(username).setVisible(true);
            } else {
                this.dispose();
                new MainMenu().setVisible(true);
            }
        }
    }//GEN-LAST:event_btnRollDiceActionPerformed

    private void saveScoreToFile() {
        try {
            FileWriter fw = new FileWriter("score.txt", true); // true = dosyaya ekle
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(username + ", level1, " + score);
            bw.newLine(); // bir sonraki kayıt alt satıra geçsin

            bw.close();
            fw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRollDice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel lblDice;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel mapPanel;
    // End of variables declaration//GEN-END:variables
}
