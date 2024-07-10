package org.example.main;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static org.example.main.Main.getClipBoard;
import static org.example.main.Main.getSystemClipboard;


public class ProperCase {
    private static final String ACTIONABLE_DELIMITERS = ".,'\"()[]{}_?\\/*+`~!@#$%^&=;:<>| -/";
    private static final Clipboard clipboard = getSystemClipboard();
    
    public static void run() {
        String finalString = convertToProperCase(getClipBoard(clipboard));
        StringSelection stringSelection = new StringSelection(finalString);
        
        clipboard.setContents(stringSelection, null);
        System.out.println("[" + finalString + "]");
    }
    
    public static String convertToProperCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean capNext = true;
        
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
    
            if (i > 1) {
                if (charArray[i - 1] == '\'' && Character.isAlphabetic(charArray[i - 2])) {
                    c = Character.toLowerCase(c);
                } else {
                    c = capNext ? Character.toUpperCase(c) : Character.toLowerCase(c);
                }
            } else {
                c = capNext ? Character.toUpperCase(c) : Character.toLowerCase(c);
            }
            sb.append(c);
//            'sds'dsd
            
            capNext = (ACTIONABLE_DELIMITERS.indexOf(c) >= 0);
        }
        return sb.toString();
    }
}