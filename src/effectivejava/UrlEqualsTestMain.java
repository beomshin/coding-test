package effectivejava;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class UrlEqualsTestMain {

    public static void main(String[] args) throws MalformedURLException, UnknownHostException {

        URL url=  new URL("https://www.naver.com");
        URL url2=  new URL("https://github.com/");
        InetAddress a1 = InetAddress.getByName(url.getHost());
        InetAddress a2 = InetAddress.getByName(url2.getHost());

        System.out.println(a1.getHostAddress());
        System.out.println(a2.getHostAddress());

        /**
         * URL은 내부적으로 ip 비교를 진행한다
         * 이는 일관성을 깨트리는 상황으로 잠재적 오류를 가지고있다.
         *
         * IP는 언제나 바뀔수있기에 따라서 equals는 어플리케이션 메모리상에 비교를 권장한다
         */
    }
}
