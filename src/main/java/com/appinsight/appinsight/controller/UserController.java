package com.appinsight.appinsight.controller;
import com.microsoft.applicationinsights.TelemetryClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microsoft.applicationinsights.telemetry.Duration;
import com.microsoft.applicationinsights.telemetry.RequestTelemetry;

@RestController
@RequestMapping("/userService")
public class UserController {

	@Autowired
    TelemetryClient telemetryClient;
	
	@Autowired
	private RestTemplate restTemplate;

    @GetMapping("/create")
    public String hello(@RequestHeader("Request-Id") String requestId) {
    	
    	/*if(requestId!=null){
    		telemetryClient.getContext().getOperation().setParentId(requestId);
    	}*/

        //track a custom event  
        telemetryClient.trackEvent("Sending a userService create event...");
        
        

        //trace a custom trace
        telemetryClient.trackTrace("Sending a userService create trace....");

        //track a custom metric
        telemetryClient.trackMetric("userService metric Create User", 1.0);
        
     
        return "UserCreated";
    }
    @GetMapping("/getUser")
    public String getUser(@RequestHeader("Request-Id") String requestId) {
    	
    

        //track a custom event  
        telemetryClient.trackEvent("Sending a getUser create event...");
        
        

        //trace a custom trace
        telemetryClient.trackTrace("Sending a getUser create trace....");

        //track a custom metric
        telemetryClient.trackMetric("userService getUser Create User", 1.0);
        
     
        return "getUser";
    }
}
