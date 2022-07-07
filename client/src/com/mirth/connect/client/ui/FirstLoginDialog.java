/*
 * Copyright (c) Mirth Corporation. All rights reserved.
 * 
 * http://www.mirthcorp.com
 * 
 * The software in this package is published under the terms of the MPL license a copy of which has
 * been included with this distribution in the LICENSE.txt file.
 */

package com.mirth.connect.client.ui;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.mirth.connect.client.core.ClientException;
import com.mirth.connect.client.ui.util.DisplayUtil;
import com.mirth.connect.model.User;

/**
 * A dialog for creating a new user or editing a current user
 */
public class FirstLoginDialog extends javax.swing.JDialog implements UserDialogInterface {

    private Frame parent;

    /** Creates new form UserDialog */
    public FirstLoginDialog(User currentUser) {
        super(PlatformUI.MIRTH_FRAME);
        this.parent = PlatformUI.MIRTH_FRAME;
        initComponents();
        DisplayUtil.setResizable(this, false);
        finishButton.setEnabled(false);

        userEditPanel.setUser(this, currentUser);
        userEditPanel.setRequiredFields(true, true);
        if (currentUser.getId() == 1) {
            registerCheckBox.setEnabled(false);
        }

        jLabel2.setForeground(UIConstants.HEADER_TITLE_TEXT_COLOR);
        setModal(true);

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                finishButtonActionPerformed(null);
            }
        });

        pack();
        Dimension dlgSize = getPreferredSize();
        Dimension frmSize = parent.getSize();
        Point loc = parent.getLocation();

        if ((frmSize.width == 0 && frmSize.height == 0) || (loc.x == 0 && loc.y == 0)) {
            setLocationRelativeTo(null);
        } else {
            setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
        }

        setVisible(true);
    }

    public void setFinishButtonEnabled(boolean enabled) {
        finishButton.setEnabled(enabled);
    }

    public void triggerFinishButton() {
        finishButtonActionPerformed(null);
    }

    // @formatter:off
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        channelOverview = new javax.swing.JPanel();
        finishButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        mirthHeadingPanel1 = new com.mirth.connect.client.ui.MirthHeadingPanel();
        jLabel2 = new javax.swing.JLabel();
        userEditPanel = new com.mirth.connect.client.ui.UserEditPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        registerCheckBox = new javax.swing.JCheckBox();
        userConsentCheckBox = new javax.swing.JCheckBox();
        contentTextPane = new javax.swing.JTextPane();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome to Mirth Connect");

        channelOverview.setBackground(new java.awt.Color(255, 255, 255));
        channelOverview.setName(""); // NOI18N

        finishButton.setText("Finish");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html>Welcome to Mirth<sup>�</sup> Connect by NextGen<sup>�</sup> Healthcare</html>");

        javax.swing.GroupLayout mirthHeadingPanel1Layout = new javax.swing.GroupLayout(mirthHeadingPanel1);
        mirthHeadingPanel1.setLayout(mirthHeadingPanel1Layout);
        mirthHeadingPanel1Layout.setHorizontalGroup(
            mirthHeadingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mirthHeadingPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );
        mirthHeadingPanel1Layout.setVerticalGroup(
            mirthHeadingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mirthHeadingPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(250, 250, 210));
        jTextPane1.setText("You may now customize your Mirth Connect user account information. You also have the option of changing your account password.");
        jTextPane1.setAutoscrolls(false);
        jTextPane1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextPane1.setEnabled(false);
        jScrollPane1.setViewportView(jTextPane1);
        
        registerCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        registerCheckBox.setSelected(true);
        registerCheckBox.setText("Register user with NextGen Healthcare - ALL fields are required unless marked as \"Optional\"");
        registerCheckBox.setToolTipText("<html>Register your user information with NextGen Healthcare to help us<br>improve the product and provide better service.</html>");
        registerCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerCheckBoxActionPerformed(evt);
            }
        });
        
        userConsentCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        userConsentCheckBox.setSelected(true);
        userConsentCheckBox.setText("I consent to recieve email updates and marketing messages from NextGen Healthcare.");
        userConsentCheckBox.setToolTipText("<html></html>"); 

        contentTextPane.setContentType("text/html");
        contentTextPane.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;For more information on the processing of your personal data, click <a href=\"https://www.nextgen.com/privacy-policy\">here to find our Privacy Policy.</a></html>");   
        
        MutableAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(set, 1);
        StyleConstants.setFontSize(set, 10);
        StyleConstants.setFontFamily(set, "Tahoma");
        StyledDocument doc = contentTextPane.getStyledDocument();
        doc.setCharacterAttributes(0, doc.getLength() + 1, set, false);
        
        contentTextPane.setParagraphAttributes(set, true);
        contentTextPane.setEditable(false);
        contentTextPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent evt) {
                if (evt.getEventType() == EventType.ACTIVATED && Desktop.isDesktopSupported()) {
                    try {
                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().browse(evt.getURL().toURI());
                        } else {
                            BareBonesBrowserLaunch.openURL(evt.getURL().toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        javax.swing.GroupLayout channelOverviewLayout = new javax.swing.GroupLayout(channelOverview);
        channelOverview.setLayout(channelOverviewLayout);
        channelOverviewLayout.setHorizontalGroup(
            channelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, channelOverviewLayout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(finishButton)
                .addGap(9, 9, 9))
            .addComponent(mirthHeadingPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
            .addGroup(channelOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(channelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addGroup(channelOverviewLayout.createSequentialGroup()
                        .addGroup(channelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerCheckBox)
                            .addComponent(userConsentCheckBox)
                            .addComponent(contentTextPane)
                            .addComponent(userEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        channelOverviewLayout.setVerticalGroup(
            channelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, channelOverviewLayout.createSequentialGroup()
                .addComponent(mirthHeadingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userConsentCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentTextPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(channelOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(channelOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // @formatter:on

    /**
     * An action for when the finish button is pressed. Checks and saves all of the information.
     */
    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        finishButton.requestFocus();
        String validateUserMessage = userEditPanel.validateUser();
        if (validateUserMessage != null) {
            parent.alertWarning(this, validateUserMessage);
        } else {
            User user = userEditPanel.getUser();
            if (userConsentCheckBox.isSelected()) {
            	user.setUserConsent(true);
            }
            boolean success = false;

            success = parent.updateCurrentUser(this, user, userEditPanel.getPassword());

            if (!success) {
                return;
            }

            if (registerCheckBox.isSelected()) {
                parent.registerUser(user);
            }

            try {
                User currentUser = parent.getCurrentUser(parent);
                parent.mirthClient.setUserPreference(currentUser.getId(), "firstlogin", "false");
            } catch (ClientException e) {
                parent.alertThrowable(this, e);
            }

            this.dispose();
        }
    }//GEN-LAST:event_finishButtonActionPerformed

    private void registerCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerCheckBoxActionPerformed
        boolean allRequired = registerCheckBox.isSelected();
        userEditPanel.setRequiredFields(allRequired, true);
    }//GEN-LAST:event_registerCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel channelOverview;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextPane1;
    private com.mirth.connect.client.ui.MirthHeadingPanel mirthHeadingPanel1;
    private javax.swing.JCheckBox registerCheckBox;
    private javax.swing.JCheckBox userConsentCheckBox;
    private com.mirth.connect.client.ui.UserEditPanel userEditPanel;
    private javax.swing.JTextPane contentTextPane;
    // End of variables declaration//GEN-END:variables
}
