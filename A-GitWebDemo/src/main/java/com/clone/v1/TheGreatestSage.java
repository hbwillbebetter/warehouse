package com.clone.v1;

/**
 * 参考：http://www.cnblogs.com/java-my-life/archive/2012/04/11/2439387.html
 * @author B
 *
 */
public class TheGreatestSage {
	//大圣本尊
    private Monkey monkey = new Monkey();
    
    public void change(){
        //克隆大圣本尊
        Monkey copyMonkey = (Monkey)monkey.clone();
        System.out.println("大圣本尊的生日是：" + monkey.getBirthDate());
        System.out.println("克隆的大圣的生日是：" + copyMonkey.getBirthDate());
        System.out.println("大圣本尊跟克隆的大圣是否为同一个对象 " + (monkey == copyMonkey));
        System.out.println("大圣本尊持有的金箍棒 跟 克隆的大圣持有的金箍棒是否为同一个对象？ " + (monkey.getStaff() == copyMonkey.getStaff()));
    }
    
    public static void main(String[]args){
        TheGreatestSage sage = new TheGreatestSage();
        sage.change();
    }
/**
 * 运行结果：
 * 大圣本尊的生日是：Thu May 23 16:40:45 CST 2019
克隆的大圣的生日是：Thu May 23 16:40:45 CST 2019
大圣本尊跟克隆的大圣是否为同一个对象 false
大圣本尊持有的金箍棒 跟 克隆的大圣持有的金箍棒是否为同一个对象？ true

1.可以看出，首先，复制的大圣本尊具有和原始的大圣本尊对象一样的birthDate，而本尊对象不相等，这表明他们二者是克隆关系；
其次，复制的大圣本尊所持有的金箍棒和原始的大圣本尊所持有的金箍棒为同一个对象。这表明二者所持有的金箍棒根本是一根，而不是两根。

2.正如前面所述，继承自java.lang.Object类的clone()方法是浅克隆。换言之，齐天大圣的所有化身所持有的金箍棒引用全都是指向一个对象的，
这与《西游记》中的描写并不一致。要纠正这一点，就需要考虑使用深克隆。

为做到深度克隆，所有需要复制的对象都需要实现java.io.Serializable接口。





 */
}
