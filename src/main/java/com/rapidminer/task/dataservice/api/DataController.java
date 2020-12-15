package com.rapidminer.task.dataservice.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rapidminer.task.dataservice.utils.NumberUtils;

@RestController
public class DataController {

  private static final String LABEL = "label";

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(path = "/median", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> median(@RequestBody String contentEntity,
      HttpServletRequest servletRequest) {
    Gson gson = new Gson();
    // TODO validate received data
    JsonArray data = gson.fromJson(contentEntity, JsonArray.class);
    Map<String, Map<String, ArrayList<Double>>> groupedData =
        new HashMap<>();
    // reconstruct the received data grouped by the label, in preparation for mathematical
    // calculations
    data.forEach(elem -> {
      if (elem.isJsonObject()) {
        JsonObject row = elem.getAsJsonObject();
        String label = row.get(LABEL).getAsString();
        // A new label is received, create a new map for it
        if (groupedData.get(label) == null) {
          groupedData.put(label, new HashMap<>());
        }
        row.entrySet().stream()
        // Select numeric fields only for median calculations
        .filter(entry -> entry.getValue().isJsonPrimitive()
            && NumberUtils.isNumeric(entry.getValue().getAsString()))
        .forEach(entry -> {
          ArrayList<Double> attributeValues;
          if (groupedData.get(label).get(entry.getKey()) == null) {
            attributeValues = new ArrayList<>();
          } else {
            attributeValues = groupedData.get(label).get(entry.getKey());
          }
          attributeValues.add(entry.getValue().getAsDouble());
          groupedData.get(label).put(entry.getKey(), attributeValues);
        });
      }
    });

    ArrayList<HashMap<String, Object>> finalResults = new ArrayList<>();
    groupedData.entrySet().forEach(groupEntry -> {
      HashMap<String, Object> row = new HashMap<>();
      row.put(LABEL, groupEntry.getKey());
      groupEntry.getValue().entrySet().forEach(attributeEntry ->
      row.put(attributeEntry.getKey(),
          NumberUtils.findMedian(attributeEntry.getValue().toArray()))
          );

      finalResults.add(row);
    });
    System.out.println(finalResults);

    return ResponseEntity.ok(gson.toJson(finalResults));
  }


}
