/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package data1;

/**
 *
 * @author rahimecalik
 */
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

public class GamePageLevel2 extends javax.swing.JFrame {

    /**
     * Creates new form GamePageLevel2
     */
    private ImageIcon playerIcon;

    public void playDiceSound() {
        try {
            File soundFile = new File("sounds/dice_roll.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

            // Ses bitince kapatsın
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void playSound(String soundFileName) {
        try {
            File soundFile = new File("sounds/" + soundFileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String username;
    private int score = 0;
    private SpotNode head;
    private SpotNode currentNode;
    private javax.swing.JButton[] buttons;

    public GamePageLevel2(String username) {
        this.username = username;
        initComponents();

        setupButtonLinkedListLevel2();
        lblUsername.setText("User: " + username);
        lblScore.setText("Score: 0");
    }

    private void setupButtonLinkedListLevel2() {
        buttons = new JButton[]{
            jButton1, jButton2, jButton3, jButton4, jButton5,
            jButton6, jButton7, jButton8, jButton9, jButton10,
            jButton11, jButton12, jButton13, jButton14, jButton15,
            jButton16, jButton17, jButton18, jButton19, jButton20,
            jButton21, jButton22, jButton23, jButton24, jButton25,
            jButton26, jButton27, jButton28, jButton29, jButton30
        };

        playerIcon = new ImageIcon(getClass().getResource("/images/player_icon.png"));

        String[] types = {"Treasure", "Trap", "Empty", "Forward", "Backward"};
        head = null;
        SpotNode prev = null;

        // 1. Normal ileri-geri bağlantılı listeyi kur
        for (int i = 0; i < 30; i++) {
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
                currentNode = head;
            } else {
                prev.next = node;
                node.prev = prev;
            }
            prev = node;

            // Burada tasarımdaki hazır butonları ayarlıyoruz
            buttons[i].setText((i + 1) + " " + type);
            //buttons[i].setEnabled(false);

            switch (type) {
                case "Treasure" ->
                    buttons[i].setBackground(Color.GREEN);
                case "Trap" ->
                    buttons[i].setBackground(Color.RED);
                case "Forward" ->
                    buttons[i].setBackground(Color.lightGray);
                case "Backward" ->
                    buttons[i].setBackground(Color.darkGray);
                case "Finish" ->
                    buttons[i].setBackground(Color.BLUE);
                case "Start" ->
                    buttons[i].setBackground(Color.BLUE);
                default ->
                    buttons[i].setBackground(Color.white);
            }

            buttons[i].setOpaque(true);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        // 2. Forward ve Backward düğümlerine jump bağlantısı kur
        SpotNode temp = head;
        while (temp != null) {
            if (temp.type.equals("Forward")) {
                SpotNode jumpTarget = temp;
                for (int j = 0; j < 3 && jumpTarget.next != null; j++) {
                    jumpTarget = jumpTarget.next;
                }
                temp.jump = jumpTarget;
            } else if (temp.type.equals("Backward")) {
                SpotNode jumpTarget = temp;
                for (int j = 0; j < 3 && jumpTarget.prev != null; j++) {
                    jumpTarget = jumpTarget.prev;
                }
                temp.jump = jumpTarget;
            }
            temp = temp.next;
        }
        // 🏁 Başlangıçta ikon Start hücresinde olsun
        buttons[0].setIcon(playerIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRollDice = new javax.swing.JButton();
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
        jButton21 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblDice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        btnRollDice.setText("Roll Dice");
        btnRollDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollDiceActionPerformed(evt);
            }
        });

        mapPanel.setLayout(new java.awt.GridLayout(5, 6, 10, 10));

        jButton1.setText("...");
        mapPanel.add(jButton1);

        jButton2.setText("...");
        mapPanel.add(jButton2);

        jButton3.setText("...");
        mapPanel.add(jButton3);

        jButton4.setText("...");
        mapPanel.add(jButton4);

        jButton5.setText("...");
        mapPanel.add(jButton5);

        jButton6.setText("...");
        mapPanel.add(jButton6);

        jButton7.setText("...");
        mapPanel.add(jButton7);

        jButton8.setText("...");
        mapPanel.add(jButton8);

        jButton9.setText("...");
        mapPanel.add(jButton9);

        jButton10.setText("jButton10");
        mapPanel.add(jButton10);

        jButton11.setText("jButton11");
        mapPanel.add(jButton11);

        jButton12.setText("jButton12");
        mapPanel.add(jButton12);

        jButton13.setText("jButton13");
        mapPanel.add(jButton13);

        jButton14.setText("jButton14");
        mapPanel.add(jButton14);

        jButton15.setText("jButton15");
        mapPanel.add(jButton15);

        jButton16.setText("jButton16");
        mapPanel.add(jButton16);

        jButton17.setText("jButton17");
        mapPanel.add(jButton17);

        jButton18.setText("jButton18");
        mapPanel.add(jButton18);

        jButton19.setText("jButton19");
        mapPanel.add(jButton19);

        jButton21.setText("jButton21");
        mapPanel.add(jButton21);

        jButton20.setText("jButton20");
        mapPanel.add(jButton20);

        jButton22.setText("jButton22");
        mapPanel.add(jButton22);

        jButton23.setText("jButton23");
        mapPanel.add(jButton23);

        jButton24.setText("jButton24");
        mapPanel.add(jButton24);

        jButton25.setText("jButton25");
        mapPanel.add(jButton25);

        jButton26.setText("jButton26");
        mapPanel.add(jButton26);

        jButton27.setText("jButton27");
        mapPanel.add(jButton27);

        jButton28.setText("jButton28");
        mapPanel.add(jButton28);

        jButton29.setText("jButton29");
        mapPanel.add(jButton29);

        jButton30.setText("jButton30");
        mapPanel.add(jButton30);

        lblUsername.setText("User:");

        lblScore.setText("Score: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnRollDice)
                        .addGap(121, 121, 121)
                        .addComponent(lblDice))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addGap(18, 18, 18)
                .addComponent(lblScore)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRollDice)
                    .addComponent(lblDice))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void btnRollDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollDiceActionPerformed
        playDiceSound();

        int dice = (int) (Math.random() * 6) + 1;
        lblDice.setText("Rolled: " + dice);

        // Zar kadar ilerle
        for (int i = 0; i < dice && currentNode.next != null; i++) {
            currentNode = currentNode.next;
        }

        // Eğer jump varsa (maksimum 3 kere zıplayabilir güvenlik için)
        int jumpCount = 0;
        while (currentNode.jump != null && jumpCount < 3) {
            currentNode = currentNode.jump;
            jumpCount++;
        }

        // Hücre tipine göre puan değişimi ve ses efekti
        String cellType = currentNode.type;
        switch (cellType) {
            case "Treasure" -> {
                score += 10;
                playSound("treasure.wav"); // 🎵 Treasure sesi çal
            }

            case "Trap" -> {
                score -= 5;
                playSound("trap.wav"); // 🎵 Trap sesi çal
            }
        }

        lblScore.setText("Score: " + score);

        // 🔥 Bütün butonları güncelle: (icon + yazı)
        SpotNode temp = head;
        for (int i = 0; i < buttons.length; i++) {
            if (temp == null) {
                break;
            }

            buttons[i].setIcon(null); // ikonları temizle
            buttons[i].setText((i + 1) + " " + temp.type); // kendi type'ını yaz

            // İcon eklemek
            if (i == currentNode.index) {
                buttons[i].setIcon(playerIcon);
                buttons[i].setText(""); // ikon olunca text sil
            }

            // Renk güncellemesi - Level 2'de kullandığımız tasarıma uygun
            switch (temp.type) {
                case "Treasure" ->
                    buttons[i].setBackground(Color.GREEN); // Level 2'de green yapmıştık
                case "Trap" ->
                    buttons[i].setBackground(Color.RED);
                case "Forward" ->
                    buttons[i].setBackground(Color.LIGHT_GRAY);
                case "Backward" ->
                    buttons[i].setBackground(Color.DARK_GRAY);
                case "Finish" ->
                    buttons[i].setBackground(Color.BLUE);
                case "Start" ->
                    buttons[i].setBackground(Color.BLUE);
                default ->
                    buttons[i].setBackground(Color.WHITE);
            }

            temp = temp.next;
        }
        if (currentNode.type.equals("Finish")) {
            JOptionPane.showMessageDialog(this, "Game Over! Final Score: " + score);
            saveScoreToFile();
            new MainMenu().setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnRollDiceActionPerformed

    private void saveScoreToFile() {
        try {
            FileWriter fw = new FileWriter("score.txt", true); // true = dosyaya ekle
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(username + ", level2, " + score);
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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GamePageLevel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePageLevel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePageLevel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePageLevel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePageLevel2("TestUser").setVisible(true); // doğru

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    javax.swing.JPanel mapPanel;
    // End of variables declaration//GEN-END:variables
}
