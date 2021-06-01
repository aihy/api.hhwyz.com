package com.hhwyz.hhwyz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author erniu.wzh
 * @date 2021/6/1 12:09
 */
@SpringBootTest
class MyServiceTest {
    @Resource
    private MyService myService;

    @Test
    void xirr() throws Exception {
        myService.xirr(25 * 12, 19710.06f, 3300000);
    }
}