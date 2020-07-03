package org.example.ch11_proxy.remote.machine;

import org.example.ch11_proxy.remote.remote.GumballMachineRemote;

import java.rmi.RemoteException;

public class GumballMonitor {
    private final GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println(machine.getLocation());
            System.out.println(machine.getNumOfGumballs());
            System.out.println(machine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
