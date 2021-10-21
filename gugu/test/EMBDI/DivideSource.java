package EMBDI;

import org.junit.Test;

import java.io.*;

public class DivideSource {
    @Test
    public void divideSource(){
        // number of sources
        int sourceNum = 55;
        // number of tuple in one source
        int tupleNum = 100;
        String totalFile = "data/stock100/100sourceDataWithoutSource.csv";
        String str;
        String[] data;
        try {
            FileReader fr = new FileReader(totalFile);
            BufferedReader br = new BufferedReader(fr);
            String temp;
            // throw first row
            temp = br.readLine();
            for(int i = 0;i<sourceNum;i++){
                int seq = i + 1;
                String filePath = "data/stock100/divideSource/source" + seq  + ".csv";
                File f = new File(filePath);
                FileOutputStream fileOutputStream = new FileOutputStream(f);
                PrintStream printStream = new PrintStream(fileOutputStream);
                System.setOut(printStream);
                try {
                    f.createNewFile();
                    // 输入属性，也可以从extract中获取
                    System.out.println(temp);
                    // System.out.println("source,sample,change%,last_trade_price,open_price,volumn,today_high,today_low,previous_close,52wk_H,52wk_L");
                    int line = 0;
                    // source 10 has 98
                    if(seq==10){
                        while(line < 98){
                            str = br.readLine();
                            System.out.println(str);
                            line++;
                        }
                        continue;
                    }
                    if(seq==25){
                        while(line < 99){
                            str = br.readLine();
                            System.out.println(str);
                            line++;
                        }
                        continue;
                    }
                    if(seq==45){
                        while(line < 99){
                            str = br.readLine();
                            System.out.println(str);
                            line++;
                        }
                        continue;
                    }
                    // 每个数据集10个元组
                    while (line<tupleNum){
                        str = br.readLine();
                        System.out.println(str);
                        line++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printStream.close();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
