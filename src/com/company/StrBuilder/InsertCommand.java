package com.company.StrBuilder;

public class InsertCommand implements Command{

    private StringBuilder stringBuilder;
    private int offset;
    private String str;

    public InsertCommand(StringBuilder stringBuilder, int offset, String str) {
        this.stringBuilder = stringBuilder;
        this.offset = offset;
        this.str = str;
    }

    @Override
    public void execute() {
        stringBuilder.insert(offset, str);
    }
}
