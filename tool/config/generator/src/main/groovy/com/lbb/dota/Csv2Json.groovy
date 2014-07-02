package com.lbb.dota

/**
 * 把CSV转成JSON.
 */
class Csv2Json {
    
    static void generate(List<String[]> csv, List<ColumnInfo> columns, File jsonFile, boolean isServer) {
        // CSV文件的最后几行可能是空行
        csv = csv.findAll { row ->
            row.length == columns.size()
        }
        
        // 按ID排序
        sortById(csv)
        
        // 生成JSON
        jsonFile.withWriter("utf-8") { writer ->
            writer.println "["
            
            for (int i = 0; i < csv.size(); i++) {
                String[] row = csv[i]
                
                writer.print "  {"
                
                def x = ''
                for (int j = 0; j < row.length; j++) {
                    ColumnInfo ci = columns[j]
                    if (ci.useType == 0) {
                        continue
                    }
                    
                    // for server, 去掉客户端列
                    if (isServer && ci.useType == 1) {
                        continue
                    }
                    
                    // for client， 去掉服务器列
                    if (!isServer && ci.useType == 3){
                        continue
                    }
                    
                    String cell = row[j]
                    def val = CsvHelper.getCellString(cell, ci)
                    
                    x += """ "${ci.csFieldName}": ${val}${j<row.length-1 ? ',' : ''}"""
                }
                
                if (x.endsWith(',')) {
                    x = x.substring(0, x.length() - 1)
                }
                
                writer.print x
                writer.println "}${i<csv.size()-1 ? ',' : ''}"
            }
            
            writer.println "]"
        }
    }
    
    // 按ID排序，顺便检查相同ID
    private static void sortById(List<String[]> csv) {
        csv.sort { a, b ->
            int idA = a[0].toInteger()
            int idB = b[0].toInteger()
            if (idA == idB) {
                throw new RuntimeException("Same ID: ${idA}!")
            }
            idA <=> idB
        }
    }
    
}

