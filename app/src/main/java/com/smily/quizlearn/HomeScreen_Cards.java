package com.smily.quizlearn;

public class HomeScreen_Cards {
    public String NameHocPhan;
    public String SLTN;
    public String Onwer;

    public HomeScreen_Cards(String nameHocPhan, String SLTN, String onwer) {
        NameHocPhan = nameHocPhan;
        this.SLTN = SLTN;
        Onwer = onwer;
    }

    public String getNameHocPhan() {
        return NameHocPhan;
    }

    public void setNameHocPhan(String nameHocPhan) {
        NameHocPhan = nameHocPhan;
    }

    public String getSLTN() {
        return SLTN;
    }

    public void setSLTN(String SLTN) {
        this.SLTN = SLTN;
    }

    public String getOnwer() {
        return Onwer;
    }

    public void setOnwer(String onwer) {
        Onwer = onwer;
    }
}
