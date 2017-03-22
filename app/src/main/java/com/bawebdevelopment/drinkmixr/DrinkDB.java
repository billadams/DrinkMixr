package com.bawebdevelopment.drinkmixr;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 3/10/17.
 */

public class DrinkDB
{
    private SQLiteDatabase database;
    private DrinkReaderContract.CocktailSQLiteHelper dbhelper;
    private Drink drink = new Drink();
    private List<Drink> drinkList = { drink.setId(DrinkReaderContract.CocktailSQLiteHelper.COLUMN_ID,
            )};

    // Creates a dummy list of Drink objects to make the application usable without
    // being hooked up to a database.
    public static List<Drink> getAllBeverages()
    {
        ArrayList<Drink> drinkList = new ArrayList<Drink>();

        // Washington Apple
        Drink drink1 = createDrink(1, "Washington Apple", "", "1 oz Sour Apple Schnapps", "1 oz Crown Royal", "", "");
        drinkList.add(drink1);

        // Sex on the Beach
        Drink drink2 = createDrink(2, "Sex on the Beach", "Garnish with a cherry.", "1.5 oz Vodka", "1 oz Peach Schnapps", "Fill remaining with half orange juice/half cranberry juice", "");
        drinkList.add(drink2);

        // Colorado Bulldog
        Drink drink3 = createDrink(3, "Colorado Bulldog", "", "2 oz Vodka", "1 oz Kahlua", "Fill remaining with half n half/Coca-Cola", "");
        drinkList.add(drink3);

        // Moscow Mule
        Drink drink4 = createDrink(4, "Moscow Mule", "Garnish with a lime.", "1.5 oz Vodka", "4 oz Ginger beer", "1/6 oz lime juice", "");
        drinkList.add(drink4);

        // Blue Hawaii
        Drink drink5 = createDrink(5, "Blue Hawaii", "", "3/4 oz Vodka", "3/4 oz Malibu", "1/2 oz blue Curacao", "3 oz. pineapple juice");
        drinkList.add(drink5);

        // Screwdriver
        Drink drink6 = createDrink(6, "Screwdriver", "", "1 3/4 oz Vodka", "3 1/2 oz orange juice", "", "");
        drinkList.add(drink6);

        // Bloody Mary
        Drink drink7 = createDrink(7, "Bloody Mary", "Garnish with celery, green olives, and a pickle.", "1 1/2 oz Vodka", "3 oz Zing Zang Bloody Mary Mix", "", "");
        drinkList.add(drink7);

        // Long Island
        Drink drink8 = createDrink(8, "Long Island Iced Tea", "Garnish with a lemon.", "1/2 oz Vodka", "1/2 oz Gin", "1/2 oz Triple sec", "1/2 oz White rum");
        drinkList.add(drink8);

        // Tequila Sunrise
        Drink drink9 = createDrink(9, "Tequila Sunrise", "Garnish with a cherry", "1 1/2 oz Tequila", "3 oz orange juice", "1/2 oz Grenadine", "");
        drinkList.add(drink9);

        // Margarita
        Drink drink10 = createDrink(10, "Margarita", "Salt rim. Garnish with a lime.", "2 oz Tequila", "1 oz Triple Sec", "3 oz Margarita mix", "");
        drinkList.add(drink10);

        return drinkList;
    }

    public static Drink createDrink(int id, String name, String instructions, String ingredient1, String ingredient2, String ingredient3, String ingredient4)
    {
        Drink drink = new Drink();
        ArrayList<String> ingredients = new ArrayList<String>();

        drink.setId(id);
        drink.setName(name);
        drink.setMixInstructions(instructions);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        drink.setIngredients(ingredients);

        return drink;
    }
}
