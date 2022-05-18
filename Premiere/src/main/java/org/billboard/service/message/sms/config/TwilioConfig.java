package org.billboard.service.message.sms.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {
    private String accountSid = "AC3a5f760562358773d17240d287217205";
    private String authToken = "b6212af9d59e4c52f970f05cf10404d0";
    private String trialNumber = "+14155238886";

    public TwilioConfig() {

    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }
}
