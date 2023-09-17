package castle;

import java.io.*;
import java.util.ArrayList;

public class LoadFile {
    private String filePath;
    public LoadFile(String filePath) {
        this.filePath = filePath;
    }
    public  ArrayList loadFile() {
        ArrayList<String> strList = new ArrayList<String>();
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        try {
            InputStream instream = new FileInputStream(file);
            if (instream != null) {
                //防止中文乱码：ANSI对应gb2312，utf-8对应utf-8
                InputStreamReader inputreader = new InputStreamReader(instream, "gb2312");
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line;
                while ((line = buffreader.readLine()) != null) {
                    strList.add(line);//追行读取
                }
                instream.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return strList;
    }

}
