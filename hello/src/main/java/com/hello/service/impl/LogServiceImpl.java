package com.hello.service.impl;

import com.hello.entity.Log;
import com.hello.service.LogService;
import org.springframework.stereotype.Service;

/**
 * Created by xuan on 2015/12/31.
 */
@Service("logService")
public class LogServiceImpl extends BaseServiceImpl <Log, Integer> implements LogService {

}
