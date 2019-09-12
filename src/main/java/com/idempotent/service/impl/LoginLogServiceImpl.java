package com.idempotent.service.impl;

import com.idempotent.pojo.LoginLog;
import com.idempotent.service.LoginLogService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-09-12 16:58
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Override
    public void insert(LoginLog loginLog) {

    }

    @Override
    public LoginLog selectByMsgId(String msgId) {
        return null;
    }
}
