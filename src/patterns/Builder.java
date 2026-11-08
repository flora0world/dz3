package patterns;

// Билдер
public class Builder {

    static class Order {
        private final String from;
        private final String to;
        private final String address;
        private final boolean express;

        private Order(OrderBuilder b) {
            this.from = b.from;
            this.to = b.to;
            this.address = b.address;
            this.express = b.express;
        }

        public String toString() {
            return "Заказ: от " + from + " к " + to +
                    ", адрес: " + address +
                    ", экспресс: " + (express ? "да" : "нет");
        }

        
        static class OrderBuilder {
            private String from;
            private String to;
            private String address;
            private boolean express;

            OrderBuilder from(String v) { this.from = v; return this; }
            OrderBuilder to(String v) { this.to = v; return this; }
            OrderBuilder address(String v) { this.address = v; return this; }
            OrderBuilder express() { this.express = true; return this; }

            Order build() { return new Order(this); }
        }
    }

    public static void show() {
        Order normal = new Order.OrderBuilder()
                .from("Олег")
                .to("Данил")
                .address("Меридианная 8")
                .build();

        Order fast = new Order.OrderBuilder()
                .from("Олег")
                .to("Данил")
                .address("Меридианная 8")
                .express()
                .build();

        System.out.println(normal);
        System.out.println(fast);
        System.out.println();
    }
}
