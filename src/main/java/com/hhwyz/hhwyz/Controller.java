package com.hhwyz.hhwyz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author erniu.wzh
 * @date 2021/5/31 19:51
 */
@RestController
public class Controller {
    @Resource
    private MyService myService;

    @GetMapping("money")
    public String money(Integer allMoney, Integer numOfMonth, Integer moneyPerMonth) {
        String res;
        try {
            res = String.format("平均年化利率：%.2f%%", myService.xirr(numOfMonth, moneyPerMonth, allMoney));
        } catch (Exception e) {
            res = "平均年化利率：error";
        }
        return res;
    }
}
