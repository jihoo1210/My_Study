package data_input_output.data_a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;

public class Example {

    public static void main(String[] args) throws Exception{
        String filePath = "C:/ParkJIhoo/Document/18_데이터 입출력.txt";
        FileReader fr = new FileReader(filePath, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(fr);

        int rowNumber = 0;
        String rowData;
        while(true) {
            rowData = br.readLine();
            rowNumber++;
            if(rowData == null) {
                break;
            }
            System.out.println(rowNumber + "\t" + rowData);
        }

        br.close(); fr.close();
    }
}