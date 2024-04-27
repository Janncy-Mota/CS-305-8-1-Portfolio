package com.snhu.sslserver;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String handleError() {
    	
        return "Sorry, the resource you requested does not exist or an error occurred!";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
