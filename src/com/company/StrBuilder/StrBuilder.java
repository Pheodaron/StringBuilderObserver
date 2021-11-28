package com.company.StrBuilder;

import com.company.Observer.Listener;
import com.company.Observer.Observable;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class StrBuilder implements Observable {
    List<Listener> listeners = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    Stack<Command> commands = new Stack<>();;

    /**
     *Конструкторы
     */
    public StrBuilder(String str) {
        this.append(str);
    }

    /**
     * Методы паттерна Observer
     */
    public void AddObserver(Listener l) {
        listeners.add(l);
    }

    public void RemoveObserver(Listener l) {
        listeners.remove(l);
    }

    public void NotifyObserver() {
        if (!(listeners == null)) {
            for (Listener l : listeners) {
                l.HandleEvent(this);
            }
        }
    }

    /**
     * Делигируемые методы
     */
    public StrBuilder insert(int offset,String str) {
        InsertCommand insertCommand = new InsertCommand(stringBuilder, offset, str);
        insertCommand.execute();

        Command cmd = new Command() {
            @Override
            public void execute() {
                stringBuilder.delete(offset, offset + str.length());
            }
        };
        commands.add(cmd);
        this.NotifyObserver();
        return this;
    }

    public StrBuilder delete(int start, int end) {
        DeleteCommand deleteCommand = new DeleteCommand(stringBuilder, start, end);
        String deleted = stringBuilder.substring(start, end);
        deleteCommand.execute();

        Command cmd = new Command() {
            @Override
            public void execute() {
            stringBuilder.insert(start, deleted);
            }
        };
        commands.add(cmd);
        this.NotifyObserver();
        return this;
    }

    public StrBuilder append(String str) {
        AppendCommand appendCommand = new AppendCommand(stringBuilder, str);
        appendCommand.execute();

        Command cmd = new Command() {
            @Override
            public void execute() {
                stringBuilder.delete(stringBuilder.length() - str.length(), stringBuilder.length());
            }
        };
        commands.add(cmd);
        this.NotifyObserver();
        return this;
    }

    //other methods
    public void undo() {
        if(!commands.isEmpty()) {
            commands.pop().execute();
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
