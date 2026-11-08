package patterns;

// Декоратор
public class Decorator {

    interface Notifier {
        void notify(String message);
    }

    static class ConsoleNotifier implements Notifier {
        public void notify(String message) {
            System.out.println("Уведомление: " + message);
        }
    }

    static abstract class NotifierWrapper implements Notifier {
        protected final Notifier inner;
        NotifierWrapper(Notifier inner) { this.inner = inner; }
        public void notify(String message) { inner.notify(message); }
    }

    static class WithSms extends NotifierWrapper {
        WithSms(Notifier inner) { super(inner); }
        public void notify(String message) {
            super.notify(message);
            System.out.println("SMS отправлено: " + message);
        }
    }

    static class WithEmail extends NotifierWrapper {
        WithEmail(Notifier inner) { super(inner); }
        public void notify(String message) {
            super.notify(message);
            System.out.println("Email отправлен: " + message);
        }
    }

    public static void show() {
        Notifier notifier = new WithEmail(new WithSms(new ConsoleNotifier()));
        notifier.notify("Посылка доставлена");
        System.out.println();
    }
}