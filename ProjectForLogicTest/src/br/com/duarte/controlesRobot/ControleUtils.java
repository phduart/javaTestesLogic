package br.com.duarte.controlesRobot;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ControleUtils {
    Robot robot = new Robot();

    public ControleUtils() throws AWTException {
    }

    public void navegaUrl() throws InterruptedException {
        abreBarraNavFirefox();
        Thread.sleep(1000);
        copiaColaEnter();
        Thread.sleep(1000);
    }

    public void copiaCola() {
        // ----- COLAR URL [ CTRL + C & CTRL + V ]
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void enter() {
        // ----- ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void abreBarraNavFirefox() {
        // ----- ABRIR BARRA [ CTRL + L ]
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }

    public void devTools() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_F12);
        robot.keyRelease(KeyEvent.VK_F12);

        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(2000);
    }

    public void copiaColaEnter() throws InterruptedException {
        copiaCola();
        enter();
        Thread.sleep(2000);
    }

    public void killAllFirefox() throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        String killCommand;

        if (os.contains("win")) {
            killCommand = "taskkill /F /IM firefox.exe";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            killCommand = "pkill firefox";
        } else {
            throw new UnsupportedOperationException("Sistema operacional não suportado");
        }

        Runtime.getRuntime().exec(killCommand);
    }

    public void digitarValor(String valor) throws InterruptedException {
        for (char c : valor.toCharArray()) {
            digitarNumeros(c);
            Thread.sleep(500);
        }
    }

    public void digitarNumeros(char caractere) {
        switch (caractere) {
            case '0': robot.keyPress(KeyEvent.VK_0); robot.keyRelease(KeyEvent.VK_0); break;
            case '1': robot.keyPress(KeyEvent.VK_1); robot.keyRelease(KeyEvent.VK_1); break;
            case '2': robot.keyPress(KeyEvent.VK_2); robot.keyRelease(KeyEvent.VK_2); break;
            case '3': robot.keyPress(KeyEvent.VK_3); robot.keyRelease(KeyEvent.VK_3); break;
            case '4': robot.keyPress(KeyEvent.VK_4); robot.keyRelease(KeyEvent.VK_4); break;
            case '5': robot.keyPress(KeyEvent.VK_5); robot.keyRelease(KeyEvent.VK_5); break;
            case '6': robot.keyPress(KeyEvent.VK_6); robot.keyRelease(KeyEvent.VK_6); break;
            case '7': robot.keyPress(KeyEvent.VK_7); robot.keyRelease(KeyEvent.VK_7); break;
            case '8': robot.keyPress(KeyEvent.VK_8); robot.keyRelease(KeyEvent.VK_8); break;
            case '9': robot.keyPress(KeyEvent.VK_9); robot.keyRelease(KeyEvent.VK_9); break;
        }
    }

    public void clicarValorPagDarDf() throws InterruptedException {

        int x = 466;
        int y = 561;

        robot.mouseMove(x, y);

        Thread.sleep(1000);

        // Simula um clique do mouse
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
