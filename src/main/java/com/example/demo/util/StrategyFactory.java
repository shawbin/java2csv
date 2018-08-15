package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    private static final Map<Integer, Strategy> STRATEGYS = new HashMap<>(1<<4);

    private StrategyFactory() {}

    public static StrategyFactory getStrategyFactory() {

        //初始化strategys
        STRATEGYS.put(1, new FirstStrategy());
        STRATEGYS.put(2, new SecondStrategy());
        return new StrategyFactory();
    }

    public void strategyExecute(Integer status) {

        STRATEGYS.get(status).executeMethod(status);
    }


}

/**
 * 测落模式特定的方法
 */
interface Strategy {

    /**
     * 执行某个特定的方法
     * @param status
     */
    void executeMethod(Integer status);
}

/**
 * 第一个方法
 * @author
 * @date
 */
class FirstStrategy implements Strategy {

    @Override
    public void executeMethod(Integer status) {

        System.out.println("first strategy is execute !!!");
    }
}

/**
 * 第二个方法
 * @author
 * @date
 */
class SecondStrategy implements Strategy {

    @Override
    public void executeMethod(Integer status) {

        System.out.println("second strategy is execute !!!");
    }
}
