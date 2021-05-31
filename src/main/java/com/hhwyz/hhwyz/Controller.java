package com.hhwyz.hhwyz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author erniu.wzh
 * @date 2021/5/31 19:51
 */
@RestController
public class Controller {
    @GetMapping("money")
    public String money(Integer allMoney, Integer numOfMonth, Integer moneyPerMonth) throws Exception {
        Process proc = Runtime.getRuntime().exec(String.format("conda activate pythonProject && python3 xirr.py %s %s %s", allMoney, numOfMonth, moneyPerMonth));
        proc.waitFor();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

// Read the output from the command:

        System.out.println("Here is the standard output of the command:\n");

        String s = null;

        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

// Read any errors from the attempted command:

        System.out.println("Here is the standard error of the command (if any):\n");

        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        return String.format("平均年化利率：%.2f%%", (float) (allMoney + numOfMonth + moneyPerMonth));
    }
}
