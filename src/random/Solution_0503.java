package random;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_0503 {
    public int Solution881_1(int[] people, int limit) {
        int numberOfBoats = 1;

        Arrays.sort(people);

        int currentRemainPeople = limit - people[0];
        for (int i = 1; i < people.length; i++) {
            if (currentRemainPeople >= people[i]) {
                currentRemainPeople -= people[i];
            } else {
                currentRemainPeople = limit - people[i];
                numberOfBoats++;
            }
        }

        return numberOfBoats;
    }

    public int Solution881_2(int[] people, int limit) {
        int numberOfBoats = 1;

        Arrays.sort(people);

        int leftIndex = 0, rightIndex = people.length - 1;
        int currentRemainPeople = limit - people[rightIndex--];
        while (leftIndex <= rightIndex) {
            if (currentRemainPeople >= people[leftIndex]) {
                currentRemainPeople -= people[leftIndex];
                leftIndex++;
            } else {
                currentRemainPeople = limit - people[rightIndex--];
                numberOfBoats++;
            }
        }

        return numberOfBoats;
    }

    public int Solution881_3(int[] people, int limit) {
        int numberOfBoats = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int person : people) {
            if (map.containsKey(person)) {
                map.put(person, map.get(person) + 1);
            } else {
                map.put(person, 1);
            }
        }

        int[] keyArray = new int[map.keySet().size()];
        int index = 0;
        for(int key : map.keySet()) {
            keyArray[index++] = key;
        }

        Arrays.sort(keyArray);

        int currentRemainPeople = limit - keyArray[--index];
        if(map.get(people[index]) > 1) {
            map.put(people[index], map.get(people[index]) - 1);
        } else {
            map.remove(people[index]);
        }

        while(!map.isEmpty()) {
            if(map.containsKey(currentRemainPeople)) {
                if(map.get(currentRemainPeople) > 1) {
                    map.put(currentRemainPeople, map.get(currentRemainPeople) - 1);
                } else {
                    map.remove(currentRemainPeople);
                }
            } else {
                // don't have below number
                int similarNumber = Integer.MIN_VALUE;
                for(int key : map.keySet()) {
                    if(key <= currentRemainPeople) {
                        similarNumber = Math.max(similarNumber, key);
                    }
                }

                if(similarNumber == Integer.MIN_VALUE) {
                    currentRemainPeople = limit - people[--index];
                    if(map.get(people[index]) > 1) {
                        map.put(people[index], map.get(people[index]) - 1);
                    } else {
                        map.remove(people[index]);
                    }

                    numberOfBoats++;
                } else {
                    currentRemainPeople = limit - people[--index];
                    if(map.get(similarNumber) > 1) {
                        map.put(similarNumber, map.get(similarNumber) - 1);
                    } else {
                        map.remove(similarNumber);
                    }
                    numberOfBoats++;
                }
            }
        }

        return numberOfBoats;
    }
    public int Solution881(int[] people, int limit) {
        int numberOfBoats = 0;

        int[] weights = new int[limit+1];
        for(int person : people) {
            weights[person]++;
        }

        int leftIndex = 0, rightIndex = weights.length - 1;
        while(leftIndex <= rightIndex) {
            while(leftIndex < rightIndex && weights[leftIndex] <= 0) leftIndex++;
            while(rightIndex > leftIndex && weights[rightIndex] <= 0) rightIndex--;

            if(weights[leftIndex] <= 0 && weights[rightIndex] <= 0) break;

            int sumWeight = leftIndex + rightIndex;

            numberOfBoats++;
            if(sumWeight <= limit) {
                weights[leftIndex]--;
            }

            weights[rightIndex]--;
        }

        return numberOfBoats;
    }

    public int Solution881_fin(int[] people, int limit) {
        int numberOfBoats = 1;

        Arrays.sort(people);

        int leftIndex = 0, rightIndex = people.length - 1;
        int currentRemainPeople = limit - people[rightIndex];
        while (leftIndex < rightIndex) {
            if (currentRemainPeople >= people[leftIndex]) {
                leftIndex++;
                rightIndex--;
                if(leftIndex <= rightIndex) numberOfBoats++;
                currentRemainPeople = limit - people[rightIndex];
            } else {
                rightIndex--;
                currentRemainPeople = limit - people[rightIndex];
                numberOfBoats++;
            }
        }

        return numberOfBoats;
    }
}
