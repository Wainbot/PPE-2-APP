package com.jeremy.ppe_2.dummy;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Formations {

    @SerializedName("")
    private List<Formation> formations;

    public Formations (List<Formation> formations)
    {
        this.formations = formations;
    }

    public List<Formation> getFormations()
    {
        return formations;
    }

    public void setFormations(Formation formation)
    {
        formations.add(formation);
    }

}