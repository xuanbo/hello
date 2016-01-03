package com.hello.service;

import com.hello.entity.Resource;

import java.util.Map;

/**
 * Created by xuan on 16-1-2.
 */
public interface ResourceService extends BaseService <Resource, Integer> {

    /**
     * 获取权限与资源的map
     * @return
     */
    public Map<String,String> getResources();
}
