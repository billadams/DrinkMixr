package com.bawebdevelopment.drinkmixr;

import java.util.List;

/**
 * Created by Bill on 3/9/17.
 */

public class Beverage
{
    private String name;
    private String mixInstructions;
    private List<String> ingredients;

    public Beverage()
    {
        this.name = "";
        this.mixInstructions = "";
        this.ingredients = null;
    }


    public Beverage(String name, String mixInstructions, List<String> ingredients)
    {
        this.name = name;
        this.mixInstructions = mixInstructions;
        this.ingredients = ingredients;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMixInstructions()
    {
        return mixInstructions;
    }

    public void setMixInstructions(String mixInstructions)
    {
        this.mixInstructions = mixInstructions;
    }

    public List<String> getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients)
    {
        this.ingredients = ingredients;
    }
}
