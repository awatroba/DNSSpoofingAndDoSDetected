/*
 * Class that describes the data contained in the file
 * Data presents network flow events collected from central routers within the network
 *   time - time,
 *   duration - duration,
 *   sourceComputer - source computer,
 *   sourcePort - source port,
 *   destinationComputer - destination computer,
 *   destinationPort - destination port,
 *   protocol - protocol,
 *   packetCount - packet count,
 *   byteCount - byte count
 */
public class NetworkFlow {
    private int time;
    private int duration;
    private String sourceComputer;
    private String sourcePort;
    private String destinationComputer;
    private String destinationPort;
    private int protocol;
    private int packetCount;
    private int byteCount;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSourceComputer() {
        return sourceComputer;
    }

    public void setSourceComputer(String sourceComputer) {
        this.sourceComputer = sourceComputer;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getDestinationComputer() {
        return destinationComputer;
    }

    public void setDestinationComputer(String destinationComputer) {
        this.destinationComputer = destinationComputer;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public int getPacketCount() {
        return packetCount;
    }

    public void setPacketCount(int packetCount) {
        this.packetCount = packetCount;
    }

    public int getByteCount() {
        return byteCount;
    }

    @Override
    public String toString() {
        return "NetworkFlow(" +
                "time=" + time +
                ", duration=" + duration +
                ", sourceComputer='" + sourceComputer + '\'' +
                ", sourcePort='" + sourcePort + '\'' +
                ", destinationComputer='" + destinationComputer + '\'' +
                ", destinationPort='" + destinationPort + '\'' +
                ", protocol=" + protocol +
                ", packetCount=" + packetCount +
                ", byteCount=" + byteCount +
                ')';
    }

    public void setByteCount(int byteCount) {
        this.byteCount = byteCount;
    }
    /*
     * helper class to create an object of type NetworkFlow
     *   time - time,
     *   duration - duration,
     *   sourceComputer - source computer,
     *   sourcePort - source port,
     *   destinationComputer - destination computer,
     *   destinationPort - destination port,
     *   protocol - protocol,
     *   packetCount - packet count,
     *   byteCount - byte count
     */
    public static final class Builder {
        private int time;
        private int duration;
        private String sourceComputer;
        private String sourcePort;
        private String destinationComputer;
        private String destinationPort;
        private int protocol;
        private int packetCount;
        private int byteCount;

        public static Builder builder() {
            return new Builder();
        }

        public Builder time(int time) {
            this.time = time;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder source(String sourceComputer) {
            this.sourceComputer = sourceComputer;
            return this;
        }

        public Builder sourcePort(String sourcePort) {
            this.sourcePort = sourcePort;
            return this;
        }

        public Builder destination(String destinationComputer) {
            this.destinationComputer = destinationComputer;
            return this;
        }

        public Builder destinationPort(String destinationPort) {
            this.destinationPort = destinationPort;
            return this;
        }

        public Builder protocol(int protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder packetCount(int packetCount) {
            this.packetCount = packetCount;
            return this;
        }

        public Builder byteCount(int byteCount) {
            this.byteCount = byteCount;
            return this;
        }

        public NetworkFlow build() {
            NetworkFlow flow = new NetworkFlow();
            flow.setTime(time);
            flow.setDuration(duration);
            flow.setSourceComputer(sourceComputer);
            flow.setSourcePort(sourcePort);
            flow.setDestinationComputer(destinationComputer);
            flow.setDestinationPort(destinationPort);
            flow.setProtocol(protocol);
            flow.setPacketCount(packetCount);
            flow.setByteCount(byteCount);
            return flow;
        }
    }

}
