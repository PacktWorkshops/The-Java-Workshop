class Computer {
    public static void whatIsIt() {
        System.out.println( "it is a PC");
    }
}

class Tablet extends Computer {
    public static void whatIsIt() {
        System.out.println( "it is a tablet");
    }
}

class Example07 {
    public static void main(String[] args) {
        Computer myTab = new Tablet();
        myTab.whatIsIt();
    }
}
