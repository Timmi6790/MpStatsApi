package de.timmi6790.mpstats.api.versions.v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StatsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -5238467635283120079L;

    public StatsNotFoundException() {
        super("No stats found");
    }
}
