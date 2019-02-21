package spring.utlis;

/**
 * @Author: Gorilla
 * @Date: Created in 16:33 2019/2/21
 * @QQ: 904878659
 */
public class SpringUtils {
    /**
     * 将类名的首字母小写，一般类名大写 在ASCII码中 大写与小写相差32
     *
     * @param simpleName
     * @return
     */
    public static String lowerFirstChar(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return new String(chars);
    }
}
