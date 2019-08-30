package com.ahmed.gamal.matchatak;

import android.util.SparseArray;

public class Const {
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String BASE_URL = "https://api.football-data.org/v2/";


    public static String getImageUrl(int id) {

        SparseArray<String> array = new SparseArray<>();
        array.put(2013, "https://www.thesportsdb.com/images/media/league/badge/0206v41534575321.png");
        array.put(2021, "https://www.thesportsdb.com/images/media/league/badge/i6o0kh1549879062.png");
        array.put(2016, "https://www.thesportsdb.com/images/media/league/badge/m7urjx1535732496.png");
        array.put(2018, "https://www.thesportsdb.com/images/media/league/badge/el53xu1551733974.png");
        array.put(2001, "https://www.thesportsdb.com/images/media/league/badge/dtp1dl1534767233.png");
        array.put(2015, "https://www.thesportsdb.com/images/media/league/badge/8f5jmf1516458074.png");
        array.put(2002, "https://www.thesportsdb.com/images/media/league/badge/0j55yv1534764799.png");
        array.put(2019, "https://www.thesportsdb.com/images/media/league/badge/ocy2fe1566216901.png");
        array.put(2003, "https://www.thesportsdb.com/images/media/league/badge/ywoi5k1534590331.png");
        array.put(2017, "https://www.thesportsdb.com/images/media/league/badge/cplp641535733210.png");
        array.put(2014, "https://www.thesportsdb.com/images/media/league/badge/7onmyv1534768460.png");
        array.put(2000, "https://www.thesportsdb.com/images/media/league/badge/jn3m4c1533806598.png");

        return array.get(id);

    }
}
