package tr.com.nuritiras.recyclercard;

import java.util.ArrayList;

public class Meyveler {
    private String meyveIsmi;
    private int meyveKalori;
    private int meyveResim;

    public Meyveler(){}

    public Meyveler(String meyveIsmi, int meyveKalori, int meyveResim) {
        this.meyveIsmi = meyveIsmi;
        this.meyveKalori = meyveKalori;
        this.meyveResim = meyveResim;
    }

    public String getMeyveIsmi() {
        return meyveIsmi;
    }

    public void setMeyveIsmi(String meyveIsmi) {
        this.meyveIsmi = meyveIsmi;
    }

    public int getMeyveKalori() {
        return meyveKalori;
    }

    public void setMeyveKalori(int meyveKalori) {
        this.meyveKalori = meyveKalori;
    }

    public int getMeyveResim() {
        return meyveResim;
    }

    public void setMeyveResim(int meyveResim) {
        this.meyveResim = meyveResim;
    }

    static public ArrayList<Meyveler> getData(){

        ArrayList<Meyveler> meyvelerList=new ArrayList<Meyveler>();

        String[] meyveler={"Muz","Kiraz","Çilek","Elma"};
        int[] kalori={15,5,30,20};
        int[] resimler={R.drawable.muz,R.drawable.kiraz,R.drawable.cilek,R.drawable.elma};

        for(int i=0;i<meyveler.length;i++){
            Meyveler meyve=new Meyveler(meyveler[i],kalori[i],resimler[i]);
            meyvelerList.add(meyve);
        }

        return meyvelerList;

    }

}
