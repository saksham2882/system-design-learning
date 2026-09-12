package lecture_12_Design_a_Notification_System.notification_system;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// ========= Notification & Decorators ===========
interface INotification {
    public String getContent();
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
        return date.toString() + " - " + notification.getContent();
    }
}

// Decorator to append a signature to the content.
class SignatureDecorator extends INotificationDecorator {
    protected String signature;

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
    public void update();
}

interface IObservable {
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifyObservers();
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

// Concrete Observer 1
class Logger implements IObserver{
    private final NotificationObservable notificationObservable;

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
    public void sendNotification(String content);
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

    public NotificationEngine(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
    }

    public void addNotificationStrategy(INotificationStrategy strategy) {
        notificationStrategies.add(strategy);
    }

    @Override
    public void update() {
        String content = notificationObservable.getNotificationContent();

        for (INotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(content);
        }
    }
}


// ========= NotificationService ===========
// The NotificationService manages notifications. It keeps track of notifications.
// Any client code will interact with the service.

// Singleton class
class NotificationService {
    private final NotificationObservable notificationObservable;
    private List<INotification> notifications = new ArrayList<>();
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

    public void sendNotification(INotification notification) {
        notifications.add(notification);
        notificationObservable.setNotification(notification);
    }
}


public class NotificationSystem {
    static void main() {

        // Create Notification Service
        NotificationService notificationService = new NotificationService();

        // Get Observable
        NotificationObservable notificationObservable = notificationService.getObservable();

        // Create Logger Observer
        Logger logger = new Logger(notificationObservable);

        // Create NotificationEngine observers
        NotificationEngine notificationEngine = new NotificationEngine(notificationObservable);

        notificationEngine.addNotificationStrategy(new EmailNotificationStrategy("test.service@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSNotificationStrategy("8765432109"));
        notificationEngine.addNotificationStrategy(new PopUpNotificationStrategy());

        // Attach these observers
        notificationObservable.addObserver(logger);
        notificationObservable.addObserver(notificationEngine);

        // Create a notification with decorators.
        INotification notification = new SimpleNotification("Your order has been placed!");
        notification = new TimestampDecorator(notification);
        notification = new SignatureDecorator(notification, "Customer Support");

        notificationService.sendNotification(notification);
    }
}
