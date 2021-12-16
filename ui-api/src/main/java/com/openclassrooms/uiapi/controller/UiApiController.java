package com.openclassrooms.uiapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Ui api controller.
 */
@Controller
@Slf4j
public class UiApiController {

    /**
     * Index string.
     *
     * @return the string
     */
    @ApiOperation(value = "This URI returns the index page")
    @GetMapping(value={"","/","/index"})
    public String index() {
        log.info("HTTP GET request received at /index");

        return "index";
    }
}
