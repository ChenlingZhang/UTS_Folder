package Utils;

/**
 * used to check String
 */
public class StringUtil {

    /**
     * is string empty
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().equals("");
    }

    /**
     * is string not empty
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return str!=null && !str.trim().equals("");
    }

}
