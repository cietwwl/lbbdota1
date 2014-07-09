package dota.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;


public class FactoryHelper {
	public static Map<String,Object> objectMap = new HashMap<>();
	private static Map<Integer, String> classMap = new HashMap<>();
	
	public static void init() {
		
		try {
			Set<Class<?>> classNames = ClassHelper.getClasses(Class.forName("dota.skill.Skill").getPackage());
			for (Class<?> e: classNames) {
				create(e);
			}
			// System.out.println(classMap);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void load(Class clazz, String str) {
		try {
			Class res = modifyClass(clazz, str);
			Object o = res.newInstance();
			objectMap.put(res.getName(), o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static <X extends Y, Y> void create(Class<X> clazz) throws Exception {
		OPHandler opHandler = clazz.getAnnotation(OPHandler.class);
		if (opHandler != null) {
			classMap.put(opHandler.CODE(), clazz.getName());
		}
	}
	
	private static Class modifyClass(Class clazz, String str) throws Exception {
		CtClass parentClass = ClassPool.getDefault().getCtClass(clazz.getName());
		CtClass resultClass = ClassPool.getDefault().makeClass(parentClass.getName() + str, parentClass);
		
		StringBuilder string =  new StringBuilder();
		string.append("public dota.skill.Skill create(dota.config.generated.SkillCfg config) {\n");
		string.append("switch (config.getSkillType()) {" + "\n");
		
		Iterator<Map.Entry<Integer, String>> it = classMap.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			string.append("case " + entry.getKey() + ":" + "\n");
			string.append("return new " + entry.getValue() + "(config);" + "\n");
		}
		string.append("}\n");
		string.append("System.out.println(\"debug\");");


		//method.
		System.out.println(string.toString());
		string.append("return null; \n}");
		string.append("}");
		CtMethod method = CtMethod.make(string.toString(), resultClass);
		resultClass.addMethod(method);
		return resultClass.toClass();
	}
}
