package com.design_pattern_23.creation.prototype.v2;


/**
 * 参考：http://www.cnblogs.com/java-my-life/archive/2012/04/11/2439387.html
 * 登记形式的原型模式----向原型管理器注册或修改原型；取出的时候：从原型管理器按某种方式取（如原型ID）
 * @author B
 *
 */
public class Client {
	public static void main(String[] args) {
		/**
		 * 两种形式的比较
		　　简单形式和登记形式的原型模式各有其长处和短处。
		　　1.如果需要创建的原型对象数目较少而且比较固定的话，可以采取第一种形式。在这种情况下，原型对象的引用可以由客户端自己保存。
		
		　　2.如果要创建的原型对象数目不固定的话，可以采取第二种形式。在这种情况下，客户端不保存对原型对象的引用，这个任务被交给管理员对象。
		      在复制一个原型对象之前，客户端可以查看管理员对象是否已经有一个满足要求的原型对象。如果有，可以直接从管理员类取得这个对象引用；
		      如果没有，客户端就需要自行复制此原型对象。
		      
1.原型模式的优点：
　　原型模式允许在运行时动态改变具体的实现类型。原型模式可以在运行期间，由客户来注册符合原型接口的实现类型，也可以动态地改变具体的实现类型，
看起来接口没有任何变化，但其实运行的已经是另外一个类实例了。因为克隆一个原型就类似于实例化一个类。

2.原型模式的缺点：
　　原型模式最主要的缺点是每一个类都必须配备一个克隆方法。配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类来说不是很难，而对于已经有的类不一定很容易，
特别是当一个类引用不支持序列化的间接对象（InputStream、Thread类、Socket类...---不能实现Serializable接口的类），或者引用含有循环结构的时候。
		 */
		try {
			Prototype p1 = new ConcretePrototype1();
			PrototypeManager.setPrototype("p1", p1);
			//获取原型来创建对象
			Prototype p3 = PrototypeManager.getPrototype("p1").clone();
			if (p3.equals(PrototypeManager.getPrototype("p1"))) {
				System.out.println(true);
			}else {
				System.out.println(false);
			}
			p3.setName("张三");
			System.out.println("第一个实例: "+p3);
			 //有人动态的切换了实现
			Prototype p2 = new ConcretePrototype2();
			PrototypeManager.setPrototype("p1", p2);
			//重新获取原型来创建对象
			Prototype p4 = PrototypeManager.getPrototype("p1").clone();
			p4.setName("李四");
			System.out.println("第二个实例: "+p4);
			//有人注销了这个原型
			PrototypeManager.removePrototype("p1");
			//再次获取原型来创建对象
			Prototype p5 = PrototypeManager.getPrototype("p1").clone();
			p5.setName("王五");
			System.out.println("第三个实例: "+p5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
