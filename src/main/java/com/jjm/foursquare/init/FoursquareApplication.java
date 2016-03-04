package com.jjm.foursquare.init;

public class FoursquareApplication {

    private static FoursquareApplication instance;
    private static String clientId;
    private static String clientSecret;

    public static FoursquareApplication getInstance() {
        if (instance == null) {
            instance = new FoursquareApplication();
        }
        return instance;
    }

    public void init(String clientId, String clientSecret) {
        setClientId(clientId);
        setClientSecret(clientSecret);
    }

    private void setClientId(String clientId) {
        FoursquareApplication.clientId = clientId;
    }

    private void setClientSecret(String clientSecret) {
        FoursquareApplication.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
