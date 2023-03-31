package util;
import java.util.List;
import java.util.ArrayList;

public class Util{
    public String getMethode(String url){
        String[] meth=url.split("/");
        return meth[2];
    }


    public List<Class<?>> getClassePackage(String packageName) throws Exception {
    List<Class<?>> classes = new ArrayList<>();
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    String path = packageName.replace('.', '/');
    for (java.net.URL resource : java.util.Collections.list(classLoader.getResources(path))) {
        for (String file : new java.io.File(resource.toURI()).list()) {
            if (file.endsWith(".class")) {
                String className = packageName + '.' + file.substring(0, file.length() - 6);
                Class<?> cl = Class.forName(className);
                classes.add(cl);
            }
        }
    }
    return classes;
}

}