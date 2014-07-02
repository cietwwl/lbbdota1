
package  dota.config.generated;

import java.lang.reflect.Method;

/**
 * 所有自动生成的配置类的超类.
 * 实现Comparable接口是为了能够使用二分法查找。
 * @see ConfigSearchAlgorithm.BINARY_SEARCH
 */
public abstract class BaseConfig implements Comparable<Integer> {
    
    // 配置表ID（每个配置表的第一列必须为ID列）
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Integer id) {
        return Integer.compare(this.id, id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id;
    }
    
    // 用反射取int字段
    public int getIntField(String fieldName) {
        return (Integer) getFieldValue(fieldName);
    }
    
    // 用反射取String字段
    public String getStringField(String fieldName) {
        return (String) getFieldValue(fieldName);
    }
    
    // 用反射获取字段值
    private Object getFieldValue(String fieldName) {
        try {
            String getterName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method getter = getClass().getMethod(getterName);
            getter.setAccessible(true);
            return getter.invoke(this);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("getIntField() failed!", e);
        }
    }
    
}

            
