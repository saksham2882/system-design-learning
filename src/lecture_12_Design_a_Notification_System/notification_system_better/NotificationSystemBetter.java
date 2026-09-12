package lecture_12_Design_a_Notification_System.notification_system_better;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// ========= Notification & Decorators ===========
interface INotification {
    String getContent();
}

// Concrete Notification -> Simple text Notification
class SimpleNotification implements INotification {
    private final String content;

    public SimpleNotification(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}


// Abstract Decorator: wraps a Notification Object
abstract class INotificationDecorator implements INotification {
    protected final INotification notification;

    public INotificationDecorator(INotification notification) {
        this.notification = notification;
    }
}

// Decorator to add a timestamp to the content.
class TimestampDecorator extends INotificationDecorator {
    public TimestampDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        Date date =  new Date();
        return date + " - " + notification.getContent();
    }
}

// Decorator to append a signature to the content.
class SignatureDecorator extends INotificationDecorator {
    protected final String signature;

    public SignatureDecorator(INotification notification, String signature) {
        super(notification);
        this.signature = signature;
    }

    @Override
    public String getContent() {
        return notification.getContent() + "\n-- " + signature + "--\n";
    }
}


// ========== Observer Pattern Components ===========
interface IObserver {
    void update();
}

interface IObservable {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}

// Concrete Observable
class NotificationObservable implements IObservable {
    private final List<IObserver> observers = new ArrayList<>();
    private INotification notification;

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public void setNotification(INotification notification) {
        this.notification = notification;
        notifyObservers();
    }

    public INotification getNotification() {
        return notification;
    }

    public String getNotificationContent() {
        return notification.getContent();
    }
}


// ========= NotificationService ===========
// The NotificationService manages notifications. It keeps track of notifications.
// Any client code will interact with the service.

// Singleton class
class NotificationService {
    private final NotificationObservable notificationObservable;
    private final List<INotification> notifications = new ArrayList<>();
    private static NotificationService instance = null;

    public NotificationService() {
        notificationObservable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationObservable getObservable() {
        return notificationObservable;
    }

    // Creates a new Notification and notifies observers.
    public void sendNotification(INotification notification) {
        notifications.add(notification);
        notificationObservable.setNotification(notification);
    }
}


// Concrete Observer 1
class Logger implements IObserver {
    private final NotificationObservable notificationObservable;

    public Logger() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public Logger(NotificationObservable notification) {
        this.notificationObservable = notification;
    }

    @Override
    public void update() {
        System.out.println("Logging new notification: \n " + notificationObservable.getNotificationContent());
    }
}

// ========== Strategy Pattern Components (Concrete Observer 2) ===========
interface INotificationStrategy {
    void sendNotification(String content);
}

class EmailNotificationStrategy implements INotificationStrategy {
    private final String emailId;

    public EmailNotificationStrategy(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("Sending notification to: " + emailId + "\n " + content);
    }
}

class SMSNotificationStrategy implements INotificationStrategy {
    private final String mobileNumber;

    public SMSNotificationStrategy(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("Sending SMS notification to: " + mobileNumber + "\n " +  content);
    }
}

class PopUpNotificationStrategy implements INotificationStrategy {
    @Override
    public void sendNotification(String content) {
        System.out.println("Sending Popup Notification: \n" + content );
    }
}


// Notification Engine for sending notification to all strategies
class NotificationEngine implements IObserver {
    private final NotificationObservable notificationObservable;
    private final List<INotificationStrategy> notificationStrategies = new ArrayList<>();

    public NotificationEngine() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public NotificationEngine(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
    }

    public void addNotificationStrategy(INotificationStrategy strategy) {
        notificationStrategies.add(strategy);
    }

    // Can have RemoveNotificationStrategy as well.

    @Override
    public void update() {
        String content = notificationObservable.getNotificationContent();

        for (INotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(content);
        }
    }
}


public class NotificationSystemBetter {
    static void main() {

        // Create Notification Service
        NotificationService notificationService = NotificationService.getInstance();

        // Create Logger Observer
        Logger logger = new Logger();

        // Create NotificationEngine Observers
        NotificationEngine notificationEngine = new NotificationEngine();

        notificationEngine.addNotificationStrategy(new EmailNotificationStrategy("test.service@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSNotificationStrategy("7654321098"));

        INotification notification = new SimpleNotification("Your order has been placed!");
        notification = new TimestampDecorator(notification);

        notificationService.sendNotification(notification);
    }
}
