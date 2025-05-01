/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package data1;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

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
        


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(255, 243, 205));
        infoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(160, 82, 45), 2), " "));

        lblUsername.setFont(new Font("Arial", Font.BOLD, 16));
        lblScore.setFont(new Font("Arial", Font.BOLD, 16));
        lblUsername.setForeground(new Color(102, 51, 0));
        lblScore.setForeground(new Color(102, 51, 0));

        infoPanel.add(lblUsername);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(lblScore);
        getContentPane().setBackground(new Color(255, 243, 205));
        mapPanel.setBackground(new Color(255, 243, 205));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(btnRollDice, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addGap(40)
                                .addComponent(lblDice, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                .addGap(40))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15)
                                .addComponent(btnRollDice)
                                .addGap(50)
                                .addComponent(lblDice)
                                .addGap(80)
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40)
                                .addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(40)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRollDice, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDice, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(40, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRollDice)
                                .addComponent(lblDice)
                                .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
        );

        setSize(1000, 700);
        setLocationRelativeTo(null);

        setupButtonLinkedListLevel2();
        btnRollDice.setIcon(resizeIcon("/images/dice.png", 40, 40));
        lblUsername.setText("User: " + username);
        lblScore.setText("Score: 0");
        setupButtonLinkedListLevel2();
        btnRollDice.setIcon(resizeIcon("/images/dice.png", 40, 40));
        lblUsername.setText("User: " + username);
        lblScore.setText("Score: 0");
    }
