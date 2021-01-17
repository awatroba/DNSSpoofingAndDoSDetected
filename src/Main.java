import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<NetworkFlow> flows = Reader.read("flows_modificated.txt");
        Detector.validate(flows);
    }
}
