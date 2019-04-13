package com.design_pattern_23.behavior.template.v3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.design_pattern_23.behavior.template.v3.enumType.EnvType;
import com.design_pattern_23.behavior.template.v3.utils.PropertyUtils;

public abstract class CompanyParser extends DataParser {
	private static Logger log = Logger.getLogger(CompanyParser.class);
	
	//template wd field
	static Map<String, String[]> baseFieldMap = new HashMap<String, String[]>();//各维度字段英文名
	static Map<String, String[]> baseFieldNameMap = new HashMap<String, String[]>();//各维度字段中文名
	//only read list base field
	static Map<String, String> listBaseMap;
	//cpws convert field(文档和库字段统一标准化)
	static Map<String, String> cpwsConvertMap;
	//index
	static Map<String, String> pname_list_indexMap;
	static Map<String, String[]> pname_entry_indexMap;
	static Map<String, String> all_list_indexMap;
	static Map<String, String[]> all_entry_indexMap;
	//base evn conf
	static String serviceTime;
	static String source_file_path;
	static String temp_file_path;
	static String result_file_path;
	//wd evn conf
	static String c_allWd;
	static String c_pnameWd;
	static String c_wdOrder;
	//es evn conf
	static double esDangerMemory;
	static long esHealthExaminationTime;
	static String esName;
	static String esIps;
	static int esPort;
	static int oneLevelTime;
	static int twoLevelTime;
	//task queue evn conf 
	static int CAMaxSize;
	static int CIMaxSize;
	static int CAQueue;
	static int CIQueue;
	//mail evn conf
	static String host;
	static String userName;
	static String password;
	static String receiverName;
	//table evn conf TODO
	
	@Override
	protected void readConf(EnvType type) {
		EnvType envType = type;
		if (envType != null) {
			log.info("current env : "+envType);
			readCommonConf();
			System.out.println("common conf is read completed!");
			readEnvConf(envType);
			System.out.println("env conf is read completed!");
			System.out.println("all conf is read completed!");
			System.out.println("");
		}else{
//			System.out.println(""+envType);
		}
	}

	private void readCommonConf() {
		List<String> confNames = new ArrayList<String>();
		//wd + field
		String templateConfName = "./"+confDir+"/wdField.properties";
		//index
		String all_entryConfName = "./"+confDir+"/c_all_entry.properties";
		String all_listConfName = "./"+confDir+"/c_all_list.properties";
		String pname_entryConfName = "./"+confDir+"/c_pname_entry.properties";
		String pname_listConfName = "./"+confDir+"/c_pname_list.properties";
		//获取列表库字段
		String listBaseConfName = "./"+confDir+"/listBaseField.properties";
		//裁判文书当事人信息中，处理文档中字段和库中字段英文名不一致
		String cpws_convertConfName = "./"+confDir+"/convertField.properties";
		confNames.add(templateConfName);
		confNames.add(all_entryConfName);
		confNames.add(all_listConfName);
		confNames.add(pname_entryConfName);
		confNames.add(pname_listConfName);
		confNames.add(listBaseConfName);
		confNames.add(cpws_convertConfName);
		//处理模板字段
		handleTemplate(templateConfName, "c-");
		//校验配置文件
		validatePropertiesArgs(confNames);
		System.out.println("配置文件校验completed!");
		//处理列表、详情索引
		pname_list_indexMap = PropertyUtils.readProp2Map(pname_listConfName);
		all_entry_indexMap = PropertyUtils.readProp2MapArray(all_entryConfName);
		all_list_indexMap = PropertyUtils.readProp2Map(all_listConfName);
		pname_entry_indexMap = PropertyUtils.readProp2MapArray(pname_entryConfName);
		//处理列表库（dsr）查询字段
		listBaseMap = PropertyUtils.readProp2Map(listBaseConfName, "c-");
		//裁判文书当事人信息中，处理文档中字段和库中字段英文名不一致
		cpwsConvertMap = PropertyUtils.readProp2Map(cpws_convertConfName);
		
	}

