package com.company.StrBuilder;

public class AppendCommand implements Command{
    private StringBuilder stringBuilder;
    private String str;

    public AppendCommand(StringBuilder stringBuilder, String str) {
        this.stringBuilder = stringBuilder;
        this.str = str;
    }

    @Override
    public void execute() {
        stringBuilder.append(str);
    }
}
