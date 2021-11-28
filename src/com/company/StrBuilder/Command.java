package com.company.StrBuilder;

public interface Command {
    default void execute() {
        System.out.println("method not defined");
    }
}
