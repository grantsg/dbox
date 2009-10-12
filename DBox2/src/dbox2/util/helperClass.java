/**
 * @author Truben
 */

package dbox2.util;

import dbox2.*;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import javax.swing.JFileChooser;


public class helperClass {

    public static final int LINUX   = 0;
    public static final int SOLARIS = 1;
    public static final int WINDOWS = 2;
    public static final int MACOS   = 3;

    /**
     * Determines the system's OS
     * @return the code for the current OS
     */
    public static int getOS() {
        String sysName = System.getProperty("os.name").toLowerCase();
        if(sysName.contains("linux"))
            return LINUX;
        else if (sysName.contains("windows"))
            return WINDOWS;
        else if (sysName.contains("solaris"))
            return SOLARIS;
        else if (sysName.contains("mac"))
            return MACOS;

        return -1; // if nothing's found
    }

    /**
     * Get and creates a app folder
     * @param applicationName
     * @return the folder file
     */
    public static File getWorkingDirectory(final String applicationName) {
        final String userHome = System.getProperty("user.home", ".");
        final File workingDirectory;
        switch (getOS()) {
            case LINUX:
            case SOLARIS:
                workingDirectory = new File(userHome, '.' + applicationName + '/');
                break;
            case WINDOWS:
                final String applicationData = System.getenv("APPDATA");
                if (applicationData != null)
                    workingDirectory = new File(applicationData, "." + applicationName + '/');
                else
                    workingDirectory = new File(userHome, '.' + applicationName + '/');
                break;
            case MACOS:
                workingDirectory = new File(userHome, "Library/Application Support/" + applicationName);
                break;
            default:
                return new File(".");
        }
        if (!workingDirectory.exists())
            if (!workingDirectory.mkdirs())
                throw new RuntimeException("The working directory could not be created: " + workingDirectory);
        return workingDirectory;
    }

    public static boolean isMac() {
        if(Main.pref.getTypeOfFileDialog() == 1)
            return false;
        if(Main.pref.getTypeOfFileDialog() == 2)
            return true;
        if("Mac OS X".equals(System.getProperty("os.name")))
            return true;
        return false;
    }

    /**
     *
     * Method that shows a file chooser to the user and use the last used path as
     * its starting point
     *
     * @param c the parent component
     * @param header The dialog's header
     * @param filter What should be shown
     * @param directories should we show directories
     * @return
     */
    public static String showFileChooser(java.awt.Component c, String header,
            FileChooserFilter filter, boolean directories) {

        return showFileChooser(c,header,filter,directories,Main.pref.getLastUsedPath());
    }

    /**
     * Method that shows a file chooser to the user
     *
     * @param c the parent component
     * @param header The dialog's header
     * @param filter What should be shown
     * @param directories should we show directories
     * @param startDir the starting path
     * @return
     */
    public static String showFileChooser(java.awt.Component c, String header,
            FileChooserFilter filter, boolean directories,String startDir) {
        if(isMac()) { // AWT
            FileDialog fd = new FileDialog((Frame)c.getParent(), header, FileDialog.LOAD);

            if(!startDir.equals(""))
                fd.setDirectory(startDir); // back to where we were

            fd.pack();
            fd.setVisible(true);

            if (fd.getFile() != null) {
                Main.pref.setLastUsedPath(fd.getDirectory());
                if(directories)
                    return fd.getDirectory();
                else
                    return fd.getDirectory() + fd.getFile();
            }
            else
                return null;
        }
        else {  // SWING
            final JFileChooser fc = new JFileChooser();
            if(directories) fc.setFileSelectionMode(fc.DIRECTORIES_ONLY);

            if(!startDir.equals(""))
                fc.setCurrentDirectory(new File(startDir)); // back to where we were

            fc.addChoosableFileFilter(filter);
            int returnVal = fc.showOpenDialog(c);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                Main.pref.setLastUsedPath(file.getAbsolutePath());
                if(directories)
                    return file.getAbsolutePath();
                else
                    return file.getAbsolutePath();
            }
            else
                return null;
        }
    }
}
