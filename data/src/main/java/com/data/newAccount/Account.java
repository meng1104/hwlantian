package com.data.newAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.Principal;
import java.util.*;


@Data
@Document
public class Account {
    @Id
    private String id;
    @Version
    private Long version;

    private String name;
    private String phone;
    private Boolean phoneVerified = false;
    private String email;
    private Boolean emailVerified = false;
    @JsonIgnore
    @Setter(onMethod = @__(@JsonProperty))
    @Getter(onMethod = @__(@JsonIgnore))
    private String password;

    /*    @
        public void setPassword(String password) {
            password = password;
        }*/
    private String wxOpenId;
    private Collection<String> roles = new ArrayList<>();
    private String faceUri;
    private String nickname;
    private Double point;
    private Long createTimestamp;

    public Account() {
    }

    public Account(String username, String password, String... roles) {
        this.name = username;
        this.password = password;
        this.roles = Arrays.asList(roles);
    }


}
