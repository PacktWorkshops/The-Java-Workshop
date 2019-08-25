class Computer {
    // variables
    double cpuSpeed;  // in GHz

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

public class Example01 {
    public static void main(String[] args) {
        Computer myPC = new Computer();
        myPC.setCpuSpeed( 2.5 );
        System.out.println( myPC.getCpuSpeed() );
    }
}
