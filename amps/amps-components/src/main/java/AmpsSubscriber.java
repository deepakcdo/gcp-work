import com.crankuptheamps.client.Message;
import com.crankuptheamps.client.exception.AMPSException;
import headfront.amps.AmpsConnection;

/**
 * Created by Deepak on 28/03/2016.
 */
public class AmpsSubscriber {


    public AmpsSubscriber(String conn, String topic) {
        AmpsConnection  connection = new AmpsConnection("AmpsSubscriber", conn, () -> {
        });
        connection.setAppendHostnameToConnectionName(true);
        connection.initialize();
        System.out.println("Subscribing....");
//        connection.subscribeTopic(sowstatus, "", message -> {
        try {
            connection.subscribeTopic(topic, "", "", message -> {
                System.out.println(message.getTopic() + " -> " + message.getData());
            }, false, Message.Command.SOWAndDeltaSubscribe, "");
        } catch (AMPSException e) {
            e.printStackTrace();
        }
        System.out.println("Subscribed....");
    }

    public static void main(String[] args) {
        String conUrl = System.getProperty("conUrl");
        String topic = System.getProperty("topic");

        if (conUrl == null) {
            System.out.println("No environment variable set for conUrl");
        }
        if (topic == null) {
            System.out.println("No environment variable set for topic");
        }
        System.out.println("Got conUrl as " + conUrl + " and topic as " + topic);

        new AmpsSubscriber(conUrl, topic);
    }
}
