package com.packt.java.chapter21;

class ShoppingCart {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalized");
    }
}
