package br.com.duarte;

import br.com.duarte.controlesRobot.ControleUtils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FirefoxControl {

   private static String URL = "https://ww1.receita.fazenda.df.gov.br/dar-avulso/gerar-dar-avulso";

    public static void main(String[] args) throws AWTException, IOException, InterruptedException {

        ControleUtils controle = new ControleUtils();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        try {
            abreFirefox();
        } catch (Exception e ) {
            System.out.println("ERRO AO ABRIR O FIREFOX");
        }

        try {
            navegarUrl(clipboard, controle);
        } catch (Exception e ) {
            System.out.println("ERRO AO NAVEGAR PARA SITE");
        }

        try {
            abrirDevTools(clipboard, controle);
        } catch (Exception e ) {
            System.out.println("ERRO AO ABRIR DEV TOOLS");
        }

        try {
            preencheCNPJ(clipboard, controle);
        } catch (Exception e) {
            System.out.println("ERRO AO PREENCHER CNPJ");
        }

        try {
            escolherCodReceita(clipboard, controle);
        } catch (Exception e) {
            System.out.println("ERRO AO ESCOLHER COD. RECEITA");
        }

        try {
            preencheDadosGuia(clipboard, controle);
        } catch (Exception e) {
            System.out.println("ERRO AO PREENCHER DADOS GUIAS");
        }

        try {
            gerarPDF(clipboard, controle);
        } catch (Exception e) {
            System.out.println("ERRO AO IMPRIMIR");
        }

        Thread.sleep(5000);
        controle.killAllFirefox();
    }

    private static void abreFirefox() throws IOException, InterruptedException {
        String firefoxPath = "\"C:\\Program Files\\Mozilla Firefox\\firefox.exe\"";
        Runtime.getRuntime().exec(firefoxPath);
        Thread.sleep(2000);
    }

    private static void navegarUrl(Clipboard clipboard, ControleUtils controle) throws InterruptedException {
        StringSelection stringSelection = new StringSelection(URL);
        clipboard.setContents(stringSelection, null);
        controle.navegaUrl();
    }

    private static void abrirDevTools(Clipboard clipboard, ControleUtils controle) throws InterruptedException {
        controle.devTools();

        String comandoCleanConsole = "clear();";
        StringSelection stringSelection = new StringSelection(comandoCleanConsole);
        clipboard.setContents(stringSelection, null);

        controle.copiaColaEnter();
    }

    private static void preencheCNPJ(Clipboard clipboard, ControleUtils controle) throws InterruptedException {

        String scriptClickCNPJ =
                "const element = document.evaluate(" +
                        "   '/html/body/app-root/app-area-restrita-site/div/div/div/main/div/app-gerar-dar-avulso/shared-page/shared-page-content/form/mat-horizontal-stepper/div[2]/div[1]/app-consultar-cpf-cnpj/div/shared-page-card/mat-card/div/mat-card-content/shared-card-content/mat-radio-group/mat-radio-button[2]/label/div[1]/div[1]'," +
                        "   document, " +
                        "   null," +
                        "   XPathResult.FIRST_ORDERED_NODE_TYPE, null" +
                        ").singleNodeValue;\n" +
                        "\n" +
                        "if (element) {\n" +
                        "  element.click();\n" +
                        "} else {\n" +
                        "  console.log('Elemento não encontrado.');\n" +
                        "}";

        StringSelection stringSelection = new StringSelection(scriptClickCNPJ);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        Thread.sleep(2000);

        String cnpjValue = "17611014041509";

        String scriptPreencheCNPJ = String.format(
                "const inputCNPJ = document.evaluate(\n" +
                        "\t'//*[@id=\"mat-input-0\"]', \n" +
                        "\tdocument, \n" +
                        "\tnull, \n" +
                        "\tXPathResult.FIRST_ORDERED_NODE_TYPE, null\n" +
                        ").singleNodeValue;\n" +
                        "\n" +
                        "if (inputCNPJ) {\n" +
                        "  inputCNPJ.value = '%s';\n" +
                        "  inputCNPJ.dispatchEvent(new Event('input'));\n" +
                        "} else {\n" +
                        "  console.log('Elemento não encontrado.');\n" +
                        "}",
                cnpjValue
        );

        stringSelection = new StringSelection(scriptPreencheCNPJ);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        Thread.sleep(2000);

        String scriptAvancaPagInit =
                "const buttonAvancarPagInit = document.evaluate(\n" +
                        "  '/html/body/app-root/app-area-restrita-site/div/div/div/main/div/app-gerar-dar-avulso/shared-page/shared-page-content/form/mat-horizontal-stepper/div[2]/div[1]/app-consultar-cpf-cnpj/div/shared-page-card/mat-card/mat-card-footer/shared-card-actions/button',\n" +
                        "  document,\n" +
                        "  null,\n" +
                        "  XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
                        "  null\n" +
                        ").singleNodeValue;\n" +
                        "\n" +
                        "if (buttonAvancarPagInit) {\n" +
                        "  buttonAvancarPagInit.click();\n" +
                        "} else {\n" +
                        "  console.log('Botão não encontrado.');\n" +
                        "}";

        stringSelection = new StringSelection(scriptAvancaPagInit);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        Thread.sleep(4000);
    }

    private static void escolherCodReceita(Clipboard clipboard, ControleUtils controle) throws InterruptedException {

        String scriptScroll =
                "window.scrollTo({ top: 500, behavior: 'smooth' });";

        StringSelection stringSelection = new StringSelection(scriptScroll);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        String codReceita = "1317";

        String scriptSetCodReceita = String.format(
          "var radioButton = document.evaluate(\n" +
                  "    \"//td[contains(text(), '\" + '%s' + \"')]/preceding-sibling::td//input[@type='radio']\",\n" +
                  "    document,\n" +
                  "    null,\n" +
                  "    XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
                  "    null\n" +
                  ").singleNodeValue;\n" +
                  "\n" +
                  "if (radioButton) {\n" +
                  "    radioButton.click();\n" +
                  "} else {\n" +
                  "    console.log(\"Botão de rádio não encontrado.\");\n" +
                  "}",
                codReceita
        );

        stringSelection = new StringSelection(scriptSetCodReceita);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        Thread.sleep(2000);

        String scriptAvancarPag =
                "const buttonAvancarPagCod = document.evaluate(\n" +
                "  '/html/body/app-root/app-area-restrita-site/div/div/div/main/div/app-gerar-dar-avulso/shared-page/shared-page-content/form/mat-horizontal-stepper/div[2]/div[2]/app-selecionar-receita/div/shared-page-card/mat-card/mat-card-footer/shared-card-actions/button[2]',\n" +
                "  document,\n" +
                "  null,\n" +
                "  XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
                "  null\n" +
                ").singleNodeValue;\n" +
                "\n" +
                "if (buttonAvancarPagCod) {\n" +
                "  buttonAvancarPagCod.click();\n" +
                "} else {\n" +
                "  console.log('Botão não encontrado.');\n" +
                "}";

        stringSelection = new StringSelection(scriptAvancarPag);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        Thread.sleep(4000);
    }

    private static void preencheDadosGuia(Clipboard clipboard, ControleUtils controle) throws InterruptedException {

        String scriptScroll =
                "window.scrollTo({ top: 1100, behavior: 'smooth' });";

        StringSelection stringSelection = new StringSelection(scriptScroll);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        // INSERIR VALOR
        controle.devTools();
        controle.clicarValorPagDarDf();
        String valorGuia = "10,00";
        controle.digitarValor(valorGuia);
        Thread.sleep(1000);
        controle.devTools();
        Thread.sleep(1000);

        // OBS
        String obsGuia = "TESTE OBS";
        String scriptObsGuia = String.format(
                "const inputObs= document.evaluate(\n" +
                        "\t'//*[@id=\"mat-input-13\"]', \n" +
                        "\tdocument, \n" +
                        "\tnull, \n" +
                        "\tXPathResult.FIRST_ORDERED_NODE_TYPE, null\n" +
                        ").singleNodeValue;\n" +
                        "\n" +
                        "if (inputObs) {\n" +
                        "  inputObs.value = '%s';\n" +
                        "  inputObs.dispatchEvent(new Event('input'));\n" +
                        "} else {\n" +
                        "  console.log('Elemento não encontrado.');\n" +
                        "}",
                obsGuia
        );

        stringSelection = new StringSelection(scriptObsGuia);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        Thread.sleep(2000);

        String scriptAvancarPag =
                "const buttonAvancarPagDados= document.evaluate(\n" +
                        "  '/html/body/app-root/app-area-restrita-site/div/div/div/main/div/app-gerar-dar-avulso/shared-page/shared-page-content/form/mat-horizontal-stepper/div[2]/div[3]/app-informar-dados/div/shared-page-card/mat-card/mat-card-footer/shared-card-actions/button[2]',\n" +
                        "  document,\n" +
                        "  null,\n" +
                        "  XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
                        "  null\n" +
                        ").singleNodeValue;\n" +
                        "\n" +
                        "if (buttonAvancarPagDados) {\n" +
                        "  buttonAvancarPagDados.click();\n" +
                        "} else {\n" +
                        "  console.log('Botão não encontrado.');\n" +
                        "}";

        stringSelection = new StringSelection(scriptAvancarPag);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();

        Thread.sleep(3000);
    }

    private static void gerarPDF(Clipboard clipboard, ControleUtils controle) throws InterruptedException {
        String scriptGerarPdf =
                "const buttonGerarPDF= document.evaluate(\n" +
                        "  '/html/body/app-root/app-area-restrita-site/div/div/div/main/div/app-gerar-dar-avulso/shared-page/shared-page-content/form/mat-horizontal-stepper/div[2]/div[4]/app-conferir-dados/div/div/div/div/shared-card-actions/button[3]',\n" +
                        "  document,\n" +
                        "  null,\n" +
                        "  XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
                        "  null\n" +
                        ").singleNodeValue;\n" +
                        "\n" +
                        "if (buttonGerarPDF) {\n" +
                        "  buttonGerarPDF.click();\n" +
                        "} else {\n" +
                        "  console.log('Botão não encontrado.');\n" +
                        "}";

        StringSelection stringSelection = new StringSelection(scriptGerarPdf);
        clipboard.setContents(stringSelection, null);
        controle.copiaColaEnter();
    }

    public void moverArquivo(){
        // Caminho da pasta de origem (Downloads) e da pasta de destino
        String origem = System.getProperty("user.home") + "\\Downloads";
        String destino = "F:\\VETOR-ENV";
        String nomeArquivo = "RelatorioDAR.pdf";

        File pastaDestino = new File(destino);
        if (!pastaDestino.exists() || !pastaDestino.isDirectory()) {
            throw new IllegalArgumentException("A pasta de destino não existe: " + destino);
        }

        // Definir o caminho completo do arquivo PDF específico
        Path caminhoOrigem = Paths.get(origem + "\\" + nomeArquivo);
        Path caminhoDestino = Paths.get(destino + "\\" + nomeArquivo);

        // Verificar se o arquivo existe antes de tentar movê-lo
        if (Files.exists(caminhoOrigem)) {
            try {
                Files.move(caminhoOrigem, caminhoDestino);
                System.out.println("Arquivo movido com sucesso para " + caminhoDestino);
            } catch (IOException e) {
                System.out.println("Erro ao mover o arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("O arquivo " + nomeArquivo + " não foi encontrado na pasta Downloads.");
        }
    }

}
