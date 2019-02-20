package com.xybean.witness.model;

import android.os.Build;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/**
 * Author @xybean on 2019/1/10.
 *
 * @see Exception#printStackTrace()
 */
public class ExceptionModel implements LogModel {

    private static final String CAUSE_CAPTION = "Caused by: ";
    private static final String SUPPRESSED_CAPTION = "Suppressed: ";

    private static final String TAG = "EXCEPTION";

    private Exception e;

    public static LogModel create(Exception e) {
        return new ExceptionModel(e);
    }

    private ExceptionModel(Exception e) {
        this.e = e;
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder();

        Set<Throwable> dejaVu =
                Collections.newSetFromMap(new IdentityHashMap<Throwable, Boolean>());
        dejaVu.add(e);

        sb.append(this);
        StackTraceElement[] trace = e.getStackTrace();
        for (StackTraceElement traceElement : trace) {
            sb.append("\tat ").append(traceElement).append("\n");
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            for (Throwable se : e.getSuppressed()) {
                printEnclosedStackTrace(sb, se, trace, SUPPRESSED_CAPTION, "\t", dejaVu);
            }
        }

        // Print cause, if any
        Throwable ourCause = e.getCause();
        if (ourCause != null)
            printEnclosedStackTrace(sb, ourCause, trace, CAUSE_CAPTION, "", dejaVu);

        return sb.toString();
    }

    @Override
    public String tag() {
        return TAG;
    }

    /**
     * Print our stack trace as an enclosed exception for the specified
     * stack trace.
     */
    private void printEnclosedStackTrace(StringBuilder s,
                                         Throwable cause,
                                         StackTraceElement[] enclosingTrace,
                                         String caption,
                                         String prefix,
                                         Set<Throwable> dejaVu) {
        if (dejaVu.contains(cause)) {
            s.append("\t[CIRCULAR REFERENCE:").append(cause).append("]").append("\n");
        } else {
            dejaVu.add(cause);
            // Compute number of frames in common between this and enclosing trace
            StackTraceElement[] trace = cause.getStackTrace();
            int m = trace.length - 1;
            int n = enclosingTrace.length - 1;
            while (m >= 0 && n >= 0 && trace[m].equals(enclosingTrace[n])) {
                m--;
                n--;
            }
            int framesInCommon = trace.length - 1 - m;

            // Print our stack trace
            s.append(prefix).append(caption).append(cause).append("\n");
            for (int i = 0; i <= m; i++)
                s.append(prefix).append("\tat ").append(trace[i]).append("\n");
            if (framesInCommon != 0)
                s.append(prefix).append("\t... ").append(framesInCommon).append(" more").append("\n");

            // Print suppressed exceptions, if any
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                for (Throwable se : cause.getSuppressed()) {
                    printEnclosedStackTrace(s, se, trace, SUPPRESSED_CAPTION,
                            prefix + "\t", dejaVu);
                }
            }

            // Print cause, if any
            Throwable ourCause = cause.getCause();
            if (ourCause != null) {
                printEnclosedStackTrace(s, ourCause, trace, CAUSE_CAPTION, prefix, dejaVu);
            }
        }
    }
}
