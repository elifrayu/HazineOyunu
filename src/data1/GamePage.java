/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package data1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 *
 * @author elifuyar
 */
public class GamePage extends javax.swing.JFrame {

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

        getContentPane().setBackground(new Color(255, 243, 205));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(255, 243, 205));

        lblUsername.setFont(new Font("Arial", Font.BOLD, 16));
        lblScore.setFont(new Font("Arial", Font.BOLD, 16));
        lblUsername.setForeground(new Color(102, 51, 0));
        lblScore.setForeground(new Color(102, 51, 0));

        infoPanel.add(lblUsername);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(lblScore);

        btnBack.setText("🔙 Back to Menu");
        btnBack.setBackground(new Color(255, 215, 130));
        btnBack.setForeground(new Color(102, 51, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBack.setFocusPainted(false);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(153, 102, 0), 2));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60)
                                .addComponent(btnRollDice, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addGap(40)
                                .addComponent(lblDice, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                .addGap(40))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(80, Short.MAX_VALUE)
                                .addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(20)
                                .addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRollDice, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDice, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setupButtonLinkedList();
        btnRollDice.setIcon(resizeIcon("/images/dice.png", 40, 40));
        btnRollDice.setBackground(new Color(255, 215, 100)); // Altın sarısı tonu
        btnRollDice.setForeground(new Color(102, 51, 0)); // Yazı rengi uyumlu kahverengi
        btnRollDice.setFocusPainted(false); // Kenar efekti yok
        btnRollDice.setBorder(BorderFactory.createLineBorder(new Color(160, 82, 45), 2)); // Sınır çizgisi
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
            //son elemanım buttons[29] olacağı için 
            if (i == buttons.length - 1) {
                type = "Finish"; // 30. butonun tipi Finish olacak
            }

            SpotNode node = new SpotNode(type, i);

            if (head == null) {
                head = node;
                currentNode = head;
            } else {
                //önceki düğümle şimdikini bağlar
                prev.next = node;
            }
            //şimdiki düğüm bir sonrakinde prev olur
            prev = node;

            buttons[i].setText("");

            buttons[i].setPreferredSize(new Dimension(100, 60));

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

            buttons[i].setOpaque(false);
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

        mapPanel.setBackground(new java.awt.Color(255, 243, 205));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(202, Short.MAX_VALUE)
                    .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(148, Short.MAX_VALUE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 543, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRollDice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDice, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(336, Short.MAX_VALUE)
                    .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(338, Short.MAX_VALUE)))
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
        int scoreDelta = 0;
        if (cellType.equals("Treasure")) {
            scoreDelta = 10;
        } else if (cellType.equals("Trap")) {
            scoreDelta = -5;
        }
        showCustomMoveDialog(this, dice, previousNode.index + 1, currentNode.index + 1, cellType, scoreDelta);
        // showCustomMoveDialog(this, dice, previousNode.index, currentNode.index, cellType, scoreDelta);
        if (currentNode.type.equals("Finish")) {
            saveScoreToFile();
            showLevelCompleteDialog(this, score, username);
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

    private void showLevelCompleteDialog(JFrame parent, int finalScore, String username) {
        JDialog dialog = new JDialog(parent, "🎉 Level 1 Completed!", true);
        dialog.setSize(450, 250);
        dialog.setLocationRelativeTo(parent);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 243, 205));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        Font fontTitle = new Font("Georgia", Font.BOLD, 22);
        Font fontText = new Font("Segoe UI", Font.PLAIN, 16);
        Color textColor = new Color(102, 51, 0);

        JLabel lbl1 = new JLabel("🏁 Level 1 Completed!");
        lbl1.setFont(fontTitle);
        lbl1.setForeground(textColor);
        lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lbl2 = new JLabel("🎯 Final Score: " + finalScore);
        lbl2.setFont(fontText);
        lbl2.setForeground(textColor);
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lbl3 = new JLabel("Would you like to continue to Level 2?");
        lbl3.setFont(fontText);
        lbl3.setForeground(textColor);
        lbl3.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(lbl1);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lbl2);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lbl3);

        // Butonlar
        JButton btnYes = new JButton("✅ Yes, continue");
        JButton btnNo = new JButton("❌ No, go to menu");

        Font btnFont = new Font("Segoe UI", Font.BOLD, 14);

        for (JButton btn : new JButton[]{btnYes, btnNo}) {
            btn.setBackground(new Color(255, 223, 140));
            btn.setForeground(textColor);
            btn.setFont(btnFont);
            btn.setFocusPainted(false);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createLineBorder(new Color(160, 82, 45)));
        }

        btnYes.addActionListener(e -> {
            dialog.dispose();
            parent.dispose(); // GamePageLevel1'i kapat
            new GamePageLevel2(username).setVisible(true);
        });

        btnNo.addActionListener(e -> {
            dialog.dispose();
            parent.dispose();
            new MainMenu().setVisible(true);
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(255, 243, 205));
        btnPanel.add(btnYes);
        btnPanel.add(Box.createHorizontalStrut(10));
        btnPanel.add(btnNo);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(btnPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    public void showCustomMoveDialog(JFrame parent, int dice, int from, int to, String cellType, int scoreDelta) {
        JDialog dialog = new JDialog(parent, "🎲 Move Result", true);
        dialog.setSize(400, 240);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 243, 205));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        Font font = new Font("Segoe UI", Font.BOLD, 16);
        Color textColor = new Color(102, 51, 0);

        JLabel lbl1 = new JLabel("🎲 You rolled a " + dice + "!");
        JLabel lbl2 = new JLabel("📌 From position " + from + " to " + to);
        JLabel lbl3 = new JLabel("🗽 Landed on: " + cellType);
        JLabel lbl4 = new JLabel();

        if (scoreDelta > 0) {
            lbl4.setText("🎉 +" + scoreDelta + " points!");
        } else if (scoreDelta < 0) {
            lbl4.setText("💀 " + scoreDelta + " points!");
        } else {
            lbl4.setText("🪥 No change in score.");
        }

        for (JLabel lbl : new JLabel[]{lbl1, lbl2, lbl3, lbl4}) {
            lbl.setFont(font);
            lbl.setForeground(textColor);
            lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(lbl);
            panel.add(Box.createVerticalStrut(8));
        }

        JButton ok = new JButton("OK ✅");
        ok.setBackground(new Color(255, 223, 140));
        ok.setForeground(textColor);
        ok.setFont(new Font("Segoe UI", Font.BOLD, 14));
        ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ok.addActionListener(e -> dialog.dispose());

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(255, 243, 205));
        btnPanel.add(ok);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(btnPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
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
