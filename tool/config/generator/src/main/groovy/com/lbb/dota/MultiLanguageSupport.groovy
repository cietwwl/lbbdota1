package com.lbb.dota

import au.com.bytecode.opencsv.CSVReader

/**
 * 多语言支持.
 */
class MultiLanguageSupport {
	// 
    def textMap = [:]
    
    // 处理多国语言的列
    void handleLanguageColumn(List<String[]> csv, List<ColumnInfo> columnInfos, String fileName) {
        csv = csv.findAll { row ->
            row.length == columnInfos.size()
        }

        // 每一行
        csv.each { String[] row ->
            // 每一列
            (0..<row.length).each { columnIdx ->
                def ci = columnInfos[columnIdx]
                // 多语言列
                if (ci.languageType == 1) {
                    String key = "${fileName}_${ci.csFieldName}_${row[0]}"
                    String value = row[columnIdx]
                    textMap.putAt(key, value)
                    row[columnIdx] = key
                }
            }
        }
     }
    
    // Text文件特殊处理
    void handleLangCsvFile(File csvFile, File outClientCsDir, File outClientJsonDir) {
        List<String[]> csv = CsvHelper.readCsv(csvFile)
        csv.remove(0) // 去掉第一行
        List<String[]> csvHeader = csv.subList(0, 6)
        List<String[]> csvBody = csv.subList(6, csv.size())
        def columns = Csv2ColumnInfo.analyze(csvHeader)

        csvBody.each { row ->
            String key = row[1]
            String value = row[2]
            textMap.putAt(key, value)
        }

        String fileNameWithoutSuffix = csvFile.name.split(/\./)[0]
        String className = fileNameWithoutSuffix + "Cfg"
        File csFile = new File(outClientCsDir, "${className}.cs")
        Csv2Cs.generate(className, columns, csFile)

        generateLangJson(outClientJsonDir)
    }
    
    // 把多国语言表转成JSON
    private generateLangJson(File outClientJsonDir) {
        File jsonFile = new File(outClientJsonDir, "Language_zh.json")
        jsonFile.withWriter("utf-8") { writer ->
            writer.println "["
            
            textMap.eachWithIndex { kv, idx ->
                writer.print "    {"
                writer.print """ "Id": ${idx + 1}, "Key": "${kv.key}", "Value": "${kv.value.replace("\n", "\\n")}" """
                writer.print "}"
                
                if (idx < textMap.size() - 1) {
                    writer.print ","
                }
                
                writer.println ""
            }
            
            writer.println "]"
        }
    }
    
}

