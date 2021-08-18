package com.example.springdb.controller;

import com.example.springdb.service.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestServices testService;

    @GetMapping("/test")
    public String testTrans() {

        try {
            testService.testTrans(true);
        } catch (Exception e) {

        }
        return "test";
    }

    @GetMapping("/test/ok")
    public String testTransOk() {

        try {
            testService.testTrans(false);
        } catch (Exception e) {

        }
        return "test";
    }

    @GetMapping("/test/no")
    public String testTransNO() {

        try {
            testService.insert();
        } catch (Exception e) {

        }
        return "test";
    }
}
