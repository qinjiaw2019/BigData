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
	ArrayList:
		底层的数据结构是数组,线程不安全,查找速度快,添加删除速度慢.
	LinkedList
		底层数据结构是链表,线程不安全,查找速度慢,添加删除速度快,可以更好的利用内存空间
		链表:单链表,双链表,循环链表(单向循环链表\双向循环链表)
	Vector:
		底层是数组,线程安全的,被ArrayList取代了.

Set:无序不可重复
	HashSet
	TreeSet
	LinkedHashSet
	
List:
	插入:
		void add(int index, E element)  在列表中指定的位置上插入指定的元素。 
		boolean addAll(Collection<? extends E> c)  追加指定集合的所有元素到这个列表的末尾，按他们的指定集合的迭代器返回。
		boolean addAll(int index, Collection<? extends E> c)  将指定集合中的所有元素插入到该列表中，从指定位置开始。 
	删除:
		boolean remove(Object o)  从该列表中移除指定元素的第一个发生，如果它是存在的。
		E remove(int index)  移除此列表中指定位置的元素。 
	查找:
		ListIterator<E> listIterator() 返回列表元素的列表迭代器（在适当的顺序）。 
		ListIterator<E> listIterator(int index)  在列表中的元素上返回列表迭代器（在适当的顺序），从列表中的指定位置开始。 
	注意:再迭代时,迭代器不允许外界对正在操作的集合进行修改,所以再迭代时不能用list.remove这样的方式进行删除,可以用迭代器删除,如iterator.remove();
	取子集:
	subList(int start,int end);

List去重:
通过重写自定义类的equals方法,然后调用list.contains(obj)方法结合去重
		
	
	