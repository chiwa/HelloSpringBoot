package com.zengcode.th;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetAddress;

@Component
@ConfigurationProperties(prefix="connection")
public class ApplicationConfiguration {


    private String username;

    private InetAddress remoteAddress;

    @Autowired
    private ServerConfiguration serverConfiguration;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public ServerConfiguration getServerConfiguration() {
        return serverConfiguration;
    }

    public void setServerConfiguration(ServerConfiguration serverConfiguration) {
        this.serverConfiguration = serverConfiguration;
    }

    @Override
    public String toString() {
        return username + " : " + remoteAddress;
    }

    @PostConstruct
    public void xxx() {
        //
    }
}
