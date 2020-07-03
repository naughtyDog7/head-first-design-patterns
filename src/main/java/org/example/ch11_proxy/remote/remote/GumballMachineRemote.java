package org.example.ch11_proxy.remote.remote;


import org.example.ch11_proxy.remote.state.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {
    int getNumOfGumballs() throws RemoteException;
    String getLocation() throws RemoteException;
    State getState() throws RemoteException;
}
