package org.example.main;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Objects;

import static org.example.main.Main.getClipBoard;
import static org.example.main.Main.getSystemClipboard;


public class UpperCase {
    private static final Clipboard clipboard = getSystemClipboard();

    public static void run() {
        String finalString = Objects.requireNonNull(getClipBoard(clipboard)).toUpperCase();
        StringSelection stringSelection = new StringSelection(finalString);

        clipboard.setContents(stringSelection, null);
        System.out.println("[" + finalString + "]");
    }
}
