package com.jeremy.ppe_2.dummy;

import com.google.gson.annotations.SerializedName;

public class Formation {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nom")
    private String nom;

    @SerializedName("id_niveau")
    private Integer idNiveau;

    @SerializedName("id_ville")
    private Integer idVille;

    @SerializedName("id_typeformation")
    private Integer idTypeFormation;

    public Formation(Integer id, String nom, Integer id_niveau, Integer id_ville, Integer id_typeformation)
    {
        this.id               = id;
        this.nom              = nom;
        this.idNiveau         = id_niveau;
        this.idVille          = id_ville;
        this.idTypeFormation  = id_typeformation;
    }

    public Integer getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }

    public Integer getIdNiveau()
    {
        return idNiveau;
    }

    public Integer getIdVille()
    {
        return idVille;
    }

    public Integer getIdTypeFormation()
    {
        return idTypeFormation;
    }

    @Override
    public String toString()
    {
        return "Formation [id=" + id + ", nom=" + nom + ", " +
                "id_niveau=" + idNiveau + ", id_ville=" + idVille + ", " +
                "id_typeformation=" + idTypeFormation + "]";
    }
}