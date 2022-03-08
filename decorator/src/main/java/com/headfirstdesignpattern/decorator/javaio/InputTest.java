package com.headfirstdesignpattern.decorator.javaio;

import java.io.*;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-24
 */
public class InputTest {
    public static void main(String[] args){
        int c;
        String file="F:\\TrainingMyself\\designpatterns\\decorator\\src\\main\\resources\\test.txt";
        try(InputStream inputStream = new LowerCaseInputStream(
                                            new BufferedInputStream(
                                                new FileInputStream(file)))) {
            while ((c = inputStream.read()) >= 0){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
