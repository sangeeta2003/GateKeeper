package in.coderarmy.gatekeeper.analytics.controller;

import in.coderarmy.gatekeeper.analytics.dto.response.HealthResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/health")
public class HealthController {
    private String serviceName;
    private String serviceDescription;
    public HealthController(@Value("${info.app.name}") String serviceName, @Value("${info.app.description}") String serviceDescription){
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
    }
    @GetMapping
    public ResponseEntity<HealthResponse> health(){
        return ResponseEntity.ok(new HealthResponse(serviceName,serviceDescription,"UP"));

    }
}