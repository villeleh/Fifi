package com.example.testing123;

import java.util.ArrayList;

/** Singleton class to hold the list of motivational phrases
 * @author Ville Lehtola
 * @author Jerry Julenius
 * @author Mathias Karhu
 */
public class MotivationText {

    private static MotivationText motiInstance = new MotivationText();

    private ArrayList<String> motiList;

    private MotivationText() { // creates a list and adds motivational strings
        motiList = new ArrayList<String>();
        motiList.add("\"On OK olla OK.\"");
        motiList.add("\"Mikään ei jatku ikuisesti.\"");
        motiList.add("\"Parhaatkin ovat aloittaneet jostakin.\"");
        motiList.add("\"Emme ole syntyneet tänne vain painaaksemme töitä niska limassa, maksaaksemme laskuja ja kuollaksemme sitten pois.\"");
        motiList.add("\"Kaikki järjestyy.\"");
        motiList.add("\"Sinä pystyt!\"");
        motiList.add("\"Joku on aina parempi. Voit silti tehdä asioita.\"");
        motiList.add("\"Älä vertaa omia heikkouksiasi muiden vahvuuksiin.\"");
        motiList.add("\"Elämä ei ole suoritettava projekti vaan nautittava matka.\"");
        motiList.add("\"Kun mikään ei ole varmaa, kaikki on mahdollista.\"");
        motiList.add("\"Live, laugh, love.\"");
        motiList.add("\"Mitä enemmän treenaat, sitä paremmaksi hyvänpuhujaksi tulet.\"");
        motiList.add("\"Jokainen tsäänssi on mahdollisuus.\"");
        motiList.add("\"Kalja tai pari piristää synkkää päivää.\"");
        motiList.add("\"Pysäytä negakela.\"");
        motiList.add("\"Sinun tehtäväsi ei ole vastata kaikkeen, mitä sinulta pyydetään.\"");
        motiList.add("\"Elämä on laiffii.\"");
        motiList.add("\"Just do it.\"");
        motiList.add("\"Jokaiseen päivään on kätketty uusi mahdollisuus.\"");
        motiList.add("\"Olet elämäsi tärkein ihminen.\"");
        motiList.add("\"Uskallus vie eteenpäin.\"");
        motiList.add("\"Tämän päivän tuska on huomisen vahvuus.\"");
    }

    public static MotivationText getInstance() {
        /** returns instance */
        return motiInstance;
    }

    public ArrayList<String> getList() {
        /** returns motilist */
        return motiList;
    }

    public int getLenght(){
        /** returns the size of motilist */
        return this.motiList.size();
    }
}
