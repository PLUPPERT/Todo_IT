package org.pluppert.data.serializer;

import com.google.gson.*;
import org.pluppert.model.AppUser;
import org.pluppert.model.Person;
import org.pluppert.model.TodoItem;
import org.pluppert.model.TodoItemTask;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    private static final JsonReader INSTANCE;

    static {
        INSTANCE = new JsonReader();
    }

    private JsonReader() {}

    public static JsonReader getInstance() {
        return INSTANCE;
    }

    public List read(ObjectType objectType) {
        String filePath;
        List list;
        switch (objectType) {
            case APP_USER -> {
                filePath = "src/main/resources/protocols/app_user.json";
                list = new ArrayList<AppUser>();
            }
            case PERSON -> {
                filePath = "src/main/resources/protocols/person.json";
                list = new ArrayList<Person>();
            }
            case TODO_ITEM -> {
                filePath = "src/main/resources/protocols/todo_item.json";
                list = new ArrayList<TodoItem>();
            }
            case TODO_ITEM_TASK -> {
                filePath = "src/main/resources/protocols/todo_item_task.json";
                list = new ArrayList<TodoItemTask>();
            }
            default -> {
                return new ArrayList<>();
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Reader reader = new FileReader(filePath)) {
            list = gson.fromJson(reader, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
