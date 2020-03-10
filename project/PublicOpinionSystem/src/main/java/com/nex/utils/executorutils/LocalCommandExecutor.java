package com.nex.utils.executorutils;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.utils.executorutils
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月02日 13:33
 * @version: V1.0
 */
public interface LocalCommandExecutor {
    ExecuteResult executeCommand(String command, long timeout);
}
