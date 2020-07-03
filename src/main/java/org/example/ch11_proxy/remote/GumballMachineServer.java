package org.example.ch11_proxy.remote;

import org.example.ch11_proxy.remote.machine.GumballMachine;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMachineServer {
    public static void main(String[] args) {

        try {
            GumballMachine gumballMachine
                    = new GumballMachine(args[0], Integer.parseInt(args[1]));

            Naming.rebind("/" + args[0].toLowerCase(), gumballMachine);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
