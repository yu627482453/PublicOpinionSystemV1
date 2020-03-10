package com.nex.service.spider.impl;

import com.nex.service.spider.BaseSpiderService;
import com.nex.utils.executorutils.ExecuteResult;
import com.nex.utils.executorutils.LocalCommandExecutorImpl;
import com.nex.utils.iniutils.MyIniUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.service.spider.impl
 * @Description: Base Spider service model.
 * @author: nero
 * @date: 2020年03月02日 15:06
 * @version: V1.0
 */
public abstract class BaseSpiderServiceImpl implements BaseSpiderService {

    final Logger logger = LoggerFactory.getLogger(BaseSpiderServiceImpl.class);
    // need to set.
    /** section in my.ini */
    @Getter private String sectionName;

    // set automatically.
    /** spider's name */
    @Getter private String spiderName;
    /** project Directory */
    @Getter private String projectDir;
    /** path to save log */
    @Getter private String logPath;
    @Getter private int timeout;
    @Getter private int thead;


    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * @Description: set spider
     * @return true: setted; false: not setted.
     */
    @Override
    public boolean setSpider() {

        // if blank
        if (StringUtils.isBlank(sectionName)) {
            logger.warn("Spider sectionName don't set");
        } else {
            try {
                // get info of spider from my.ini.
                spiderName = MyIniUtil.readMyIniFile(sectionName, "name");
                projectDir = MyIniUtil.readMyIniFile(sectionName, "project_dir");
                logPath = MyIniUtil.readMyIniFile(sectionName, "log_dir");
                timeout = Integer.parseInt(MyIniUtil.readMyIniFile(sectionName, "timeout"));
                thead = Integer.parseInt(MyIniUtil.readMyIniFile(sectionName, "thread"));

                return true;

            } catch (IOException e) {
                e.printStackTrace();
                logger.warn("Couldn't get the spider!!!");
                logger.info("Maybe the section is wrong.");
            }
        }

        return false;
    }

    /**
     * @Description: crawl the index page.
     * @return true: succeed; false: failed.
     */
    @Override
    public boolean crawlIndex() {

        LocalCommandExecutorImpl localCommandExecutor = new LocalCommandExecutorImpl();

        // splice the commend sentence.
        String commend = "cmd.exe /c " +
                         "cd " + projectDir + " && " +
                         "scrapy crawl " + spiderName;

        // do thead(time) times.
        for (int i = 0; i < thead; i++) {
            // execute the commend.
            ExecuteResult executeResult = localCommandExecutor.executeCommand(commend, timeout);
            if (executeResult.getExitCode() == -1) {
                return false;
            }
            logger.info(executeResult.getExecuteOut());
        }
        return true;
    }

    /**
     * @Description: crawl the comment page.
     * @return true: succeed; false: failed.
     */
    @Override
    public boolean crawlComment(String commentId) {

        LocalCommandExecutorImpl localCommandExecutor = new LocalCommandExecutorImpl();

        // splice the commend sentence.
        String commend = "cmd.exe /c " +
                "cd " + projectDir + " && " +
                "scrapy crawl " + spiderName +
                " -a mid=" + commentId;

        // execute the commend sentence.
        ExecuteResult executeResult = localCommandExecutor.executeCommand(commend, timeout);
        if (executeResult.getExitCode() == -1) {
            return false;
        }
        logger.info(executeResult.getExecuteOut());
        return true;
    }
}
