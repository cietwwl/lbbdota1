package com.lbb.dota

/**
 * CSV列信息.
 */
class ColumnInfo {
    
    String columnName   // 列名
    String columnType   // 列对应的数据类型
    int    clientType   // 列对应的客户端数据类型
    int    useType      // 列对应的使用类型，0，忽略，1，客户端，2，both, 3，服务器
    int    languageType // 多国语言类型，1，需要翻译  
    String desc         // 描述
    
    String javaFieldName
    String javaFieldType
    String csFieldName
    String csFieldType
	
}

