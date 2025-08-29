package com.bajaj.bfhl;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class BFHLController {

    @PostMapping("/bfhl")
    public Map<String, Object> processData(@RequestBody Map<String, Object> request) {
        List<String> inputList = (List<String>) request.get("data");

        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> alphabetList = new ArrayList<>();
        List<String> specialChars = new ArrayList<>();

        int total = 0;

        
        for (String item : inputList) {
            if (item.matches("\\d+")) {
                int number = Integer.parseInt(item);
                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
                total += number;
            } else if (item.matches("[a-zA-Z]+")) {
                alphabetList.add(item.toUpperCase());
            } else {
                specialChars.add(item);
            }
        }

        
        StringBuilder letters = new StringBuilder();
        for (String str : inputList) {
            if (str.matches("[a-zA-Z]+")) {
                letters.append(str);
            }
        }

        
        StringBuilder concatBuilder = new StringBuilder();
        int index = 0;
        for (int i = letters.length() - 1; i >= 0; i--) {
            char ch = letters.charAt(i);
            if (index % 2 == 0) {
                concatBuilder.append(Character.toUpperCase(ch));
            } else {
                concatBuilder.append(Character.toLowerCase(ch));
            }
            index++;
        }

        
        Map<String, Object> response = new HashMap<>();
        response.put("is_success", true);
        response.put("user_id", "Anjali_Satish_Gawade_27072004");   
        response.put("email", "anjaligawade2020@gmail.com");
        response.put("roll_number", "22BCE2096");
        response.put("odd_numbers", oddNumbers);
        response.put("even_numbers", evenNumbers);
        response.put("alphabets", alphabetList);
        response.put("special_characters", specialChars);
        response.put("sum", String.valueOf(total));
        response.put("concat_string", concatBuilder.toString());

        return response;
    }
}