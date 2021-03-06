package de.timmi6790.mpstats.api.versions.v1.java.leaderboard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.timmi6790.mpstats.api.versions.v1.java.board.repository.models.Board;
import de.timmi6790.mpstats.api.versions.v1.java.game.repository.models.Game;
import de.timmi6790.mpstats.api.versions.v1.java.stat.repository.models.Stat;
import lombok.Data;

@Data
public class LeaderboardData {
    @JsonIgnore
    private final int repositoryId;

    private final Game game;
    private final Stat stat;
    private final Board board;
    private final boolean deprecated;
    private final long lastUpdate;
}
