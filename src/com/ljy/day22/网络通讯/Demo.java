package com.ljy.day22.网络通讯;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 * 网络通信:三大要素:IP,端口号,协议
 * 1.ip:在网络中唯一的标记一台主机
 *    127.0.0.1 (本地地址/本机地址/保留地址) java中将IP面向对象Inet4Address
 * 2.端口号:用来区分一台主机上的多个服务器(不可以重复) 取值范围0-65535
 *    注意点:在通信时两边的端口号要一致
 * 3.网络协议:
 *    相当于制定的同一的标准
 *    
 *  应用层
 *
 *  与其它计算机进行通讯的一个应用，它是对应应用程序的通信服务的。
 *  例如，一个没有通信功能的字处理程序就不能执行通信的代码，
 *  从事字处理工作的程序员也不关心OSI的第7层。但是，如果添加了一个
 *  传输文件的选项，那么字处理器的程序员就需要实现OSI的第7层。
 *  示例：TELNET，HTTP，FTP，NFS，SMTP等。
 *  
 *  表示层
 *  
 *  这一层的主要功能是定义数据格式及加密。例如，FTP允许你选择以二进制
 *  或ASCII格式传输。如果选择二进制，那么发送方和接收方不改变文件的内容。
 *  如果选择ASCII格式，发送方将把文本从发送方的字符集转换成标准的ASCII后
 *  发送数据。在接收方将标准的ASCII转换成接收方计算机的字符集。示例：加密，ASCII等。
 *  
 *  会话层
 *  
 *  它定义了如何开始、控制和结束一个会话，包括对多个双向消息的控制和管理，
 *  以便在只完成连续消息的一部分时可以通知应用，从而使表示层看到的数据是连续的，
 *  在某些情况下，如果表示层收到了所有的数据，则用数据代表表示层。示例：RPC，SQL等。
 *  
 *  传输层
 *  
 *  这层的功能包括是否选择差错恢复协议还是无差错恢复协议，及在同一主机上对不同
 *  应用的数据流的输入进行复用，还包括对收到的顺序不对的数据包的重新排序功能。
 *  示例：TCP，UDP，SPX。
 *  
 *  网络层
 *  
 *  这层对端到端的包传输进行定义，它定义了能够标识所有结点的逻辑地址，还定义了
 *  路由实现的方式和学习的方式。为了适应最大传输单元长度小于包长度的传输介质，
 *  网络层还定义了如何将一个包分解成更小的包的分段方法。示例：IP，IPX等。
 *  
 *  数据链路层
 *  
 *  它定义了在单个链路上如何传输数据。这些协议与被讨论的各种介质有关。示例：ATM，FDDI等。
 *  
 *  物理层
 *  
 *  OSI的物理层规范是有关传输介质的特性标准，这些规范通常也参考了其他组织制定的标准。
 *  连接头、帧、帧的使用、电流、编码及光调制等都属于各种物理层规范中的内容。
 *  物理层常用多个规范完成对所有细节的定义。示例：Rj45，802.3等。
 *
 * </pre>
 * @author lijiayan_mail@163.com
 * @createTime 2018年3月27日
 */
public class Demo {
	/*
	 * 10.0.113.222
	 * IP地址
	 * InetAddress
	 */
	public static void main(String[] args) {
		//获取自己的主机
		try {
			InetAddress host = InetAddress.getLocalHost();
			System.out.println(host.getHostName());//主机名
			System.out.println(host.getHostAddress());//IP地址
			
			//获取任意主机的内容
			InetAddress baidu = InetAddress.getByName("www.baidu.com");
			System.out.println(baidu.getHostName());//主机名
			System.out.println(baidu.getHostAddress());//IP地址
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
}
