package unittest.junittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)  //RunWith表示这个类是一个suite的类
@SuiteClasses({TestA.class, TestCalCulate.class}) //说明这个类中包含哪些测试组件
public class TestSuite {
	/*
	 * 测试原则：
	 * 1、建议创建一个专门的source folder-->test来编写测试类代码
	 * 2、测试类的包应该保持和需要测试的类一致
	 * 3、测试单元中的每一个测试方法都必须可以独立执行，没有顺序
	 *    测试方法之间不能有任何的依赖性
	 */
}
