package by.tms.project.model;

import java.util.ResourceBundle;

/**
 *  The enum MessageManager
 */
public enum MessageManager {
    /**
     * Message manager.
     */
    MESSAGE(ResourceBundle.getBundle("message"));

    /**
     * The Bundle.
     */
    private final ResourceBundle bundle;

    MessageManager(ResourceBundle bundle){
        this.bundle = bundle;
    }

    /**
     * Take message.
     * @param messageName
     * @return the message.
     */
    public String takeMessage(String messageName){
        return bundle.getString(messageName);
    }

}
