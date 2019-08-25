class Computer {
    public void whatIsIt() {
        System.out.println( "it is a PC");
    }
}

class Tablet extends Computer {
    public void whatIsIt() {
        System.out.println( "it is a tablet");
    }
}

class Example06 {
    public static void main(String[] args) {
        // alternative: Computer myTab = new Tablet();
        Tablet myTab = new Tablet();
        myTab.whatIsIt();
    }
}
