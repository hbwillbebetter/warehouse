package com.design_pattern_23.behavior.template.v3;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.design_pattern_23.behavior.template.v3.constant.ConstantUtils;
import com.design_pattern_23.behavior.template.v3.enumType.EnvType;

public class AllCompanyParser extends CompanyParser {
	private static Logger log = Logger.getLogger(AllCompanyParser.class);
	private CompanyParser companyParser;//持有父类引用
	private static volatile boolean isConfInit = false;
	
	//所有字段final
	private File srcfile;
	private List datas;
	private final EnvType type;
	private final String startTime;
	private final String endTime;
	private final String timeType;
	private final String searchTypeName;
	private final String serviceTime;
	
	private AllCompanyParser(AllCompanyParserBuilder builder) {
		this.type = builder.type;
		this.startTime = builder.startTime;
		this.endTime = builder.endTime;
		this.timeType = builder.timeType;
		this.searchTypeName = builder.searchTypeName;
		this.serviceTime = builder.serviceTime;
		//初始化配置信息
		if(!isConfInit){
			super.readConf(this.type);
			isConfInit = true;
		}else {
			System.out.println(""+this.getClass().getName()+" is instantiated!");
		}
	}
	//内部静态类
	public static class AllCompanyParserBuilder {
		private final EnvType type;
		private String timeType;
		private String startTime;
		private String endTime;
		private String serviceTime;
		private String searchTypeName;
		
		public AllCompanyParserBuilder(EnvType type, String timeType){
			if(type == null) throw new IllegalAccessError("env parameter is error!");
			this.type = type;
			this.timeType = timeType;
		}
		//执行业务日期
		public AllCompanyParserBuilder serviceTime(String serviceTime){
			this.serviceTime = serviceTime;
			return this;
		}
		//查询开始日期
		public AllCompanyParserBuilder startTime(String startTime){
			this.startTime = startTime;
			return this;
		}
		//查询截止日期
		public AllCompanyParserBuilder endTime(String endTime){
			this.endTime = endTime;
			return this;
		}
		//设置查询方式：全文:all,模糊:pname,精准:party
		public AllCompanyParserBuilder searchTypeName(String searchTypeName){
			this.searchTypeName = searchTypeName;
			return this;
		}
		
		// 返回最终构造的用户对象
		public AllCompanyParser build(){
			AllCompanyParser aParser = new AllCompanyParser(this);
			validateUserObject(aParser);
			return aParser;
		}

		private void validateUserObject(AllCompanyParser aParser) {
			// 基本的验证检查
			// 确保用户对象不违反系统假设
			
		}
	}
	
	@Override
	protected void getInputData() {
		try {
			String pathname = super.temp_file_path+File.separator+ConstantUtils.caFlag+ConstantUtils.joinLine+super.serviceTime+ConstantUtils.joinLine+ConstantUtils.srcfileSufix;
			this.srcfile = new File(pathname);
			this.datas = FileUtils.readLines(this.srcfile, super.charsetName);
			System.out.println("企业全量数据获取completed!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("get inputdata is error!"+e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	protected void checkInputData() {
		this.datas = super.checkData(datas, ConstantUtils.caFlag);
		System.out.println("企业全量数据校验completed!");
		//get cym info
		super.getCym();
		System.out.println("企业曾用名初始化completed!");
		
	}

	@Override
	protected void initEmptyFile() {
		System.out.println("企业全量数据初始化empty文件completed!");
		
	}

	@Override
	protected void processData() {
		System.out.println("企业全量数据正在处理...");
		
		//dateSplit();
		
	}

	@Override
	protected void writeData2File() {
		System.out.println("企业全量数据写入文件completed!");
	}


}
