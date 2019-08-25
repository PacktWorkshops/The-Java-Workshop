class Computer {
    // variables
    private double cpuSpeed;  // in GHz

    // constructor
    Computer() {
        cpuSpeed = 0;
    }

    // methods
    void setCpuSpeed ( double _cpuSpeed ) {
        cpuSpeed = _cpuSpeed;
    }

    double getCpuSpeed () {
        return cpuSpeed;
    }
}

class Tablet extends Computer {
    // variables
    private double screenSize;  // in inches

    // methods
    void setScreenSize ( double _screenSize ) {
        screenSize = _screenSize;
    }

    double getScreenSize () {
        return screenSize;
    }
}

public class Example05 {
    public static void main(String[] args) {
        Tablet myTab = new Tablet();
        myTab.setCpuSpeed( 2.5 );
        myTab.setScreenSize( 10 );
        System.out.println( myTab.getCpuSpeed() );
        System.out.println( myTab.getScreenSize() );
    }
}
