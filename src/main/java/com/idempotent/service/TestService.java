package com.idempotent.service;

import com.idempotent.common.ServerResponse;
import com.idempotent.pojo.Mail;

public interface TestService {

    ServerResponse testIdempotence();

    ServerResponse accessLimit();

    ServerResponse send(Mail mail);
}
