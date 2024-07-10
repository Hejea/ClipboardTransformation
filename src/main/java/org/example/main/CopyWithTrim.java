package org.example.main;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.List;

import static org.example.main.Main.getSystemClipboard;


public class CopyWithTrim {
    private static final Clipboard clipboard = getSystemClipboard();
    
    public static void run() {
        String clipBoard = getClipBoard();
        
        if (clipBoard != null) {
            String substring = clipBoard.substring(clipBoard.length() - 1);
            
            if (substring.endsWith("\n")) {
                StringSelection stringSelection = new StringSelection(clipBoard.trim());
                
                clipboard.setContents(stringSelection, null);
            }
        }
    }
    
    public static String getClipBoard() {
        try {
            List<DataFlavor> flavors = Arrays.stream(clipboard.getAvailableDataFlavors()).filter(
                df -> df.getRepresentationClass() == String.class && df.isMimeTypeEqual("text/plain")
            ).toList();
            
            DataFlavor dataFlavor = flavors.stream().findFirst().orElse(null);
            
            return (String) clipboard.getData(dataFlavor);
        } catch (Exception ignored) {
        }
        return null;
    }
}
