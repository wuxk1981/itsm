package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.ServiceItem;

public interface ServiceItemMapper extends BaseMapper<ServiceItem,String>{

	List<ServiceItem> findServiceItemByMap(ServiceItem serviceItem);
}