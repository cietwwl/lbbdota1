package com.lbb.dota

/**
 * 把Excel表单转成Lua Table
 */
class Sheet2Lua {
    
//    static void generate(Sheet sheet, List<ColumnInfo> columns, File luaFile) {
//        luaFile.withWriter("utf-8") { writer ->
//            writer.println "{"
//            
//            for (int i = 5; i < sheet.lastRowNum; i++) {
//                Row row = sheet.getRow(i)
//                
//                writer.print "  {"
//                for (int j = 0; j < row.lastCellNum; j++) {
//                    ColumnInfo ci = columns[j]
//                    Cell cell = row.getCell(j)
//                    def val = SheetHelper.getCellString(cell, ci)
//                    
//                    writer.print """ ${ci.columnName}=${val},"""
//                }
//                writer.println "},"
//            }
//            
//            writer.println "}"
//        }
//    }
    
}

