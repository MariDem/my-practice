package by.marina.service;

import by.marina.DB.DataProvider;
import by.marina.DB.DemoEntity;
import by.marina.DB.UserProvider;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DataService {
    private final DataProvider dataProvider;
    private final Gson gson;

    public DataService() {
        dataProvider = new DataProvider();
        gson = new Gson();
    }

    public List<DemoEntity> getAllEntitiesForResponse() throws IOException {
        List<DemoEntity> entities = new ArrayList<>();
        try {
            entities = dataProvider.getAllEntities();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return entities;
    }

    public void addEntity(String name, String address) {
        try {
           dataProvider.addEntity(name, address);
        }catch (Exception e){

        }
    }

    public boolean loginProcess(String userName, String password) {
        try {
            return new UserProvider().loginProcess(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}