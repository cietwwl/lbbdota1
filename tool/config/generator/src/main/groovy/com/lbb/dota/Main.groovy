package com.lbb.dota

// 根据CSV配置文件生成Java代码、CS代码和JSON

// csv文件类型
CSV_TYPE_CLIENT = 1
CSV_TYPE_SERVER = 2
CSV_TYPE_BOTH   = 3

String csvDir = "../csv"
String outDir = "../generated"
String javaPkg = "dota.config.generated"

// 各种目录
csvClientDir = new File("${csvDir}/client")
csvServerDir = new File("${csvDir}/server")
csvCommonDir = new File("${csvDir}/common")
//csvLangFile  = new File("${csvDir}/language/Language.csv")
outServerJavaDir = new File("${outDir}/server/java/${javaPkg.replace('.', '/')}")
outServerJsonDir = new File("${outDir}/server/json")
outClientCsDir   = new File("${outDir}/client/cs")
outClientCsDir2   = new File("${outDir}/client/cs2")
outClientJsonDir = new File("${outDir}/client/json")

configMap = []

// 多语言支持
multiLangSupport = new MultiLanguageSupport()

// 删除旧文件，生成新文件
deleteGeneratedFiles()
generateFiles()

// 删除之前生成的文件
void deleteGeneratedFiles() {
    [outServerJavaDir, outServerJsonDir, outClientCsDir, outClientCsDir2, outClientJsonDir].each { dir ->
        //println "Making dir: ${dir.canonicalPath}"
        dir.deleteDir()
        dir.mkdirs()
    }
}

// 重新生成各种文件
void generateFiles() {
    csvServerDir.eachFile { csvFile ->
        handleCsvFile(csvFile, CSV_TYPE_SERVER)
    }
    
    csvClientDir.eachFile { csvFile ->
        handleCsvFile(csvFile, CSV_TYPE_CLIENT)
    }
    
    csvCommonDir.eachFile { csvFile ->
        handleCsvFile(csvFile, CSV_TYPE_BOTH)
    }
    
    // multiLangSupport.handleLangCsvFile(csvLangFile, outClientCsDir, outClientJsonDir)
    File javaFile = new File(outServerJavaDir, "GameConfig.java")
    Csv2Java.generateGameConfig(javaFile, configMap)
    File javaFile0 = new File(outServerJavaDir, "ConfigLoader.java")
    Csv2Java.generateConfigLoader(javaFile0)
    File javaFile1 = new File(outServerJavaDir, "BaseConfig.java")
    Csv2Java.generateBaseConfig(javaFile1)
    File javaFile2 = new File(outServerJavaDir, "ConfigException.java")
    Csv2Java.generateConfigException(javaFile2)
}

// 一次处理一个csv文件
void handleCsvFile(File csvFile, def csvType) {
    println "CSV file: ${csvFile.canonicalFile}"
    
    // read file
    List<String[]> csv = CsvHelper.readCsv(csvFile)
    csv.remove(0) // 去掉第一行
    List<String[]> csvHeader = csv.subList(0, 6)
    List<String[]> csvBody = csv.subList(6, csv.size())
    
    String fileNameWithoutSuffix = csvFile.name.split(/\./)[0]
    String className = fileNameWithoutSuffix + "Cfg"
    def columnInfos = Csv2ColumnInfo.analyze(csvHeader)
    //println columns

    // for server
    if (csvType == CSV_TYPE_SERVER || csvType == CSV_TYPE_BOTH) {
        // csv -> java
        File javaFile = new File(outServerJavaDir, "${className}.java")
        //println "Java: ${javaFile.canonicalFile}"
        Csv2Java.generate(className, columnInfos, javaFile)
        
        // csv -> json
        File jsonFile = new File(outServerJsonDir, "${fileNameWithoutSuffix}.json")
        //println "JSON: ${jsonFile.canonicalFile}"
        Csv2Json.generate(csvBody, columnInfos, jsonFile, true)
        
        configMap.add("${className}");
    }
    
    // for client
    if (csvType == CSV_TYPE_CLIENT || csvType == CSV_TYPE_BOTH) {
        // csv -> cs
        File csFile = new File(outClientCsDir, "${className}.cs")
        //println "CS: ${csFile.canonicalFile}"
        Csv2Cs.generate(className, columnInfos, csFile)
		
		File csFile2 = new File(outClientCsDir2, "${className}.cs")
		Csv2Cs2.generate(className, columnInfos, csFile2)
        
        // 处理language列，必须在csv->json之前
       // multiLangSupport.handleLanguageColumn(csvBody, columnInfos, fileNameWithoutSuffix)
        
        // csv -> json
        File jsonFile = new File(outClientJsonDir, "${fileNameWithoutSuffix}.json")
        //println "JSON: ${jsonFile.canonicalFile}"
        Csv2Json.generate(csvBody, columnInfos, jsonFile, false)
    }
    
}