	private void handleTemplate(String confName, String pre) {
		String key = null;
		String value = null;
		String item = null;
		try {
			Map<String, String> templateMap = PropertyUtils.readProp2Map(confName, pre);
			for(Map.Entry<String, String> entry : templateMap.entrySet()){
				key = entry.getKey();
				value = entry.getValue();
				String[] fieldsArray = value.split(",");
				int len = fieldsArray.length;
				String[] baseFieldArray = new String[len];
				String[] baseFieldNameArray = new String[len];
				for (int i = 0; i < fieldsArray.length; i++) {
					item = fieldsArray[i];
					String[] itemArray = item.split("@");
					if(itemArray.length > 2) throw new RuntimeException();
					baseFieldArray[i] = itemArray[0];
					baseFieldNameArray[i] = itemArray[1];
				}
				baseFieldMap.put(key, baseFieldArray);
				baseFieldNameMap.put(key, baseFieldNameArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("conf file: "+confName+" is error! item:"+item+", key:"+key+", value:"+value);
		}
	}

	private void validatePropertiesArgs(List<String> confNames) {
		boolean vf = true;
		for (String confName : confNames) {
			List<Object> values = PropertyUtils.showValues(confName);
			for(Object object : values){
				String vString = object.toString().trim();
				if (vString.contains("，") || vString.contains(",,") || vString.contains(", ") || vString.contains(" ,")) {
					System.out.println("配置文件:"+confName+",有误,错误行键值:"+object.toString());
					vf = false;
					break;
				}
			}
			if(!vf){
				break;
			}
		}
		if(!vf) throw new IllegalArgumentException("conf is error !");
	}


	private synchronized void readEnvConf(EnvType envType) {
		// TODO Auto-generated method stub
		//env
		String ppt = null;
		if (envType == EnvType.DEV) {
			ppt = "./"+confDir+"/dev/env.properties";
		}else if(envType == EnvType.TEST){
			ppt = "./"+confDir+"/test/env.properties";
		}else if(envType == EnvType.PROD){
			ppt = "./"+confDir+"/prod/env.properties";
		}
		Properties envppt = PropertyUtils.readProp(ppt);
		dealEnvConf(envppt);
	}

	private void dealEnvConf(Properties ppt) {
		serviceTime = ppt.getProperty("serviceDate", "T");
		if (serviceTime.equals("T")) {
			serviceTime = new SimpleDateFormat("yyyyMMdd").format(new Date());
		}
		source_file_path = ppt.getProperty("source_file_path");
		temp_file_path = ppt.getProperty("temp_file_path");
		result_file_path = ppt.getProperty("result_file_path");
		c_allWd = ppt.getProperty("c_allWd","");
		c_pnameWd = ppt.getProperty("c_pnameWd");
//		p_allWd = ppt.getProperty("p_allWd");
//		p_pnameWd = ppt.getProperty("p_pnameWd");
		c_wdOrder = ppt.getProperty("c_wdOrder");
//		p_wdOrder = ppt.getProperty("p_wdOrder");
		esDangerMemory = Double.parseDouble(ppt.getProperty("esDangerMemory","25.6"));
		esHealthExaminationTime = Long.parseLong(ppt.getProperty("esHealthExaminationTime","5000"));
		esName = ppt.getProperty("esName","shunyi-venus");
		esIps = ppt.getProperty("esIps","192.168.35.36,192.168.35.41,192.168.35.42,192.168.35.44,192.168.35.76,192.168.35.38");
		esPort = Integer.parseInt(ppt.getProperty("esPort", "9300"));
		CAMaxSize = Integer.parseInt(ppt.getProperty("CAMaxSize", "5"));
		CIMaxSize = Integer.parseInt(ppt.getProperty("CIMaxSize", "5"));
//		PAMaxSize = Integer.parseInt(ppt.getProperty("PAMaxSize", "5"));
//		PIMaxSize = Integer.parseInt(ppt.getProperty("PIMaxSize", "5"));
		CAQueue = Integer.parseInt(ppt.getProperty("CAQueue", "50"));
		CIQueue = Integer.parseInt(ppt.getProperty("CIQueue", "500"));
//		PAQueue = Integer.parseInt(ppt.getProperty("PAQueue", "500"));
//		PIQueue = Integer.parseInt(ppt.getProperty("PIQueue", "500"));
		oneLevelTime = Integer.parseInt(ppt.getProperty("oneLevelTime", "30"));
		twoLevelTime = Integer.parseInt(ppt.getProperty("twoLevelTime", "1200"));
		host = ppt.getProperty("host", "smtp.exmail.qq.com");
		userName = ppt.getProperty("userName", "ccfwpt@fahai.cc");
		password = ppt.getProperty("password", "CCfwpt36524");
		receiverName = ppt.getProperty("receiverName","hubing@fahai.cc");
	}

	//get cym 
	protected void getCym(){
		System.out.println("获取曾用名信息completed!");
	}
	
	//validate sub class input data
	public List checkData(List datas, String flag) {
		// TODO Auto-generated method stub
		
		return new ArrayList();
	}
	
	
}
