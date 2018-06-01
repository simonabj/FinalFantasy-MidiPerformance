package DivineChili.KeyHook;

import DivineChili.Controller;
import org.jnativehook.GlobalScreen;

public class KeyPressUtil
{
    public static String currentText = "Ø";
    private static boolean isRunning = false;
    public static String returnText = "";
    public static String GetKeyPress(String currText) {
        if(!isRunning) {
            KeyPressUtil.currentText = currText;
            KeyPressUtil.isRunning = true;

            GlobalScreen.addNativeKeyListener(new KeyHookListener());

            String rString = KeyPressUtil.returnText;
            KeyPressUtil.returnText = "";
            return rString;
        } else
            return "Ø";
    }
}
