package effectivejava;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {

        int num;

        public State(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println(num + "방 청소");
            num = 0;
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int num) {
        state = new State(num);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }

}
