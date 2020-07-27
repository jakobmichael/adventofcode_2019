package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Day6 {

    static List<String> wayToSanta = new ArrayList<>();
    static List<String> wayToYou = new ArrayList<>();

    public static void checkOrbitList(List<String> input) {
        Map<String, List<String>> orbitMap = new HashMap<>();

        for (String orbit : input) {
            String[] planets = orbit.split("\\)");

            //
            List<String> orbiting = orbitMap.computeIfAbsent(planets[0], k -> new ArrayList<>());
            orbiting.add(planets[1]);
        }
        int allOrbits = countOrbits("COM", orbitMap, 0);

        // part two

        Map<String, String> originalOrbitMap = createOrbitMap(input);

        int orbitalTransfers = getToSanta(originalOrbitMap);

        System.out.println(allOrbits);
        System.out.println(orbitalTransfers);

    }

    public static int countOrbits(String planet, Map<String, List<String>> orbits, int orbitConnections) {
        int sumOrbits = orbitConnections;
        if (orbits.containsKey(planet)) {

            for (String s : orbits.get(planet)) {
                sumOrbits += countOrbits((s), orbits, orbitConnections + 1);

            }
        }

        return sumOrbits;

    }

    public static int getToSanta(Map<String, String> orbitMap) {

        List<String> wayToSanta = findConnectionsToSanta("SAN", orbitMap);
        List<String> wayToYou = findConnectionsToYou("YOU", orbitMap);
        List<String> connections = new ArrayList<>();

        for (String s : wayToYou) {
            if (!wayToSanta.contains(s)) {
                connections.add(s);
            }

        }

        for (String s : wayToSanta) {
            if (!wayToYou.contains(s)) {

                connections.add(s);
            }

        }

        int orbitalTransfers = connections.size() - 2;

        return orbitalTransfers;
    }
    // search keys to values, save the keys in List until COM is the key which is
    // added to the List
    // compare List for Santa and List for way to YOU, substract number of orbits

    public static List<String> findConnectionsToSanta(String planet, Map<String, String> orbitMap) {

        // String key;

        // endLoop:

        // for (String orbit : orbitMap.keySet()) {
        // if (orbit.equals(planet)) {
        // key = orbitMap.get(orbit);
        // wayToSanta.add(key);
        // if (key.equals("COM")) {
        // break endLoop;
        // }
        // findConnectionsToSanta(key, orbitMap);
        // }
        // }

        Set<String> keys = new HashSet<String>();
        for (String orbit : orbitMap.values()) {
            for (Map.Entry<String, String> entry : orbitMap.entrySet()) {
                if (Objects.equals(orbit, entry.getValue())) {
                    keys.add(entry.getKey());

                }
            }
        }

        for (String orbit : keys) {

           

            List<String> list = new ArrayList<>();

            while (orbitMap.keySet().contains(orbit)) {

                list.add(orbit);
                orbit = orbitMap.get(orbit);

            }

            if (list.contains(planet)) {
                for (String s : list) {
                    wayToSanta.add(s);
                }
                return wayToSanta;
            }
        }

        List<String> emptyList = new ArrayList<String>();
        emptyList.add("empty");
        return emptyList;

    }

    public static List<String> findConnectionsToYou(String planet, Map<String, String> orbitMap) {

        // String key;

        // for (String orbit : orbitMap.keySet()) {
        // if (orbit.equals(planet)) {
        // key = orbitMap.get(orbit);
        // wayToYou.add(key);

        // if (key.equals("COM")) {
        // return wayToYou;
        // } else {
        // findConnectionsToYou(key, orbitMap);
        // }
        // }

        // }

        // List<String> emptyList = new ArrayList<String>();
        // emptyList.add("empty");

        // return emptyList;

        Set<String> keys = new HashSet<String>();
        for (String orbit : orbitMap.values()) {
            for (Map.Entry<String, String> entry : orbitMap.entrySet()) {
                if (Objects.equals(orbit, entry.getValue())) {
                    keys.add(entry.getKey());

                }
            }
        }

        for (String orbit : keys) {

            

            List<String> list = new ArrayList<>();

            while (orbitMap.keySet().contains(orbit)) {

                list.add(orbit);
                orbit = orbitMap.get(orbit);
            }
            if (list.contains(planet)) {
                for (String s : list) {
                    wayToYou.add(s);

                }
                return wayToYou;
            }

        }

        List<String> emptyList = new ArrayList<String>();
        emptyList.add("empty");

        return emptyList;

    }

    public static HashMap<String, String> createOrbitMap(List<String> input) {

        LinkedHashMap<String, String> originalOrbitMap = new LinkedHashMap<>();

        for (String orbit : input) {
            String[] planets = orbit.split("\\)");

            // original List

            originalOrbitMap.put(planets[1], planets[0]);

        }

        return originalOrbitMap;
    }
}