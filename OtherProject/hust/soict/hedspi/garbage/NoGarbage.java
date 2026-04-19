package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
public class NoGarbage {
    public static void main(String[] args) throws Exception {
        String filename = "C:\\Users\\LENOVO\\Documents\\CaoThanhLam-202416961\\OtherProject\\rac.txt";
        byte[] inputBytes = { };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        /*
        StringBuffer outputStringBuffer = new StringBuffer();
        for (byte b : inputBytes) {
            outputStringBuffer.append((char) b);
        } //slower than StringBuilder

         */
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}