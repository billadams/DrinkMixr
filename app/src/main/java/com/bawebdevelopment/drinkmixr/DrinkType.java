package com.bawebdevelopment.drinkmixr;

/**
 * Created by Bill on 3/22/17.
 */

public enum DrinkType
{
    COCKTAIL,
    SHOT,
    MARTINI;

    @Override
    public String toString()
    {
        String s = "";
        if (this.ordinal() == 0)
        {
            s = "Cocktail";
        }
        else if (this.ordinal() == 1)
        {
            s = "Shot";
        }
        else if (this.ordinal() == 2)
        {
            s = "Martini";
        }

        return s;
    }
}
