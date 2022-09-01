package codeSignal.prep;

import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
 * ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
 * ["Quesadilla", "Chicken", "Cheese", "Sauce"],
 * ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
 * 
 * @param dishes
 */
public class GroupingDishes {
    public static void main(String[] args) {
        var s = new String[][] {
                new String[] { "Salad", "Tomato", "Cucumber", "Salad", "Sauce" },
                new String[] { "Pizza", "Tomato", "Sausage", "Sauce", "Dough" },
                new String[] { "Quesadilla", "Chicken", "Cheese", "Sauce" },
                new String[] { "Sandwich", "Salad", "Bread", "Tomato", "Cheese" },
        };
        var result = solution(s);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    static String[][] solution(String[][] dishes) {
        var map = new TreeMap<String, TreeSet<String>>();
        for (var dish : dishes) {
            // get name of dish
            var name = dish[0];
            // get list of ingredients
            var ingredients = Arrays.copyOfRange(dish, 1, dish.length);
            for (var ingredient : ingredients) {
                // check if we have seen this ingredient before
                if (map.containsKey(ingredient)) {
                    // update the list of ingredients for this ingredient ignoring duplicates
                    map.get(ingredient).add(name);
                } else {
                    var s =new TreeSet<String>();
                    s.add(name);
                    map.put(ingredient, s);
                }
            }
        }
        var res = new ArrayList<ArrayList<String>>();
        for (var key : map.keySet()) {
            var ingredients = map.get(key);
            if (ingredients != null && ingredients.size() > 1) {
                var line = new ArrayList<String>();
                line.add(key);
                line.addAll(ingredients);
                res.add(line);
            }
        }
        return res.stream().map(arr -> arr.toArray(String[]::new)).toArray(String[][]::new);
    }
}
