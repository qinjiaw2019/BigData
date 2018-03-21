package com.ljy.day18.io流5.filecopy;

/**
 * 文件拷贝测试类
 * <pre>
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月21日
 */
public class Test {
	/**
	 * 拷贝文件测试
	 */
	@org.junit.Test
	public void test() {
		//.代表project目录,即BigData
		String sourcePath = "./src/com/ljy/day18/io流5/filecopy/source/test.txt";
		String targetPath = "./src/com/ljy/day18/io流5/filecopy/target/test_copy.txt";
		boolean reslut = FileUtils.copy(sourcePath, targetPath);
		System.out.println(reslut?"拷贝成功":"拷贝失败");
	}
}
