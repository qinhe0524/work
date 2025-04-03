package com.xk.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.mysql.jdbc.Util;

/**
 * ********************************************************
 * @ClassName: DataCache
 * @Description: TODO(缓存操作)
 * @author NoNo
 * @date 2014-11-4 下午03:28:13
 *******************************************************
 */
@SuppressWarnings("all")
public class DataCache extends SqlSessionDaoSupport{
	private static MemCached cache = MemCached.getInstance();
	protected WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
	protected SqlSessionTemplate sql=(SqlSessionTemplate)wac.getBean("sqlSession");
	protected SqlSession sqlSession=null;
	private static final String sqlSpaceName="Cache";

	/**
	 * ********************************************************
	 * @Title: getCacheObj
	 * @Description: TODO(获取cache整体对像)
	 * @return MemCached
	 * @date 2014-11-1 下午09:57:37
	 ********************************************************
	 */
	public static MemCached getCacheObj(){
		return cache;
	}

    /**
     * ********************************************************
     * @Title: getCache
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @param cacheNames   缓存名
     * @param methodName   方法名
     * @param o
     * @param SearchKey  要搜索的键名
     * @param SearchVl   要搜索的值
     * @return Object
     * @date 2014-11-4 下午05:35:17
     ********************************************************
     */
	public Object getCache(String cacheNames,String methodName,Object o) {
		Object cache_result=cache.get(cacheNames);	//cacheName的名称为AA.BB.CC时，cache_result相当于get("AA");
		if(cache_result==null){
				try {	
					Method[] ms=this.getClass().getMethods();					
				    for(Method m:ms){	
				    	 if(m.getName().equals("getCache"+methodName)){		
				    		 cache_result=m.getParameterAnnotations().length==0?m.invoke(this):m.invoke(this,o);
				    		 break;
				    	  }
				     }		
					cache.add(cacheNames, cache_result);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	    if(cacheNames.indexOf(".")!=-1){
	    	String[] names=cacheNames.split("\\.");	
	    	try {
	        	Map<String,Object> current=(Map<String,Object>)cache_result;
		    	for(int i=1;i<names.length-1;i++){   //AA.BB.CC 从BB开始，因为cache_result就是AA的结果。
		    		if(current.get(names[i])!=null){
		    			current=(Map<String,Object>)current.get(names[i]);
		    		}else{
		    			return new HashMap<String,Object>();	
		    		}
		    	}
		    	cache_result=current.get(names[names.length-1]);
	    	} catch (Exception e) {
				e.printStackTrace();
				return new HashMap<String,Object>();
			}
	    }
		return cache_result!=null?cache_result:null;
	}

	
    /**
     * ********************************************************
     * @Title: getCache
     * @Description: TODO(根据缓存名，参数，搜索键名，搜索值获取缓存)
     * @param key  缓存名 getCache+key是方法名
     * @return Object  
     * @date 2014-11-1 下午09:58:25
     ********************************************************
     */
	public Object getCache(String key,String args,String searchKey,String searchVl){		
		String methodName=key.split("\\.")[0];		
		if(key.startsWith("b_")){  //如果是b_ 开头的，那么就是读取baseinfo的信息			
			args=methodName.replaceFirst("b_", "");
			methodName="baseinfo";	
		}		
		methodName=methodName.substring(0, 1).toUpperCase()+methodName.replaceFirst("\\w",""); 
		return this.getCache(key,methodName,(Object)args);
	}
	
	
	public Object getCache(String key,String searchKey,String searchVl){
		return this.getCache(key, null, searchKey, searchVl);
	}
	/**
	 * ********************************************************
	 * @Title: getCarteButtonCache
	 * @Description: TODO(获取当前菜单下的按钮)
	 * @param key
	 * @param args
	 * @return Object
	 * @date 2014-11-5 上午10:25:40
	 ********************************************************
	 */
	public Object getCarteButtonCache(String key,String args){	
		return this.getCache(key, args, null, null);
	}
	/**
	 * ********************************************************
	 * @Title: getCache
	 * @Description: TODO(这里用一句话描述这个类的作用)
	 * @param key
	 * @return Object
	 * @date 2014-11-4 下午06:11:18
	 ********************************************************
	 */
	
	public Object getCache(String key){
		return this.getCache(key, null, null, null);
	}
	/**
	 * 获取基本信息缓存
	 * @param key
	 * @return
	 */
	public Object getDataCache(String key){
		Object obj=cache.get(key);
		//没获取到数据则查询数据库
		try {
			if (obj==null) {
				List<Map<String,Object>> valList=getSession().selectList("getDataByKeyen");
				if (valList!=null) {
					//临时保存基本数据，归类后便于保存进缓存
					Map<String,Map<String,String>> tmp=new HashMap<String, Map<String,String>>();
					
					for (int i = 0; i < valList.size(); i++) {
						Map<String,Object> tmpMap=valList.get(i);
						Map vltmp=tmp.get(tmpMap.get("CLASS_EN")+"");
						if (vltmp==null) {
							vltmp=new HashMap();
						}
						vltmp.put(tmpMap.get("INFO_EN")+"", tmpMap.get("INFO"));
						tmp.put(tmpMap.get("CLASS_EN")+"", vltmp);
					}
					
					//放进缓存
					for (String keytmp : tmp.keySet()) {
						cache.add(keytmp, tmp.get(keytmp));
					}
					obj=cache.get(key);
				}
			}
//			obj=sortMapByKey((Map) obj);//按Key进行排序
			obj=(Map) obj;//按Key进行排序
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeSession();
		}
		return obj;
	}
	/**
	 ********************************************************* 
	 * @Title: sortMapByKey
	 * @Description: 跟据Key值排序
	 * @return Map<String, String>
	 * @date 2016-3-22
	 ******************************************************** 
	 */
	public static Map<String, String> sortMapByKey(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}

		Map<String, String> sortMap = new TreeMap<String, String>(
				new MapKeyComparator());

		sortMap.putAll(map);

		return sortMap;
	}
	
	/**
	 * ********************************************************
	 * @Title: getCacheBaseinfo
	 * @Description: TODO(根据类CLASS_EN获取信息  )
	 * @param class_en   
	 * @return Map<String,Map<String,Object>>
	 * @date 2014-11-4 下午03:50:05
	 ********************************************************
	 */
	public Map<String,Map<String,Object>> getCacheBaseinfo(String class_en){ //获取基础信息
	
        List<Map<String,Object>> l=getSession().selectList(getSqlName("getDataByKeyen"), class_en);

		closeSession();
		return Utils.listToMap(l, "INFO_EN");
	}	
	/**
	 * ********************************************************
	 * @Title: getCacheBaseinfoClass
	 * @Description: TODO(获取所有类英文、中文信息)
	 * @return Map<String,String>
	 * @date 2014-11-4 下午03:51:12
	 ********************************************************
	 */
	public Map<String,String> getCacheBaseinfoClass(){  //获取基础信息,<类英文，类中文>
		List<Map<String,Object>> l=getSession().selectList(getSqlName("baseinfoClass"));
		closeSession();
        return  Utils.listToMap(l, "CLASS_EN","CLASS_CN");
	}
	/**
	 * 
	 *********************************************************.<br>
	 * [方法] getCacheCarte <br>
	 * [描述] 获取菜单map <br>
	 * [参数] TODO(对参数的描述) <br>
	 * [返回] Map<String,Map<String,Object>> <br>
	 * [时间] 2015-4-7 下午03:45:53 <br>
	 *********************************************************.<br>
	 */
	public List<Map<String, Object>> getCacheCarte(){
		List<Map<String, Object>> carteList = getSession().selectList(getSqlName("getAllList"));
		closeSession();
		return carteList;
	}
	public Map<String, Map<String, Object>> getCacheBackCarte(){
		List<Map<String, Object>> carteList = getSession().selectList(getSqlName("getAllList"));
		closeSession();
		Map<String, Map<String, Object>> IdListMap=CommonUtil.listToMap(carteList, "ID");
		return IdListMap;
	}

	/**
	 * 获取用户缓存
	 * @return
	 */
	public Map<String,Map<String, Object>> getCacheUserInfo(){
		List<Map<String, Object>> list = getSession().selectList(getSqlName("UserInfo"));
		return Utils.listToMap(list, "user_code");
		
	}
	
	/**
	 * 获取代理缓存
	 */
	
	public Map<String,Map<String, Object>> getCacheAgentInfo(){
			List<Map<String, Object>> list = getSession().selectList(getSqlName("AgentInfo"));
			return Utils.listToMap(list, "agent_no");
	}
	

	/**
	 * ********************************************************
	 * @Title: getSession
	 * @Description: TODO(获取sqlSession并打开)
	 * @return SqlSession
	 * @date 2014-11-4 下午03:15:19
	 ********************************************************
	 */
	public SqlSession getSession(){
		this.sqlSession=sql.getSqlSessionFactory().openSession();
		return sqlSession;
	}
	/**
	 * ********************************************************
	 * @Title: closeSession
	 * @Description: TODO(关闭数据连接) void
	 * @date 2014-11-4 下午03:19:35
	 ********************************************************
	 */
	public void closeSession(){
		if(sqlSession!=null) {
			try {
				sqlSession.close();
			}catch ( Exception e){

			}
		}
	}
	/**
	 * ********************************************************
	 * @Title: getSqlName
	 * @Description: TODO(获取执行SQL所需要的格式： 命令空间.SQLID)
	 * @param sqlId
	 * @return String
	 * @date 2014-11-4 下午03:37:14
	 ********************************************************
	 */
	public String getSqlName(String sqlId){
		 return sqlSpaceName+"."+sqlId;
	}
    


	


	
}
