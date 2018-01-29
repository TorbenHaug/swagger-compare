package de.haug_dev.swagger_compare.swagger_compare_facade;

import de.haug_dev.swagger_compare.swagger_compare_core.SwaggerCompareCore;
import de.haug_dev.swagger_compare.swagger_compare_dto.OpenAPICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_reader.SwaggerCompareReader;
import de.haug_dev.swagger_compare.swagger_compare_reader.InvalidOpenAPIFileException;
import io.swagger.v3.oas.models.OpenAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;

@Component
public class SwaggerCompareFacade {

    public SwaggerCompareFacade() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

    Logger logger = LoggerFactory.getLogger(SwaggerCompareFacade.class);

    private SwaggerCompareReader reader;

    private SwaggerCompareCore core;

    @Autowired
    public SwaggerCompareFacade(SwaggerCompareReader reader, SwaggerCompareCore core) {
        this.reader = reader;
        this.core = core;
    }

    public OpenAPICompareResult compare(String urlLeftString, String urlRightString) throws MalformedURLException, InvalidOpenAPIFileException {
        logger.debug("Urls to compare: \"" + urlLeftString + ", \"" + urlRightString + "\"");
        URL urlLeft;
        URL urlRight;
        try {
            urlLeft = new URL(urlLeftString);
        } catch (MalformedURLException e) {
            logger.error("UrlLeft is not a valid URL: " + urlLeftString);
            throw new MalformedURLException("UrlLeft is not a valid URL: " + urlLeftString);
        }

        try {
            urlRight = new URL(urlRightString);
        } catch (MalformedURLException e) {
            logger.error("urlRight is not a valid URL: " + urlRightString);
            throw new MalformedURLException("UrlLeft is not a valid URL: " + urlRightString);
        }

        OpenAPI[] read = reader.read(urlLeft, urlRight);
        OpenAPICompareResult result = core.compare(read[0], read[1]);
        return result;
    }
}
