package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *    ���̺귯�� VS �����ӿ�ũ 
 *    
 *    => ���̺귯�� (�ڹ�,Jsoup...)
 *       : ���� ���Ǵ� ����� ��Ƽ� �̸� ������ �� Ŭ������ ����
 *         �����Ӱ� ����� �� �ִ�  
 *    => �����ӿ�ũ 
 *       : ���߿� �ʿ��� ����� �̸� �����ص� Ŭ������ ����
 *         => �⺻ Ʋ�� ������� �ִ� (Ʋ�ȿ����� ����� ����)
 *            ====== XML / Annotation 
 *    => ��ǥ���� �����ӿ�ũ 
 *       1. MyBatis 
 *       2. Ajax,Vue , React => �̹� ������ ������� �ִ�  
 *       3. Spring / Spring-Boot 
 *    => ���� 
 *       = �⺻ Ʋ(����)�� ������� �ֱ� ������ ǥ��ȭ�� �Ǿ� �ִ� 
 *         => ���� �������� ���� : �ѹ� �ͼ��� ���� ����� ���ϴ� 
 *                             =========================
 *                              ���������ÿ� �������� ������ ���� 
 *       = ���� �Ⱓ�� ���� 
 *       = ������谡 �ܼ��Ѵ� 
 *         ==============
 *    => ���� 
 *       = ����� ���� (��ü�� ����� ��ƴ�) 
 *         String-Boot 
 *         String Framework 
 *         String Security 
 *         String Betch 
 *         String Data 
 *         String Cloud 
 *         ===========================
 *       = ���̴� (���� �ӵ��� ������) 
 *       = �н��ؾߵǴ� ���̺귯���� ���� ���� 
 *   ==================================== ���� (�ڹ�,JSP,DB) 
 *   Spring���� ���Ǵ� ��� �غ�
 *   1) Database
 *        JDBC / ORM 
 *               === ������ �����ͺ��̽� : MyBatis / JPA / Hibernate 
 *                                    ============== 
 *   2) Web : MVC => Controller�� �̹� ���� 
 *   3) Core  
 *       �������� Ŭ���� ������ (�����̳�)
 *                   =====
 *                    ���� / �Ҹ� => ��ü�� �����ֱ� ���� 
 *       => Container : Ŭ������ ��Ƽ� ����  
 *          ������ ��� (Ŭ����) : VOŬ������ �������� (����� ���� ��������) => ���� ��󿡼� ���� 
 *          =========
 *           1) �������� ���Ŀ� �°� ��� (���� ����)
 *              = Ŭ���� ��� 
 *                = XML�� �̿� => Spring 4 / Spring 5=> �ڹ� �̿� 
 *                  <bean id="aa" class="com.sist.main.AA">
 *                      map.put("aa",new AA())
 *                      AA a=map.get("aa")
 *                   ======================= �ǹ����� ���� ��� 
 *                = @Bean("aa")
 *                  public AA aa()
 *                  {
 *                     return new AA()
 *                  }
 *                = ������̼� �̿� 
 *                @Component("a")
 *                          ===== id
 *                class A
 *                {
 *                }
 *          XML/Annotation�� �о Container�� ���� 
 *          ====================================
 *                         | => Spring
 *                    ����� Ŭ�������� ���� 
 *          1. Container�� ���� 
 *          ================== Ŭ������ �޸� �Ҵ� (��ü ����) 
 *                             ��ü ã�� => getBean("id")
 *                             ��ü �Ҹ� 
 *                     BeanFactory : Core => DI (��ü ���� / �Ҹ� / �ʱ�ȭ)
 *                          |
 *                   ApplicationContext : Core / AOP
 *                          | ============ WebApplicationContext
 *                                          Core/AOP/MVC
 *            -----------------------------------
 *            |                                 |
 *     AnnotationConfigApplicationContext   GenericXmlApplicationContext
 *         Core / AOP / Annotation             Core / AOP / CLOSE
 *         
 *         1. �Ϲ� ������ => ApplicationContext 
 *         2. �� => WebApplicationContext
 *         3. ������̼� => AnnotationConfigApplicationContext
 *         =================================================
 *            => Ŭ���� ��� => �ʿ�ø��� ��ϵ� Ŭ������ ã�Ƽ� ��� => �ʿ䰡 ���� ��쿡�� �Ҹ�
 *                                                             System.gc()
 *       => DI => Setter / Constructor / Method 
 *          �������� ���ؼ� => ��������� �ʱ�ȭ 
 *       => AOP => ���� ��� (���������� ����ϴ� ����� ��Ƽ� �ڵ� ȣ��)
 *       
 *       class A
 *       {
 *       }
 *       class B
 *       {
 *       }
 *       class C
 *       {                                  �����̳� 
 *       }                           =======================
 *                                      id       class
 *                                   =======================
 *       <bean id="a" class="A">        a        new A()
 *       <bean id="b" class="B">        b        new B()
 *       <bean id="c" class="C">        c        new C()
 *                                   =======================
 *                                   
 *                             ||
 *                       A  aa = �����̳�.getBean("a")
 *                                             ===== id��
 *                       => System.gc() => �޸� ���� 
 *       �����ֱ� 
 *       1. class�б� 
 *       2. Ŭ���� �޸� �Ҵ� 
 *       3. setter�� �̿��ؼ� �ʱ�ȭ
 *       ================================ Spring 
 *       4. ������ ��� : ��� Ŭ���� ã�� 
 *       ================================ ������ ���
 *       5. ����� Ŭ���� �޸� ���� 
 *       ================================ Spring 
 *       
 *       class Board
 *       {
 *           public void insert(){}
 *           public void list(){}
 *           public void detail(){}
 *           public void update(){}
 *           public void delete(){}
 *       }
 *       
 *       
 *       DI  : ��� Ŭ������ ���� 
 *             �ʱ�ȭ 
 *              = setter DI
 *              = ������ DI 
 *              = method DI => ��ü ������   / ��ü �Ҹ�� 
 *                             init-method  destory-method 
 *       AOP : Transaction / Security
 *       
 *       ORM : �����ͺ��̽� ���� : MyBatis 
 *       MVC : WEB
 *       =================================================
 */
// ��ü ���� 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. �����̳ʿ� XML�Ľ� ��û 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
		// 2. �ʿ��� ��ü�� ��û 
		Board b=(Board)app.getBean("board");
		System.out.println("b="+b);
		b.list();
		b.insert();
		Board b1=app.getBean("board",Board.class); // ���׸� => �ڵ� ����ȯ 
		System.out.println("b1="+b1);
		// 3. �ʿ信 ���� �޼ҵ� ȣ���Ŀ� ��� : �̱��� = �Ѱ��� �޸��ּҸ� �̿��ؼ� ����
		b1.list();
		b1.insert();
	}

}
