package com.hello.service.impl;

import com.hello.entity.Resource;
import com.hello.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuan on 16-1-2.
 */
@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl <Resource, Integer> implements ResourceService {

    @Override
    public Map<String, String> getResources() {
        Map<String, String> map = new HashMap<String, String>();
        List<Resource> resources = super.getAll();
        for(Resource resource : resources){
            map.put(resource.getUrl(), resource.getAuthority());
        }
        return map;
    }
}
