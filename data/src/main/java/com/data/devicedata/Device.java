package com.data.devicedata;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.geo.Shape;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;


/**
 * Created by Airj on 2016/5/2.
 */
@Data
@Document
public class Device {

    static final Integer MAX_COMMAND_LINE = 0x10000;
    static final Integer LESS_THAN_SIZE = 0x8000;


    @Id
    private String id;
    @Version
    private Long version;
    Serial serial = Serial.UNDEFINED;

    Shape location;

    @JsonIgnore
    Integer commandLine = 0;
    @JsonIgnore
    LinkedList<Command> commands = new LinkedList<>();
    @JsonIgnore
    Status status;

    @JsonIgnore
    public void addCommand(Command command) {
        command.setLine(commandLine++);
        command.setTimestamp(System.currentTimeMillis());
        if (Objects.equals(commandLine, MAX_COMMAND_LINE)) {
            commandLine = 0;
        }
        commands.addLast(command);
    }

    @Transient
    @JsonIgnore
    Boolean commandReduced = false;

    @JsonIgnore
    public Command getAndReduceCommand(Integer line) {
        if (line == null) {
            line = 0;
        }
        Command command = commands.peekFirst();
        if (command == null) {
            return null;
        }
        Integer commandLine = command.getLine();
        if (Math.floorMod(commandLine - line, MAX_COMMAND_LINE) < LESS_THAN_SIZE) {
            return command;
        }
        commands.removeFirst();
        commandReduced = true;
        return getAndReduceCommand(line);
    }

    @JsonIgnore
    public Boolean updateStatus(String key, Object value) {
        if (status == null) {
            status = new Status();
        }
        Object old = status.map.get(key);
        if (old != value) {
            status.map.put(key, value);
            return true;
        }
        return false;
    }

    @JsonIgnore
    public Boolean updateStatus(Map<String,Object> map) {
        if (status == null) {
            status = new Status();
        }
        Boolean changed = false;
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            if (updateStatus(entry.getKey(), entry.getValue())) {
                changed = true;
            }
        }
        return changed;
    }

    @JsonIgnore
    public Object getStatus(String key) {
        if (status == null) {
            return null;
        }
        return status.map.get(key);
    }

    public enum Serial {
        UNDEFINED,
        M2,
        N2,
        U1,
        D1,
        C1,
        KG,
    }

    /**
     * Created by Administrator on 2016/5/26.
     */
    @Data
    public static class Status {

        @JsonIgnore
        Map<String, Object> map = new HashMap<>();
        @JsonIgnore
        Map<String, Object> offset = new HashMap<>();
        @JsonIgnore
        Map<String, Object> focus = new HashMap<>();

        @JsonInclude
        @JsonAnySetter
        public void anySetter(String key, Object value) {
            map.put(key, value);
        }

        @JsonInclude
        @JsonAnyGetter
        Map anyGetter() {
            return map;
        }
    /*
        Boolean power;
        List<Integer> ledList;
        Integer ledListTime;
        Integer LedAlpha;*/
    }

    /**
     * Created by Airj on 2016/5/27.
     */
    @Data
    public static class Command {
        @JsonProperty
        Integer line;

        @JsonIgnore
        public void setLine(Integer line) {
            this.line = line;
        }

        @JsonIgnore
        Map<String, Object> map = new HashMap<>();
    /*
        @JsonInclude
        public Object get(String key) {
            return map.get(key);
        }*/

        @JsonInclude
        @JsonAnySetter
        public void anySetter(String key, Object value) {
            map.put(key, value);
        }

        @JsonAnyGetter
        Map anyGetter() {
            return map;
        }

        Long timestamp;

      /*  String wifiSsid;
        String wifiPassword;
        Boolean wifiNotInRange;*/
    }
}
