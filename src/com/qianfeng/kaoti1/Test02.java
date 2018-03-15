package com.qianfeng.kaoti1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Test02 {
	
	public static void main(String[] args) {
		//1.创建公司
		Company baidu = companyFactory("1001", "百度", 2000, "李彦宏", "全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求。百度超过千亿的中文网页数据库，可以瞬间找到相关的搜索结果");
		Company tengxun = companyFactory("1010", "腾讯", 10000, "马化腾", "深圳市腾讯计算机系统有限公司成立于1998年11月，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立。是中国最大的互联网综合服务提供商之一，也是中国服务用户最多的互联网企业之一");
		Company alibaba = companyFactory("1020", "阿里巴巴", 20000, "马云","阿里巴巴网络技术有限公司（简称：阿里巴巴集团）是由曾担任英语教师的马云为首的18人，于1999年在中国杭州创立，他们相信互联网能够创造公平的竞争环境，让小企业通过创新与科技扩展业务，并在参与国内或全球市场竞争时处于更有利的位置");
		Company jindong = companyFactory("1050", "京东", 8000, "刘强东", "京东（JD.com）是中国最大的自营式电商企业，2015年第一季度在中国自营式B2C电商市场的占有率为56.3%。目前，京东集团旗下设有京东商城、京东金融、拍拍网、京东智能、O2O及海外事业部");
		Company xiaomi = companyFactory("1030", "1030", 5000, "雷军", "小米公司成立于2010年4月，是一家专注于智能产品自主研发的移动互联网公司。’为发烧而生’是小米的产品概念。小米公司首创了用互联网模式开发手机操作系统、发热友参与开发改进的模式");
		
		//添加到Map中
		Map<Company, String>map = new TreeMap<>(new Comparator<Company>() {

			@Override
			public int compare(Company c1, Company c2) {
				int no = c1.getNo().compareTo(c2.getNo());
				int name = c1.getName().compareTo(c2.getName());
				int founder = c1.getFounder().compareTo(c2.getFounder());
				int num = c1.getNum()-c2.getNum();
				return no!=0?no:name!=0?name:founder!=0?founder:num;
			}
		});
		map.put(baidu, "努力做外卖的广告公司！");
		map.put(tengxun, "一直在模仿,从来不自创,模仿一个超越一个");
		map.put(alibaba, "十个商家九个刷还有一个搞批发");
		map.put(jindong, "打着正品的旗号卖淘宝档次的商品");
		map.put(xiaomi, "为发烧而生！");

		Set<Entry<Company,String>> set = map.entrySet();
		Iterator<Entry<Company, String>> iterator = set.iterator();
		while(iterator.hasNext()){
			Entry<Company, String> next = iterator.next();
			Company company = next.getKey();
			String comm = next.getValue();
			System.out.println(company.toString()+"\t 评价:"+comm);
		}
		
		FileOutputStream fis = null;
		ObjectOutputStream os = null;
		Set<Company> keySet = map.keySet();
		try {
			fis = new FileOutputStream(
					"F:\\\\work\\\\java\\\\eclipseProjects\\\\BigData\\\\src\\\\com\\\\qianfeng\\\\kaoti1\\randomArray.txt",true);
			os = new ObjectOutputStream(fis);

			for (Company com : keySet) {
				os.writeObject(com);
			} 
			os.flush();
			fis.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static Company companyFactory(String no,String name,int num,String founder,String info) {
		Company company = new Company();
		company.setNo(no);
		company.setNum(num);
		company.setName(name);
		company.setFounder(founder);
		company.setInfo(info);
		return company;
	}
}
