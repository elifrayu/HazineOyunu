/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package data1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        setContentPane(new BackgroundPanel("/images/background.jpg"));
        initComponents();
    }

    private void showHowToPlay() {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/how_to_play.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);

        JOptionPane.showMessageDialog(
                this,
                label,
                "",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStartGame = new javax.swing.JButton();
        btnScoreboard = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnStartGame.setBackground(new java.awt.Color(162, 91, 23));
        btnStartGame.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnStartGame.setText("Start Game");
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });

        btnScoreboard.setBackground(new java.awt.Color(162, 91, 23));
        btnScoreboard.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnScoreboard.setText("Score Table");
        btnScoreboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreboardActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(162, 91, 23));
        btnExit.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setText("Treasure Hunt Adventure");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        jLabel2.setText("Roll the dice, collect treasures, and avoid traps!");

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jButton1.setText("Guide");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnScoreboard))
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnScoreboard, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        // Tema renkleri
        JDialog dialog = new JDialog(this, "🏴‍☠️ Start Your Adventure", true);
        dialog.setSize(400, 250);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(new Color(255, 243, 205)); // kum rengi

        JLabel title = new JLabel("🏝️ Welcome, Explorer!");
        title.setBounds(90, 20, 300, 25);
        title.setFont(new Font("Georgia", Font.BOLD, 18));
        title.setForeground(new Color(102, 51, 0));

        JLabel prompt = new JLabel("Enter your username:");
        prompt.setBounds(40, 60, 300, 20);
        prompt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        prompt.setForeground(new Color(102, 51, 0));

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(40, 85, 300, 30);
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btnStart = new JButton("🎮 Start Game");
        btnStart.setBounds(40, 130, 140, 35);
        btnStart.setBackground(new Color(255, 215, 130)); // Altın sarısı
        btnStart.setForeground(new Color(102, 51, 0));
        btnStart.setFocusPainted(false);

        JButton btnCancel = new JButton("🔙 Go Back");
        btnCancel.setBounds(200, 130, 140, 35);
        btnCancel.setBackground(new Color(200, 200, 200));
        btnCancel.setForeground(new Color(102, 51, 0));
        btnCancel.setFocusPainted(false);

        dialog.add(title);
        dialog.add(prompt);
        dialog.add(txtUsername);
        dialog.add(btnStart);
        dialog.add(btnCancel);

        btnStart.addActionListener(e -> {
    String username = txtUsername.getText().trim();

    if (!username.isEmpty()) {
        dialog.dispose();

        // Özel hoş geldin paneli oluştur
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBackground(new Color(255, 243, 205));
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("🏴‍☠️ Welcome, " + username + "!");
        lblTitle.setFont(new Font("Georgia", Font.BOLD, 20));
        lblTitle.setForeground(new Color(102, 51, 0));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitle = new JLabel("Let the treasure hunt begin!");
        lblSubtitle.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblSubtitle.setForeground(new Color(80, 40, 0));
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        welcomePanel.add(lblTitle);
        welcomePanel.add(Box.createVerticalStrut(10));
        welcomePanel.add(lblSubtitle);

        JOptionPane.showMessageDialog(
            this,
            welcomePanel,
            "Adventure Ready!",
            JOptionPane.PLAIN_MESSAGE
        );

        new GamePage(username).setVisible(true);
        this.dispose();

    } else {
        JOptionPane.showMessageDialog(dialog,
                "❗ Username cannot be empty!",
                "Input Error",
                JOptionPane.WARNING_MESSAGE);
    }
});

        btnCancel.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnScoreboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreboardActionPerformed
        JDialog dialog = new JDialog(this, "🏆 Score Table", true);
        dialog.setSize(420, 280);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(new Color(255, 243, 205)); // Kum rengi arka plan

        JLabel title = new JLabel("📜 View Your Scores!");
        title.setBounds(90, 15, 300, 25);
        title.setFont(new Font("Georgia", Font.BOLD, 18));
        title.setForeground(new Color(102, 51, 0));

        JLabel prompt = new JLabel("Enter your username:");
        prompt.setBounds(40, 55, 300, 20);
        prompt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        prompt.setForeground(new Color(102, 51, 0));

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(40, 80, 320, 30);
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btnShow = new JButton("📊 Show Scores");
        btnShow.setBounds(40, 130, 140, 35);
        btnShow.setBackground(new Color(255, 215, 130));
        btnShow.setForeground(new Color(102, 51, 0));
        btnShow.setFocusPainted(false);

        JButton btnCancel = new JButton("🔙 Go Back");
        btnCancel.setBounds(220, 130, 140, 35);
        btnCancel.setBackground(new Color(200, 200, 200));
        btnCancel.setForeground(new Color(102, 51, 0));
        btnCancel.setFocusPainted(false);

        dialog.add(title);
        dialog.add(prompt);
        dialog.add(txtUsername);
        dialog.add(btnShow);
        dialog.add(btnCancel);

        btnShow.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "❗ Username cannot be empty!");
                return;
            }

            ScoreBST bst = new ScoreBST();
            try (BufferedReader br = new BufferedReader(new FileReader("score.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 3) {
                        String user = parts[0].trim();
                        String level = parts[1].trim();
                        int score = Integer.parseInt(parts[2].trim());

                        if (user.equalsIgnoreCase(username)) {
                            bst.insert(score, level);
                        }
                    }
                }

                if (bst.root == null) {
                    JOptionPane.showMessageDialog(dialog, "No scores found for user: " + username);
                    return;
                }

                StringBuilder allScores = new StringBuilder();
                collectScoresInline(bst.root, allScores);
                ScoreNode best = bst.findMax(bst.root);
                ScoreNode worst = bst.findMin(bst.root);

                JTextArea area = new JTextArea();
                area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                area.setBackground(new Color(255, 250, 230));
                area.setForeground(new Color(60, 30, 0));
                area.setEditable(false);
                area.setText(
                        "🏴 User: " + username + "\n\n"
                        + "📜 All Scores:\n" + allScores.toString()
                        + "\n\n🏆 Best Score: " + best.score + " (" + best.level + ")"
                        + "\n💀 Worst Score: " + worst.score + " (" + worst.level + ")"
                );
                JScrollPane scroll = new JScrollPane(area);
                scroll.setPreferredSize(new Dimension(400, 250));
                scroll.setBorder(BorderFactory.createLineBorder(new Color(160, 82, 45), 2));

                JOptionPane.showMessageDialog(this, scroll, "🏆 Score Table", JOptionPane.PLAIN_MESSAGE);
                dialog.dispose();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });

        btnCancel.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

// Skorları inorder toplar
    private void collectScores(ScoreNode root, StringBuilder sb) {
        if (root != null) {
            collectScores(root.left, sb);
            sb.append(root.score).append(" (").append(root.level).append(")\n");
            collectScores(root.right, sb);
        }
    }//GEN-LAST:event_btnScoreboardActionPerformed
    private void collectScoresInline(ScoreNode root, StringBuilder sb) {
        if (root != null) {
            collectScoresInline(root.left, sb);
            sb.append(root.score).append(" (").append(root.level).append(")  |  ");
            collectScoresInline(root.right, sb);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showHowToPlay();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnScoreboard;
    private javax.swing.JButton btnStartGame;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
