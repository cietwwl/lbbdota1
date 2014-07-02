package com.lbb.dota

/**
 * 分析CSV，生成ColumnInfo数组.
 */
class Csv2ColumnInfo {
    
    static List<ColumnInfo> analyze(List<String[]> csvHeader) {
        def columnInfos = csvHeader[0].findAll{it}.collect{new ColumnInfo()}
        
        // 分析前6行
        csvHeader.eachWithIndex { String[] row, int rowIdx ->
            columnInfos.eachWithIndex { columnInfo, colIdx ->
                String cell = row[colIdx]
                switch(rowIdx) {
                    case 0:
                        columnInfo.columnName = cell
                        columnInfo.javaFieldName = javaFieldName(columnInfo.columnName)
                        columnInfo.csFieldName = csFieldName(columnInfo.columnName)
                        break
                    case 1:
                        columnInfo.columnType = cell
                        columnInfo.javaFieldType = javaFieldType(columnInfo.columnType)
                        columnInfo.csFieldType = csFieldType(columnInfo.columnType)
                        break
                    case 2:
                    	columnInfo.clientType = (cell == "" ? 0 : cell.toInteger())
                    	break
                    case 3:
                        columnInfo.useType = (cell == "" ? 0 : cell.toInteger())
                        break
                    case 4:
                        columnInfo.languageType = (cell == "" ? 0 : cell.toInteger())
                        break
                    case 5:
                        columnInfo.desc = cell
                        break
                }
            }
        }
   
        columnInfos
    }
    
    // column_name -> columnName
    private static String javaFieldName(String columnName) {
        if (columnName == '') {
            throw new RuntimeException("Empty String!")
        }
        if (!columnName.contains('_')) {
            return columnName
        }
        
        columnName = columnName
            .split("_")
            .collect {CsvHelper.capitalize(it)}
            .join("")
        columnName[0].toLowerCase() + columnName[1..-1]
    }
    
    // column_name -> ColumnName
    private static String csFieldName(String columnName) {
        if (columnName == '') {
            throw new RuntimeException("Empty String!")
        }
//        if (!columnName.contains('_')) {
//            return columnName
//        }
        
        columnName
            .split("_")
            .collect {CsvHelper.capitalize(it)}
            .join("")
    }
    
    private static String javaFieldType(String columnType) {
        switch (columnType) {
            case "string": return "String"
            case "bool"  : return "boolean"
            default: return columnType
        }
    }

    private static String csFieldType(String columnType) {
        //if (columnType == "string") return "String"
        columnType
    }

}

