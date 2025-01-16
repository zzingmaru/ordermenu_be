package com.miniproject.exception;

import lombok.Builder;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@Builder
public class UseException extends RuntimeException {

    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{}");

    Integer rsCode;
    String rsMsg;

    public UseException(String rsMsg) {
        super(rsMsg);
        this.rsCode = 99999;
        this.rsMsg = rsMsg;
    }

    public UseException(Integer rsCode, String rsMsg) {
        super(rsMsg);
        this.rsCode = rsCode;
        this.rsMsg = rsMsg;
    }

    public UseException(String rsMsg, Object... args) {
        super(formatMessage(rsMsg, args));
        this.rsCode = 99999;
        this.rsMsg = formatMessage(rsMsg, args);
    }

    public UseException(Integer rsCode, String rsMsg, Object... args) {
        super(formatMessage(rsMsg, args));
        this.rsCode = rsCode;
        this.rsMsg = formatMessage(rsMsg, args);
    }


    private static String formatMessage(String format, Object... args) {
        if (args == null || args.length == 0) {
            return format;
        }

        String[] parts = PLACEHOLDER_PATTERN.split(format, -1);
        StringBuilder builder = new StringBuilder(format.length());

        for (int i = 0; i < parts.length - 1; i++) {
            builder.append(parts[i]);
            builder.append(args[i]);
        }
        builder.append(parts[parts.length - 1]);

        return builder.toString();
    }

}

