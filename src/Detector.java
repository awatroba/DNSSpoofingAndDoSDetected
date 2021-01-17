import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Class that detects the attack
* UDPPort - port for UDP= 53
* UDPProtocolNumber - UDP protocol number = 17
* maximumConnections - maximum number of connections considered safe = 50
 */
public class Detector {
    private static String UDPPort = "53";
    private static int UDPProtocolNumber = 17;
    private static int maximumConnections = 50;
    public static void validate(List<NetworkFlow> flows) {
        if(isDNSSpoofing(flows)) {
            return;
        }
        if(isDoS(flows)) {
            return;
        }
    }
    private static List<NetworkFlow> detectDNSSpoofing(List<NetworkFlow> flows){
        List<NetworkFlow> infectedData = new LinkedList<>();
        for (NetworkFlow flow: flows) {
            if(flow.getProtocol()==UDPProtocolNumber && flow.getSourcePort().equals(UDPPort)) {
                infectedData.add(flow);
            }
        }
        return infectedData;
    }
    private static boolean isDNSSpoofing(List<NetworkFlow> flows){
        List<NetworkFlow> infectedData = detectDNSSpoofing(flows);
        if (infectedData.isEmpty()){
            System.out.println("Not detected DNS Spoofing attack");
            return false;
        }
        else{
            System.out.println("Detected  DNS Spoofing attack! ");
            for (NetworkFlow flow: infectedData) {
                System.out.println(flow);
            }
            return true;
        }
    }
    private static Map<String, Long> checkDestinationComputer(List<NetworkFlow> theSameTime){
        Map<String, Long> callLog = new HashMap<>();
        for (NetworkFlow flow: theSameTime) {
            callLog.put(flow.getDestinationComputer(),
                    theSameTime.stream().filter(flow1 ->
                            flow1.getDestinationComputer().equals(
                                    flow.getDestinationComputer())).count());
        }
        callLog = callLog.entrySet().stream()
                .filter(entry -> entry.getValue()>maximumConnections)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return callLog;
    }

    private static Map<Integer, Long> detectDoS(List<NetworkFlow> flows){
        Map<Integer, Long> theSameTime = new HashMap<>();
        for (NetworkFlow flow: flows) {
            theSameTime.put(flow.getTime(),flows.stream().filter(flow1 ->
                    flow1.getTime() == flow.getTime()).count());
        }
        return theSameTime;
    }

    private static boolean isDoS(List<NetworkFlow> flows){
        Map<Integer, Long> theSameTime =  detectDoS(flows);
        if (theSameTime.isEmpty()){
            System.out.println("Not detected DoS attack (no connection with the same time )");
            return false;
        }
        List<NetworkFlow> connectionsToFilter = flows.stream()
                .filter(flow -> theSameTime.keySet().contains(flow.getTime()))
                .collect(Collectors.toList());
        Map<String, Long> infectedData =checkDestinationComputer(connectionsToFilter);
        if (infectedData.isEmpty()){
            System.out.println("Not detected DoS/DDos attack");
            return false;
        }
        else{
            System.out.println("Detected  DoS/DDos attack! ");
                System.out.println(infectedData);
            return true;
        }


    }
}
