package selenium;


import java.util.*;

public class TestArea {

    static String[] iArr = {"PEE", "RAP", "TAR", "TOP", "EAT", "RAR", "RAT"};
    static HashMap<String, ArrayList<String>> prefixMap = new HashMap<String, ArrayList<String>>();

    static ArrayList <String> combinations = new ArrayList<>();

    static int largestStringIndex = 0;

    public static void main(String[] args) {

        createPrefixMap(iArr);

        for (int i = 0; i< iArr.length; i++){

            Stack<String> chain = new Stack<>();
            Stack<String> followup = new Stack<>();
            Stack<String> visited = new Stack<>();

            String startingPoint = iArr[i];

            followup.add(iArr[i]);

            while(!followup.empty()){

                startingPoint = followup.pop();
                ArrayList<String> nextWord = getNextWord(startingPoint);

                chain.add(startingPoint);
                visited.add(startingPoint);

                nextWord = removeVisited(nextWord, visited);

                if((nextWord.isEmpty() || nextWord == null)
                        && !followup.empty()){
                    popUntilFollowupWordFound(chain, followup, visited);
                }

                if((nextWord.isEmpty() || nextWord == null)
                        && followup.empty() && chain.size()<iArr.length){
                    System.out.println("These given set form a chain, but do not include all the words : " + chain);
                }

                if(!followup.contains(nextWord)){
                    followup.addAll(nextWord);
                }

            }

            combinations.add(chain.toString());
//            System.out.println(chain.toString());

            if((combinations.get(i).length()
                    > combinations.get(largestStringIndex).length())){

                largestStringIndex = i;
            }
        }

        System.out.println("The largest String is : " + combinations.get(largestStringIndex));

    }

    private static void popUntilFollowupWordFound(Stack<String> chain,
                                                  Stack<String> followup, Stack<String> visited) {

        boolean followUpNotFound = true;

        while(followUpNotFound){

            String peek = String.valueOf(followup.peek().charAt(0));

            String availableWord = chain.pop();
            String peek1 = String.valueOf(availableWord.charAt(0));
            visited.remove(availableWord);

            if(peek.equalsIgnoreCase(peek1)){
                followUpNotFound = false;
            }
        }

    }

    private static ArrayList<String> removeVisited(ArrayList<String> nextWord, Stack<String> visited) {
        ArrayList<String> copyArr = new ArrayList<>();
        copyArr.addAll(nextWord);

        copyArr.removeAll(visited);
        return copyArr;
    }

    private static ArrayList<String> getNextWord(String s) {

        ArrayList<String> copyArr = new ArrayList<>();
        copyArr.addAll(prefixMap.get(String.valueOf(s.charAt(s.length() - 1))));

        return copyArr;
    }

    public static void createPrefixMap(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String word = strArr[i];

            if (prefixMap.containsKey(String.valueOf(word.charAt(0)))) {
                ArrayList<String> words = prefixMap.get(String.valueOf(word.charAt(0)));
                words.add(word);
            } else {
                ArrayList<String> words = new ArrayList<>();
                words.add(word);
                prefixMap.put(String.valueOf(word.charAt(0)), words);
            }
        }

        System.out.println(prefixMap);
    }
}
