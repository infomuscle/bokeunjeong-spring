package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

@Getter
@Entity
public class HttpInterface extends Audit {

    @Id
    @GeneratedValue
    @Column(name = "http_interface_id")
    private Long id;

    private String requestUri;
    private String cookies;
    private String remoteHost;
    private String remoteAddr;
    private String localAddr;
    private String referer;
    private String userAgent;

    public HttpInterface(HttpServletRequest request) {
        this.requestUri = request.getRequestURI();
        this.remoteHost = request.getRemoteHost();
        this.remoteAddr = request.getRemoteAddr();
        this.localAddr = request.getLocalAddr();
        this.referer = request.getHeader("referer");
        this.userAgent = request.getHeader("user-agent");
        if (request.getCookies() != null) {
            this.cookies = request.getCookies().toString();
        }
    }
}
