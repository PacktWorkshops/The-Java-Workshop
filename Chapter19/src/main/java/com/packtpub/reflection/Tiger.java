package com.packtpub.reflection;

import java.io.Serializable;

public class Tiger implements Mammal, Serializable {
    public boolean hasLegs() {
        return true;
    }

    public boolean hasFur() {
        return true;
    }

    public boolean burnsBright() {
        return true;
    }
}
