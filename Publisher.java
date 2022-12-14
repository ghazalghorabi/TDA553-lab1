import java.util.ArrayList;

public class Publisher{
    
    private ArrayList<Subscriber> subscribers;
    
    public void AddSubscriber(Subscriber sub){
        subscribers.add(sub);
    }

    public void RemoveSubscriber(Subscriber sub){
        subscribers.remove(sub);
    }
}