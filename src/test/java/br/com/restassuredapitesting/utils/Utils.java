package br.com.restassuredapitesting.utils;

public class Utils {

    public static String getSchemaBasePath(String pack, String nameSchema){
        return System.getProperty("user.dir")
                +"/src/test/java/br/com/restassuredapitesting/tests/"
                + pack + "/schema/" + nameSchema + ".json";
    }
    public static String nometeste() {return "Jonas";}
    public static String sobrenometeste() {return "Brito";}
    public static String checkinteste() {return "2018-01-01";}
    public static String checkoutteste() {return "2019-01-01";}
}
