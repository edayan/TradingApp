package com.bank.trading.services;

import com.bank.trading.domain.StrategyConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Loads Strategy from resource file
 */
@Component
public class StrategyFileLoader implements StrategyLoader {

    private final Map<Integer, SignalStrategy> strategyMap = new HashMap<>();

    public StrategyFileLoader() {
        loadStrategies();
    }

    private void loadStrategies() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("strategies.json")) {
            List<StrategyConfig> strategyConfigs = objectMapper.readValue(inputStream, new TypeReference<>() {
            });

            for (StrategyConfig config : strategyConfigs) {
                try {
                    Class<?> strategyClass = Class.forName(config.getStrategyClass());
                    SignalStrategy strategy = (SignalStrategy) strategyClass.getDeclaredConstructor().newInstance();
                    strategyMap.put(config.getSignalId(), strategy);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         NoSuchMethodException |
                         InvocationTargetException e) {
                    System.out.println("Error: in reading strategy config file" + e);
                    // Or shutdown if needed
                }
            }
        } catch (IOException e) {
            System.out.println("Error: in loading strategies" + e);
            // Or shutdown if needed
        }
    }

    @Override
    public SignalStrategy getStrategy(int signalId) {
        return strategyMap.get(signalId);
    }
}
