package com.husq.test.model.proxy.jdkproxy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import org.apache.commons.io.FileUtils;

/*实现功能：通过proxy的newProxyInstance返回代理对象
 * 1,声明一段源码（动态产生代理）
 * 2，编译源码（JDK Compiler(API) ,产生新的类（代理类））
 * 3，将这个类loader到内存当中，产生一个新的对象（代理对象）
 * 4，return 代理对象
 * 
 * */
public class MyProxy {
	public static Object newProxyInstance(Class infce,MyinvocationHandle h) throws Exception{
		String rn = "\r\n";
		String methodStr="";
		for(Method m:infce.getMethods()){
			methodStr += "	@Override "+rn+
			"	public void "+m.getName()+"() {"+rn+
			"try{"+rn+
			"		Method md = "+infce.getName()+".class.getMethod(\""+m.getName()+"\");"+rn+
			"		h.invoke(this,md);"+rn+
			"}catch(Exception e){e.printStackTrace();}"+rn+
			"	}";
		}
		String str = "package com.husq.test.model.proxy.jdkproxy;"+rn+
				"	import com.husq.test.model.proxy.jdkproxy.MyinvocationHandle;"+rn+
				"	import java.lang.reflect.Method;"+rn+
		" public class $MyProxy0 implements "+infce.getName()+" {"+rn+
		"	private MyinvocationHandle h;"+rn+
		"	public $MyProxy0(MyinvocationHandle h) {"+rn+
		"		this.h= h;"+rn+
		"	}"+rn+methodStr+rn+
		"}";
		//产生代理类的Java类
		String filename=System.getProperty("user.dir")+"/bin/com/husq/test/model/proxy/jdkproxy/$MyProxy0.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str);
		
		//编译
		//拿到编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//文件管理器
		StandardJavaFileManager javaFileManager = compiler.getStandardFileManager(null, null, null);
		//获取文件
		Iterable units = javaFileManager.getJavaFileObjects(filename);
		//编译任务
		CompilationTask t = compiler.getTask(null, javaFileManager, null, null, null, units);
		t.call();
		javaFileManager.close();
		
		ClassLoader cl  = ClassLoader.getSystemClassLoader();
		Class c = cl.loadClass("com.husq.test.model.proxy.jdkproxy.$MyProxy0");
		
		Constructor constructor = c.getConstructor(MyinvocationHandle.class);
		return constructor.newInstance(h);
	} 
}
