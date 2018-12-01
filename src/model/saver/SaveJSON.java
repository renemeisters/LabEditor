package model.saver;

import model.Kachel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveJSON implements Save {

    @Override
    public void save(String fname, ArrayList<Kachel> kacheln) {
        fname = fname+".json";
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        //JSONObject colors = new JSONObject();
        //JSONObject colors = new JSONObject();
        int i = 0;

        for(Kachel kachel : kacheln){
            arr.add(kachel.getX());
            arr.add(kachel.getY());
            arr.add(kachel.getColor());
            obj.put(i,arr.toJSONString());
            i++;
            arr.clear();
        }
        try (FileWriter file = new FileWriter(fname)) {
            file.write(obj.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
