package com.utils;

public interface GlobalConstants {
    public static final String FORWARD_DISPLAY = "display";
    /**
     * Name of the standard forward for the cancel method.  Used in OcpAction
     * if the neither the cancel not the back button was used to submit the
     * form.
     */
    public static final String FORWARD_SAVE = "save";

    /**
     * Name of the standard forward for the back method (the name is somewhat
     * ironic).  Use in OcpAction if the back button was used to submit the
     * form.
     */
    public static final String FORWARD_BACK = "back";

    /**
     * Name of the standard forward for the cancel method.  Used in OcpAction
     * if the cancel button was used to submit the form.
     */
    public static final String FORWARD_CANCEL = "cancel";

    /**
     * Name of the standard forward for the home method.  Used in OcpAction
     * if the home link was used to submit the form.
     */
    public static final String FORWARD_HOME = "mainMenu";

    /**
     * Name of the standard forward for return actions.  Usually used when the
     * cancel of finish button is pressed.
     */
    public static final String FORWARD_RETURN = "return";

    /**                                                                            
     * Name of the standard forward for return actions.  Usually used when the
     * cancel of finish button is pressed.
     */
    public static final String FORWARD_NEXT = "next";
    
    public static final String FORWARD_LOGOFF = "logoff";
    
    public static final String PARAM_WINDOW_NAME = "windowName";
    
    public static final String GLOBAL_MAIN_WINDOW_NAME = "main";
    
    public static final String SIGNON_PATH = "/LoginProcess";
    
    public static final String SIGNOFF_PATH = "/SignOff"; 
    
    public static final String ATTR_NAME_READ_ONLY = "com.forms.READ_ONLY";
    
    public static final String ATTR_NAME_PROPAGATE_READ_ONLY = "com.forms.PROPAGATE_READ_ONLY";
    
    public static final String ATTR_NAME_READ_ONLY_OVERRIDE = "com.forms.READ_ONLY_OVERRIDE";
    
    public static final String FORWARD_ADD = "add";
    
    public static final String FORWARD_UPDATE = "update";
    
    public static final String FORWARD_DELETE = "delete";
    
    
}
