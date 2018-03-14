package com.ljy.day13.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型用于方法
 * 
 * @author lijia <br/>
 *         1.方法的返回值,参数与类的泛型保持一致.类的泛型确定了,方法的返回值类型就确定了
 * @see com.ljy.day13.fanxing.Tool <br/>
 *      2.方法属于自己的泛型 3.静态发方法使用泛型
 */
public class FXOnFun {
	public <E> List<E> getList(Class<E> clazz) {
		List<E> list = new ArrayList<>();
		return list;
	}
}
