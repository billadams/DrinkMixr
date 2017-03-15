package com.bawebdevelopment.drinkmixr;

import java.util.List;

/**
 * Created by Bill on 3/9/17.
 */

public class Drink
{
    private int id;
    private String name;
    private String mixInstructions;
    private List<String> ingredients;

    public Drink()
    {
        this.id = 0;
        this.name = "";
        this.mixInstructions = "";
        this.ingredients = null;
    }

    public Drink(int id, String name, String mixInstructions, List<String> ingredients)
    {
        this.id = id;
        this.name = name;
        this.mixInstructions = mixInstructions;
        this.ingredients = ingredients;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
