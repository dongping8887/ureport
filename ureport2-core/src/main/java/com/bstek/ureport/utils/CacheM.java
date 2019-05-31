package com.bstek.ureport.utils;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;

/**
 * 
 * @ClassName:  CacheM   
 * @Description:TODO(进程内缓存)   
 * @author: wl
 * @date:   2019年1月8日 下午2:50:24   
 *     
 * @Copyright: 2019 www.rjhcsoft.com Inc. All rights reserved. 
 * 注意：本内容仅限于北京融嘉合创科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class CacheM {
	
	private static Cache cache;
	private static Cache imageCache;
	
	public static Cache getCache() {
		if(cache==null) {
			cache=CacheUtil.newFIFOCache(1000,1000*60*60);   //先进先出缓存;容量大小50000 缓存时间1小时
		}
		return cache;
	}
	
	public static Cache getImageCache() {
		if(imageCache==null) {
			imageCache=CacheUtil.newFIFOCache(100,1000*60*10);   //先进先出缓存;容量大小100 
		}
		return imageCache;
	}
}
