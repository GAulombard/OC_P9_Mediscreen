package com.openclassrooms.uiapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Validated
@Api(description = "User Interface API")
@Slf4j
public class UiApiController {

    @ApiOperation(value = "This URI returns the index page")
    @RequestMapping(value={"","/","/index"})
    public String index() {
        log.info("HTTP GET request received at /index");

        return "index";
    }
}