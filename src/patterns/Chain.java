package patterns;

// Цепочка обязанностей
public class Chain {

    static abstract class Step {
        protected Step next;

        Step setNext(Step next) {
            this.next = next;
            return next;
        }

        abstract void doStep(String parcel);
    }

    static class CheckAddress extends Step {
        void doStep(String parcel) {
            System.out.println("Проверили адрес для: " + parcel);
            if (next != null) next.doStep(parcel);
        }
    }

    static class Pack extends Step {
        void doStep(String parcel) {
            System.out.println("Упаковали: " + parcel);
            if (next != null) next.doStep(parcel);
        }
    }

    static class Ship extends Step {
        void doStep(String parcel) {
            System.out.println("Отправили: " + parcel);
        }
    }

    public static void show() {
        Step check = new CheckAddress();
        Step pack = new Pack();
        Step ship = new Ship();

        check.setNext(pack).setNext(ship);

        check.doStep("Коробка с книгами");
        System.out.println();
    }
}