package com.hhwyz.hhwyz;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author erniu.wzh
 * @date 2021/6/1 11:28
 */
@Service
public class MyService {
    public float xirr(int monthNums, float eachMonthMoney, int allMoney) throws Exception {
        float left = 0f;
        float right = 10f;
        List<LocalDate> dayList = generateDayList(monthNums);
        float leftY = sum(eachMonthMoney, left, dayList, allMoney);
        System.out.println("l " + leftY);
        float rightY = sum(eachMonthMoney, right, dayList, allMoney);
        System.out.println("r " + rightY);
        if (leftY > 0 || rightY < 0) {
            throw new Exception("error");
        }
        while (true) {
            float midY = sum(eachMonthMoney, (left + right) / 2, dayList, allMoney);
            if ((right - left) < 0.00001) {
                break;
            }
            if (midY > 0) {
                right = (left + right) / 2;
            } else {
                left = (left + right) / 2;
            }
            System.out.println(String.format("this time: left=%.8f right=%.8f midY=%.8f", left, right, midY));
        }
        System.out.println(String.format("%.2f", (left + right) / 2 * 100));
        return (left + right) / 2 * 100;
    }

    private float sum(float eachMonthMoney, float rate, List<LocalDate> dayList, int allMoney) {
        float res = 0;
        for (int i = 1; i < dayList.size(); i++) {
            double dayBetween = ChronoUnit.DAYS.between(dayList.get(0), dayList.get(i));
            double p = Math.pow((1 + rate), dayBetween / 365);
            res += eachMonthMoney / p;
        }
        return allMoney - res;
    }

    private List<LocalDate> generateDayList(int monthNums) {
        List<LocalDate> dayList = new ArrayList<>();
        for (int i = 0; i < monthNums + 1; i++) {
            dayList.add(LocalDate.of(2021, 1, 1).plusMonths(i));
        }
        System.out.println(dayList);
        return dayList;
    }
}
