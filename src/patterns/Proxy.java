package patterns;

// Прокси
public class Proxy {

    interface Delivery {
        void deliver(String parcel);
    }

    static class RealCourier implements Delivery {
        public void deliver(String parcel) {
            System.out.println("Курьер повёз: " + parcel);
        }
    }

    static class ProxyCourier implements Delivery {
        private final Delivery real = new RealCourier();

        public void deliver(String parcel) {
            System.out.println("Запрос получен " + parcel);
            real.deliver(parcel);
            System.out.println("Запрос завершён");
        }
    }

    public static void show() {
        Delivery delivery = new ProxyCourier();
        delivery.deliver("Подарок");
        System.out.println();
    }
}