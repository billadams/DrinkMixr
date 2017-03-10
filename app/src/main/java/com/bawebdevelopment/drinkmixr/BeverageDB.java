package com.bawebdevelopment.drinkmixr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 3/10/17.
 */

public class BeverageDB
{

    public static List<Beverage> getAllBeverages()
    {
        ArrayList<Beverage> drinkList = new ArrayList<Beverage>();
        ArrayList<String> ingredients = new ArrayList<String>();

        // Washington Apple
        ingredients.add("1 oz Sour Apple Schnapps");
        ingredients.add("1 oz Crown Royal");
        Beverage beverage1 = new Beverage("Washington Apple", "", ingredients);
        drinkList.add(beverage1);

        // Sex on the Beach
        ingredients.clear();
        ingredients.add("1.5 oz Vodka");
        ingredients.add("1 oz Peach Schnapps");
        ingredients.add("Fill remaining with half orange juice/half cranberry juice");
        Beverage beverage2 = new Beverage("Sex on the Beach", "", ingredients);
        drinkList.add(beverage2);

        // Colorado Bulldog
        ingredients.clear();
        ingredients.add("2 oz Vodka");
        ingredients.add("1 oz Kahlua");
        ingredients.add("Fill remaining with half n half/Coca-Cola");
        Beverage beverage3 = new Beverage("Colorado Bulldog", "", ingredients);
        drinkList.add(beverage3);

        // Moscow Mule
        ingredients.clear();
        ingredients.add("1.5 oz Vodka");
        ingredients.add("4 oz Ginger beer");
        ingredients.add("1/6 oz lime juice");
        Beverage beverage4 = new Beverage("Moscow Mule", "", ingredients);
        drinkList.add(beverage4);

        // Blue Hawaii
        ingredients.clear();
        ingredients.add("3/4 oz Vodka");
        ingredients.add("3/4 oz Malibu");
        ingredients.add("1/2 oz blue Curacao");
        ingredients.add("3 oz. pineapple juice");
        Beverage beverage5 = new Beverage("Blue Hawaii", "", ingredients);
        drinkList.add(beverage5);

        // Screwdriver
        ingredients.clear();
        ingredients.add("1 3/4 oz Vodka");
        ingredients.add("3 1/2 oz orange juice");
        Beverage beverage6 = new Beverage("Screwdriver", "", ingredients);
        drinkList.add(beverage6);

        // Bloody Mary
        ingredients.clear();
        ingredients.add("1 1/2 oz Vodka");
        ingredients.add("3 oz Zing Zang Bloody Mary Mix");
        Beverage beverage7 = new Beverage("Bloody Mary", "", ingredients);
        drinkList.add(beverage7);

        // Long Island
        ingredients.clear();
        ingredients.add("1/2 oz Vodka");
        ingredients.add("1/2 oz Gin");
        ingredients.add("1/2 oz Triple sec");
        ingredients.add("1/2 oz White rum");
        Beverage beverage8 = new Beverage("Long Island Iced Tea", "", ingredients);
        drinkList.add(beverage8);

        return drinkList;
    }

}
