import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.net.ssl.*;
import java.net.*;
import java.util.LinkedList;

public class APIURLGET {


    static String[] getAllMatches(String substr){
        String Titles[] = null;
        int pageNumber = 1;
        int total = Integer.MAX_VALUE;
        String url_string = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page="
                + pageNumber;

        while (total > 0) {

            try {
                URL url = new URL(url_string);
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                if (con.getResponseCode() == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer content = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();
                    System.out.println(content.toString());
                }
                total =0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String[] s = null;
        return s;
    }


    public static void main(String[] args){

        getAllMatches("Rahul");
    }

}