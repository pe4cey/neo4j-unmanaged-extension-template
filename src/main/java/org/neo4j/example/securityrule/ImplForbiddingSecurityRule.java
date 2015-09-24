package org.neo4j.example.securityrule;

import org.neo4j.server.rest.security.ForbiddingSecurityRule;
import org.neo4j.server.rest.security.SecurityFilter;

import javax.servlet.http.HttpServletRequest;

public class ImplForbiddingSecurityRule implements ForbiddingSecurityRule {

    private final String REALM = "WallyWorld";

    @Override
    public boolean isForbidden(HttpServletRequest request) {
        System.out.println("ImplForbiddingSecurityRule.isForbidden");
        if (request.getRequestURI().contains("/db/data/transaction")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAuthorized(HttpServletRequest request) {
        System.out.println("ImplForbiddingSecurityRule.isAuthorized");
        return true;
    }

    @Override
    public String forUriPath() {
        System.out.println("ImplForbiddingSecurityRule.forUriPath");
        return "/*";
    }

    @Override
    public String wwwAuthenticateHeader() {
        System.out.println("ImplForbiddingSecurityRule.wwwAuthenticateHeader");
        return SecurityFilter.basicAuthenticationResponse(REALM);
    }
}
