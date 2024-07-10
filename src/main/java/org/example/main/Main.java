package org.example.main;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.Arrays;
import java.util.List;


public class Main {
    
    public static void main(String[] args) {
        if (args.length > 0) {
            String trsf = args[0].toLowerCase();
            // String trsf = "lower";
            // String trsf = "proper";
            // String trsf = "upper";
            
            switch (trsf) {
                case "lower" -> LowerCase.run();
                case "proper" -> ProperCase.run();
                case "upper" -> UpperCase.run();
                default -> errorArgs();
            }
        } else {
            errorArgs();
        }
    }
    
    public static void errorArgs() {
        System.out.println("\nNo Args\nCases :\n\tLower\n\tProper\n\tUpper");
    }
    
    public static String getClipBoard2(Clipboard clipboard) {
        try {
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return "";
    }
    
    public static String getClipBoard(Clipboard clipboard) {
        try {
            List<DataFlavor> flavors = Arrays.stream(clipboard.getAvailableDataFlavors()).filter(df -> df.getRepresentationClass() == String.class && df.isMimeTypeEqual("text/plain")).toList();
            
            DataFlavor dataFlavor = flavors.stream().findFirst().orElse(null);
            
            return (String) clipboard.getData(dataFlavor);
        } catch (Exception ignored) {
        }
        return null;
    }
    
    public static Clipboard getSystemClipboard() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        return defaultToolkit.getSystemClipboard();
    }
}
