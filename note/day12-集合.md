数组:
	可以存储不用类型的数据
	缺点:创建的是一个定值,只能存储固定长度的数据,一旦满了就不能再存了
集合:
	特点:可以存储不同类型的数据,存储空间会随着存储的数据的增大而增大
	有点:可以更加合理的使用内存.
	缺点:只能存放应用数据类型.	
集合分类:
1.Collection
	List(ArrayList,LinkedList,vector)
	Set(HashSet,TreeSet)
3.Map
	HashMap
	TreeMap
	
Collection中定义是整个Collection体系最共性的方法:

Collection<Object> c = new ArrayList<Object>();
1.添加:
	boolean add(E e);在集合的末尾追加
	boolean addAll(Collection<? extends E> c2)  
2.删除:
	boolean remove(Object o)
	boolean removeAll(Collection<?> c2):会遍历c2中的元素并从c中删除该元素.
	void clear():从这个集合中移除所有的元素(可选操作),size = 0.

3.判断:
	boolean contains(Object o)  返回 true如果集合包含指定元素。 
	boolean containsAll(Collection<?> c)  返回 true如果这个集合包含指定集合的所有元素
	isEmpty() 返回 true如果集合不包含任何元素。 
4.获取
	int size()  返回此集合中的元素的数目。
5.转换成数组:当希望将元素集合的长度固定下来
	Object[] toArray()  
	<T> T[] toArray(T[] a)
6.迭代器:
	Iterator<E> iterator()//从集合中获取迭代器 
		Iterator<Object> it = c.iterator();
		while(it.hasNext()) {
			Object object = it.next();
			System.out.println(object);
		}
	注意:迭代器使用了一次全部对象遍历后,不能接着使用,因为指针已经指向集合最后位置了,如果需要再迭代,需要重新获取集合的迭代器.

List:有序可重复
	ArrayList
	LinkedList

Set:无序不可重复
	HashSet
	TreeSet
	LinkedHashSet
	
		
		
		
		
		
	
	