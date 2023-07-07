package com.smily.quizlearn;

public class AddScreen_Rcv_CardToAdd {
    public int Stt;
    public String DN;
    public String TN;

    public AddScreen_Rcv_CardToAdd(int stt, String DN, String TN) {
        Stt = stt;
        this.DN = DN;
        this.TN = TN;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int stt) {
        Stt = stt;
    }

    public String getDN() {
        return DN;
    }

    public void setDN(String DN) {
        this.DN = DN;
    }

    public String getTN() {
        return TN;
    }

    public void setTN(String TN) {
        this.TN = TN;
    }
}
