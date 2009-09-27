/*
 * PreferencesGUI.java
 *
 * Created on July 29, 2007, 6:28 PM
 * 
 * @author Truben
 */

package dbox2.GUI;

import dbox2.*;
import dbox2.util.FileChooserFilter;
import dbox2.util.helperClass;
import java.awt.*;
import javax.swing.*;

public class PreferencesGUI extends javax.swing.JDialog {

    private int iconindex;
    
    /** Creates new form PreferencesGUI */
    public PreferencesGUI() {
        
        initComponents();

        txtDosBoxPath.setText(Main.pref.getDosBoxPath());
        chkKeepOpen.setSelected(Main.pref.isKeepOpen());
        chkFullscreen.setSelected(Main.pref.isFullScreen());
        cmbKeyboard.setSelectedIndex(Main.pref.getKeyboardIndex());
        cmbIconSize.setSelectedIndex(Main.pref.getIconSizeIndex());
        iconindex = cmbIconSize.getSelectedIndex();

        centerScreen();
    }
    
    /**
     * Putter boksen midt paa skjermen
     */
    public void centerScreen() {
    	  Dimension dim = getToolkit().getScreenSize();
    	  Rectangle abounds = getBounds();
    	  setLocation((dim.width - abounds.width) / 2,
    	      (dim.height - abounds.height) / 2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDosBoxPath = new javax.swing.JTextField();
        cmdConfirm = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel()
        {
            ImageIcon backImage = new javax.swing.ImageIcon(getClass().getResource("/dbox2/img/bg.jpg"));
            Image image = backImage.getImage();
            int w = backImage.getIconWidth();

            public void paintComponent (Graphics g) {
                for(int i=0;i<50;i++)
                g.drawImage(image, w*i, 0, this);
                super.paintComponent(g);
            }
        }
        ;
        jLabel5 = new javax.swing.JLabel();
        cmdBrowse = new javax.swing.JButton();
        chkKeepOpen = new javax.swing.JCheckBox();
        chkFullscreen = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cmbKeyboard = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbIconSize = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preferences");
        setModal(true);
        setResizable(false);

        jLabel1.setText("Path to DosBox");

        txtDosBoxPath.setToolTipText("The full path to the DosBox executable. On MacOs X this path has to point to the\nexecutable inside the app package. If you chose browse, D-Box will do this by\nitself to please and serve you!");
        txtDosBoxPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDosBoxPathActionPerformed(evt);
            }
        });

        cmdConfirm.setText("Close");
        cmdConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConfirmActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Preferences");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel5)
                .addContainerGap(416, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .add(jLabel5)
                .add(15, 15, 15))
        );

        cmdBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbox2/img/folder.png"))); // NOI18N
        cmdBrowse.setToolTipText("Browse...");
        cmdBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBrowseActionPerformed(evt);
            }
        });

        chkKeepOpen.setText("Keep the DosBox window open (doesn't always work)");
        chkKeepOpen.setToolTipText("Determines if the DosBox window will be closed after the application\nyou currently are running has halted. This option will only have effect\non applications that you're opening after you have altered this preference.");
        chkKeepOpen.setMargin(new java.awt.Insets(0, 0, 0, 0));

        chkFullscreen.setText("Play games in full screen (Press Alt+Enter in game to toggle)");
        chkFullscreen.setToolTipText("If you check this, your programs will run in full screen.\nYou can toggle by using the key combination Alt + Enter");
        chkFullscreen.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel2.setText("Keyboard layout (Country or language):");

        cmbKeyboard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Belgium", "Brazil", "Canadian-French", "Czech Republic", "Denmark", "Finland", "France", "Germany", "Hungary", "Italy", "Latin America", "Netherlands", "Norway", "Poland", "Portugal", "Slovak Republic", "Spain", "Sweden", "Switzerland (French)", "Switzerland (German)", "United Kingdom", "United States", "United States (Dvorak)", "Yugoslavia (Serbo-Croatian)" }));
        cmbKeyboard.setToolTipText("Select your keyboard layout.\n\nNote that some games needs a specific\nkeyboard layout (often english).");
        cmbKeyboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKeyboardActionPerformed(evt);
            }
        });

        jLabel3.setText("Icon size in application list");

        cmbIconSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Small", "Medium", "Large", "X-Large" }));
        cmbIconSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIconSizeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(layout.createSequentialGroup()
                        .add(txtDosBoxPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 446, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdBrowse))
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 38, Short.MAX_VALUE)
                        .add(cmbKeyboard, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(437, Short.MAX_VALUE)
                .add(cmdConfirm)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 239, Short.MAX_VALUE)
                .add(cmbIconSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(chkFullscreen)
                    .add(chkKeepOpen, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                .addContainerGap())
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtDosBoxPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdBrowse))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(cmbKeyboard, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(cmbIconSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(chkKeepOpen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(chkFullscreen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                .add(cmdConfirm)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-522)/2, (screenSize.height-350)/2, 522, 350);
    }// </editor-fold>//GEN-END:initComponents

private void cmdBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBrowseActionPerformed
    String file = helperClass.showFileChooser(this, "Select DosBox executable",
            new FileChooserFilter(FileChooserFilter.STARTS_WITH, new String[]{"dosbox"}, "DOSBox"), false);


    if(file != null) {
            if(file.endsWith("app"))
                    file+="/Contents/MacOS/DOSBox";
            txtDosBoxPath.setText(file);
    }
}//GEN-LAST:event_cmdBrowseActionPerformed

private void cmdConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConfirmActionPerformed
    Main.pref.setDosBoxPath(txtDosBoxPath.getText());
    Main.pref.setKeepOpen(chkKeepOpen.isSelected());
    Main.pref.setFullScreen(chkFullscreen.isSelected());
    Main.pref.setKeyboardCountry(cmbKeyboard.getSelectedItem().toString());
    if(cmbIconSize.getSelectedIndex() != -1)
        Main.pref.setIconSize(cmbIconSize.getSelectedItem().toString());

    this.setVisible(false);

    if(cmbIconSize.getSelectedIndex() != iconindex) {
        Main.n.setVisible(false);
        Main.n.dispose();
    }
}//GEN-LAST:event_cmdConfirmActionPerformed

private void txtDosBoxPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDosBoxPathActionPerformed
    
}//GEN-LAST:event_txtDosBoxPathActionPerformed

private void cmbKeyboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKeyboardActionPerformed

}//GEN-LAST:event_cmbKeyboardActionPerformed

private void cmbIconSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIconSizeActionPerformed

}//GEN-LAST:event_cmbIconSizeActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkFullscreen;
    private javax.swing.JCheckBox chkKeepOpen;
    private javax.swing.JComboBox cmbIconSize;
    private javax.swing.JComboBox cmbKeyboard;
    private javax.swing.JButton cmdBrowse;
    private javax.swing.JButton cmdConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDosBoxPath;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        cmdConfirmActionPerformed(null);
    }


}
