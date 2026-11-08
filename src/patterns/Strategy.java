package patterns;

// СТРАТЕГИЯ
public class Strategy {

    interface PriceStrategy {
        int price(int km);
    }

    static class NormalPrice implements PriceStrategy {
        public int price(int km) { return km * 10; }
    }

    static class ExpressPrice implements PriceStrategy {
        public int price(int km) { return km * 25; }
    }

    static class Delivery {
        private PriceStrategy strategy;

        void use(PriceStrategy strategy) { this.strategy = strategy; }

        int priceFor(int km) { return strategy.price(km); }
    }

    public static void show() {
        Delivery delivery = new Delivery();

        delivery.use(new NormalPrice());
        System.out.println("Обычная доставка на 10 км: " + delivery.priceFor(10) + " рублей");

        delivery.use(new ExpressPrice());
        System.out.println("Экспресс доставка на 10 км: " + delivery.priceFor(10) + " рублей");
        System.out.println();
    }
}