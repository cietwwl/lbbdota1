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
	private static Map<Integer, String> skillMap = new HashMap<>();
	private static Map<Integer, String> buffMap = new HashMap<>();
	
	public static void init() {
		
		try {
			Set<Class<?>> classNames = ClassHelper.getClasses(Class.forName("dota.skill.Skill").getPackage());
			classNames.addAll(ClassHelper.getClasses(Class.forName("dota.buff.Buff").getPackage()));
			for (Class<?> e: classNames) {
				create(e);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void load(Class<?> clazz, String str) {
		try {
			Class<?> res = generateClass(clazz, str);
			Object o = res.newInstance();
			objectMap.put(res.getName(), o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static <X extends Y, Y> void create(Class<X> clazz) throws Exception {
		OP opHandler = clazz.getAnnotation(OP.class);
		if (opHandler == null) {
			return;
		}
		
		if (opHandler.TYPE() == OP.SKILL) {
			skillMap.put(opHandler.CODE(), clazz.getName());
		} else if (opHandler.TYPE() == OP.BUFF) {
			buffMap.put(opHandler.CODE(), clazz.getName());
		}
	}
	
	private static Class<?> generateClass(Class<?> clazz, String str) throws Exception {
		CtClass parentClass = ClassPool.getDefault().getCtClass(clazz.getName());
		CtClass resultClass = ClassPool.getDefault().makeClass(parentClass.getName() + str, parentClass);
		CtMethod method = null;
		
		if ("Skill".equals(str)) {
			method = CtMethod.make(generateSkillMethod(), resultClass);
		} else {
			method = CtMethod.make(generateBuffMethod(), resultClass);
		}
		
		resultClass.addMethod(method);
		return resultClass.toClass();
	}
	
	private static String generateBuffMethod() {
		StringBuilder string =  new StringBuilder();
		string.append("public dota.buff.Buff create(dota.config.generated.BuffCfg config) {\n");
		string.append("switch (config.getBuffType()) {" + "\n");

		Iterator<Map.Entry<Integer, String>> it = buffMap.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			string.append("case " + entry.getKey() + ":" + "\n");
			string.append("return new " + entry.getValue() + "(config);" + "\n");
		}
		string.append("}\n");
		string.append("System.out.println(\"debug\");");
		string.append("return null; \n}");
		string.append("}");
		return string.toString();
	}
	
	private static String generateSkillMethod() {
		StringBuilder string =  new StringBuilder();
		string.append("public dota.skill.Skill create(dota.config.generated.SkillCfg config) {\n");
		string.append("switch (config.getSkillType()) {" + "\n");

		Iterator<Map.Entry<Integer, String>> it = skillMap.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			string.append("case " + entry.getKey() + ":" + "\n");
			string.append("return new " + entry.getValue() + "(config);" + "\n");
		}
		string.append("}\n");
		string.append("System.out.println(\"debug\");");
		string.append("return null; \n}");
		string.append("}");
		return string.toString();
	}
}
