package me.panpan.config.client.service;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
@Getter
public class SpringCloudConfigClientService {

    private static final Logger logger = LogManager.getLogger(SpringCloudConfigClientService.class);

    @Value("${logger.name.root}")
    private String loggerNameRoot;

    @Value("${logger.level.root}")
    private String loggerLevelRoot;

    @Value("${logger.name.app}")
    private String loggerNameApp;

    @Value("${logger.level.app}")
    private String loggerLevelApp;

    @EventListener
    public void onRefreshScopeRefreshed(RefreshScopeRefreshedEvent event) {
        logger.info("Refresh completed. Updated loggerNameRoot: {}, loggerLevelRoot: {}", loggerNameRoot, loggerLevelRoot);
        logger.info("Refresh completed. Updated loggerNameApp: {}, loggerLevelApp: {}", loggerNameRoot, loggerLevelRoot);

    }
}
