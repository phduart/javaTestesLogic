package br.com.duarte;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class logic {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        String valor = "-21.0342130";
        doConvertToGMS(Double.parseDouble(valor));
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
