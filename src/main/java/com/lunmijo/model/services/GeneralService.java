package com.lunmijo.model.services;

import com.lunmijo.model.connection.PostgreSQLConnection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneralService {

    private GeneralService() { }

    /**
     * @param statement SQL statement
     * @return ResultSet
     */
    public static ResultSet executeQueryWithResult(String statement) {
        ResultSet result = null;

        try {
            result = makeStatement()
                    .executeQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param statement SQL statement
     */
    public static void executeQueryWithoutResult(String statement) {

        try {
            makeStatement()
                    .execute(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static Statement makeStatement() {
        try {
            return PostgreSQLConnection.getConnection()
                    .createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is generic and it uses Reflection API to get class.
     * @param statement SQL statement
     * @param objClassToReturn object of class you need to be returned
     * @param objClassToCallMethod object of class where makeEntity(ResultSet result) method exists
     * @param <T> objClassToReturn
     * @param <S> objClassToCallMethod
     * @return objClassToReturn
     */
    static <T, S> T readOne(String statement, T objClassToReturn, S objClassToCallMethod) {
        ResultSet result = GeneralService.executeQueryWithResult(statement);
        try {
            Method method = objClassToCallMethod.getClass().getMethod("makeEntity", ResultSet.class);
            return (T) method.invoke(objClassToCallMethod.getClass(), result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    static <T, S> List<T> readFew(String statement, T t, S s) {
        ResultSet result = GeneralService.executeQueryWithResult(statement);
        try {
            ArrayList<T> entityList = new ArrayList<T>();
            while (result.next()) {
                Method method = s.getClass().getDeclaredMethod("makeEntity", ResultSet.class);
                entityList.add((T) method.invoke(s.getClass(), result));
            }
            return entityList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
