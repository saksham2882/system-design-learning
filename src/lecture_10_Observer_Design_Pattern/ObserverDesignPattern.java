package lecture_10_Observer_Design_Pattern;

// Definition:
// Defines a one-to-many relationship between objects so that when one object changes state, all of its dependents are notified, and updated automatically.

import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
    public void update();
}

// Observable interface: a YouTube channel interface
interface IChannel {
    public void subscribe(ISubscriber subscriber);
    public void unsubscribe(ISubscriber subscriber);
    public void notifySubscribers();
}


// Concrete Subject: a YouTube channel that observers can subscribe-to
class Channel implements IChannel {
    private final List<ISubscriber> subscribers;
    private String name;
    private String latestVideo;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(ISubscriber subscriber : subscribers){
            subscriber.update();
        }
    }

    public void uploadVideo(String title) {
        latestVideo = title;
        System.out.println("Video uploaded: " + title);
        notifySubscribers();
    }

    public String getLatestVideo() {
        return "\nCheckout our new video: "  + latestVideo + "\n";
    }
}


// Concrete Observer: represents a subscriber to the channel
class Subscriber implements ISubscriber {
    private final String name;
    private final Channel channel;

    public Subscriber(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + "," + channel.getLatestVideo());
    }
}


public class ObserverDesignPattern {
    static void main() {

        // Create a channel and subscribers
        Channel channel = new Channel("Happy Coding!");

        Subscriber subscriber1 = new Subscriber("Rahul", channel);
        Subscriber subscriber2 = new Subscriber("Rohit", channel);

        // Rahul & Rohit subscribe to Happy Codding!
        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        // Upload a video: both Rahul and Rohit are notified
        channel.uploadVideo("Testing Observer Design Pattern");

        // Rohit unsubscribes; Rahul remains subscribed
        channel.unsubscribe(subscriber2);

        // Upload another video: only Rahul is notified
        channel.uploadVideo("Agentic AI Tutorial");
    }
}
