
package dota.config.generated;

import com.google.common.collect.ImmutableList;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 从Classpath加载JSON配置文件.
 */
public class ConfigLoader {
    
    private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .create();
    
    /**
     * 加载JSON数据.
     * @param <T>
     * @param <T>
     * @param cfgClass
     * @return
     * @throws ConfigException 
     */
    public static <T extends BaseConfig> Map<Integer, T> loadConfig(Class<T> cfgClass) throws ConfigException {
        // 根据类名推出文件名：XxxCfg|XxxConfig -> /Xxx.json
        String jsonFileName = "/" + cfgClass.getSimpleName().replaceAll("Cfg", "") + ".json";
        logger.info("Loading JSON: " + jsonFileName);
        
        // 加载JSON数据，并进行后处理
        List<T> cfgs = loadJson(jsonFileName, cfgClass);
        
        Map<Integer, T> resMap = new HashMap<>();
        
        for(T e: cfgs) {
        	resMap.put(e.getId(), e);
        }
        
        return resMap;
    }
    
    // .json => ImmutableList<T>
    private static <T> List<T> loadJson(String jsonFileName, Class<T> cfgClass) throws ConfigException {
        List<JsonObject> jsonObjs = loadJson(jsonFileName);
        ImmutableList.Builder<T> builder = ImmutableList.builder();
        
        for (JsonObject jsonObj : jsonObjs) {
            builder.add(gson.fromJson(jsonObj, cfgClass));
        }
        
        return builder.build();
    }
    
    // .json => List<JsonObject>
    private static List<JsonObject> loadJson(String jsonFileName) throws ConfigException {
        // http://stackoverflow.com/questions/20773850/gson-typetoken-with-dynamic-arraylists-type
        Type type = new TypeToken<ArrayList<JsonObject>>(){}.getType();
        
        try (InputStream is = ConfigLoader.class.getResourceAsStream(jsonFileName);
                InputStreamReader reader = new InputStreamReader(is, "utf-8")) {
            
            return gson.fromJson(reader, type);
        } catch (IOException | RuntimeException e) {
            throw new ConfigException("Failed to parse JSON: " + jsonFileName, e);
        }
    }

}
            
