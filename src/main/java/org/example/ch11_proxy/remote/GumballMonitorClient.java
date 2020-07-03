package org.example.ch11_proxy.remote;

import org.example.ch11_proxy.remote.machine.GumballMonitor;
import org.example.ch11_proxy.remote.remote.GumballMachineRemote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorClient {
    public static void main(String[] args) {
        String seattleMachine = "rmi://localhost/seattle";
        try {
            GumballMachineRemote machine = ((GumballMachineRemote) Naming.lookup(seattleMachine));
            GumballMonitor monitor = new GumballMonitor(machine);
            monitor.report();
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
