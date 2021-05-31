package com.hhwyz.hhwyz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author erniu.wzh
 * @date 2021/5/31 19:51
 */
@RestController
public class Controller {
    @GetMapping("money")
    public String money() {
        return "10";
    }
}
