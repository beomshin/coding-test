package effectivejava;

public class RoomTestMain {

    public static void main(String[] args) throws Exception {

        // room null 처리후 GC 대상 처리 확인
        Room room = new Room(1);
        room = null;
        System.gc();

        try (Room room1 = new Room(2)) {
            System.out.println("try with resources 를 통한 객체 회수");
        }

        /**
         * System.gc를 수행하여도 해당 메모리 회수 시점은 정확히 파단할 수 없다
         * 여러번 실행결과 순서가 매번 다르게 발생된다.
         *
         */

    }
}
