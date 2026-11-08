package patterns;

// Адаптер

public class Adapter {

    interface Delivery {
        void sendParcel(String address);
    }

    static class OldSystem {
        void shipTo(String addr) {
            System.out.println("Доставка выполнена. Адрес: " + addr);
        }
    }

    static class DeliveryAdapter implements Delivery {
        private final OldSystem old = new OldSystem();

        public void sendParcel(String address) {
            old.shipTo(address);
        }
    }

    public static void show() {
        Delivery delivery = new DeliveryAdapter();
        delivery.sendParcel("Чистапольская 10");
        System.out.println();
    }
}