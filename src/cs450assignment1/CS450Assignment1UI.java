/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs450assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Paul
 */
public class CS450Assignment1UI extends javax.swing.JFrame
{

    /**
     * Creates new form CS450Assignment1UI
     */
    public CS450Assignment1UI()
    {
        this.totalWaitTimeRR = 0;
        this.totalWaitTimeFCFS = 0;
        this.initialProcessList = new ArrayList<>();

        initComponents();

        this.numberOfProcesses = Integer.parseInt((String) jComboBoxProcessNum.getSelectedItem());
        this.quantum = Integer.parseInt((String) jComboBoxQuantum.getSelectedItem());
        this.numberOfSets = Integer.parseInt((String) jComboBoxNumSets.getSelectedItem());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroupProcessRun = new javax.swing.ButtonGroup();
        jDialogAbout = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaAbout = new javax.swing.JTextArea();
        jButtonAboutClose = new javax.swing.JButton();
        jPanelProcess = new javax.swing.JPanel();
        jScrollPaneProcessData = new javax.swing.JScrollPane();
        jTextAreaProcessData = new javax.swing.JTextArea();
        jPanelParameters = new javax.swing.JPanel();
        jLabelProcesses = new javax.swing.JLabel();
        jComboBoxProcessNum = new javax.swing.JComboBox<>();
        jComboBoxQuantum = new javax.swing.JComboBox<>();
        jLabelQuantum = new javax.swing.JLabel();
        jCheckBoxSaveToFile = new javax.swing.JCheckBox();
        jButtonClearProcessData = new javax.swing.JButton();
        jButtonGenerateProcess = new javax.swing.JButton();
        jCheckBoxVerbose = new javax.swing.JCheckBox();
        jLabelNumSets = new javax.swing.JLabel();
        jComboBoxNumSets = new javax.swing.JComboBox<>();
        jPanelAlgorithm = new javax.swing.JPanel();
        jPanelAlgorithmSelector = new javax.swing.JPanel();
        jRadioButtonFCFS = new javax.swing.JRadioButton();
        jRadioButtonRR = new javax.swing.JRadioButton();
        jRadioButtonComparator = new javax.swing.JRadioButton();
        jButtonRun = new javax.swing.JButton();
        jButtonClearOutput = new javax.swing.JButton();
        jScrollPaneOutput = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();
        jLabelInfo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jMenuItemQuit = new javax.swing.JMenuItem();

        jDialogAbout.setTitle("About");
        jDialogAbout.setLocation(new java.awt.Point(0, 0));
        jDialogAbout.setLocationByPlatform(true);
        jDialogAbout.setMinimumSize(new java.awt.Dimension(500, 400));
        jDialogAbout.setResizable(false);

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
        jButtonAboutClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
        setBounds(new java.awt.Rectangle(0, 0, 750, 800));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(getLocation());
        setMaximumSize(new java.awt.Dimension(750, 1500));
        setMinimumSize(new java.awt.Dimension(745, 800));
        setPreferredSize(new java.awt.Dimension(745, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(745, 800));

        jPanelProcess.setMaximumSize(new java.awt.Dimension(775, 32767));

        jScrollPaneProcessData.setBorder(javax.swing.BorderFactory.createTitledBorder("Process Data"));

        jTextAreaProcessData.setEditable(false);
        jTextAreaProcessData.setColumns(20);
        jTextAreaProcessData.setRows(5);
        jScrollPaneProcessData.setViewportView(jTextAreaProcessData);

        jPanelParameters.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        jLabelProcesses.setText("Number of Processes");

        jComboBoxProcessNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jComboBoxProcessNum.setToolTipText("The number of processes to utilize.");
        jComboBoxProcessNum.setBorder(null);
        jComboBoxProcessNum.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxProcessNumActionPerformed(evt);
            }
        });

        jComboBoxQuantum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jComboBoxQuantum.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxQuantumActionPerformed(evt);
            }
        });

        jLabelQuantum.setText("Quantum");

        jCheckBoxSaveToFile.setText("Save comparison to file");

        jButtonClearProcessData.setText("Clear Output");
        jButtonClearProcessData.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonClearProcessDataActionPerformed(evt);
            }
        });

        jButtonGenerateProcess.setText("Generate Data");
        jButtonGenerateProcess.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonGenerateProcessActionPerformed(evt);
            }
        });

        jCheckBoxVerbose.setText("Verbose comparison");

        jLabelNumSets.setText("Number Of Sets");

        jComboBoxNumSets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        jComboBoxNumSets.setToolTipText("The number of data sets to calculate when using the compare option.");
        jComboBoxNumSets.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxNumSetsActionPerformed(evt);
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
                            .addComponent(jComboBoxProcessNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxVerbose)
                            .addComponent(jLabelNumSets)
                            .addComponent(jComboBoxNumSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuantum))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGenerateProcess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonClearProcessData)
                .addGap(25, 25, 25))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNumSets)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxNumSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxSaveToFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxVerbose, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonClearProcessData, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerateProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelProcessLayout = new javax.swing.GroupLayout(jPanelProcess);
        jPanelProcess.setLayout(jPanelProcessLayout);
        jPanelProcessLayout.setHorizontalGroup(
            jPanelProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProcessLayout.createSequentialGroup()
                .addGroup(jPanelProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(jScrollPaneProcessData, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelProcessLayout.setVerticalGroup(
            jPanelProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProcessLayout.createSequentialGroup()
                .addComponent(jScrollPaneProcessData, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelAlgorithm.setMaximumSize(new java.awt.Dimension(775, 32767));
        jPanelAlgorithm.setMinimumSize(new java.awt.Dimension(700, 700));
        jPanelAlgorithm.setPreferredSize(new java.awt.Dimension(700, 700));

        jPanelAlgorithmSelector.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithm Type"));

        buttonGroupProcessRun.add(jRadioButtonFCFS);
        jRadioButtonFCFS.setSelected(true);
        jRadioButtonFCFS.setText("First Come First Serve");

        buttonGroupProcessRun.add(jRadioButtonRR);
        jRadioButtonRR.setText("Round Robin");

        buttonGroupProcessRun.add(jRadioButtonComparator);
        jRadioButtonComparator.setText("Compare");

        jButtonRun.setText("Run");
        jButtonRun.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonRunActionPerformed(evt);
            }
        });

        jButtonClearOutput.setText("Clear Output");
        jButtonClearOutput.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
                    .addComponent(jRadioButtonComparator)
                    .addGroup(jPanelAlgorithmSelectorLayout.createSequentialGroup()
                        .addGroup(jPanelAlgorithmSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButtonFCFS)
                            .addComponent(jRadioButtonRR, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAlgorithmSelectorLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(jButtonClearOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAlgorithmSelectorLayout.setVerticalGroup(
            jPanelAlgorithmSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlgorithmSelectorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jRadioButtonFCFS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonRR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonComparator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanelAlgorithmSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClearOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPaneOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithm Output"));

        jTextAreaOutput.setEditable(false);
        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setRows(5);
        jScrollPaneOutput.setViewportView(jTextAreaOutput);

        javax.swing.GroupLayout jPanelAlgorithmLayout = new javax.swing.GroupLayout(jPanelAlgorithm);
        jPanelAlgorithm.setLayout(jPanelAlgorithmLayout);
        jPanelAlgorithmLayout.setHorizontalGroup(
            jPanelAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlgorithmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneOutput)
                    .addComponent(jPanelAlgorithmSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAlgorithmLayout.setVerticalGroup(
            jPanelAlgorithmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlgorithmLayout.createSequentialGroup()
                .addComponent(jScrollPaneOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAlgorithmSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelInfo.setText("Made by Paul Canada");

        jMenuFile.setText("File");

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemAbout);

        jMenuItemQuit.setText("Close");
        jMenuItemQuit.setToolTipText("Closes the application.");
        jMenuItemQuit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
                .addComponent(jPanelProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProcess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAlgorithm, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInfo)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method handles performing actions when the Quit menu item is called. 
     * @param evt 
     */
    private void jMenuItemQuitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemQuitActionPerformed
    {//GEN-HEADEREND:event_jMenuItemQuitActionPerformed
        // Close out of the application
        this.dispose();
    }//GEN-LAST:event_jMenuItemQuitActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemAboutActionPerformed
    {//GEN-HEADEREND:event_jMenuItemAboutActionPerformed
        jDialogAbout.setVisible(true);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jButtonAboutCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAboutCloseActionPerformed
    {//GEN-HEADEREND:event_jButtonAboutCloseActionPerformed
        jDialogAbout.dispose();
    }//GEN-LAST:event_jButtonAboutCloseActionPerformed

    private void jButtonClearProcessDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearProcessDataActionPerformed
        jTextAreaProcessData.setText("");
    }//GEN-LAST:event_jButtonClearProcessDataActionPerformed

    private void jButtonGenerateProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateProcessActionPerformed
        System.out.println("Setting up initial list.");
        setupList();
        System.out.println("Done setting up initial List.");

        jTextAreaProcessData.setText("");

        for (int i = 0; i < numberOfProcesses; i++)
        {
            jTextAreaProcessData.setText(jTextAreaProcessData.getText()
                    + initialProcessList.get(i).getProcessName()
                    + "\r\n---Arrival time:  " + initialProcessList.get(i).getArrivalTime()
                    + "\r\n---Burst time:    " + initialProcessList.get(i).getBurstTime()
                    + "\r\n---Priority:          " + initialProcessList.get(i).getPriority() + "\r\n\r\n");

        }
    }//GEN-LAST:event_jButtonGenerateProcessActionPerformed

    private void jComboBoxQuantumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxQuantumActionPerformed
        quantum = Integer.parseInt((String) jComboBoxQuantum.getSelectedItem());
        jTextAreaProcessData.setText(jTextAreaProcessData.getText() + "Setting quantum to: " + Integer.toString(quantum) + ".\n");
    }//GEN-LAST:event_jComboBoxQuantumActionPerformed

    private void jComboBoxProcessNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProcessNumActionPerformed
        numberOfProcesses = Integer.parseInt((String) jComboBoxProcessNum.getSelectedItem());
        jTextAreaProcessData.setText(jTextAreaProcessData.getText() + "Setting number of processes to: " + Integer.toString(numberOfProcesses) + ".\n");
    }//GEN-LAST:event_jComboBoxProcessNumActionPerformed

    private void jButtonClearOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearOutputActionPerformed
        jTextAreaOutput.setText("");
    }//GEN-LAST:event_jButtonClearOutputActionPerformed

    private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed
        generateAlgorithmOutput();
    }//GEN-LAST:event_jButtonRunActionPerformed

    private void jComboBoxNumSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNumSetsActionPerformed
        this.numberOfSets = Integer.parseInt((String) jComboBoxNumSets.getSelectedItem());
        jTextAreaProcessData.setText(jTextAreaProcessData.getText() + "Setting number of sets to: " + Integer.toString(this.numberOfSets) + ".\n");
    }//GEN-LAST:event_jComboBoxNumSetsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(CS450Assignment1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CS450Assignment1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CS450Assignment1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CS450Assignment1UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
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
    private javax.swing.JCheckBox jCheckBoxVerbose;
    private javax.swing.JComboBox<String> jComboBoxNumSets;
    private javax.swing.JComboBox<String> jComboBoxProcessNum;
    private javax.swing.JComboBox<String> jComboBoxQuantum;
    private javax.swing.JDialog jDialogAbout;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelNumSets;
    private javax.swing.JLabel jLabelProcesses;
    private javax.swing.JLabel jLabelQuantum;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemQuit;
    private javax.swing.JPanel jPanelAlgorithm;
    private javax.swing.JPanel jPanelAlgorithmSelector;
    private javax.swing.JPanel jPanelParameters;
    private javax.swing.JPanel jPanelProcess;
    private javax.swing.JRadioButton jRadioButtonComparator;
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
    private final ArrayList<Process> initialProcessList;
    private FCFSQueue fcfs;
    private RRQueue rr;
    private int numberOfSets;
    private int totalWaitTimeRR;
    private int totalWaitTimeFCFS;

    // End of user declaration
    // User method declaration
    
    private void testSetup()
    {
        initialProcessList.add(new Process("P1", 7, 1, 3));
        initialProcessList.add(new Process("P2", 5, 1, 5));
        initialProcessList.add(new Process("P3", 4, 1, 9));
        initialProcessList.add(new Process("P4", 4, 1, 15));
        initialProcessList.add(new Process("P5", 6, 1, 21));
        initialProcessList.add(new Process("P6", 3, 1, 30));
        initialProcessList.add(new Process("P7", 7, 1, 36));
        initialProcessList.add(new Process("P8", 5, 1, 37));
        initialProcessList.add(new Process("P9", 3, 1, 39));
        initialProcessList.add(new Process("P10", 5, 1, 48));
        
    }
    
    private void setupList()
    {
        int bt = 0;
        int pr = 0;
        random = new Random();
        initialProcessList.clear();

        // Create a new process and store it in the initial list
        for (int i = 1; i <= numberOfProcesses; i++)
        {
            releaseTime += random.nextInt(10) + 1;
            bt = random.nextInt(5) + 3;
            pr = random.nextInt(numberOfProcesses / 2);

            initialProcessList.add(new Process("P" + i, bt, pr, releaseTime));
        }
        // Reset release time for fresh processes in the future
        releaseTime = 0;
    }

    private void setupAlgorithms()
    {
        if (jRadioButtonFCFS.isSelected())
        {
            System.out.println("Setting up FCFSQueue.");
            fcfs = new FCFSQueue(initialProcessList);
            fcfs.setupAlgorithm();
            System.out.println("Done setting up FCFSQueue.");
        } else if (jRadioButtonRR.isSelected())
        {
            System.out.println("Setting up RRQueue.");
            rr = new RRQueue(initialProcessList, quantum);
            rr.setupAlgorithm();
            System.out.println("Done setting up RRQueue.");
        } else
        {
            System.out.println("Setting up FCFSQueue.");
            fcfs = new FCFSQueue(initialProcessList);
            fcfs.setupAlgorithm();
            System.out.println("Done setting up FCFSQueue.");
            System.out.println("Setting up RRQueue.");
            rr = new RRQueue(initialProcessList, quantum);
            rr.setupAlgorithm();
            System.out.println("Done setting up RRQueue.");
        }

    }

    private void runComparator()
    {
        String processOutput = "";
        String algorithmOutput = "";
        jTextAreaOutput.setText("");
        jTextAreaProcessData.setText("");

        for (int i = 0; i < numberOfSets; i++)
        {

            setupList();

            processOutput += "--Start of Set #" + (i + 1) + "--\r\n\r\n";
            jTextAreaProcessData.setText(jTextAreaProcessData.getText() + processOutput);
            for (int j = 0; j < numberOfProcesses; j++)
            {
                processOutput += initialProcessList.get(j).getProcessName()
                        + "\r\n---Arrival time:  " + initialProcessList.get(j).getArrivalTime()
                        + "\r\n---Burst time:    " + initialProcessList.get(j).getBurstTime()
                        + "\r\n---Priority:      " + initialProcessList.get(j).getPriority() + "\r\n\r\n";

                //jTextAreaProcessData.setText(jTextAreaProcessData.getText() + processOutput);
            }
            processOutput += "\r\n--End of Set #" + (i + 1) + "--\r\n\r\n";
            //jTextAreaProcessData.setText(jTextAreaProcessData.getText() + processOutput);

            setupAlgorithms();
            totalWaitTimeRR += rr.calculateTotalWaitTime();
            totalWaitTimeFCFS += fcfs.calculateTotalWaitTime();

            if (jCheckBoxVerbose.isSelected())
            {
                algorithmOutput += "--Start of Set #" + (i + 1) + "--\r\n\r\n";

                algorithmOutput += "---Start of First Come First Serve Algorithm---\r\n\r\n"
                        + fcfs.getOutputText() + "\r\nAverage wait time: " + fcfs.calculateAverageWaitTime() + "\r\n\r\n" + "----End of First Come First Serve Algorithm----\r\n\r\n";

                algorithmOutput += "----Start of Round Robin Algorithm----\r\n\r\n"
                        + "\r\n\r\n" + rr.getOutputText() + "\r\nAverage wait time: " + rr.calculateAverageWaitTime() + "\r\n\r\n----End of Round Robin Algorithm----\r\n\r\n";

                algorithmOutput += "\r\n--End of Set #" + (i + 1) + "--\r\n\r\n";
            }

        }

        algorithmOutput += "\r\nAverage wait time for all data sets:\r\nFirst Come First Serve: "
                + ((float) (totalWaitTimeFCFS / (float) numberOfProcesses) / numberOfSets) + "\r\nRound Robin: " + ((float) (totalWaitTimeRR / (float) numberOfProcesses) / numberOfSets) + "\r\n";

        jTextAreaProcessData.setText(processOutput);
        jTextAreaOutput.setText(algorithmOutput);

        totalWaitTimeRR = 0;
        totalWaitTimeFCFS = 0;

        if (jCheckBoxSaveToFile.isSelected())
        {
            String fileName = "output-" + new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
            File file = new File("./" + fileName + ".txt");
            
            try
            (PrintWriter printWriter = new PrintWriter(file)) {

                printWriter.println(processOutput);
                printWriter.println(algorithmOutput);

            } catch (FileNotFoundException e)
            {
                System.out.println("File not found.");
            }
        }

    }

    private void generateAlgorithmOutput()
    {

        jTextAreaOutput.setText("");
        String output = "";

        try
        {
            if (initialProcessList.isEmpty() && !jRadioButtonComparator.isSelected())
            {
                jTextAreaOutput.setText("Process list is empty.\r\nPlease generate process data first.\r\n");
            } else
            {

                if (jRadioButtonFCFS.isSelected())
                {

                    setupAlgorithms();
                    output = "---Start of First Come First Serve Algorithm---\r\n\r\n" + fcfs.getOutputText() + "\r\nAverage wait time: "
                            + fcfs.calculateAverageWaitTime() + "\r\n\r\n" + "----End of First Come First Serve Algorithm----\r\n\r\n";

                    jTextAreaOutput.setText(jTextAreaOutput.getText() + output);
                } else if (jRadioButtonRR.isSelected())
                {

                    setupAlgorithms();
                    output = "----Start of Round Robin Algorithm----\r\n\r\n" + ".\r\n\r\n" + rr.getOutputText() + "\r\nAverage wait time: "
                            + rr.calculateAverageWaitTime() + "\r\n\r\n----End of Round Robin Algorithm----\r\n\r\n";

                    jTextAreaOutput.setText(jTextAreaOutput.getText() + output);
                } else if (jRadioButtonComparator.isSelected())
                {

                    runComparator();
                }
            }

        } catch (NullPointerException e)
        {
            jTextAreaOutput.setText(jTextAreaOutput.getText() + "Please generate process data first.\r\n");
        }
    }
    // End of user method delcaration
}
