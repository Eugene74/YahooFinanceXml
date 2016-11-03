package yahoofinancexml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    
    public static void main(String[] args) throws Exception {

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        String result = performRequest(request);
        File file = new File("I:\\AllProgram\\fileFromProgram\\yahoofinance.xml");

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(result);
            fileWriter.flush();
        } catch (IOException e) {

        }
        Query query;
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            query = (Query) unmarshaller.unmarshal(file);



           Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // пишем в файл
            marshaller.marshal(query, file);
            marshaller.marshal(query,System.out );


        } catch (JAXBException e) {
            e.printStackTrace();
        }




    }

    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();



            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
                char[] buf = new char[1000000];

                int r = 0;
                do {
                    if ((r = br.read(buf)) > 0)
                        sb.append(new String(buf, 0, r));

                } while (r > 0);

            } finally {
                http.disconnect();
            }

            return sb.toString();


    }
}