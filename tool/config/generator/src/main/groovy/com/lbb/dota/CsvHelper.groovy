package com.lbb.dota

import au.com.bytecode.opencsv.CSVReader

class CsvHelper {
    
    // 把CSV文件读到内存
    static List<String[]> readCsv(File csvFile) {
        CSVReader reader = new CSVReader(new FileReader(csvFile))
        List<String[]> csv = reader.readAll()
        reader.close()
        csv
    }

    // 首字母大写
    static String capitalize(String word) {
        if (word == '') {
            throw new RuntimeException("Empty String!")
        } else if (word.length() == 1) {
            word[0].toUpperCase()
        } else {
            word[0].toUpperCase() + word[1..-1]
        }
    }
    
    static String getCellString(String cell, ColumnInfo ci) {
        switch (ci.columnType) {
        case 'string': return '"' + cell.replace('\n', '\\n') + '"' // TODO escape "
            case 'int'   : return cell ? cell : '0'
            case 'float' : return getFloatString(cell)
        }
        
        return cell
    }
    
    private static String getFloatString(String cell) {
        if (!cell) {
            return '0'
        }
        if (cell.endsWith('%')) {
            return ''+Float.parseFloat(cell.replace('%', ''))/100
        }
        return cell
    }
    
}

