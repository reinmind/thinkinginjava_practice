package annotation.database.processor;

import annotation.database.Constraints;
import annotation.database.DBTable;
import annotation.database.SQLInteger;
import annotation.database.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zx
 */
public class TableCreator {
    public String createTable(String clsName){
        Class<?> cls = null;
        try {
            cls = Class.forName(clsName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBTable dbTable= cls.getAnnotation(DBTable.class);
        if(dbTable == null){
            System.out.println("No DBTable annotations in " + clsName );
        }
        String tableName = dbTable.name();
        if(tableName.length() < 1){
            //没名字粑粑给你取
            tableName = cls.getName().toUpperCase();
        }
        List<String> columnDefs = new ArrayList<>();
        for(Field field : cls.getDeclaredFields()){
            String columnName = null;
            Annotation[] annotations = field.getDeclaredAnnotations();
            if(annotations.length < 1) {
                continue;
            }
            if(annotations[0] instanceof SQLInteger){
                SQLInteger sqlInteger = (SQLInteger) annotations[0];
                if(sqlInteger.name().length() < 1){
                    columnName = field.getName().toUpperCase();
                }
                else{
                    columnName = sqlInteger.name();
                }
                columnDefs.add(columnName + " INT " + getConstrains(sqlInteger.constrains()));
            }
            if(annotations[0] instanceof SQLString){
                SQLString sqlInteger = (SQLString) annotations[0];
                if(sqlInteger.name().length() < 1){
                    columnName = field.getName().toUpperCase();
                }
                else{
                    columnName = sqlInteger.name();
                }
                columnDefs.add(columnName + " VARCHAR(" + sqlInteger.value() + ")" +getConstrains(sqlInteger.constrains()));
            }
        }
        StringBuilder createCommand = new StringBuilder(
                "CREATE TABLE " + tableName + "(");
        for(String columnDef : columnDefs){
            createCommand.append("\n " + columnDef + ",");
        }
        String tableCreate = createCommand.substring(0,createCommand.length() - 1) + ");";

        return tableCreate;
    }
    private static String getConstrains(Constraints con){
        String constraints = "";
        if(!con.allowNull()){
            constraints += " NOT NULL ";
        }
        if(con.primaryKey()){
            constraints += " PRIMARY KEY ";
        }
        if(con.unique()){
            constraints += " UNIQUE ";
        }
        return constraints;
    }
}
