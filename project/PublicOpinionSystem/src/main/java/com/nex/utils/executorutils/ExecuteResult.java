package com.nex.utils.executorutils;

import lombok.Data;
import lombok.ToString;

/**
 * @Project: PublicOpinionSystem
 * @Package: com.nex.utils.executorutils
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月02日 13:32
 * @version: V1.0
 */

@ToString
@Data
public class ExecuteResult {
    private int exitCode;
    private String executeOut;

    public ExecuteResult(int exitCode, String executeOut) {
        this.exitCode = exitCode;
        this.executeOut = executeOut;
    }
}
