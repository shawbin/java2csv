package com.example.demo.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyFactoryTest {

    @Test
    public void getStrategyFactory() {

        StrategyFactory strategyFactory = StrategyFactory.getStrategyFactory();
        strategyFactory.strategyExecute(1);
        strategyFactory.strategyExecute(2);
    }
}