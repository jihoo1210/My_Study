package data_input_output.data_b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        System.out.println("원본 파일 경로: " + path);

        String subPath = scanner.nextLine();
        System.out.println("복사 파일 경로: " + subPath);
    
        File file = new File(path);
        if(!file.exists()) {
            System.out.println("원본 파일이 존재하지 않습니다.");
            System.exit(0);
        }
        
        File targetFile = new File(subPath);
        File parentFile = targetFile.getParentFile();
        if(!parentFile.exists()) {
            targetFile.mkdirs();
        }

        BufferedInputStream input = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(subPath));

        byte[] b = new byte[1024];
        int num = -1;
        while (true) {
            num = input.read(b);
            if(num == -1) {
                break;
            }
            output.write(b, 0 , num);
        }

        scanner.close(); input.close(); output.close();
    }
}
