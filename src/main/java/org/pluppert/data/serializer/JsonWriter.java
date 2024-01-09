package org.pluppert.data.serializer;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class JsonWriter {
    private static final JsonWriter INSTANCE;

    static {
        INSTANCE = new JsonWriter();
    }

    private JsonWriter(){}

    public static JsonWriter getInstance() {
        return INSTANCE;
    }
    public void write(List<Object> listToWrite) throws IOException {
        String filePath;
        switch (listToWrite.getFirst().getClass().getSimpleName()) {
            case "AppUser" -> { filePath = "src/main/resources/protocols/app_user.json"; }
            case "Person" -> { filePath = "src/main/resources/protocols/person.json";}
            case "TodoItem" -> { filePath = "src/main/resources/protocols/todo_item.json";}
            case "TodoItemTask" -> { filePath = "src/main/resources/protocols/todo_item_task.json";}
            default -> { filePath = "";}
        }
        Writer writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        gson.toJson(listToWrite, writer);
        writer.close();
    }
}
