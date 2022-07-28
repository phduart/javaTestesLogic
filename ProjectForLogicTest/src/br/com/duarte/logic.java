package br.com.duarte;

import br.com.duarte.dto.BrainLoginDTO;
import br.com.duarte.models.Bjrr29;
import br.com.duarte.models.BlockedProposalBrain;
import br.com.duarte.models.CoordenadasBrain;
import br.com.duarte.models.Talhao;
import br.com.duarte.models.brainTeste.BlockedProposal;
import br.com.duarte.models.brainTeste.Coordinates;
import br.com.duarte.models.brainTeste.PointCoordinates;
import br.com.duarte.models.brainTeste.Talhoes;
import br.com.duarte.xirr.Transaction;
import br.com.duarte.xirr.Xirr;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;


public class logic {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException, ParseException {
        System.out.println("Inicio");

        getXirr();

        System.out.println("FIM");
    }

    private static void getXirr(){
        System.out.println("------ INICIO PROCESSO ------");
        double rate = new Xirr(
                new Transaction(96526.86, "2022-05-03"),
                new Transaction(-98.139, "2022-05-03"),
                new Transaction(-10912.5, "2022-06-03"),
                new Transaction( -10805.3, "2022-07-03"),
                new Transaction( -10724.5, "2022-08-03"),
                new Transaction( -10643.7, "2022-09-03"),
                new Transaction( -10562.9, "2022-10-03"),
                new Transaction( -10482.1, "2022-11-03"),
                new Transaction( -10401.4, "2022-12-03"),
                new Transaction( -10320.6, "2023-01-03"),
                new Transaction( -10239.8, "2023-02-03"),
                new Transaction( -10104, "2023-03-03")
        ).xirr();
        System.out.println(rate);
        double d = (double) (Math.round(rate*10000.0)/10000.0);
        System.out.println(d);
        System.out.println("------ FIM PROCESSO ------");
    }

