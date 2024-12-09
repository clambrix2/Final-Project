package com.example.finalproject;

public class Wikiidclass {
   private static Wikiinfo it;

    public Wikiidclass(Wikiinfo t)
    {
        it = t;
    }

    public static Wikiinfo getIt() {
        return it;
    }

    public static void setIt(Wikiinfo i) {
        it = i;
    }
}
