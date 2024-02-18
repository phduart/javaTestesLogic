package br.com.duarte;

import br.com.duarte.models.Bjrr29;
import br.com.duarte.models.BlockedProposalBrain;
import br.com.duarte.models.CoordenadasBrain;
import br.com.duarte.models.Talhao;
import br.com.duarte.models.brad.Prazos;
import br.com.duarte.models.brainTeste.BlockedProposal;
import br.com.duarte.models.brainTeste.Coordinates;
import br.com.duarte.models.brainTeste.PointCoordinates;
import br.com.duarte.models.brainTeste.Talhoes;
import br.com.duarte.models.perso.Node;

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
import java.time.LocalDateTime;
import java.util.*;


public class logic {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException, ParseException {
        System.out.println("Inicio");

        validaSeDataMenor();

        System.out.println("FIM");
    }

    public static void validaSeDataMenor() throws ParseException {
        String dataGuia = "25/12/2023";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date dataInfoGuia = dateFormat.parse(dataGuia);
        Date dtAtual = getData(new Date());

        if(dataInfoGuia.before(dtAtual)){
            System.out.println("Data é menor!");
        } else {
            System.out.println("Data válida");
        }

    }

    public static Date getData(Date aDate) {
        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(aDate);
        myCalendar.set(Calendar.HOUR_OF_DAY, 0);
        myCalendar.set(Calendar.MINUTE, 0);
        myCalendar.set(Calendar.SECOND, 0);
        myCalendar.set(Calendar.MILLISECOND, 0);
        return myCalendar.getTime();
    }

    private static void testeComparator() {


        Node nodes = new Node();
        List<String> nodesValues = new ArrayList<>();
        nodesValues.add("27");
        nodesValues.add("3");
        nodesValues.add("2");
        nodesValues.add("7");
        nodesValues.add("47");
        nodesValues.add("4");
        nodesValues.add("24");
        nodesValues.add("6");
        nodesValues.add("36");

        nodes.setValue(nodesValues);
        System.out.println(nodesValues);

        List<String> nodesValuesToValidate = new ArrayList<>();
        List<String> nodesValuesToCompare = new ArrayList<>();
        // for para pegar os valores duplos
        for (String value : nodesValues){
            if(value.length() > 1 ){
                nodesValuesToValidate.add(value);
            } else {
                nodesValuesToCompare.add(value);
            }
        }

        // Compare value each with split
        for (String value : nodesValuesToValidate) {
            for(int i = 0; i < value.length(); i++){
                if(!compareChainChar(String.valueOf(value.charAt(i)), nodesValuesToCompare)){
                    System.out.println("Error on validate!");
                } else {
                    System.out.println("Success!");
                }
            }
        }
    }

    private static boolean compareChainChar(String valueToValidate, List<String> listToCompare){
        if(listToCompare.contains(valueToValidate)){
            return true;
        } else {
            return false;
        }
    }

    private static BigDecimal converterTaxaDeJurosDia(){
        // receber taxaMes = 0.79741401
        BigDecimal taxaMes = new BigDecimal("0.79741401");
        System.out.println("taxa mes " + taxaMes);

        // tratando taxaMes = taxaMes / 100
        taxaMes = taxaMes.divide(new BigDecimal("100"));

        // CALCULO ---- (((1+ taxa) ^ (1/30)) - 1) * 100
        // x = (1+ taxa)
        BigDecimal taxaDia = BigDecimal.ONE.add(taxaMes).setScale(8, RoundingMode.FLOOR);
        System.out.println("x = (1+taxa) = " + taxaDia);

        // y = (1/d)
        BigDecimal potencia = BigDecimal.ONE.divide(new BigDecimal("30"), 8, RoundingMode.FLOOR);
        System.out.println("y = (1/360) = " +  potencia);

        double taxaDouble = Double.parseDouble(taxaDia.toString());
        double potenciaDouble = Double.parseDouble(potencia.toString());

        // z = x^y
        double resultCalcTaxa = Math.pow(taxaDouble, potenciaDouble);
        System.out.println("z = x^y = " + resultCalcTaxa);

        // a = (z - 1) * 100
        double taxaJurosDia = (resultCalcTaxa - 1) * 100;
        BigDecimal taxaJurosDecimal = new BigDecimal(taxaJurosDia);
        System.out.println("a = (z - 1) * 100 = " + taxaJurosDecimal  + "%");

        return taxaJurosDecimal;
    }

    public static void descontoCompostoDia(float valor, float taxa, int dias){
        float num = valor;
        System.out.println("R$" + num);

        for(int i = 0; i < dias; i++){
            num = num - (num/100) * taxa;
            System.out.println("R$" + num);
        }
    }

    public static float descontoComposto(float nominal, float taxa, int tempo)
    {
        return (float)(nominal * (1 - (Math.pow((1-taxa), tempo))));
    }


    private static void getCalculation(double num1, double num2, String operator){

        switch(operator) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            case "/":
                System.out.println(num1 / num2);
                break;
        }

    }

    private static void setText(String string){
        System.out.println(string);
    }

    private static void getMeses(int meses){
        List<String> competencias = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        for(int i = 0; i < meses; i++){
            calendar.add(Calendar.MONTH, -1);
            competencias.add(dateFormat.format(calendar.getTime()));
            System.out.println(dateFormat.format(calendar.getTime()));
        }
        System.out.println(competencias.size());

    }

    private static void getTesteHashMapLacuna(){
        ArrayList<Prazos> list = new ArrayList<Prazos>();
        HashMap<String, String> hashPrazosFim = new HashMap<String, String>();

        Prazos prazosUm = new Prazos();
        prazosUm.setIdPlano(1);
        prazosUm.setPrazoInicio(1);
        prazosUm.setPrazoFim(4);
        list.add(prazosUm);

        Prazos prazosDois = new Prazos();
        prazosDois.setIdPlano(1);
        prazosDois.setPrazoInicio(5);
        prazosDois.setPrazoFim(10);
        list.add(prazosDois);

        System.out.println("teste");

        for(Prazos prazos : list){
            if(prazos.getIdPlano() == 1) {
                hashPrazosFim.put("1", String.valueOf(prazos.getPrazoFim()));
            };
        }

        System.out.println("teste");
        if(hashPrazosFim.containsKey("1")){
            int prazoFimInt = Integer.parseInt(hashPrazosFim.get("1"));

            if(11 == prazoFimInt+1){
                System.out.println("é igual");
            }
        }

        System.out.println("teste");


    }

    private static void getDataAnterior(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        System.out.println(dateFormat.format(calendar.getTime()));

        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        System.out.println(dateFormat.format(calendar.getTime()));
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
