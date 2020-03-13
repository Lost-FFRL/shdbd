
import java.util.ArrayList;

/**
 * 临时测试使用类
 *
 * @author Lost
 * @date 2020-02-26 13:50
 * @see
 * @since 2.7.0
 */
public class Temp {

    byte[] a = new byte[1024 * 1000];

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start ...");
        ArrayList<Temp> list = new ArrayList<Temp>();
        while (true) {
            list.add(new Temp());
            Thread.sleep(10);
        }
    }
}
