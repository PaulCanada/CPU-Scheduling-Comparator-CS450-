/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs450assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Paul
 */
public class CS450Assignment1UI extends javax.swing.JFrame {

    /**
     * Creates new form CS450Assignment1UI
     */
    public CS450Assignment1UI() {
        this.initialProcessList = new ArrayList<Process>();

        initComponents();
        numberOfProcesses = Integer.parseInt((String) jComboBoxProcessNum.getSelectedItem());
        quantum = Integer.parseInt((String) jComboBoxQuantum.getSelectedItem());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupProcessRun = new javax.swing.ButtonGroup();
        jDialogAbout = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaAbout = new javax.swing.JTextArea();
        jButtonAboutClose = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jLabelInfo = new javax.swing.JLabel();
        jScrollPaneProcessData = new javax.swing.JScrollPane();
        jTextAreaProcessData = new javax.swing.JTextArea();
        jPanelAlgorithmSelector = new javax.swing.JPanel();
        jRadioButtonFCFS = new javax.swing.JRadioButton();
        jRadioButtonRR = new javax.swing.JRadioButton();
        jRadioButtonBoth = new javax.swing.JRadioButton();
        jButtonRun = new javax.swing.JButton();
        jButtonClearOutput = new javax.swing.JButton();
        jScrollPaneOutput = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();
        jPanelParameters = new javax.swing.JPanel();
        jLabelProcesses = new javax.swing.JLabel();
        jComboBoxProcessNum = new javax.swing.JComboBox<>();
        jComboBoxQuantum = new javax.swing.JComboBox<>();
        jLabelQuantum = new javax.swing.JLabel();
        jCheckBoxSaveToFile = new javax.swing.JCheckBox();
        jButtonClearProcessData = new javax.swing.JButton();
        jButtonGenerateProcess = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNewData = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jMenuItemQuit = new javax.swing.JMenuItem();

        jDialogAbout.setTitle("About");
        jDialogAbout.setMinimumSize(new java.awt.Dimension(500, 400));
        jDialogAbout.setModal(true);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextAreaAbout.setEditable(false);
        jTextAreaAbout.setColumns(20);
        jTextAreaAbout.setLineWrap(true);
        jTextAreaAbout.setRows(5);
        jTextAreaAbout.setText("This program tests the efficiency and performance of the First Come First Serve and Round Robin CPU scheduling algorithms.\n\nAssignment 1 for WCSU's CS450 Operating Systems class.\n\nMade by Paul Canada.");
        jTextAreaAbout.setWrapStyleWord(true);
        jTextAreaAbout.setAutoscrolls(false);
        jTextAreaAbout.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane2.setViewportView(jTextAreaAbout);

        jButtonAboutClose.setText("Close");
        jButtonAboutClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAboutCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogAboutLayout = new javax.swing.GroupLayout(jDialogAbout.getContentPane());
        jDialogAbout.getContentPane().setLayout(jDialogAboutLayout);
        jDialogAboutLayout.setHorizontalGroup(
            jDialogAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAboutLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2)
                .addGap(19, 19, 19))
            .addGroup(jDialogAboutLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButtonAboutClose, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(157, 157, 157))
        );
        jDialogAboutLayout.setVerticalGroup(
            jDialogAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAboutLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(73, 73, 73)
                .addComponent(jButtonAboutClose, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.controlDkShadow);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(800, 800));

        jPanelMain.setMinimumSize(new java.awt.Dimension(700, 700));
        jPanelMain.setPreferredSize(new java.awt.Dimension(700, 700));

        jLabelInfo.setText("Made by Paul Canada");

        jScrollPaneProcessData.setBorder(javax.swing.BorderFactory.createTitledBorder("Process Data"));

        jTextAreaProcessData.setEditable(false);
        jTextAreaProcessData.setColumns(20);
        jTextAreaProcessData.setRows(5);
        jScrollPaneProcessData.setViewportView(jTextAreaProcessData);

        jPanelAlgorithmSelector.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithm Type"));

        buttonGroupProcessRun.add(jRadioButtonFCFS);
        jRadioButtonFCFS.setSelected(true);
        jRadioButtonFCFS.setText("First Come First Serve");

        buttonGroupProcessRun.add(jRadioButtonRR);
        jRadioButtonRR.setText("Round Robin");

        buttonGroupProcessRun.add(jRadioButtonBoth);
        jRadioButtonBoth.setText("Compare");

        jButtonRun.setText("Run");
        jButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRunActionPerformed(evt);
            }
        });

        jButtonClearOutput.setText("Clear Output");
        jButtonClearOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlgorithmSelectorLayout = new javax.swing.GroupLayout(jPanelAlgorithmSelector);
        jPanelAlgorithmSelector.setLayout(jPanelAlgorithmSelectorLayout);
        jPanelAlgorithmSelectorLayout.setHorizontalGroup(
            jPanelAlgorithmSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlgorithmSelectorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlgorithmSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAlgorithmSelectorLayout.createSequentialGroup()
                        .addGroup(jPanelAlgorithmSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButtonFCFS)
                            .addComponent(jRadioButtonRR, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonBoth, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelAlgorithmSelectorLayout.createSequentialGroup()
                        .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jButtonClearOutput)))
                .addContainerGap())
        );
        jPanelAlgorithmSelectorLayout.setVerticalGroup(
            jPanelAlgorithmSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlgorithmSelectorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jRadioButtonFCFS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonRR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBoth)
                .addGap(18, 18, 18)
                .addGroup(jPanelAlgorithmSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClearOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jScrollPaneOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithm Output"));

        jTextAreaOutput.setEditable(false);
        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setRows(5);
        jScrollPaneOutput.setViewportView(jTextAreaOutput);

        jPanelParameters.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        jLabelProcesses.setText("Number of Processes");

        jComboBoxProcessNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jComboBoxProcessNum.setToolTipText("The number of processes to utilize.");
        jComboBoxProcessNum.setBorder(null);
        jComboBoxProcessNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProcessNumActionPerformed(evt);
            }
        });

        jComboBoxQuantum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jComboBoxQuantum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxQuantumActionPerformed(evt);
            }
        });

        jLabelQuantum.setText("Quantum");

        jCheckBoxSaveToFile.setText("Save to file");

        jButtonClearProcessData.setText("Clear Output");
        jButtonClearProcessData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearProcessDataActionPerformed(evt);
            }
        });

        jButtonGenerateProcess.setText("Generate New Data");
        jButtonGenerateProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateProcessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelParametersLayout = new javax.swing.GroupLayout(jPanelParameters);
        jPanelParameters.setLayout(jPanelParametersLayout);
        jPanelParametersLayout.setHorizontalGroup(
            jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParametersLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProcesses)
                    .addGroup(jPanelParametersLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxSaveToFile)
                            .addComponent(jComboBoxProcessNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuantum))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGenerateProcess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonClearProcessData)
                .addGap(19, 19, 19))
        );
        jPanelParametersLayout.setVerticalGroup(
            jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProcesses)
                    .addComponent(jLabelQuantum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProcessNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxSaveToFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClearProcessData, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerateProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneProcessData, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                    .addComponent(jScrollPaneOutput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelAlgorithmSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabelInfo)
                        .addGap(45, 45, 45))))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jPanelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE))
                    .addComponent(jScrollPaneProcessData))
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jPanelAlgorithmSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jLabelInfo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addComponent(jScrollPaneOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        jMenuFile.setText("File");

        jMenuItemNewData.setText("Generate New Data");
        jMenuItemNewData.setToolTipText("Creates a new set of processes.");
        jMenuItemNewData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewDataActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNewData);

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemAbout);

        jMenuItemQuit.setText("Close");
        jMenuItemQuit.setToolTipText("Closes the application.");
        jMenuItemQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemQuitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemQuit);

        jMenuBar.add(jMenuFile);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemQuitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemQuitActionPerformed
    {//GEN-HEADEREND:event_jMenuItemQuitActionPerformed
        // Close out of the application
        this.dispose();
    }//GEN-LAST:event_jMenuItemQuitActionPerformed

    private void jMenuItemNewDataActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemNewDataActionPerformed
    {//GEN-HEADEREND:event_jMenuItemNewDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemNewDataActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemAboutActionPerformed
    {//GEN-HEADEREND:event_jMenuItemAboutActionPerformed
        // TODO add your handling code here:

        jDialogAbout.setVisible(true);
        //JDialog.showMessageDialog(this, "Poop");
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jButtonAboutCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAboutCloseActionPerformed
    {//GEN-HEADEREND:event_jButtonAboutCloseActionPerformed
        // TODO add your handling code here:
        jDialogAbout.dispose();
    }//GEN-LAST:event_jButtonAboutCloseActionPerformed

    private void jButtonClearProcessDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearProcessDataActionPerformed
        // TODO add your handling code here:
        jTextAreaProcessData.setText("");
    }//GEN-LAST:event_jButtonClearProcessDataActionPerformed

    private void jButtonGenerateProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateProcessActionPerformed
        System.out.println("Setting up initial list.");
        setupList(numberOfProcesses);
        System.out.println("Done setting up initial List.");

        System.out.println("Setting up FCFSQueue.");
        fcfs = new FCFSQueue(initialProcessList);
        fcfs.setupAlgorithm();
        System.out.println("Done setting up FCFSQueue.");

        System.out.println("Setting up RRQueue.");
        rr = new RRQueue(initialProcessList, quantum);
        rr.setupAlgorithm();
        System.out.println("Done setting up RRQueue.");

        jTextAreaProcessData.setText("");

        for (int i = 0; i < numberOfProcesses; i++) {
            jTextAreaProcessData.setText(jTextAreaProcessData.getText()
                + initialProcessList.get(i).getProcessName()
                + "\n---Burst time:  " + initialProcessList.get(i).getBurstTime()
                + "\n---Priority:        " + initialProcessList.get(i).getPriority()
                + "\n---Arrival time: " + initialProcessList.get(i).getArrivalTime() + "\n\n");

        }
    }//GEN-LAST:event_jButtonGenerateProcessActionPerformed

    private void jComboBoxQuantumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxQuantumActionPerformed
        // TODO add your handling code here:
        quantum = Integer.parseInt((String) jComboBoxQuantum.getSelectedItem());
        jTextAreaProcessData.setText(jTextAreaProcessData.getText() + "Setting quantum to : " + Integer.toString(quantum) + ".\n");
    }//GEN-LAST:event_jComboBoxQuantumActionPerformed

    private void jComboBoxProcessNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProcessNumActionPerformed
        // TODO add your handling code here:
        numberOfProcesses = Integer.parseInt((String) jComboBoxProcessNum.getSelectedItem());
        jTextAreaProcessData.setText(jTextAreaProcessData.getText() + "Setting number of processes to : " + Integer.toString(numberOfProcesses) + ".\n");
    }//GEN-LAST:event_jComboBoxProcessNumActionPerformed

    private void jButtonClearOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearOutputActionPerformed
        // TODO add your handling code here:
        jTextAreaOutput.setText("");
    }//GEN-LAST:event_jButtonClearOutputActionPerformed

    private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed
        // TODO add your handling code here:
        generateAlgorithmOutput();
    }//GEN-LAST:event_jButtonRunActionPerformed

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
            java.util.logging.Logger.getLogger(CS450Assignment1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CS450Assignment1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CS450Assignment1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CS450Assignment1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CS450Assignment1UI().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupProcessRun;
    private javax.swing.JButton jButtonAboutClose;
    private javax.swing.JButton jButtonClearOutput;
    private javax.swing.JButton jButtonClearProcessData;
    private javax.swing.JButton jButtonGenerateProcess;
    private javax.swing.JButton jButtonRun;
    private javax.swing.JCheckBox jCheckBoxSaveToFile;
    private javax.swing.JComboBox<String> jComboBoxProcessNum;
    private javax.swing.JComboBox<String> jComboBoxQuantum;
    private javax.swing.JDialog jDialogAbout;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelProcesses;
    private javax.swing.JLabel jLabelQuantum;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemNewData;
    private javax.swing.JMenuItem jMenuItemQuit;
    private javax.swing.JPanel jPanelAlgorithmSelector;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelParameters;
    private javax.swing.JRadioButton jRadioButtonBoth;
    private javax.swing.JRadioButton jRadioButtonFCFS;
    private javax.swing.JRadioButton jRadioButtonRR;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneOutput;
    private javax.swing.JScrollPane jScrollPaneProcessData;
    private javax.swing.JTextArea jTextAreaAbout;
    private javax.swing.JTextArea jTextAreaOutput;
    private javax.swing.JTextArea jTextAreaProcessData;
    // End of variables declaration//GEN-END:variables

    // User variable declaration
    private static int releaseTime = 0;
    private Random random;
    private int numberOfProcesses = 0;
    private int quantum = 0;
    private ArrayList<Process> initialProcessList;
    private ArrayList<ExtendedProcess> initialEProcessList;
    private FCFSQueue fcfs;
    private RRQueue rr;
    // End of user declaration

    // User method declaration
    private void setupList(int numberOfProcesses) {
        int bt = 0;
        int pr = 0;
        random = new Random();
        initialProcessList.clear();

        // Create a new process and store it in the initial list
        for (int i = 1; i <= numberOfProcesses; i++) {
            releaseTime += random.nextInt(10);
            bt = random.nextInt(5) + 3;
            pr = random.nextInt(numberOfProcesses / 2);

            initialProcessList.add(new Process("P" + i, bt, pr, releaseTime));

        }

        // Reset release time for fresh processes in the future
        releaseTime = 0;
    }

    private void generateAlgorithmOutput() {
        try {
            if ((fcfs.getNumberOfProcesses() < 10) || (rr.getNumberOfProcesses() < 10)) {
                jTextAreaOutput.setText("Must have at least 10 processes.\n");
            } else {

                if (jRadioButtonFCFS.isSelected()) {
                    jTextAreaOutput.setText(jTextAreaOutput.getText() + "-------------Start of First Come First Serve Algorithm----------\n\n"
                            + fcfs.getOutputText() + "-----------End of First Come First Serve Algorithm-----------\n\n");
                } else if (jRadioButtonRR.isSelected()) {
                    jTextAreaOutput.setText(jTextAreaOutput.getText() + "-------------------Start of Round Robin Algorithm---------------\n\n"
                            + rr.getOutputText() + "---------------------End of Round Robin Algorithm---------------\n\n");
                }
            }
        } catch (NullPointerException e) {
            jTextAreaOutput.setText(jTextAreaOutput.getText() + "Please generate process data first.\n");
        }
    }
    // End of user method delcaration
}