    private static void getTempoCorrido(){
        Instant start = Instant.now();
        for(int i = 0; i < 10; i++){

        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }

    private static void getTesteOrderObject(){
        BlockedProposalBrain blockedProposalBrain = new BlockedProposalBrain();
        blockedProposalBrain.setProposta(1);
        blockedProposalBrain.setCpfcnpj("11111");
        blockedProposalBrain.setEndosso(1);

        List<Talhao> talhaoList = new ArrayList<>();
        List<Bjrr29> bjrr29List = getBjrr29List();
        int[] talhoesArray = getBjrr29TalhoesList();

        for(int talhao: talhoesArray){
            List<CoordenadasBrain> coordenadasBrainList = new ArrayList<>();
            for(Bjrr29 bjrr29 : bjrr29List) {
                if(bjrr29.getTalhao() == talhao){
                    CoordenadasBrain coordenadasBrain = new CoordenadasBrain();
                    coordenadasBrain.setPonto(bjrr29.getPonto());
                    coordenadasBrain.setLatitude(bjrr29.getLatitude());
                    coordenadasBrain.setLongitude(bjrr29.getLongitude());
                    coordenadasBrainList.add(coordenadasBrain);
                }
            }
            Talhao talhaoBrain = new Talhao();
            talhaoBrain.setTalhao(talhao);
            talhaoBrain.setCoordenadas(coordenadasBrainList);
            talhaoList.add(talhaoBrain);
        }

        blockedProposalBrain.setTalhoes(talhaoList);
    }

    private static int[] getBjrr29TalhoesList(){
        int[] talhoes = {1,2};
        return talhoes;
    }

    private static List<Bjrr29> getBjrr29List(){
        Bjrr29 umUm = new Bjrr29();
        umUm.setOperacion(1);
        umUm.setTalhao(1);
        umUm.setPonto(1);
        umUm.setLatitude("1");
        umUm.setLongitude("-1");

        Bjrr29 umDois = new Bjrr29();
        umDois.setOperacion(1);
        umDois.setTalhao(1);
        umDois.setPonto(2);
        umDois.setLatitude("2");
        umDois.setLongitude("-2");

        Bjrr29 doisUm = new Bjrr29();
        doisUm.setOperacion(1);
        doisUm.setTalhao(2);
        doisUm.setPonto(1);
        doisUm.setLatitude("21");
        doisUm.setLongitude("-21");

        List<Bjrr29> list = new ArrayList<>();
        list.add(umUm);
        list.add(umDois);
        list.add(doisUm);
        return list;
    }

    private static void createBlockedBrainTesteUm(){
        BlockedProposalBrain blockedProposalBrain = new BlockedProposalBrain();
        blockedProposalBrain.setProposta(1);
        blockedProposalBrain.setCpfcnpj("11111");
        blockedProposalBrain.setEndosso(1);

        // Criando Lista de Coordenadas
        List<CoordenadasBrain> coordenadasBrainList = new ArrayList<>();

        CoordenadasBrain coordenadasBrainUm = new CoordenadasBrain();
        coordenadasBrainUm.setPonto(1);
        coordenadasBrainUm.setLatitude("1111");
        coordenadasBrainUm.setLongitude("-1111");
        coordenadasBrainList.add(coordenadasBrainUm);

        CoordenadasBrain coordenadasBrainDois = new CoordenadasBrain();
        coordenadasBrainDois.setPonto(2);
        coordenadasBrainDois.setLatitude("2222");
        coordenadasBrainDois.setLongitude("-2222");
        coordenadasBrainList.add(coordenadasBrainDois);

        // --- Criando Lista de Talhoes
        List<Talhao> talhaoList = new ArrayList<>();

        Talhao talhao = new Talhao();
        talhao.setTalhao(1);
        talhao.setCoordenadas(coordenadasBrainList);

        talhaoList.add(talhao);

        blockedProposalBrain.setTalhoes(talhaoList);
    }

    private static void createBlockedProposal(){
        // Criando Coordenadas
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude("1");
        coordinates.setLongitude("1");

        // Criando Ponto com Coordenadas
        PointCoordinates pointCoordinates = new PointCoordinates();
        HashMap<Integer, Coordinates> pointCoordinate = new HashMap<>();
        pointCoordinate.put(1, coordinates);
        pointCoordinates.setCoordinates(pointCoordinate);

        // Criando Talhoes com Ponto e Coordenadadas
        Talhoes talhoes = new Talhoes();
        HashMap<Integer, PointCoordinates> talhao = new HashMap<>();
        talhao.put(1, pointCoordinates);
        talhoes.setTalhoes(talhao);

        // Criando Proposta
        BlockedProposal blockedProposal = new BlockedProposal();
        blockedProposal.setOperacion(1);
        blockedProposal.setPoliza(1);
        blockedProposal.setCpfCnpj("11111111");
        blockedProposal.setEndosso(1);
        blockedProposal.setTalhoes(talhoes);
    }

    private static void doConvertToGMS(double valor){
        int d = (int) valor;
        int m = (int) ((valor - d)* 60);
        double valorMenosD = (valor - d);
        BigDecimal mDivideSessenta;
        String input1 = String.valueOf(m);
        String input2 = "60";
        BigDecimal a = new BigDecimal(input1);
        BigDecimal divisor = new BigDecimal(input2);
        int scale = 8;
        mDivideSessenta = a.divide(divisor, scale, RoundingMode.CEILING);
        double mDivideSessentaDouble = mDivideSessenta.doubleValue();
        double valorMenosDMenosMDivideSessenta = valorMenosD-mDivideSessentaDouble;
        BigDecimal bd = BigDecimal.valueOf(valorMenosDMenosMDivideSessenta*3600);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        String valorGMS = (d+"º" + " " + m*-1+"'" + " " + bd.multiply(BigDecimal.valueOf(-1))+"\"");
        System.out.println(valorGMS);
    }

    private static void doReplaceString(){
        String name = "01 - Agrícola";
        String newName = name.substring(5, name.length());
        System.out.print(newName);
    }

    private static void doTestCleanSSL() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        URL url = new URL("https://www.nakov.com:2083/");
        URLConnection con = url.openConnection();
        Reader reader = new InputStreamReader(con.getInputStream());
        while (true) {
            int ch = reader.read();
            if (ch==-1) {
                break;
            }
            System.out.print((char)ch);
        }
    }
}
