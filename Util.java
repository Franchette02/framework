package util;
public class Util{
    public String getMethode(String url){
        String[] meth=url.split("/");
        return meth[2];
    }
}