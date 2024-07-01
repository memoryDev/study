package com.memory.springjwt.controller;

import com.memory.springjwt.dto.JoinDTO;
import com.memory.springjwt.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String join(JoinDTO joinDto) {

        joinService.joinProcess(joinDto);

        return "ok";
    }

}
