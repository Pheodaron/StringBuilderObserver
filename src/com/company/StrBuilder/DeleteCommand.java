package com.company.StrBuilder;

public class DeleteCommand implements Command {
    StringBuilder stringBuilder;
    private int start;
    private int end;

    public DeleteCommand(StringBuilder stringBuilder, int start, int end) {
        this.stringBuilder = stringBuilder;
        this.start = start;
        this.end = end;

    }

    @Override
    public void execute() {
        stringBuilder.delete(start, end);
    }
}
