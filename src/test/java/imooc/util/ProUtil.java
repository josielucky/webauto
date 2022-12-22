package imooc.util;


import java.io.IOException;
import java.util.Properties;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ProUtil {
    public Properties Pro;//定义一个全局的变量

    public ProUtil(String FilePath){
        //通过构造器给全局变量赋值，方便GetPro中引用
        Pro = ReadProperties(FilePath);//调用ReadProperties方法，将文件内容读取赋值给Pro
    }

    public Properties ReadProperties(String FilePath){
        //读取操作
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(FilePath);
            BufferedInputStream In = new BufferedInputStream(fileInputStream);
            properties.load(In);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
    public String GetPro(String key){
        //用来获取配置文件
        if(Pro.containsKey(key)){//获取关键字，先判断是否存在
            String value = Pro.getProperty(key);
            return value;
        }else {
            return "";
        }
    }
    public int GetLength(){
        //获取行数
        return Pro.size();
    }

    public static void main(String[] args) throws IOException {
        ProUtil proUtil = new ProUtil("element.properties");
        System.out.println(proUtil.GetPro("username"));

    }
}
