package attestation_1.seminar_6.observable;

class EventListenerTest {

    @org.junit.jupiter.api.Test
    void update() {
        class TestEL implements EventListener {

            @Override
            public <T> void update(String eventType, T obj) {
                System.out.print("eventType: " + eventType + "\n");
                System.out.print("   object: " + obj.toString() + "\n");
            }
        }

        TestEL testEL = new TestEL();

        EventStringBuilder esb = new EventStringBuilder();

        esb.bind("append", testEL);
        esb.bind("replace", testEL);

        esb.append("dima ");
        esb.append("durak");
        esb.replace(4, 5, " isn't ");
    }
}