public void showCustomMoveDialog(JFrame parent, int dice, int from, int to, String cellType, int scoreDelta, int jumpCount) {
    JDialog dialog = new JDialog(parent, "🎲 Move Result", true);
    dialog.setSize(420, 250);
    dialog.setLayout(new BorderLayout());
    dialog.setLocationRelativeTo(parent);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(255, 243, 205));
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

    Font font = new Font("Segoe UI", Font.BOLD, 16);
    Color textColor = new Color(102, 51, 0);

    // Label listesi oluştur
    java.util.List<JLabel> labels = new java.util.ArrayList<>();

    if (jumpCount > 0)
        labels.add(new JLabel("⏩ You jumped " + jumpCount));

    labels.add(new JLabel("🎲 You rolled a " + dice + "!"));
    labels.add(new JLabel("📍 From position " + from + " to " + to));
    labels.add(new JLabel("🧭 Landed on: " + cellType));

    JLabel scoreLabel = new JLabel();
    if (scoreDelta > 0)
        scoreLabel.setText("🎉 +" + scoreDelta + " points!");
    else if (scoreDelta < 0)
        scoreLabel.setText("💀 " + scoreDelta + " points!");
    else
        scoreLabel.setText("🪵 No change in score.");
    labels.add(scoreLabel);

    // Ortak stil ve panel'e ekleme
    for (JLabel lbl : labels) {
        lbl.setFont(font);
        lbl.setForeground(textColor);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl);
        panel.add(Box.createVerticalStrut(8));
    }

    // OK Butonu
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
    private void setupButtonLinkedListLevel2() {
        buttons = new JButton[]{
            jButton1, jButton2, jButton3, jButton4, jButton5,
            jButton6, jButton7, jButton8, jButton9, jButton10,
            jButton11, jButton12, jButton13, jButton14, jButton15,
            jButton16, jButton17, jButton18, jButton19, jButton20,
            jButton21, jButton22, jButton23, jButton24, jButton25,
            jButton26, jButton27, jButton28, jButton29, jButton30
        };

        playerIcon = resizeIcon("/images/player_icon.png", 60, 60);

        String[] types = {"Treasure", "Trap", "Empty", "Forward", "Backward"};
        head = null;
        SpotNode prev = null;

        // 1. Normal ileri-geri bağlantılı listeyi kur
        for (int i = 0; i < 30; i++) {
            String type = types[(int) (Math.random() * types.length)];

            if (i == 0) {
                type = "Start"; // 1. butonun tipi Start olacak
            }

            if (i == buttons.length-1) {
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
            buttons[i].setText(""); // yazıyı tamamen kaldır

// Type'a göre ikon veriyoruz
            switch (type) {
                case "Treasure" ->
                    buttons[i].setIcon(resizeIcon("/images/treasure.png", 60, 60));
                case "Trap" ->
                    buttons[i].setIcon(resizeIcon("/images/trap.png", 60, 60));
                case "Forward" ->
                    buttons[i].setIcon(resizeIcon("/images/forward.png", 60, 60));
                case "Backward" ->
                    buttons[i].setIcon(resizeIcon("/images/backward.png", 60, 60));
                case "Finish" ->
                    buttons[i].setIcon(resizeIcon("/images/finish.png", 60, 60));
                case "Start" ->
                    buttons[i].setIcon(resizeIcon("/images/start.png", 60, 60));
                default ->
                    buttons[i].setIcon(resizeIcon("/images/empty.png", 60, 60));
            }
            buttons[i].setBackground(new Color(255, 243, 205));
            buttons[i].setOpaque(true);
            buttons[i].setContentAreaFilled(false);

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
        lblUsername = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblDice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        btnRollDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollDiceActionPerformed(evt);
            }
        });

        mapPanel.setBackground(new java.awt.Color(255, 243, 205));
        mapPanel.setLayout(new java.awt.GridLayout(5, 6, 10, 10));

        jButton1.setText("...");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        mapPanel.add(jButton1);

        jButton2.setText("...");
        jButton2.setContentAreaFilled(false);
        mapPanel.add(jButton2);

        jButton3.setText("...");
        jButton3.setContentAreaFilled(false);
        mapPanel.add(jButton3);

        jButton4.setText("...");
        jButton4.setContentAreaFilled(false);
        mapPanel.add(jButton4);

        jButton5.setText("...");
        jButton5.setContentAreaFilled(false);
        mapPanel.add(jButton5);

        jButton6.setText("...");
        jButton6.setContentAreaFilled(false);
        mapPanel.add(jButton6);

        jButton7.setText("...");
        jButton7.setContentAreaFilled(false);
        mapPanel.add(jButton7);

        jButton8.setText("...");
        jButton8.setContentAreaFilled(false);
        mapPanel.add(jButton8);

        jButton9.setText("...");
        jButton9.setContentAreaFilled(false);
        mapPanel.add(jButton9);

        jButton10.setText("...");
        jButton10.setContentAreaFilled(false);
        mapPanel.add(jButton10);

        jButton11.setText("...");
        jButton11.setContentAreaFilled(false);
        mapPanel.add(jButton11);

        jButton12.setText("...");
        jButton12.setContentAreaFilled(false);
        mapPanel.add(jButton12);

        jButton13.setText("...");
        jButton13.setContentAreaFilled(false);
        mapPanel.add(jButton13);

        jButton14.setText("...");
        jButton14.setContentAreaFilled(false);
        mapPanel.add(jButton14);

        jButton15.setText("...");
        jButton15.setContentAreaFilled(false);
        mapPanel.add(jButton15);

        jButton16.setText("...");
        jButton16.setContentAreaFilled(false);
        mapPanel.add(jButton16);

        jButton17.setText("...");
        jButton17.setContentAreaFilled(false);
        mapPanel.add(jButton17);

        jButton18.setText("...");
        jButton18.setContentAreaFilled(false);
        mapPanel.add(jButton18);

        jButton19.setText("...");
        jButton19.setContentAreaFilled(false);
        mapPanel.add(jButton19);

        jButton20.setText("...");
        jButton20.setContentAreaFilled(false);
        mapPanel.add(jButton20);

        jButton21.setText("...");
        jButton21.setContentAreaFilled(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        mapPanel.add(jButton21);

        jButton22.setText("...");
        jButton22.setContentAreaFilled(false);
        mapPanel.add(jButton22);

        jButton23.setText("...");
        jButton23.setContentAreaFilled(false);
        mapPanel.add(jButton23);

        jButton24.setText("...");
        jButton24.setContentAreaFilled(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        mapPanel.add(jButton24);

        jButton25.setText("...");
        jButton25.setContentAreaFilled(false);
        mapPanel.add(jButton25);

        jButton26.setText("...");
        jButton26.setContentAreaFilled(false);
        mapPanel.add(jButton26);

        jButton27.setText("...");
        jButton27.setContentAreaFilled(false);
        mapPanel.add(jButton27);

        jButton28.setText("...");
        jButton28.setContentAreaFilled(false);
        mapPanel.add(jButton28);

        jButton29.setText("...");
        jButton29.setContentAreaFilled(false);
        mapPanel.add(jButton29);

        jButton30.setText("...");
        jButton30.setContentAreaFilled(false);
        mapPanel.add(jButton30);

        lblUsername.setText("User:");

        lblScore.setText("Score: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnRollDice)
                        .addGap(121, 121, 121)
                        .addComponent(lblDice))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
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

        // Zarın değerini hesapla
        int dice = (int) (Math.random() * 6) + 1;
        btnRollDice.setIcon(resizeIcon("/images/dice.png", 40, 40));
        lblDice.setText("Rolled: " + dice);

        // Şu anki hücreyi kaydet
        SpotNode previousNode = currentNode;
        int previousIndex = currentNode.index;

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

            case "Empty" -> {
                // Boş hücrede hiçbir şey değişmez
            }
        }

        lblScore.setText("Score: " + score);

        // 🔥 Bütün butonları güncelle: (icon + yazı)
        SpotNode temp = head;
        for (int i = 0; i < buttons.length; i++) {
            if (temp == null) {
                break;
            }

            // Eğer eski hücrede oyuncu varsa, eski ikonunu geri getir
            if (temp.index == previousIndex) {
                // Önceki hücreye ait ikonları geri koyuyoruz (örneğin, "Empty" gibi)
                switch (temp.type) {
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
            }

            // İkonu şu anki hücreye koy
            if (i == currentNode.index) {
                buttons[i].setIcon(playerIcon);
            }

            temp = temp.next;
        }

        // Bilgilendirme mesajı
        int scoreDelta = 0;
if (cellType.equals("Treasure")) scoreDelta = 10;
else if (cellType.equals("Trap")) scoreDelta = -5;

showCustomMoveDialog(this, dice, previousNode.index+1, currentNode.index+1, cellType, scoreDelta, jumpCount);
        // Eğer varış noktası bitiş ise
        if (currentNode.type.equals("Finish")) {
            showGameOverDialog(this, score);
            saveScoreToFile();
            new MainMenu().setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnRollDiceActionPerformed
private void showGameOverDialog(Component parent, int finalScore) {
    JDialog dialog = new JDialog((JFrame) parent, "🎉 Adventure Completed", true);
    dialog.setSize(380, 200);
    dialog.setLocationRelativeTo(parent);
    dialog.setLayout(new BorderLayout());

    // Ana panel
    JPanel panel = new JPanel();
    panel.setBackground(new Color(255, 243, 205));
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

    JLabel lblTitle = new JLabel("🏁 Game Over!");
    lblTitle.setFont(new Font("Georgia", Font.BOLD, 22));
    lblTitle.setForeground(new Color(102, 51, 0));
    lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel lblScore = new JLabel("Your final score: " + finalScore);
    lblScore.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    lblScore.setForeground(new Color(60, 40, 0));
    lblScore.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(lblTitle);
    panel.add(Box.createVerticalStrut(10));
    panel.add(lblScore);

    // Buton paneli
    JButton btnOK = new JButton("Return to Menu 🔙");
    btnOK.setBackground(new Color(255, 223, 140));
    btnOK.setForeground(new Color(102, 51, 0));
    btnOK.setFont(new Font("Segoe UI", Font.BOLD, 14));
    btnOK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnOK.setFocusPainted(false);
    btnOK.setBorder(BorderFactory.createLineBorder(new Color(160, 82, 45)));

    btnOK.addActionListener(e -> {
        dialog.dispose();
        new MainMenu().setVisible(true);
    });

    JPanel btnPanel = new JPanel();
    btnPanel.setBackground(new Color(255, 243, 205));
    btnPanel.add(btnOK);

    dialog.add(panel, BorderLayout.CENTER);
    dialog.add(btnPanel, BorderLayout.SOUTH);
    dialog.setVisible(true);
}
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

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

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
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
