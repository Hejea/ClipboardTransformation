package org.example.main;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static org.example.main.CopyWithTrim.getClipBoard;
import static org.example.main.Main.getSystemClipboard;


public class LowerCase {
    private static final Clipboard clipboard = getSystemClipboard();
    
    public static void run() {
        String clipBoard = getClipBoard();
        
        if (clipBoard != null) {
            String finalString = clipBoard.toLowerCase();
            StringSelection stringSelection = new StringSelection(finalString);
            
            clipboard.setContents(stringSelection, null);
            System.out.println("[" + finalString + "]");
        }
    }
}
