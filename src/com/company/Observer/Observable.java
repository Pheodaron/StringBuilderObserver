package com.company.Observer;

public interface Observable {
    void AddObserver(Listener l);
    void RemoveObserver(Listener l);
    void NotifyObserver();
}
