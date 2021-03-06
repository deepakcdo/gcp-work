import headfront.amps.AmpsConnection;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Deepak on 28/03/2016.
 */
public class AmpsPublisher {
    long count = 1; // Change this to publish records from this id
    Random random = new Random();
    AmpsConnection connection = null;

    public AmpsPublisher(String conn, String topic) {
        connection = new AmpsConnection("AmpsPublisher", conn, () -> {
        });
        connection.setAppendHostnameToConnectionName(true);
        connection.initialize();
        System.out.println("Publishing....");
        while (count < 10000000) {
            publishHistoricTrade(topic);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void publishHistoricTrade(String topic) {
        Map<String, Object> data = new HashMap<>();
        final int i = (int) (Math.random() * 10);
        try {
        data.put("ID", "Trade_" + i);
        data.put("EXN_ID", "TRADER1_" + i);
        data.put("EXN_NAME", "TRADER1_" + i);
        data.put("topic", topic);
        data.put("Bid", 100 + random.nextInt(100));
        data.put("Offer", 10.2 - random.nextInt(100));
        data.put("client", "Who knows");
        data.put("Date", new Date().toString());
        data.put("Hostname", InetAddress.getLocalHost().getHostName());
        data.put("User", System.getProperty("user.name"));
        data.put("State", "Done");
            connection.publishDelta(topic, "ID", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Staring AmpsPublisher !!!!!!!");
        String conUrl = System.getenv().get("conUrl");
        String topic = System.getenv().get("topic");

        if (conUrl == null) {
            System.out.println("No environment variable set for conUrl");
        }
        if (topic == null) {
            System.out.println("No environment variable set for topic");
        }
        System.out.println("Got conUrl as " + conUrl + " and topic as " + topic);

        if (conUrl == null || topic == null){
            System.exit(9);
        }
        new AmpsPublisher(conUrl, topic);
    }
}
