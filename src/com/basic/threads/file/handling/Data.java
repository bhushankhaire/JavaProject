package com.basic.threads.file.handling;

public class Data {
    String id;
    String state;
    long timestamp;
    String type;
    String host;

    String flag;

    public Data() {
    }

    public Data(String id, String state, long timestamp, String type, String host) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
        this.type = type;
        this.host = host;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", timestamp=" + timestamp +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
