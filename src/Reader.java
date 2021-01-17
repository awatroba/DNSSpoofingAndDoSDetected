import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
 * Class for reading data from a file
 * split - char for separating data = ,
 */
public class Reader {
    static String split =",";
    static List<NetworkFlow> read(String filePath) {
        List<NetworkFlow> flows = new LinkedList<>();
        String line = "";
        File file = new File(filePath);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(in.hasNext()) {
            line = in.nextLine();
            String[] a = line.split(split);
            flows.add(NetworkFlow.Builder
                    .builder()
                    .time(Integer.valueOf(a[0]))
                    .duration(Integer.valueOf(a[1]))
                    .source(a[2])
                    .sourcePort(a[3])
                    .destination(a[4])
                    .destinationPort(a[5])
                    .protocol(Integer.valueOf(a[6]))
                    .packetCount(Integer.valueOf(a[7]))
                    .byteCount(Integer.valueOf(a[8]))
                    .build());
        }

        return flows;
    }
}
