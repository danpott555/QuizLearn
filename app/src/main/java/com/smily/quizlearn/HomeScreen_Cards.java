package com.smily.quizlearn;

public class HomeScreen_Cards {
    public String nameHocPhan;
    public String sLTN;
    public String owner;

    public HomeScreen_Cards(String nameHocPhan, String sLTN, String owner) {
        this.nameHocPhan = nameHocPhan;
        this.sLTN = sLTN;
        this.owner = owner;
    }

    public String getNameHocPhan() {
        return nameHocPhan;
    }

    public void setNameHocPhan(String nameHocPhan) {
        this.nameHocPhan = nameHocPhan;
    }

    public String getsLTN() {
        return sLTN;
    }

    public void setsLTN(String sLTN) {
        this.sLTN = sLTN;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
