package com.data.devicedata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Airj on 2016/5/2.
 */

@Data
@Document
public class DeviceAdapter {
    @Id
    private String id;

    @Version
    private Long version;

    private String accountId;

    @DBRef
    private Device device;
    //    private Config config;
    @JsonUnwrapped
    private Customize customize;
    private Status status = Status.NONE;


    public DeviceAdapter() {
    }

    @JsonIgnore
    public Boolean isOperable() {
        if (status == DeviceAdapter.Status.OWN) {
            return true;
        }
        if (status == DeviceAdapter.Status.OPERABLE) {
            return true;
        }
        return false;
    }

    @JsonIgnore
    public Boolean isViewable() {
        if (status == DeviceAdapter.Status.OWN) {
            return true;
        }
        if (status == DeviceAdapter.Status.OPERABLE) {
            return true;
        }
        if (status == Status.VIEWABLE) {
            return true;
        }
        return false;
    }

    public Boolean hasPermission(Principal principal) {
        try {
            return Objects.equals(getAccountId(), principal.getName());
        } catch (NullPointerException e) {
            return false;
        }
    }

    public Boolean isPublicField(String fieldName) {
        List include = Arrays.asList("id", "account", "device");
        return include.contains(fieldName);
    }

    @Data
    public static class Customize {
        String name;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Boolean favorite;
    }

    public enum Status {
        OWN,
        OPERABLE,
        VIEWABLE,
        UNAUTHORIZED,
        INVALID,
        NONE,
    }
}