package com.packtpub.temps;

public class SummerHigh {
    private City base;
    private City moderateCuts;
    private City noCuts;


    public SummerHigh(City base, City moderateCuts, City noCuts) {
        this.base = base;
        this.moderateCuts = moderateCuts;
        this.noCuts = noCuts;
    }

    public City getBase() {
        return base;
    }

    public void setBase(City base) {
        this.base = base;
    }

    public City getModerateCuts() {
        return moderateCuts;
    }

    public void setModerateCuts(City moderateCuts) {
        this.moderateCuts = moderateCuts;
    }

    public City getNoCuts() {
        return noCuts;
    }

    public void setNoCuts(City noCuts) {
        this.noCuts = noCuts;
    }

    public String format(boolean fahrenheit) {
        StringBuilder builder = new StringBuilder();

        builder.append("In 2100, ");
        builder.append(base.format(fahrenheit));
        builder.append(" will be like\n   ");
        builder.append(noCuts.format(fahrenheit));
        builder.append(" with no emissions cuts,");
        builder.append("\n   ");
        builder.append(moderateCuts.format(fahrenheit));
        builder.append(" with moderate emissions cuts");

        return builder.toString();
    }
}
