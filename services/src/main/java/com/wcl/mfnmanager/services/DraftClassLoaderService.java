package com.wcl.mfnmanager.services;

import com.wcl.mfnmanager.entities.player.Player;
import com.wcl.mfnmanager.entities.player.Position;
import com.wcl.mfnmanager.entities.player.Potential;
import com.wcl.mfnmanager.services.draft.loader.DraftPlayerFileLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DraftClassLoaderService {
    private final List<String> fileNames = Arrays.asList("ALL.csv", "C.csv", "CB.csv", "DT.csv", "FB.csv", "FGK.csv", "FS.csv", "GUNNER.csv", "K.csv", "KH.csv", "KO.csv", "KR.csv", "LDE.csv",
            "LG.csv", "LS.csv", "LT.csv", "MLB.csv", "P.csv", "PR.csv", "QB.csv", "RB.csv", "RDE.csv", "RG.csv", "RT.csv", "SLB.csv",
            "SS.csv", "STBLK.csv", "STRUSH.csv", "TE.csv", "WLB.csv", "WR.csv");

    private final DraftPlayerFileLoader draftPlayerFileLoader;

    public DraftClassLoaderService() {
        draftPlayerFileLoader = new DraftPlayerFileLoader();
    }

    public List<Player> importDraftCLassData(final File dataDirectory) {

        final List<Future<Map<Integer, Player>>> futures;

        final var executor = Executors.newFixedThreadPool(31);

        final var basePlayers = new ConcurrentHashMap<Integer, Player>();
        try {
            futures = executor.invokeAll(getTasksToLoadDataFiles(dataDirectory));
            executor.shutdown();
            basePlayers.putAll(futures.get(0).get().values().stream()
                    .collect(Collectors.toMap(Player::id, dp -> dp)));

            IntStream.rangeClosed(1, 30).forEachOrdered(a -> {
                try {
                    final var positionFileData = futures.get(a).get();

                    positionFileData.forEach((key, value) -> {
                        var posName = value.assignedPosition().name();
                        final var index = posName.indexOf(" (");
                        if (index > 0) {
                            posName = posName.substring(0, index);
                        }
                        posName = switch (posName) {
                            case "Kickoffs", "Field Goal Kicker" -> "K";
                            case "Gunner" -> "GUNNER";
                            case "Kick Holder" -> "KH";
                            case "Kick Returner" -> "KR";
                            case "Long Snapper" -> "LS";
                            case "Punt Returner" -> "PR";
                            case "ST Blocker" -> "STBLK";
                            case "ST Rusher" -> "STRUSH";
                            default -> posName;
                        };

                        basePlayers.get(key).positionPotentialRatings().put(Position.valueOf(posName),
                                new Potential(value.currentOA(), value.maximumOA()));
                    });


                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>(basePlayers.values());
    }


    private List<Callable<Map<Integer, Player>>>  getTasksToLoadDataFiles(final File draftClassDataDirectory) {
        final var tasks = new ArrayList<Callable<Map<Integer, Player>>>();
        fileNames.forEach(filename -> tasks.add(() -> draftPlayerFileLoader.loadPlayerFileData(draftClassDataDirectory, filename)));
        return tasks;
    }
}
