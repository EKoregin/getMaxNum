package com.example.getMaxNum.controller;

import com.example.getMaxNum.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NumberController {

    private final NumberService numberService;

    @PostMapping("getMaxNumber")
    public Integer getMaxNumber(@RequestParam String path, @RequestParam("nnum") int nNum){
        return numberService.getMaxNumber(path, nNum);
    }
}
