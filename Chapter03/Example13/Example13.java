class Computer {
    @Deprecated
    public void whatIsIt() {
        System.out.println( "it is a PC");
    }

    public void getDeviceType() {
        System.out.println( "it is a PC");
    }
}

class Tablet extends Computer {
    @Override
    public void whatIsIt() {
        System.out.println( "it is a tablet");
    }
}

class Example13 {
    public static void main(String[] args) {
        Tablet myTab = new Tablet();
        myTab.whatIsIt();
    }
}
